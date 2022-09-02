package com.example.myapplication.services.jobscheduler;

import androidx.appcompat.app.AppCompatActivity;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;

public class JobActivity extends AppCompatActivity {
    TextView jtxt;
    Button jbtn,jbtn2;
    String jobval;
    JobScheduler jobScheduler;
    BroadcastReceiver  br=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals("com.myapp.broad_cast_receiver3")) {
                jtxt.setText(String.valueOf(intent.getIntExtra("jobval", 0)));
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
        jbtn2=(Button) findViewById(R.id.jbtn2);
        jobScheduler=(JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);

        jbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                jbtn.setEnabled(false);
                startjob();
            }
        });
        jbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jbtn.setEnabled(true);
                jobScheduler.cancel(100);
            }
        });

    }

    public void startjob(){
        ComponentName componentName=new ComponentName(this,MyJob.class);
        jobInfo=new JobInfo.Builder(100,componentName)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
                .setPeriodic(15*60*1000)
                .setRequiresCharging(false)
                .setPersisted(true)
                .build();
        jobScheduler.schedule(jobInfo);


    }


    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter filter = new IntentFilter();
        filter.addAction("com.myapp.broad_cast_receiver3");
        registerReceiver(br, filter);
    }
    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(br);
    }
}