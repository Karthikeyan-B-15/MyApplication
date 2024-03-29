package com.example.myapplication.api;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.api.volley.Apilib;
import com.example.myapplication.api.asynctask.AsyncActivity;
import com.example.myapplication.R;
import com.example.myapplication.SharedData;

import java.util.List;

public class ApiHome extends AppCompatActivity {
    private Button asyncbtn,pasync,apibtn,databtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api_home);
        asyncbtn=(Button) findViewById(R.id.asyncbtn);
        pasync=(Button) findViewById(R.id.pasync);
        apibtn=(Button) findViewById(R.id.apibtn);
        databtn=(Button) findViewById(R.id.databtn);
        Intent intent=getIntent();
        String action=intent.getAction();
        Uri data =intent.getData();
        if(data!=null) {
            List<String> params = data.getPathSegments();
            String id = params.get(params.size() - 1);
            Toast.makeText(this, id, Toast.LENGTH_LONG).show();
        }
        asyncbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(ApiHome.this, AsyncActivity.class);
                startActivity(intent);
            }
        });
        pasync.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(ApiHome.this, ParallelAsync.class);
                startActivity(intent);
            }
        });
        apibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(ApiHome.this, Apilib.class);
                startActivity(intent);
            }
        });
        databtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(ApiHome.this, SharedData.class);
                startActivity(intent);
            }
        });
    }
}