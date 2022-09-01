package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.dagger.Car;
import com.example.myapplication.dagger.CarComponent;

public class MView extends AppCompatActivity {
    Button mview1,mview2;
    private Car car;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mview);
        mview1=(Button) findViewById(R.id.mview1);
        mview2=(Button) findViewById(R.id.mview2);
//        CarComponent component= DaggerCarComponent.create();
//        car=component.getCar();
//        car.dive();
        mview1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MView.this,MViewBinding.class);
                startActivity(intent);
            }
        });
        mview2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MView.this,MDataBinding.class);
                startActivity(intent);
            }
        });
    }
}