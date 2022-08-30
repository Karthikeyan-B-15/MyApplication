package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.myapplication.databinding.ActivityMdataBindingBinding;

public class MDataBinding extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMdataBindingBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_mdata_binding);
        User user = new User("Test", "User");
        binding.setUser(user);
    }
}