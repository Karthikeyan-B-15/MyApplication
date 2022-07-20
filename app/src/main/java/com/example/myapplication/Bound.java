package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Button;
import android.widget.TextView;

public class Bound extends AppCompatActivity {
    private BoundService boundService;
    private ServiceConnection serviceConnection;
    private boolean isbound;
    private TextView btext;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bound);
        serviceConnection=null;
        Button bbtn1 = (Button) findViewById(R.id.bbtn1);
        Button bbtn2 = (Button) findViewById(R.id.bbtn2);
        Button bbtn3 = (Button) findViewById(R.id.bbtn3);
        Button bbtn4 = (Button) findViewById(R.id.bbtn4);
        Button bbtn5 = (Button) findViewById(R.id.bbtn5);
        btext=(TextView)findViewById(R.id.bindtext);
        bbtn1.setOnClickListener(view -> {
             intent=new Intent(Bound.this,BoundService.class);
            startService(intent);
        });
        bbtn2.setOnClickListener(view -> {
            intent=new Intent(Bound.this,BoundService.class);

            stopService(intent);
        });
        bbtn3.setOnClickListener(view -> {
            bindServ();
        });
        bbtn4.setOnClickListener(view -> {
            unBindService();
        });
        bbtn5.setOnClickListener(view -> {
            setCount();
        });

    }
    public void bindServ(){
        if(serviceConnection==null){
            serviceConnection=new ServiceConnection() {
                @Override
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    BoundService.MyBinder myBinder=(BoundService.MyBinder)iBinder;
                    boundService=myBinder.getService();
                    isbound=true;
                }

                @Override
                public void onServiceDisconnected(ComponentName componentName) {
                    isbound=false;
                }
            };
        }
        bindService(intent,serviceConnection, Context.BIND_AUTO_CREATE);
    }
    public void unBindService(){
        if(isbound){
            unbindService(serviceConnection);
            isbound=false;
        }
    }
    public void setCount(){
        if(isbound){
            btext.setText("Count"+boundService.getCount());
        }else{
            btext.setText("Service not found");
        }
    }
}