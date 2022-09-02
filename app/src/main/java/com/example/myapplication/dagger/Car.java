package com.example.myapplication.dagger;

import android.util.Log;

import javax.inject.Inject;

public class Car {
    private Engine engine;
    private Wheels wheels;
    @Inject
    public Car (Engine engine,Wheels wheels){
        this.engine=engine;
        this.wheels=wheels;
    }
    public void drive(){
        Log.d("car","driving.....");
    }
}
