package com.example.bookstore.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bookstore.R;
import com.example.bookstore.backend.api.ApiClient;
import com.example.bookstore.backend.models.EditProfileForm;
import com.example.bookstore.backend.models.User;
import com.example.bookstore.helpers.SharedPreference;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditProfileActivity extends AppCompatActivity {

    EditText nameEt;
    EditText phoneEt;
    EditProfileForm editProfileForm;

    String name;
    String phone;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        nameEt = findViewById(R.id.edit_name_editText);
        phoneEt = findViewById(R.id.edit_phone_editText);
        id = SharedPreference.getToken(getApplicationContext());

    }

    public void editNow(View view) {
        if (getInputData()){
            doEditProfile();
        }
    }

    private void doEditProfile() {
        editProfileForm = new EditProfileForm(name,phone);
        ApiClient.getInstance(this).doEditProfile(id,editProfileForm).enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                Toast.makeText(EditProfileActivity.this, "Edit Done", Toast.LENGTH_LONG).show();
                Intent i = new Intent(EditProfileActivity.this,ProfileActivity.class);
                startActivity(i);
                finish();
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(EditProfileActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private boolean getInputData() {
        name = nameEt.getText().toString().trim();
        phone = phoneEt.getText().toString().trim();
        return true;
    }
}
