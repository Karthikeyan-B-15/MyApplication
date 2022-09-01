package com.example.myapplication.adapters.recycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class Recycle extends AppCompatActivity {
    Adapter adapter;
    List<ModelClass> list;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);
        recyclerView=(RecyclerView)findViewById(R.id.recycle);
        list=new ArrayList<>();
        list.add(new ModelClass("Mountain",R.drawable.nature1));
        list.add(new ModelClass("Mountain",R.drawable.nature2));
        list.add(new ModelClass("Mountain",R.drawable.nature3));
        list.add(new ModelClass("Mountain",R.drawable.nature4));
        list.add(new ModelClass("Mountain",R.drawable.nature1));
        list.add(new ModelClass("Mountain",R.drawable.nature2));
        list.add(new ModelClass("Mountain",R.drawable.nature3));
        list.add(new ModelClass("Mountain",R.drawable.nature4));
        list.add(new ModelClass("Mountain",R.drawable.nature1));
        list.add(new ModelClass("Mountain",R.drawable.nature2));
        list.add(new ModelClass("Mountain",R.drawable.nature3));
        list.add(new ModelClass("Mountain",R.drawable.nature4));
        layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
//        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
//        recyclerView.setLayoutManager(gridLayoutManager);
        adapter=new Adapter(list);
        recyclerView.setAdapter(adapter);


    }
}