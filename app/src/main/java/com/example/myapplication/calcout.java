package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class calcout extends AppCompatActivity {
    TextView numtext;
    int num1,num2;
    Button add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcout);
        Intent numbers=getIntent();
        num1=Integer.parseInt(numbers.getStringExtra("nums1"));
        num2=Integer.parseInt(numbers.getStringExtra("nums2"));
        numtext=(TextView) findViewById(R.id.numtext);
        add=(Button) findViewById(R.id.add);
        numtext.setText("Perfoming numbers are :"+" "+num1+","+num2);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int res=num1+num2;
                Intent result=new Intent();
                result.putExtra("finalres",res);
                setResult(RESULT_OK,result);
                finish();
            }
        });
    }
}