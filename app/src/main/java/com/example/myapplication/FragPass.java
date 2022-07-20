package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

public class FragPass extends AppCompatActivity implements FragA.FragAlistener,FragB.FragBlistener {
    private FragA fragA;
    private FragB fragB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag_pass);
        fragA=new FragA();
        fragB=new FragB();
        getSupportFragmentManager().beginTransaction().replace(R.id.containera,fragA).replace(R.id.containerb,fragB).commit();
    }

    @Override
    public void onInputAsent(CharSequence input) {
        fragB.updateEditText(input);
    }

    @Override
    public void onInputBsent(CharSequence input) {
        fragA.updateEditText(input);
    }
}