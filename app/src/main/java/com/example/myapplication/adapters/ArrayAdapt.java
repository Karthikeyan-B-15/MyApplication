package com.example.myapplication.adapters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myapplication.R;

public class ArrayAdapt extends AppCompatActivity {
    ListView list;
    String[] names={"karthi","manikandan","tamil","hemath","gokul","naveen","maariselvam","nitheesh","abilesh","sanjay","deepa","zubair"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_adapt);
        list=(ListView) findViewById(R.id.arraylist);
        ArrayAdapter<String> arrayAdapter =new ArrayAdapter<String>(this,R.layout.listitem,R.id.listtext,names);
        list.setAdapter(arrayAdapter);
    }
}