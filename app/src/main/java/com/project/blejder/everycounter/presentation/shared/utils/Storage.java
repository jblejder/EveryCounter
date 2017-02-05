package com.project.blejder.everycounter.presentation.shared.utils;


import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.content.SharedPreferencesCompat;

import com.google.common.base.Optional;
import com.google.gson.Gson;
import com.project.blejder.everycounter.presentation.shared.Constants;

import javax.inject.Inject;

public class Storage {

    private SharedPreferences prefs;

    @Inject
    public Storage(Context app) {
        prefs = app
                .getSharedPreferences(Constants.USER_PREFS, Context.MODE_PRIVATE);
    }

    public <T> void putObject(T object, String key) {
        SharedPreferencesCompat.EditorCompat instance = SharedPreferencesCompat.EditorCompat
                .getInstance();
        String json = new Gson().toJson(object);

        SharedPreferences.Editor edit = prefs.edit();
        edit.putString(key, json);
        edit.apply();
    }

    public <T> Optional<T> getObject(String key, Class<T> clazz) {
        String string = this.prefs.getString(key, null);
        if (string == null) {
            return Optional.absent();
        }
        Gson gson   = new Gson();
        T    object = gson.fromJson(string, clazz);
        return Optional.of(object);
    }
}
