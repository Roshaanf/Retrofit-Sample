package com.example.roshaan.retrofitsample.rest.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Roshaan on 2/12/2018.
 */

public class ImageModel {

    @SerializedName("title")
    String title;
    @SerializedName("image")
    String image;
    @SerializedName("response")
    String response;

    public String getResponse() {
        return response;
    }

    @Override
    public String toString() {
        return "ImageModel{" +
                "title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", response='" + response + '\'' +
                '}';
    }


}
