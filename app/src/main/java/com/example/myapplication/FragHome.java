package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FragHome extends AppCompatActivity {
    private Button fragbtn1, fragbtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag_home);
        fragbtn1 = (Button) findViewById(R.id.fragbtn1);
        fragbtn2 = (Button) findViewById(R.id.fragbtn2);
        fragbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FragHome.this, FragMain.class);
                startActivity(intent);
            }
        });
        fragbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FragHome.this, FragPass.class);
                startActivity(intent);
            }
        });
    }
}
