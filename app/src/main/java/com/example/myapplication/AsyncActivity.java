package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class AsyncActivity extends AppCompatActivity {
    private Button getbtn,disbtn;
    TextView gettext;
    ProgressBar progressBar;
    AsyncData asyncData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);
        getbtn=(Button)findViewById(R.id.getbtn);
        disbtn=(Button)findViewById(R.id.disbtn);
        gettext=(TextView)findViewById(R.id.gettext);
        progressBar=(ProgressBar)findViewById(R.id.progressBar);
        Drawable progressDrawable = progressBar.getProgressDrawable().mutate();
        progressDrawable.setColorFilter(Color.parseColor("#053da6"), android.graphics.PorterDuff.Mode.SRC_IN);
        progressBar.setProgressDrawable(progressDrawable);
        getbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                asyncData=new AsyncData(gettext,progressBar);
                asyncData.execute();
            }
        });
        disbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                String data = asyncData.data1;
                Intent intent=new Intent(AsyncActivity.this,AsyncDisplay.class);
                intent.putExtra("json",data);
                startActivity(intent);
                }
                catch (NullPointerException e){
                    gettext.setText("Data cannot display because data not get!!");
                }

            }
        });
    }


}