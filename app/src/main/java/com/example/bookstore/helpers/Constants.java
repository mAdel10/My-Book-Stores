package com.example.bookstore.helpers;

public class Constants {

    /**
     * ---------------------------------------------------------------------------------------------
     * ---------------------------------------- API ------------------------------------------------
     */
    public static final String BASE_URL = "https://node-book-store.herokuapp.com/api/";
    public static final String SERVICES_SIGN_UP = BASE_URL + "users/register";
    public static final String SERVICES_SIGN_IN = BASE_URL + "users/login";
    public static final String SERVICES_PROFILE = BASE_URL + "users/me";
    public static final String SERVICES_EDIT_PROFILE = BASE_URL + "users/editProfile";
    public static final String SERVICES_GET_BOOKS = BASE_URL + "books/";
    public static final String SERVICES_GET_SLIDER = BASE_URL + "books/home/slider";
    public static final String SERVICES_BUY_BOOK = BASE_URL + "books/buy";
    public static final String SERVICES_GET_MY_BOOKS = BASE_URL + "users/books";

    /**
     * ---------------------------------------------------------------------------------------------
     * ---------------------------------------- KEYS -----------------------------------------------
     */
    public static final String INTENT_ID = "intentId";
    public static final String INTENT_KEY = "intentKey";
    public static final String INTENT_NAME = "intentName";
    public static final String INTENT_LOCALE = "intentLocale";
    public static final String INTENT_OBJECT = "intentObject";
    public static final String KEY_TOKEN = "authToken";
    public static final String USER = "user";

    public static final String INTENT_SESSION = "intentSession";
    public static final String INTENT_GROUP = "intentGroup";

    /**
     * ---------------------------------------------------------------------------------------------
     * --------------------------------- FONTS -----------------------------------------------------
     */
    public static final String FONT_GOTHAM_BOOK = "gotham_rounded_book.otf";
    public static final String FONT_GOTHAM_LIGHT = "gotham_rounded_light.otf";
    public static final String FONT_GOTHAM_MEDIUM = "gotham_rounded_medium.otf";
    public static final String FONT_GOTHAM_BOOK_ITALIC = "gotham_rounded_book_italic.otf";

    /**
     * ---------------------------------------------------------------------------------------------
     * ---------------------------------------- TIMING ---------------------------------------------
     */
    public static final int SPLASH_TIME_OUT = 3000;
    public static final int SLIDER_TIME_OUT = 1;

    /**
     * ---------------------------------------------------------------------------------------------
     * ---------------------------------------- Language -------------------------------------------
     */
    public static final String LOCALE_ENGLISH = "en";
    public static final String LOCALE_ENGLISH_US = "en_US";
    public static final String LOCALE_ARABIC = "ar";
}
