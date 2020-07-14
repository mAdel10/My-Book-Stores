package com.example.bookstore.backend.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class MyBooks implements Serializable {

    @SerializedName("books")
    @Expose
    private List<Book> books;

    public MyBooks() {
    }

    public MyBooks(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
