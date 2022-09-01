package com.example.myapplication.dagger;

import android.util.Log;

import javax.inject.Inject;

public class Car {
    private Engine engine;
    @Inject
    public Car (Engine engine){
        this.engine=engine;
    }
    public void dive(){
        Log.d("car","driving.....");
    }
}
