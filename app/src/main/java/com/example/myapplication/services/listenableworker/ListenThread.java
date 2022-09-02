package com.example.myapplication.services.listenableworker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;
import com.example.myapplication.services.workmanager.Counter2;

import java.util.concurrent.TimeUnit;

public class ListenThread extends AppCompatActivity {
    Button lwbtn1,lwbtn2;
    WorkRequest workRequest;
    Constraints constraints;
    WorkManager workManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listen_thread);
        lwbtn1=(Button)findViewById(R.id.lwbtn2);
        lwbtn2=(Button)findViewById(R.id.lwbtn2);
        workManager=workManager.getInstance(this);
        constraints=new Constraints.Builder()
                .setRequiredNetworkType(NetworkType.UNMETERED)
                .build();
        workRequest=new PeriodicWorkRequest.Builder(Counter2.class,5, TimeUnit.SECONDS)
                .setConstraints(constraints).build();
        lwbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                workManager.enqueue(workRequest);
            }
        });
        lwbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                workManager.cancelAllWork();
            }
        });
    }
}