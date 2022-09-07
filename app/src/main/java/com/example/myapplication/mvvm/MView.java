package com.example.myapplication.mvvm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;
import com.example.myapplication.dagger.Car;
import com.example.myapplication.dagger.CarComponent;


//import com.example.myapplication.dagger.DaggerCarComponent;
import com.example.myapplication.dagger.DaggerCarComponent;
import com.example.myapplication.mvvm.noteapp.NoteActivity;
import com.example.myapplication.mvvm.viewmodel.MyViewModel2;

import javax.inject.Inject;

public class MView extends AppCompatActivity {
    Button mview1,mview2,mview3,mview4;
    @Inject Car car;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mview);
        mview1=(Button) findViewById(R.id.mview1);
        mview2=(Button) findViewById(R.id.mview2);
        mview3=(Button) findViewById(R.id.mview3);
        mview4=(Button) findViewById(R.id.mview4);
        CarComponent component= DaggerCarComponent.create();
        car=component.getCar();
        car.drive();
        mview1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MView.this, MViewBinding.class);
                startActivity(intent);
            }
        });
        mview2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MView.this, MDataBinding.class);
                startActivity(intent);
            }
        });
        mview3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MView.this,MyViewModel2.class);
                startActivity(intent);
            }
        });
        mview4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MView.this, NoteActivity.class);
                startActivity(intent);
            }
        });
    }
}