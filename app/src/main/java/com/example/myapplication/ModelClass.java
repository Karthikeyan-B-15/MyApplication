package com.example.myapplication;

public class ModelClass {
    String name;
    int image;
    public ModelClass(String name,int image){
        this.name=name;
        this.image=image;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }
}
