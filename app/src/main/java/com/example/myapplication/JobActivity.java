package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class JobActivity extends AppCompatActivity {
    TextView jtxt;
    Button jbtn;
    String jobval;
    JobScheduler jobScheduler;
    BroadcastReceiver  br=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals("com.myapp.broad_cast_receiver3")) {
                jobval=String.valueOf(intent.getIntExtra("jobval", 0));
            }
        }
    };
    JobInfo jobInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job);
        jtxt=(TextView) findViewById(R.id.jtxt);
        jbtn=(Button) findViewById(R.id.jbtn1);
        jbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startjob();
            }
        });

    }

    public void startjob(){
        ComponentName componentName=new ComponentName(this,MyJob.class);
        jobInfo=new JobInfo.Builder(100,componentName)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_CELLULAR)
                .setPeriodic(15*60*1000)
                .setRequiresCharging(false)
                .setPersisted(true)
                .build();
        jobScheduler=(JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
        if(jobScheduler.schedule(jobInfo)==JobScheduler.RESULT_SUCCESS){
            jtxt.setText(jobval);
        }
        else{
            jobScheduler.cancel(100);
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter filter = new IntentFilter();
        filter.addAction("com.myapp.broad_cast_receiver3");
        registerReceiver(br, filter);
    }
}