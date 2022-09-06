package com.example.myapplication.mvvm.viewmodel;

import android.util.Log;

import androidx.lifecycle.Lifecycle;

import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;


public class ActivityViewModel extends ViewModel implements LifecycleObserver {
    private boolean check =false;
    Thread thread;
    private int count=0;
    MutableLiveData<Integer> counter;
    public ActivityViewModel(){
        counter=new MutableLiveData<>();
        thread=new Thread((Runnable) () -> {
            while (check) {
                try {

                    Thread.sleep(1000);
                    if(check) {
                        count++;
                        counter.postValue(count);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
    public LiveData<Integer> getCounter(){
        return counter;
    }
    public void startcount(){
        if(!check) {
            check = true;
            thread.start();
        }
    }
    public void stopcount(){
        check=false;
    }
//    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
//    private void lifeCycle(){
//        Log.d("lifecycle","Event is resumed!");
//    }
}
