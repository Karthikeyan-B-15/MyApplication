package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ThreadsDemo extends AppCompatActivity {
    Button tbtn1,tbtn2;
  private volatile boolean stop=false;
    Handler handler=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_threads_demo);
        tbtn1=(Button)findViewById(R.id.tbtn1);
        tbtn2=(Button)findViewById(R.id.tbtn2);
        tbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                ExtendedThread extendedThread=new ExtendedThread(10);
//                extendedThread.start();
                stop=false;
                IRunnable runnable=new IRunnable(10);
                new Thread(runnable).start();
            }
        });
        tbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("thread","Message Thread Stop");
                stop=true;

            }
        });
    }
    class ExtendedThread extends Thread{
        int seconds;
        ExtendedThread(int seconds){
            this.seconds=seconds;
        }
        @Override
        public void run() {
            for(int i=0;i<seconds;i++){
                Log.d("thread","Message Thread is"+i);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    class IRunnable implements Runnable{
        int seconds;
        IRunnable(int seconds){
            this.seconds=seconds;
        }
        @Override
        public void run() {
            for(int i=0;i<seconds;i++){
                if(stop){
                    return;
                }

                Log.d("thread","Message Thread is"+i);

                if(i==5){
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            tbtn1.setText("begin");
                        }
                    });
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}