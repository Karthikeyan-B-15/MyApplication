package com.example.myapplication.services.exmple;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class ExpService extends AppCompatActivity {
    private Button sbtn2,sbtn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exp_service);
        sbtn2=(Button)findViewById(R.id.sbtn2);
        sbtn3=(Button) findViewById(R.id.sbtn3);
        sbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(ExpService.this,Mservice.class);
                intent.putExtra("i",1);
                startService(intent);
            }
        });
        sbtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(ExpService.this,Mservice.class);

                stopService(intent);
            }
        });
    }
}