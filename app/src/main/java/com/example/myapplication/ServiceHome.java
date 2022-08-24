package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ServiceHome extends AppCompatActivity {
    private Button sbtn1,sbtn4,sbtn5,sbtn6,sbtn7,sbtn8,sbtn9,sbtn10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_home);
        sbtn1=(Button)findViewById(R.id.sbtn1);
        sbtn4=(Button)findViewById(R.id.sbtn4);
        sbtn5=(Button)findViewById(R.id.sbtn5);
        sbtn6=(Button)findViewById(R.id.sbtn6);
        sbtn7=(Button)findViewById(R.id.sbtn7);
        sbtn8=(Button)findViewById(R.id.sbtn8);
        sbtn9=(Button)findViewById(R.id.sbtn9);
        sbtn10=(Button)findViewById(R.id.sbtn10);
        sbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(ServiceHome.this,ExpService.class);
                startActivity(intent);
            }
        });
        sbtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ServiceHome.this,Bound.class);
                startActivity(intent);
            }
        });
        sbtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ServiceHome.this,ForegroundService.class);
                startActivity(intent);
            }
        });
        sbtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ServiceHome.this,ThreadsDemo.class);
                startActivity(intent);
            }
        });
        sbtn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ServiceHome.this,JobActivity.class);
                startActivity(intent);
            }
        });
        sbtn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ServiceHome.this,WorkActivity.class);
                startActivity(intent);
            }
        });
        sbtn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ServiceHome.this,ThreadWork.class);
                startActivity(intent);
            }
        });
        sbtn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ServiceHome.this,ListenThread.class);
                startActivity(intent);
            }
        });
    }
}