package com.example.bookstore.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;

import android.widget.LinearLayout;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.bookstore.R;
import com.example.bookstore.backend.api.ApiClient;
import com.example.bookstore.backend.models.Book;
import com.example.bookstore.controllers.adapters.BookAdapter;
import com.example.bookstore.helpers.Constants;



import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    BookAdapter bookAdapter;
    ImageSlider imageSlider;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageSlider = findViewById(R.id.home_slider);
        setSliderViews();


        recyclerView = findViewById(R.id.recycleView_home);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayout = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayout);
        getBooks();
    }

    private void setSliderViews() {
        ApiClient.getInstance(getApplicationContext()).doGetSlider().enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                List<SlideModel> slideModels = new ArrayList<>();
                for (int i=0 ; i< response.body().size(); i++){
                    slideModels.add(new SlideModel(response.body().get(i)));
                    imageSlider.setImageList(slideModels,true);
                }
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
                Toast.makeText(HomeActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getBooks() {
        ApiClient.getInstance(getApplicationContext()).doGetBooks().enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                if (response != null) {
                    Log.d("cat", "onResponse" + response.body().toString());
                    List<Book> books = response.body();
                    bookAdapter = new BookAdapter(books, getApplicationContext());
                    recyclerView.setAdapter(bookAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                Toast.makeText(HomeActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void goToMyProfile(View view) {
        Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
        startActivity(intent);
    }

}