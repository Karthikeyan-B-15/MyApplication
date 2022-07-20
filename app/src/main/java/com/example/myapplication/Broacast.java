package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Broacast extends AppCompatActivity {
    BroadcastReceiver br=new BroadcastReceiver(){
        public void onReceive(Context context, Intent intent) {
            broad_text=intent.getIntExtra("intval",0);
            Log.i("demo","broadcast receiver"+ String.valueOf(intent.getIntExtra("intval",0)));
            Toast.makeText(context,"Broadcast received",Toast.LENGTH_LONG).show();
        }
    };;
    private int broad_text;
    private TextView broadText;
    private Button broad_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broacast);
        broadText=(TextView)findViewById(R.id.broadText);
        broad_btn=(Button)findViewById(R.id.broad_btn);

        broad_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                broadText.setText(String.valueOf(broad_text));

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter filter = new IntentFilter();
        filter.addAction("com.myapp.broad_cast_receiver");
        registerReceiver(br, filter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(br);
    }
}