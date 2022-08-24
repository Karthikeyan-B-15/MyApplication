package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import androidx.work.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadWork extends AppCompatActivity  {
    Button twbtn1,twbtn2;
    WorkManager workManager;
    Constraints constraints;
    WorkRequest workRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_work);
        twbtn1=(Button) findViewById(R.id.twbtn1);
        twbtn2=(Button) findViewById(R.id.twbtn2);
        Configuration myConfig = new Configuration.Builder()
                .setExecutor(Executors.newFixedThreadPool(8))
                .build();
        workManager.initialize(this,myConfig);
        workManager=workManager.getInstance(this);
        constraints=new Constraints.Builder()
                .setRequiredNetworkType(NetworkType.UNMETERED)
                .build();
        workRequest=new PeriodicWorkRequest.Builder(Counter2.class,5, TimeUnit.SECONDS)
                .setConstraints(constraints).build();
        twbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                workManager.enqueue(workRequest);
            }
        });
        twbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                workManager.cancelAllWork();
            }
        });
    }


}