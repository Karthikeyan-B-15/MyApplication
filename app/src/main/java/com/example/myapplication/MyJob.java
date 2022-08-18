package com.example.myapplication;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

public class MyJob extends JobService {
    JobAsync jobAsync;
    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        jobAsync=new JobAsync(jobParameters);
        jobAsync.execute();
        jobFinished(jobParameters,false);
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        jobAsync.cancel(true);
        return false;
    }
    public class JobAsync extends AsyncTask<Void,Void,Void>{
        int count=0;
        JobParameters jobParameters;
        JobAsync(JobParameters jobParameters){
            this.jobParameters=jobParameters;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            while (true) {
                try {
                    Thread.sleep(1000);
                    if(true) {
                        count++;
                        Intent intent = new Intent("com.myapp.broad_cast_receiver3");
                        intent.putExtra("jobval", count);
                        sendBroadcast(intent);
                        Log.i("demo1", "broadcast receiver for ServiceB" + String.valueOf(intent.getIntExtra("jobval", 0)));

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        }
    }
    }

