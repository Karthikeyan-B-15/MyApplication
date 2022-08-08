package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class SimpleAdapters extends AppCompatActivity {
    ListView list;
    String[] names={"karthi","manikandan","tamil","hemath","gokul","naveen","maariselvam","nitheesh","abilesh","sanjay","deepa","zubair"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_adapters);
        list=(ListView) findViewById(R.id.list);
        ArrayList<HashMap<String,String>> arrayList=new ArrayList<>();
        for (int i=0;i<names.length;i++){
            HashMap<String,String> hashMap=new HashMap<>();
            hashMap.put("name",names[i]);
            arrayList.add(hashMap);
        }
        String[] from={"name"};
        int[] to={R.id.listtext};
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,arrayList,R.layout.listitem,from,to);
        list.setAdapter(simpleAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(SimpleAdapters.this,"Name is"+" "+names[i],Toast.LENGTH_LONG).show();
            }
        });
    }
}