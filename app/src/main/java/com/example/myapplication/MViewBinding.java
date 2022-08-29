package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.myapplication.databinding.ActivityMviewBindingBinding;

public class MViewBinding extends AppCompatActivity {
    private ActivityMviewBindingBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMviewBindingBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);
        binding.viewtext.setText("Hello world !!!");
    }
}