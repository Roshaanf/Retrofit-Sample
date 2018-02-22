package com.example.roshaan.retrofitsample.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Roshaan on 2/8/2018.
 */

public class ApiClient {

    public static final String BASE_URL = "https://reqres.in";
    public static Retrofit mInstance = null;

    //singleton method
    public static Retrofit getApiClient() {
        if (mInstance == null) {
            mInstance = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build();

        }
        return mInstance;

    }
}
