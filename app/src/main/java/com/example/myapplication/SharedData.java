package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class SharedData extends AppCompatActivity {
    EditText stext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_data);
        stext=(EditText) findViewById(R.id.stext);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences res=getSharedPreferences("sharedpref",)
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences=getSharedPreferences("sharedpref",MODE_PRIVATE);
        SharedPreferences.Editor edit=sharedPreferences.edit();
        edit.putString("sname",stext.getText().toString());
        edit.apply();

    }
}