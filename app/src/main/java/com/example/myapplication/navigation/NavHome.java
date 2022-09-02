package com.example.myapplication.navigation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.navigation.basics.NavBasic;
import com.example.myapplication.navigation.drawer.ui.NavigationActivity;
import com.example.myapplication.R;

public class NavHome extends AppCompatActivity {
    private Button nbtn1,nbtn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_home);
        nbtn1=(Button)findViewById(R.id.nbtn1);
        nbtn2=(Button)findViewById(R.id.nbtn2);
        nbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(NavHome.this, NavBasic.class);
                startActivity(intent);
            }
        });
        nbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(NavHome.this, NavigationActivity.class);
                startActivity(intent);
            }
        });
    }
}