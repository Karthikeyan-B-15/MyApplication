package com.example.myapplication.adapters.pager;

public class Data {
    String title;
    int image;
    public Data(String title,int image){
        this.title=title;
        this.image=image;
    }
    public String getTitle(){
        return title;
    }
    public int getImage(){
        return image;
    }
}
