package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Layout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);
        Button lbtn1=(Button)findViewById(R.id.lbtn1);
        Button lbtn2=(Button)findViewById(R.id.lbtn6);
        Button cbtn=(Button)findViewById(R.id.cbtn);
        lbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Layout.this,LayoutHome.class);
                startActivity(intent);
            }
        });
        lbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Layout.this,LayoutExample.class);
                startActivity(intent);
            }
        });
        cbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Layout.this,Orient.class);
                startActivity(intent);

            }
        });
    }
}