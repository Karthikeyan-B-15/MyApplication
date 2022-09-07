package com.example.myapplication.mvvm.noteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityCreateNoteBinding;

public class CreateNote extends AppCompatActivity {
    ActivityCreateNoteBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityCreateNoteBinding.inflate(getLayoutInflater());
        View view =binding.getRoot();
        setContentView(view);
        binding.cnbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title=binding.cntext1.getText().toString();
                String desc=binding.cntext2.getText().toString();
                Intent data=new Intent();
            }
        });
    }
}