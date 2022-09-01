package com.example.myapplication.api;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.AsyncTaskLoader;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.myapplication.R;

public class ParallelAsync extends AppCompatActivity {
    ProgressBar progressBarA,progressBarB;
    Button pbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parallel_async);
        progressBarA=(ProgressBar)findViewById(R.id.progressBarA);
        progressBarB=(ProgressBar)findViewById(R.id.progressBarB);
        pbtn=(Button)findViewById(R.id.pbtn);
        pbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressAsyncA progressAsyncA=new ProgressAsyncA();
                progressAsyncA.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
                ProgressAsyncB progressAsyncB=new ProgressAsyncB();
                progressAsyncB.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
            }
        });
    }
    public class ProgressAsyncA extends AsyncTask<Void,Integer,Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            try {

                for (int i=0;i<10;i++){
                    Thread.sleep(1000);
                   publishProgress(i);
                }
            }catch (Exception e){
                e.printStackTrace();
            };
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            progressBarA.setProgress(values[0]+1);
        }
    }
    public class ProgressAsyncB extends AsyncTask<Void,Integer,Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            try {

                for (int i=0;i<10;i++){
                    Thread.sleep(500);
                    publishProgress(i);
                }
            }catch (Exception e){
                e.printStackTrace();
            };
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            progressBarB.setProgress(values[0]+1);
        }
    }

}