package com.example.roshaan.retrofitsample.rest.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Roshaan on 2/8/2018.
 */

public class User {

    @SerializedName("data")
    private Data data;

    public Data getData() {
        return data;
    }

    @Override
    public String toString() {
        return "User{" +
                "data=" + data +
                '}';
    }



    //making it child class so we can acces it in anyother pakage
   public class Data {

        @SerializedName("id")
        private int id;
        @SerializedName("first_name")
        private String firstName;
        @SerializedName("last_name")
        private String lastName;
        @SerializedName("avatar")
        private String avatar;

        public int getId() {
            return id;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getAvatar() {
            return avatar;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "id=" + id +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", avatar='" + avatar + '\'' +
                    '}';
        }
    }
}



