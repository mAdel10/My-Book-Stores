package com.example.bookstore.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bookstore.R;
import com.example.bookstore.backend.api.ApiClient;
import com.example.bookstore.backend.models.Book;
import com.example.bookstore.backend.models.MyBooks;
import com.example.bookstore.backend.models.User;
import com.example.bookstore.controllers.adapters.BookAdapter;
import com.example.bookstore.helpers.SharedPreference;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileActivity extends AppCompatActivity {

    ImageView profileImg;
    TextView nameTxt;
    TextView emailTxt;
    TextView phoneTxt;
    TextView addressTxt;
    String id;

    private RecyclerView recyclerView;
    BookAdapter bookAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profileImg = findViewById(R.id.profile_img);
        nameTxt = findViewById(R.id.profile_name);
        emailTxt = findViewById(R.id.profile_email);
        phoneTxt = findViewById(R.id.profile_phone);
        addressTxt = findViewById(R.id.profile_Address);
        id = SharedPreference.getToken(getApplicationContext());
        doGetProfile();


        recyclerView = findViewById(R.id.recycleView_my_books);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayout = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayout);
        doGetMyBooks();
    }

    private void doGetProfile() {
        ApiClient.getInstance(getApplicationContext()).doGetProfile(id).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                //Log.d("cat", "onResponse" + response.body().toString());
                if (response.body() != null) {
                    Picasso.get()
                            .load(response.body().getImage())
                            .placeholder(R.drawable.img_placeholder)
                            .into(profileImg);

                    nameTxt.setText(response.body().getName());
                    emailTxt.setText(response.body().getEmail());
                    phoneTxt.setText(response.body().getPhone());
                    addressTxt.setText(response.body().getAddress());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(ProfileActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void doGetMyBooks() {
        ApiClient.getInstance(getApplicationContext()).doGetMyBooks(id).enqueue(new Callback<MyBooks>() {
            @Override
            public void onResponse(Call<MyBooks> call, Response<MyBooks> response) {
                bookAdapter = new BookAdapter(response.body().getBooks(), getApplicationContext());
                recyclerView.setAdapter(bookAdapter);
            }

            @Override
            public void onFailure(Call<MyBooks> call, Throwable t) {

            }
        });
    }

    public void logOut(View view) {
        if (SharedPreference.getToken(this) != null || SharedPreference.getUser(this) != null) {
            SharedPreference.deleteToken(this);
            SharedPreference.deleteUser(this);
            Intent i = new Intent(ProfileActivity.this, LogInActivity.class);
            startActivity(i);
            finish();
        }
    }

    public void backBtn(View view) {
        Toast.makeText(this, "I will do Nothing", Toast.LENGTH_SHORT).show();
    }

    public void editProfile(View view) {
        Intent i = new Intent(ProfileActivity.this, EditProfileActivity.class);
        startActivity(i);
    }
}