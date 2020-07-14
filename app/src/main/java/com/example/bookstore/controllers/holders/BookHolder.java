package com.example.bookstore.controllers.holders;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookstore.R;

public class BookHolder extends RecyclerView.ViewHolder {

    public ImageView bookImg;
    public TextView bookNameEd;
    public TextView bookAuthorEd;
    public TextView bookPriceEd;
    public TextView bookDiscountEd;
    public TextView bookDescriptionEd;
    public TextView bookAboutAuthorEd;
    public RatingBar bookRating;
    public Button buyNowBtn;
    public Button viewBookBtn;

    public BookHolder(@NonNull View v) {
        super(v);
        bookImg = v.findViewById(R.id.item_fBook_img);
        bookNameEd = v.findViewById(R.id.item_fBook_name_api);
        bookAuthorEd = v.findViewById(R.id.item_fBook_author_api);
        bookPriceEd = v.findViewById(R.id.item_fBook_price_api);
        bookDiscountEd = v.findViewById(R.id.item_fBook_discount_api);
        bookDescriptionEd = v.findViewById(R.id.item_fBook_description_api);
        bookAboutAuthorEd = v.findViewById(R.id.item_fBook_author_description_api);
        bookRating = v.findViewById(R.id.item_fBook_rate_api);
        buyNowBtn = v.findViewById(R.id.item_fBook_buy_btn);
        viewBookBtn = v.findViewById(R.id.item_fBook_view_btn);
    }
}
