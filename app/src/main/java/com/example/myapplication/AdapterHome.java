package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class AdapterHome extends AppCompatActivity implements  AdapterView.OnItemSelectedListener{
    private Button sadapt,aadapt,cadapt,radapt,padapt;
    Spinner spin;
    String[] spinitem={"India","Pakistan","America","Russia","Japan"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_home);
        sadapt=(Button)findViewById(R.id.sadapt);
        aadapt=(Button)findViewById(R.id.aadapt);
        cadapt=(Button)findViewById(R.id.cadapt);
        radapt=(Button)findViewById(R.id.radapt);
        padapt=(Button)findViewById(R.id.padapt);
        spin=(Spinner)findViewById(R.id.spin);
        ArrayAdapter<String> spinner =new ArrayAdapter<String>(this,R.layout.listitem,R.id.listtext,spinitem);
        spinner.setDropDownViewResource(R.layout.listitem);
        spin.setAdapter(spinner);
        sadapt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AdapterHome.this, SimpleAdapters.class);
                startActivity(intent);
            }
        });
        aadapt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AdapterHome.this, ArrayAdapt.class);
                startActivity(intent);
            }
        });
        cadapt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AdapterHome.this, Custom.class);
                startActivity(intent);
            }
        });
        radapt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AdapterHome.this, Recycle.class);
                startActivity(intent);
            }
        });
        padapt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AdapterHome.this, PageAdapt.class);
                startActivity(intent);
            }
        });
        spin.setOnItemSelectedListener(this);


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(AdapterHome.this,"Selected Item is "+" "+spinitem[i],Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}