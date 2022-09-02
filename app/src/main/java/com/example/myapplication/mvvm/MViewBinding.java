package com.example.myapplication.mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.ViewBinding;

import android.os.Bundle;
import android.view.View;

import com.example.myapplication.databinding.ActivityMviewBindingBinding;

public class MViewBinding extends AppCompatActivity {
    private ActivityMviewBindingBinding binding;
    ViewBinding viewBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMviewBindingBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);
        binding.viewtext.setText("Hello world !!!");
    }
}