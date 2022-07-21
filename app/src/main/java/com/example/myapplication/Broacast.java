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
    private int broad_text,broad_text2;
    BroadcastReceiver br=new BroadcastReceiver(){
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals("com.myapp.broad_cast_receiver")) {
                broad_text = intent.getIntExtra("intval", 0);
                Log.i("demo", "broadcast receiver" + String.valueOf(intent.getIntExtra("intval", 0)));
            }else if(intent.getAction().equals("com.myapp.broad_cast_receiver2")){
                broad_text2 = intent.getIntExtra("intval2", 0);
                Log.i("demo", "broadcast receiver for ServiceB" + String.valueOf(intent.getIntExtra("intval2", 0)));
            }
            Toast.makeText(context,"Broadcast received",Toast.LENGTH_LONG).show();
        }
    };;

    private TextView broadText,broadText2;
    private Button broad_btn,start,stop,get2;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broacast);
        broadText=(TextView)findViewById(R.id.broadText);
        broad_btn=(Button)findViewById(R.id.broad_btn);
        start=(Button)findViewById(R.id.start);
        stop=(Button)findViewById(R.id.stop);
        get2=(Button)findViewById(R.id.get2);
        broadText2=(TextView) findViewById(R.id.broadText2);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 intent=new Intent(Broacast.this,ServiceB.class);
                startService(intent);
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 intent=new Intent(Broacast.this,ServiceB.class);
                stopService(intent);
            }
        });
        get2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                broadText2.setText(String.valueOf(broad_text2));
            }
        });
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
        filter.addAction("com.myapp.broad_cast_receiver2");
        registerReceiver(br, filter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(br);
    }
}