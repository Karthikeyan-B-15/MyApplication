package com.example.myapplication;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class BoundService extends Service {
    private int count=0;
    private boolean boolval=false;
    class MyBinder extends Binder{
        public BoundService getService(){
            return BoundService.this;
        }
    }
    private IBinder binder =new MyBinder();
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("demo","on bind");
        return binder;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("demo","Thread Id :"+Thread.currentThread().getId());
        boolval=true;
        new Thread((Runnable) ()->{
            startCount();
        }).start();
        // If the notification supports a direct reply action, use
// PendingIntent.FLAG_MUTABLE instead.
        Intent notificationIntent = new Intent(this, Bound.class);
        PendingIntent pendingIntent =
                PendingIntent.getActivity(this, 0, notificationIntent,
                        PendingIntent.FLAG_IMMUTABLE);


        Notification notification = new Notification.Builder(this, com.example.myapplication.App.ID)
                    .setContentTitle("Example Notification")
                .setSmallIcon(R.drawable.ic_android)
                    .setContentIntent(pendingIntent)
                    .build();


// Notification ID cannot be 0.
        startForeground(1, notification);

        return START_STICKY;
    }
    public void startCount(){
    while(boolval){
        try{
            Thread.sleep(1000);
            if(boolval){
                count=count+1;
                Intent intent=new Intent("com.myapp.broad_cast_receiver");
                intent.putExtra("intval",count);
                sendBroadcast(intent);
                Log.i("demo","Thread Id :"+Thread.currentThread().getId()+" "+"Count :"+count);
            }
        }catch (InterruptedException e){
            Log.i("demo","Thread Interupt");
        }
    }
    }
    public void stopCount(){
        boolval=false;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopCount();
        Log.i("demo","Thread destroy");
    }
}
