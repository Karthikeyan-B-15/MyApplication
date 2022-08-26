package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class SharedData extends AppCompatActivity {
    private EditText stext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_data);
        stext=(EditText) findViewById(R.id.stext);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences res=getSharedPreferences("sharedpref",MODE_PRIVATE);
        String sres=res.getString("sname","");
        stext.setText(sres);
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences=getSharedPreferences("sharedpref",MODE_PRIVATE);
        SharedPreferences.Editor myedit=sharedPreferences.edit();
        myedit.putString("sname",stext.getText().toString());
        myedit.apply();

    }
}