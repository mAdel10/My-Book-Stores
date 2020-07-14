package com.example.bookstore.backend.api;

import com.example.bookstore.backend.models.Book;
import com.example.bookstore.backend.models.EditProfileForm;
import com.example.bookstore.backend.models.MyBooks;
import com.example.bookstore.backend.models.SignForm;
import com.example.bookstore.backend.models.Token;
import com.example.bookstore.backend.models.User;
import com.example.bookstore.helpers.Constants;

import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiInterface {

    //    @POST(Constants.SERVICES_SIGN_UP)
//    Call<ResponseBody> doSignUp(@HeaderMap Map<String, String> headers,
//                                @Body SignForm signForm);
    @POST(Constants.SERVICES_SIGN_UP)
    Call<ResponseBody> doSignUp(@Body SignForm signForm);

    @POST(Constants.SERVICES_SIGN_IN)
    Call<Token> doSignIn(@Body SignForm signForm);

    @GET(Constants.SERVICES_PROFILE)
    Call<User> doGetProfile(@Header("x-auth-token") String token);

    @PUT(Constants.SERVICES_EDIT_PROFILE)
    Call<List<User>> doEditProfile(@Header("x-auth-token") String token,
                                   @Body EditProfileForm editProfileForm);

    @GET(Constants.SERVICES_GET_BOOKS)
    Call<List<Book>> doGetBooks();

    @GET(Constants.SERVICES_GET_SLIDER)
    Call<List<String>> doGetSlider();

    @POST(Constants.SERVICES_BUY_BOOK + "/{bookId}")
    Call<Book> doBuyBook(@Header("x-auth-token") String token,
                         @Path("bookId") String id);

    @GET(Constants.SERVICES_GET_MY_BOOKS)
    Call<MyBooks> doGetMyBooks(@Header("x-auth-token") String token);
}