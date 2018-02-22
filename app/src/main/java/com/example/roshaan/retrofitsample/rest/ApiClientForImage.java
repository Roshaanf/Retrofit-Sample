package com.example.roshaan.retrofitsample.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Roshaan on 2/12/2018.
 */

public class ApiClientForImage {

    //making this new class because base url is changed

    public static final String BASE_URL = "http://10.0.3.2/uploadedimage/";
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
