package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {
    EditText logtext;
    Button logbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        logtext=(EditText) findViewById(R.id.logtext);
        logbtn=(Button) findViewById(R.id.logbtn);
        logbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this,calcin.class);
                intent.putExtra("logname",logtext.getText().toString());
                startActivity(intent);
            }
        });
    }
}