package com.example.roshaan.retrofitsample.rest.service;

import com.example.roshaan.retrofitsample.rest.model.ImageModel;
import com.example.roshaan.retrofitsample.rest.model.User;
import com.example.roshaan.retrofitsample.rest.model.UserList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Roshaan on 2/8/2018.
 */

public interface ApiInterface {

    //single user
    @GET("/api/users/2")
    Call<User> getSingleUser();

    //userlist with parameter , if more thn one paramters are required thn use Ex: @QueryMap Map<String,String> options
    @GET("/api/users?")
    Call<UserList> getUserList(@Query("page") int page);

    @FormUrlEncoded
    @POST("upload.php")
    Call<ImageModel> uploadImage(@Field("title") String title,@Field("image") String image);
}
