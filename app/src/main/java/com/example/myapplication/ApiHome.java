package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ApiHome extends AppCompatActivity {
    private Button asyncbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api_home);
        asyncbtn=(Button) findViewById(R.id.asyncbtn);
        asyncbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(ApiHome.this,AsyncActivity.class);
                startActivity(intent);
            }
        });
    }
}