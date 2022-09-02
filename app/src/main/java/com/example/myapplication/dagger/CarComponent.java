package com.example.myapplication.dagger;

import dagger.Component;

@Component (modules = WheelsModule.class)
public interface CarComponent {
    Car getCar();
}
