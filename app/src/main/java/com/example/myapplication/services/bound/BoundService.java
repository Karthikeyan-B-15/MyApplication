package com.example.myapplication.services.bound;

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

import com.example.myapplication.services.App;
import com.example.myapplication.R;

public class BoundService extends Service {
    private int count=0;
    private boolean boolval=false;
    private String STOP_ACTION="stop";
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
        if(STOP_ACTION.equals(intent.getAction())){
            stopSelf();
        }
        new Thread((Runnable) ()->{
            startCount();
        }).start();

        return START_STICKY;
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void startCount(){
    while(boolval){
        try{
            Thread.sleep(1000);
            if(boolval){
                count=count+1;
                Intent notificationIntent = new Intent(this, Bound.class);
                PendingIntent pendingIntent =PendingIntent.getActivity(this, 0, notificationIntent, PendingIntent.FLAG_IMMUTABLE);
                //Broadcast sending data from notification
                Intent broadIntent= new Intent("com.example.foreground");
                broadIntent.putExtra("fore",count);
                PendingIntent actionIntent=PendingIntent.getBroadcast(this,0,broadIntent,PendingIntent.FLAG_UPDATE_CURRENT);
                //Stop the service from notification bar
                Intent stop=new Intent(this,BoundService.class);
                stop.setAction(STOP_ACTION);
                PendingIntent pStopSelf = PendingIntent.getForegroundService(this, 0, stop,PendingIntent.FLAG_CANCEL_CURRENT);

                Notification notification = new Notification.Builder(this, App.ID)
                        .setContentTitle("Example Notification")
                        .setSmallIcon(R.drawable.ic_android)
                        .setContentIntent(pendingIntent)
                        .setContentText(String.valueOf(count))
                        .setAutoCancel(true)
                        .setOnlyAlertOnce(true)
                        .addAction(R.mipmap.ic_launcher, "send", actionIntent)
                        .addAction(R.mipmap.ic_launcher,"cancel",pStopSelf)
                        .build();
                startForeground(1, notification);

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
