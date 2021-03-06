package com.theQuake.quakeInfo;

import android.content.Context;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Utils {

    public static List<Country> generateCountryList(Context context) throws IOException {
        List<Country> countries = new ArrayList<>();

        InputStream jsonInput = context.getAssets().open("countries.json");
        int jsonSize = jsonInput.available();
        byte[] buffer = new byte[jsonSize];
        jsonInput.read(buffer);
        jsonInput.close();
        String json = new String(buffer, "UTF-8");

        Gson gson = new Gson();
        Country[] countriesArray = gson.fromJson(json, Country[].class);

        countries = Arrays.asList(countriesArray);

        return countries;
    }
}
