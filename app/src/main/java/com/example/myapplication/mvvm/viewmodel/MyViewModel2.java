package com.example.myapplication.mvvm.viewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;


import com.example.myapplication.databinding.ActivityMyViewModel2Binding;


public class MyViewModel2 extends AppCompatActivity {


    private ActivityMyViewModel2Binding binding;
    ActivityViewModel activityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMyViewModel2Binding.inflate(getLayoutInflater());
      View view=binding.getRoot();
        setContentView(view);
        activityViewModel=new ViewModelProvider(this).get(ActivityViewModel.class);
        binding.vstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activityViewModel.startcount();
            }
        });
        binding.vstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                activityViewModel.stopcount();
            }
        });
        activityViewModel.getCounter().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                binding.viewtext2.setText(String.valueOf(integer));
            }
        });
        getLifecycle().addObserver(activityViewModel);


    }

}