package com.example.bookstore.controllers.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookstore.R;
import com.example.bookstore.backend.api.ApiClient;
import com.example.bookstore.backend.models.Book;
import com.example.bookstore.backend.models.MyBooks;
import com.example.bookstore.controllers.holders.BookHolder;
import com.example.bookstore.helpers.SharedPreference;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookAdapter extends RecyclerView.Adapter<BookHolder> {


    private List<Book> books;
    private Context context;
    private String id;

    public BookAdapter(List<Book> books, Context context){
        this.books = books;
        this.context = context;
    }

    private Context getContext() {
        return context;
    }

    @NonNull
    @Override
    public BookHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_feature_books, parent, false);
        return new BookHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull BookHolder holder, int position) {

        id = SharedPreference.getToken(context);

        Book bok = books.get(position);
        Picasso.get()
                .load(bok.getImage())
                .placeholder(R.drawable.img_placeholder)
                .into(holder.bookImg);

        holder.bookNameEd.setText(bok.getName());
        holder.bookAuthorEd.setText(bok.getAuthor());
        holder.bookPriceEd.setText(String.valueOf(bok.getPrice()));
        holder.bookDiscountEd.setText(String.valueOf(bok.getDiscount()));
        holder.bookDescriptionEd.setText(bok.getBookDescription());
        holder.bookAboutAuthorEd.setText(bok.getAboutAuthor());
        holder.bookRating.setRating(bok.getRating());
        
        holder.buyNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiClient.getInstance(context).doBuyBook(id,bok.getId()).enqueue(new Callback<Book>() {
                    @Override
                    public void onResponse(Call<Book> call, Response<Book> response) {
                        Toast.makeText(context, "Now The Book is Yours", Toast.LENGTH_SHORT).show();
                        Toast.makeText(context, id, Toast.LENGTH_SHORT).show();
                        holder.buyNowBtn.setVisibility(View.GONE);
                        holder.viewBookBtn.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onFailure(Call<Book> call, Throwable t) {
                        Toast.makeText(context, t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return books.size();
    }
}
