package com.example.myapplication.services.workmanager;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import java.io.IOException;

public class Counter extends Worker {
    Context context;
    WorkerParameters workerParameters;
    boolean iscount;
    int count=0;
    public Counter(@NonNull Context context, @NonNull WorkerParameters workerParams) {
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

        while ( iscount && count<10){
            try {
                Thread.sleep(1000);
                if(iscount ){
                    count++;
                    Log.d("count", String.valueOf(count));

                }

            }catch (InterruptedException e){
                Log.d("count","thread interupt");
            }

        }
    }

//    @Override
//    public void onStopped() {
//        super.onStopped();
//        try {
//            iscount=false;
//            Log.d("count","Counter stopped");
//        }catch (Exception e){
//            Log.d("count",String.valueOf(e));
//        }
//
//    }


}
