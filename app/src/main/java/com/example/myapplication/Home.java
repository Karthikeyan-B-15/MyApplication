package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {
    private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8;
    GridLayoutManager gridLayoutManager;
    HomeAdapter homeAdapter;
    RecyclerView recyclerView;
    List<HomeModel> griditem;
    HomeAdapter.RecyclerClickListener listener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home);
        recyclerView=(RecyclerView) findViewById(R.id.homepager);
        griditem=new ArrayList<>();
        griditem.add(new HomeModel("Activity"));
        griditem.add(new HomeModel("Fragment"));
        griditem.add(new HomeModel("Service"));
        griditem.add(new HomeModel("Broad Cast"));
        griditem.add(new HomeModel("Layout"));
        griditem.add(new HomeModel("Calculator"));
        griditem.add(new HomeModel("Adapter"));
        griditem.add(new HomeModel("Recycler"));
        griditem.add(new HomeModel("Navigation"));
        griditem.add(new HomeModel("API"));
        griditem.add(new HomeModel("MVVM"));
        setOnClickLister();
        gridLayoutManager=new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);
        homeAdapter=new HomeAdapter(griditem,listener);
        recyclerView.setAdapter(homeAdapter);




    }
    public void setOnClickLister(){
        Intent intent;
        listener=new HomeAdapter.RecyclerClickListener() {
            @Override
            public void onClick(View view, int position) {
                switch (griditem.get(position).getText()){
                    case "Activity":
                        Intent intent=new Intent(Home.this,Login.class);
                        startActivity(intent);
                        break;
                    case "Fragment":
                        Intent intent1=new Intent(Home.this,FragHome.class);
                        startActivity(intent1);
                        break;
                    case "Service":
                        Intent intent2=new Intent(Home.this,ServiceHome.class);
                        startActivity(intent2);
                        break;
                    case "Broad Cast":
                        Intent intent3=new Intent(Home.this,Broacast.class);
                        startActivity(intent3);
                        break;
                    case "Layout":
                        Intent intent4=new Intent(Home.this,Layout.class);
                        startActivity(intent4);
                        break;
                    case "Calculator":
                        Intent intent5=new Intent(Home.this,Calculator.class);
                        startActivity(intent5);
                        break;
                    case "Adapter":
                        Intent intent6=new Intent(Home.this,AdapterHome.class);
                        startActivity(intent6);
                        break;
                    case "Recycler":
                        Intent intent7=new Intent(Home.this,RecyclerHome.class);
                        startActivity(intent7);
                        break;
                    case "Navigation":
                        Intent intent8=new Intent(Home.this,NavHome.class);
                        startActivity(intent8);
                        break;
                    case "API":
                        Intent intent9=new Intent(Home.this,ApiHome.class);
                        startActivity(intent9);
                        break;
                    case "MVVM":
                        Intent intent10=new Intent(Home.this,MView.class);
                        startActivity(intent10);
                        break;
                    default:
                }

            }
        };
    }

}