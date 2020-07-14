package com.example.bookstore.helpers;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.bookstore.backend.models.User;
import com.google.gson.Gson;

public class SharedPreference {
    public static void saveToken(Context context, String accessToken) {
        SharedPreferences.Editor editor =
                PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putString(Constants.KEY_TOKEN, accessToken);
        editor.apply();
    }

    public static String getToken(Context context) {
        SharedPreferences preferences =
                PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(Constants.KEY_TOKEN, null);
    }

    public static void deleteToken(Context context) {
        SharedPreferences.Editor editor =
                PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.remove(Constants.KEY_TOKEN);
        editor.apply();
    }

    public static void saveUser(Context context, User user) {
        SharedPreferences.Editor editor =
                PreferenceManager.getDefaultSharedPreferences(context).edit();
        Gson gson = new Gson();
        String json = gson.toJson(user);
        editor.putString(Constants.USER, json);
        editor.apply();
    }

    public static User getUser(Context context) {
        SharedPreferences preferences =
                PreferenceManager.getDefaultSharedPreferences(context);
        Gson gson = new Gson();
        String json = preferences.getString(Constants.USER, null);
        return gson.fromJson(json, User.class);
    }

    public static void deleteUser(Context context) {
        SharedPreferences.Editor editor =
                PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.remove(Constants.USER);
        editor.apply();
    }
}
