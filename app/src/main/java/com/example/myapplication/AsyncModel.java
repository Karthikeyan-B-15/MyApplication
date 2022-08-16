package com.example.myapplication;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

public class AsyncModel {
    String firstName,lastName,email,imgurl;

    public AsyncModel(String firstName, String lastName, String email,String imgurl){
        this.email=email;
        this.firstName=firstName;
        this.lastName=lastName;
        this.imgurl=imgurl;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public String getLastName() {
        return lastName;
    }

    public String getImgurl() {
        return imgurl;
    }
}
