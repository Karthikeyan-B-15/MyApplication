package com.example.myapplication.adapters.customadapt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.myapplication.Data;
import com.example.myapplication.R;

import java.util.ArrayList;

public class Custom extends AppCompatActivity {
    ListView listView;
    ArrayList<Data> arrayList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
        listView=(ListView)findViewById(R.id.customlist);
        arrayList.add(new Data("Nature 1",R.drawable.nature1));
        arrayList.add(new Data("Nature 2",R.drawable.nature2));
        arrayList.add(new Data("Nature 3",R.drawable.nature3));
        arrayList.add(new Data("Nature 4",R.drawable.nature4));
        CustomAdapter customAdapter=new CustomAdapter(this,R.layout.customadapter,arrayList);
        listView.setAdapter(customAdapter);
    }
}