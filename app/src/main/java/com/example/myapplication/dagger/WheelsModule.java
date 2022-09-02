package com.example.myapplication.dagger;

import dagger.Module;
import dagger.Provides;

@Module
public class WheelsModule {
    @Provides
    static Rims provideRims(){
        return new Rims();
    }
    @Provides
    static Tires provideTires(){
        Tires tires=new Tires();
        tires.run();
        return tires;
    }
    @Provides
    static Wheels provideWheels(Rims rims,Tires tires){
        return new Wheels(rims,tires);
    }

}
