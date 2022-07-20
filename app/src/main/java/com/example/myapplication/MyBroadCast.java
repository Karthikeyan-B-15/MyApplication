package com.example.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyBroadCast extends BroadcastReceiver {
    private int broad_text;
    @Override
    public void onReceive(Context context, Intent intent) {
        broad_text=intent.getIntExtra("intval",0);
       Log.i("demo","broadcast receiver"+ String.valueOf(intent.getIntExtra("intval",0)));
        Toast.makeText(context,"Broadcast received",Toast.LENGTH_LONG).show();

    }
}
