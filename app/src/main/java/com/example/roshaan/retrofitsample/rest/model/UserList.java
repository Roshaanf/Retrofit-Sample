package com.example.roshaan.retrofitsample.rest.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Roshaan on 2/8/2018.
 */

public class UserList {

    @SerializedName("page")
    int page;
    @SerializedName("per_page")
    int perPage;
    @SerializedName("total")
    int total;
    @SerializedName("total_pages")
    int totalPages;
    @SerializedName("data")
    List<Data> data;

    public int getPage() {
        return page;
    }

    public int getPerPage() {
        return perPage;
    }

    public int getTotal() {
        return total;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public List<Data> getData() {
        return data;
    }

    @Override
    public String toString() {
        return "UserList{" +
                "page=" + page +
                ", perPage=" + perPage +
                ", total=" + total +
                ", totalPages=" + totalPages +
                ", data=" + data +
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
