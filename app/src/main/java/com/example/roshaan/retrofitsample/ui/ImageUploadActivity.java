package com.example.roshaan.retrofitsample.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Base64;
import android.view.View;
import android.widget.Toast;

import com.example.roshaan.retrofitsample.R;
import com.example.roshaan.retrofitsample.databinding.ActivityImageUploadBinding;
import com.example.roshaan.retrofitsample.rest.ApiClient;
import com.example.roshaan.retrofitsample.rest.ApiClientForImage;
import com.example.roshaan.retrofitsample.rest.model.ImageModel;
import com.example.roshaan.retrofitsample.rest.model.User;
import com.example.roshaan.retrofitsample.rest.service.ApiInterface;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ImageUploadActivity extends AppCompatActivity {

    ActivityImageUploadBinding binding;
    public static final int REQUESTCODE=123;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_image_upload);


    }

    public void open(View v){

        Intent intent=new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,REQUESTCODE);
    }

    public void upload(View v){

        final String image=imageToString();
        String title=String.valueOf(binding.title.getText());

        ApiInterface apiInterface= ApiClientForImage.getApiClient().create(ApiInterface.class);
        Call<ImageModel> call=apiInterface.uploadImage(title,image);

        call.enqueue(new Callback<ImageModel>() {
            @Override
            public void onResponse(Call<ImageModel> call, Response<ImageModel> response) {

                ImageModel imageModel=response.body();
                System.out.println("Hllo "+imageModel);
                Toast.makeText(ImageUploadActivity.this, imageModel.getResponse(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ImageModel> call, Throwable t) {

            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==REQUESTCODE){

            Uri path= data.getData();

            try{
                bitmap= MediaStore.Images.Media.getBitmap(getContentResolver(),path);
                binding.imageId.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String imageToString(){

        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
        byte[] imgbyte=byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(imgbyte,Base64.DEFAULT);
    }
}
