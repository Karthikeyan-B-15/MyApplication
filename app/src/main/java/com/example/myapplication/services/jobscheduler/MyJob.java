package com.example.myapplication.services.jobscheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

public class MyJob extends JobService {
    JobAsync jobAsync;
    JobParameters jobParameters;
    boolean check=false;
    boolean jobCanelled=false;
    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        check=true;
        this.jobParameters=jobParameters;
        jobAsync=new JobAsync();
        jobAsync.execute();
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        jobAsync.cancel(true);
        jobCanelled=true;
        return true;
    }
    public class JobAsync extends AsyncTask<Void, Void, Void> {


        @Override
        protected Void doInBackground(Void... voids) {
            int count=0;
            while (check){
                try {Thread.sleep(1000);
                    if(check) {

                        count++;
                        Log.i("demo1", String.valueOf(count));
                        Intent intent = new Intent("com.myapp.broad_cast_receiver3");
                        intent.putExtra("jobval", count);
                        sendBroadcast(intent);

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            if (jobCanelled) {
                jobFinished(jobParameters, false);
            }
    return null;
        }
    }
    public void onStop(){
        check=false;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        onStop();
    }
}

