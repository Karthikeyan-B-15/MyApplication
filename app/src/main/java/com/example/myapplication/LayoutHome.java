package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LayoutHome extends AppCompatActivity {
    private Button lbtn2,lbtn3,lbtn4,lbtn5;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    LinearFrag linearFrag=new LinearFrag();
    RelativeFrag relativeFrag=new RelativeFrag();
    FrameFrag frameFrag=new FrameFrag();
    ConstraintFrag constraintFrag=new ConstraintFrag();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_home);
        lbtn2=(Button) findViewById(R.id.lbtn2);
        lbtn3=(Button) findViewById(R.id.lbtn3);
        lbtn4=(Button) findViewById(R.id.lbtn4);
        lbtn5=(Button) findViewById(R.id.lbtn5);

        fragmentManager=getSupportFragmentManager();

        lbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fragmentManager.findFragmentByTag("linear")==null){
               fragmentTransaction=fragmentManager.beginTransaction();

                fragmentTransaction.replace(R.id.layoutContainer,linearFrag,"linear")
                        .addToBackStack(null)
                        .commit();
            }}
        });
        lbtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fragmentManager.findFragmentByTag("relative")==null){
                fragmentTransaction=fragmentManager.beginTransaction();

                fragmentTransaction.replace(R.id.layoutContainer,relativeFrag,"relative")
                        .addToBackStack(null)
                        .commit();
            }}
        });
        lbtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fragmentManager.findFragmentByTag("frame")==null){
                 fragmentTransaction=fragmentManager.beginTransaction();

                fragmentTransaction.replace(R.id.layoutContainer,frameFrag,"frame")
                        .addToBackStack(null)
                        .commit();
            }}
        });
        lbtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fragmentManager.findFragmentByTag("constraint")==null) {
                    fragmentTransaction = fragmentManager.beginTransaction();

                    fragmentTransaction.replace(R.id.layoutContainer, constraintFrag, "constraint")
                            .addToBackStack(null)
                            .commit();
                }
            }
        });
    }

}