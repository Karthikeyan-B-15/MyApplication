package com.example.myapplication.api.asynctask;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

public class AsyncModel {
    String firstName,lastName,email,imgurl;
    int id;

    public AsyncModel(String firstName, String lastName, String email,String imgurl){
        this.email=email;
        this.firstName=firstName;
        this.lastName=lastName;
        this.imgurl=imgurl;
    }

    public AsyncModel(int id,String firstName, String lastName, String email,String imgurl){
        this.id=id;
        this.email=email;
        this.firstName=firstName;
        this.lastName=lastName;
        this.imgurl=imgurl;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
