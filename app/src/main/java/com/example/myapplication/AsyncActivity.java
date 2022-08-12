package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class AsyncActivity extends AppCompatActivity {
    private Button getbtn,disbtn;
    TextView gettext;

    AsyncData asyncData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);
        getbtn=(Button)findViewById(R.id.getbtn);
        disbtn=(Button)findViewById(R.id.disbtn);
        gettext=(TextView)findViewById(R.id.gettext);
        getbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                asyncData=new AsyncData(gettext);
                asyncData.execute();
            }
        });
        disbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = asyncData.data1;
                Intent intent=new Intent(AsyncActivity.this,AsyncDisplay.class);
                intent.putExtra("json",data);
                startActivity(intent);

            }
        });
    }


}