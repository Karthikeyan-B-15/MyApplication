package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnChange;
    Button add;
    Button actC;
    Button actA;
    TextView text;
    int counter;
    String str;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context=this;
        Intent intent=getIntent();
        Toast.makeText(context,"ON CREATE", Toast.LENGTH_SHORT).show();
         btnChange=(Button)  findViewById(R.id.setPort);
         actC=(Button) findViewById(R.id.button5);
         actA=(Button) findViewById(R.id.button4);

        btnChange.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                if(getRequestedOrientation()== ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) {
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                }
                else{
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

                }

            }
        });
        actC.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(context,MainActivity3.class);
                startActivity(intent);
            }
        });
         actA.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
         add=findViewById(R.id.add);
         text=findViewById(R.id.text);
         counter=0;
         text.setText(String.valueOf(counter));
         add.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 counter=Integer.valueOf(text.getText().toString())+1;
                 text.setText(String.valueOf(counter));
             }
         });

  }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        Toast.makeText(MainActivity.this,"ON START", Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        Toast.makeText(MainActivity.this,"ON RESUME", Toast.LENGTH_LONG).show();
    }
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        Toast.makeText(MainActivity.this,"ON PAUSE", Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onRestart() {
        // TODO Auto-generated method stub
        super.onRestart();
        Toast.makeText(MainActivity.this,"ON RESTART", Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
        Toast.makeText(MainActivity.this,"ON STOP", Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        Toast.makeText(MainActivity.this,"ON DESTROY", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("msg", String.valueOf(counter));
        Toast.makeText(MainActivity.this,"ONsaveinstancestate ", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        text.setText(savedInstanceState.getString("msg",String.valueOf(counter)));
        Toast.makeText(MainActivity.this,"onrestoreinstancestate ", Toast.LENGTH_LONG).show();
    }


    public void navToActivity(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("value",str);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }

}
