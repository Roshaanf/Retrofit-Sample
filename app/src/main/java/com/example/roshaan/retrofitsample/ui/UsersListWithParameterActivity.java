package com.example.roshaan.retrofitsample.ui;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.roshaan.retrofitsample.R;
import com.example.roshaan.retrofitsample.databinding.ActivityUsersListWithParameterBinding;
import com.example.roshaan.retrofitsample.rest.ApiClient;
import com.example.roshaan.retrofitsample.rest.model.UserList;
import com.example.roshaan.retrofitsample.rest.service.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UsersListWithParameterActivity extends AppCompatActivity {

    ActivityUsersListWithParameterBinding binding;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding= DataBindingUtil.setContentView(this,R.layout.activity_users_list_with_parameter);

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        //end point /api/users?
        Call<UserList> call = apiInterface.getUserList(0);

        call.enqueue(new Callback<UserList>() {
            @Override
            public void onResponse(Call<UserList> call, Response<UserList> response) {

                UserList list=response.body();
                System.out.println("Hello "+list);

                //setting first user
                binding.firstName1.setText(list.getData().get(0).getFirstName());
                binding.lastName1.setText(list.getData().get(0).getLastName());
                binding.id1.setText(""+list.getData().get(0).getId());
                Glide.with(UsersListWithParameterActivity.this)
                        .load(list.getData().get(0).getAvatar())
                        .into(binding.image1);


                //setting secod user
                binding.firstName2.setText(list.getData().get(1).getFirstName());
                binding.lastName2.setText(list.getData().get(1).getLastName());
                binding.id2.setText(""+list.getData().get(1).getId());
                Glide.with(UsersListWithParameterActivity.this)
                        .load(list.getData().get(1).getAvatar())
                        .into(binding.image2);


                //setting 3rd user
                binding.firstName3.setText(list.getData().get(2).getFirstName());
                binding.lastName3.setText(list.getData().get(2).getLastName());
                binding.id3.setText(""+list.getData().get(2).getId());
                Glide.with(UsersListWithParameterActivity.this)
                        .load(list.getData().get(2).getAvatar())
                        .into(binding.image3);



                //Common info

                binding.page.setText(""+list.getPage());
                binding.perPage.setText(""+list.getPerPage());
                binding.total.setText(""+list.getTotal());
                binding.totalPage.setText(""+list.getTotalPages());
            }

            @Override
            public void onFailure(Call<UserList> call, Throwable t) {

            }
        });

    }
}
