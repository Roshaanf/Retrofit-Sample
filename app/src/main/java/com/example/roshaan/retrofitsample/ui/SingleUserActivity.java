package com.example.roshaan.retrofitsample.ui;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.bumptech.glide.Glide;
import com.example.roshaan.retrofitsample.R;
import com.example.roshaan.retrofitsample.databinding.ActivityMainBinding;
import com.example.roshaan.retrofitsample.rest.ApiClient;
import com.example.roshaan.retrofitsample.rest.model.User;
import com.example.roshaan.retrofitsample.rest.service.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SingleUserActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        Call<User> call = apiInterface.getSingleUser();

        //will asynchronously send the request(BAckground thread but onResponse and onFailure will be called on main thread so
        //we can udpate UI
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                User user = response.body();
                System.out.println("User " + user);

                binding.firstName.setText(user.getData().getFirstName());
                binding.lastName.setText(user.getData().getLastName());
                binding.numbe.setText(String.valueOf(user.getData().getId()));


                Glide.with(SingleUserActivity.this)
                        .load(user.getData().getAvatar())
                        .into(binding.image);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

                System.out.println("onFailure " + t.getMessage());
            }
        });
    }
}
