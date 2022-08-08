package com.example.myapplication;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import androidx.annotation.NonNull;

public class LooperThread extends Thread{
    Handler handler;
    @Override
    public void run() {
        Looper.prepare();
         handler=new Handler(Looper.myLooper()){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                Log.d("thread","looperthread"+msg.obj);
            }
        };

        Looper.loop();
    }
}
