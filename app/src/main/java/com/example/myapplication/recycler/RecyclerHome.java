package com.example.myapplication.recycler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;
import com.example.myapplication.recycler.stager.Stager;
import com.example.myapplication.recycler.todo.Todo;

public class RecyclerHome extends AppCompatActivity {
    Button rbtn1,rbtn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_home);
        rbtn1=(Button)findViewById(R.id.rbtn1);
        rbtn2=(Button)findViewById(R.id.rbtn2);
        rbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(RecyclerHome.this, Todo.class);
                startActivity(intent);
            }
        });
        rbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(RecyclerHome.this, Stager.class);
                startActivity(intent);
            }
        });
    }
}