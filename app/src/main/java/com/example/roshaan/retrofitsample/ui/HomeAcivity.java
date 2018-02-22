package com.example.roshaan.retrofitsample.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.roshaan.retrofitsample.R;

public class HomeAcivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_acivity);
    }

    public void singleUser(View v){
        startActivity(new Intent(this,SingleUserActivity.class));
    }

    public void usersList(View v){
        startActivity(new Intent(this,UsersListWithParameterActivity.class));
    }
    public void imageUpload(View v){
        startActivity(new Intent(this,ImageUploadActivity.class));
    }
}
