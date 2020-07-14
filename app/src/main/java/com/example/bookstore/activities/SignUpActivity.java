package com.example.bookstore.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bookstore.R;
import com.example.bookstore.backend.api.ApiClient;
import com.example.bookstore.backend.api.ApiInterface;
import com.example.bookstore.backend.models.SignForm;
import com.example.bookstore.backend.models.Token;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SignUpActivity extends AppCompatActivity {

    EditText nameTV;
    EditText addressTV;
    EditText emailTV;
    EditText passwordTV;
    EditText rePasswordTV;
    EditText phoneTV;
    SignForm signForm;

    String name;
    String address;
    String password;
    String phone;
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        nameTV = findViewById(R.id.signUp_firstName_editText);
        addressTV = findViewById(R.id.signUp_address_editText);
        emailTV = findViewById(R.id.signUp_email_editText);
        passwordTV = findViewById(R.id.signUp_password_editText);
        rePasswordTV = findViewById(R.id.signUp_confirmPassword_editText);
        phoneTV = findViewById(R.id.signUp_phone_editText);

    }

    private void doSignUp() {
        signForm = new SignForm(name,address,email,phone,password);
        ApiInterface apiInterface = ApiClient.getInstance(getApplicationContext());
        apiInterface.doSignUp(signForm).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful()){
                    Intent i = new Intent(SignUpActivity.this,LogInActivity.class);
                    startActivity(i);
                    finish();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(SignUpActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void SignUp(View view) {
        if (getInputData()){
            doSignUp();
        }
    }

    private Boolean getInputData() {
        name = nameTV.getText().toString().trim();
        email = emailTV.getText().toString().trim();
        password = passwordTV.getText().toString().trim();
        phone = phoneTV.getText().toString().trim();
        address = addressTV.getText().toString().trim();
        return true;
    }
}
