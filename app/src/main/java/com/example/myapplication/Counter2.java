package com.example.myapplication;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import java.util.concurrent.CancellationException;

public class Counter2 extends Worker {
    Context context;
    WorkerParameters workerParameters;
    boolean iscount;
    int count=0;
    public Counter2(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        this.context=context;
        this.workerParameters=workerParams;

    }

    @NonNull
    @Override
    public Result doWork() {
        iscount =true;
        try {
            countTheNumber(iscount);
        }catch (Exception e){
            e.printStackTrace();
            return Result.failure();
        }

        return Result.success();
    }
    public void countTheNumber(Boolean iscount){
        int i=0;
        while (i<5 && iscount){
            try {
                Thread.sleep(1000);
                if(iscount){
                    count=count+5;
                    Log.d("count", String.valueOf(count));

                }

            }catch (CancellationException | InterruptedException e){
                e.printStackTrace();
                Log.d("count",String.valueOf(e));
            }
            i++;
        }
    }

    @Override
    public void onStopped() {
        super.onStopped();
        iscount=false;
        countTheNumber(iscount);
        Log.d("count","Counter stopped");
    }

}
