package com.example.myapplication.services;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.myapplication.R;

public class ForegroundService extends AppCompatActivity {
    private String foregroundText;

    BroadcastReceiver br=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            foregroundText= String.valueOf(intent.getIntExtra("fore",0));
            Log.i("fore",foregroundText);
            TextView foreText = findViewById(R.id.foreText);
            foreText.setText(foregroundText);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foreground_service);

    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter filter =new IntentFilter();
        filter.addAction("com.example.foreground");
        registerReceiver(br,filter);
    }
}