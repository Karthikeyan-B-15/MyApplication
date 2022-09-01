package com.example.myapplication.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class ServiceB extends Service {
    private int count=0;
    private boolean boolval=false;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("demo","Thread Id :"+Thread.currentThread().getId());
        boolval=true;
        new Thread((Runnable) ()->{
            startCount();
        }).start();
        return START_STICKY;
    }

    public void startCount(){
        while(boolval){
            try{
                Thread.sleep(1000);
                if(boolval){
                    count=count+5;
                    Intent intent=new Intent("com.myapp.broad_cast_receiver2");
                    intent.putExtra("intval2",count);
                    sendBroadcast(intent);
                    Log.i("demo","Thread Id :"+Thread.currentThread().getId()+" "+"Count :"+count);
                }
            }catch (InterruptedException e){
                Log.i("demo","Thread Interupt");
            }
        }
    }
    public void stopCount(){
        boolval=false;
    }

//    public int getCount() {
//        return count;
//    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopCount();
        Log.i("demo","Thread destroy");
    }
}
