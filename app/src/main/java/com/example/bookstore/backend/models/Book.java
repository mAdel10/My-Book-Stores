package com.example.bookstore.backend.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Book implements Serializable {

    @SerializedName("_id")
    @Expose
    private String id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("image")
    @Expose
    private String image;

    @SerializedName("author")
    @Expose
    private String author;

    @SerializedName("price")
    @Expose
    private double price;

    @SerializedName("rating")
    @Expose
    private Float rating;

    @SerializedName("discount")
    @Expose
    private int discount;

    @SerializedName("bookDescription")
    @Expose
    private String bookDescription;

    @SerializedName("aboutAuthor")
    @Expose
    private String aboutAuthor;

    public Book() {
    }

    public Book(String id, String name, String image, String author, double price, Float rating, int discount, String bookDescription, String aboutAuthor) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.author = author;
        this.price = price;
        this.rating = rating;
        this.discount = discount;
        this.bookDescription = bookDescription;
        this.aboutAuthor = aboutAuthor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public String getAboutAuthor() {
        return aboutAuthor;
    }

    public void setAboutAuthor(String aboutAuthor) {
        this.aboutAuthor = aboutAuthor;
    }
}
