package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity implements View.OnClickListener {
    EditText logtext;
    Button logbtn;
    private Context context=this;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Intent intent=getIntent();
        logtext=(EditText) findViewById(R.id.logtext);
        logbtn=(Button) findViewById(R.id.logbtn);
        logbtn.setOnClickListener((View.OnClickListener) context);
    }

    public void onClick(View view) {
        if(view.getId()==R.id.logbtn){
            Intent intent = new Intent(context,calcin.class);
            intent.putExtra("logname",logtext.getText().toString());
            startActivity(intent);
        }
    }
}