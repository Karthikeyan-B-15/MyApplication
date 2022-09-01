package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.Configuration;
import androidx.work.Constraints;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;

import android.media.VolumeShaper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WorkActivity extends AppCompatActivity {
    WorkManager workManager;
    Constraints constraints;
    PeriodicWorkRequest workRequest;
    WorkRequest workRequest1,workRequest2,workRequest3;
    Button wbtn1,wbtn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work);
        wbtn1=(Button)findViewById(R.id.wbtn1);
        wbtn2=(Button)findViewById(R.id.wbtn2);
        workManager=workManager.getInstance(this);
        constraints=new Constraints.Builder()
                .setRequiredNetworkType(NetworkType.UNMETERED)
                .build();
        workRequest=new PeriodicWorkRequest.Builder(Counter.class,5,TimeUnit.SECONDS)
                .setConstraints(constraints).build();
//        workRequest1=(OneTimeWorkRequest)new OneTimeWorkRequest.Builder(Counter.class).addTag("worker1").build();
//        workRequest2=(OneTimeWorkRequest)new OneTimeWorkRequest.Builder(Counter2.class).addTag("worker2").build();
//        workRequest3=(OneTimeWorkRequest)new OneTimeWorkRequest.Builder(Counter3.class).addTag("worker3").build();
        wbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                workManager.enqueue(workRequest);

                workManager.enqueueUniquePeriodicWork("work",
                        ExistingPeriodicWorkPolicy.REPLACE,
                        workRequest
                        );
//                workManager.beginWith((OneTimeWorkRequest) workRequest1)
//                        .then((OneTimeWorkRequest) workRequest2)
//                        .then((OneTimeWorkRequest) workRequest3).enqueue();
//                workManager.beginWith(Arrays.asList((OneTimeWorkRequest)workRequest1,(OneTimeWorkRequest) workRequest2)).then((OneTimeWorkRequest) workRequest3).enqueue();
            }
        });
        wbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                  workManager.cancelAllWork();
//                workManager.cancelWorkById(workRequest.getId());

                    workManager.cancelUniqueWork("work");


//                workManager.cancelAllWorkByTag("worker2");
            }
        });

    }


}