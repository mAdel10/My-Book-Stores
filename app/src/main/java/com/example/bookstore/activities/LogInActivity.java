package com.example.bookstore.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bookstore.R;
import com.example.bookstore.backend.api.ApiClient;
import com.example.bookstore.backend.models.SignForm;
import com.example.bookstore.backend.models.Token;
import com.example.bookstore.helpers.SharedPreference;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LogInActivity extends AppCompatActivity {

    EditText emailTV;
    EditText passwordTV;
    SignForm signForm;

    String email;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        emailTV = findViewById(R.id.edit_name_editText);
        passwordTV = findViewById(R.id.signIn_password_editText);

    }

    public void SignIn(View view) {
        if (getInputData()) {
            doSignIn();
        }
    }

    public void createAccount(View view) {
        Intent i = new Intent(LogInActivity.this, SignUpActivity.class);
        startActivity(i);
    }

    private void doSignIn() {
        signForm = new SignForm(email, password);
        ApiClient.getInstance(getApplicationContext()).doSignIn(signForm).enqueue(new Callback<Token>() {
            @Override
            public void onResponse(Call<Token> call, Response<Token> response) {
                if (response.isSuccessful()) {
                    SharedPreference.saveToken(getApplicationContext(),response.body().getAuthToken());
                    Intent i = new Intent(LogInActivity.this, HomeActivity.class);
                    startActivity(i);
                    finish();
                }else{
                    Toast.makeText(LogInActivity.this, "Invaled User or Password", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Token> call, Throwable t) {
                Toast.makeText(LogInActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean getInputData() {
        email = emailTV.getText().toString().trim();
        password = passwordTV.getText().toString().trim();
         return true;
    }
}
