package com.example.myapplication;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class Counter2 extends Worker {
    Context context;
    WorkerParameters workerParameters;
    boolean iscount;
    int count=0;
    public Counter2(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        this.context=context;
        this.workerParameters=workerParams;
        iscount=true;
    }

    @NonNull
    @Override
    public Result doWork() {
        countTheNumber();
        return Result.success();
    }
    public void countTheNumber(){
        int i=0;
        while (i<5 && iscount){
            try {
                Thread.sleep(1000);
                if(iscount){
                    count=count+5;
                    Log.d("count", String.valueOf(count));

                }

            }catch (Exception e){
                Log.d("count","thread interupt");
            }
            i++;
        }
    }

    @Override
    public void onStopped() {
        super.onStopped();
        iscount=false;
        Log.d("count","Counter stopped");
    }
}
