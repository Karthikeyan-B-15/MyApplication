package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

public class PageAdapt extends AppCompatActivity {
    ViewPager viewPager;
    DotsIndicator dot;
    ViewAdapter viewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_adapt);
        viewPager=(ViewPager)findViewById(R.id.pager);
        dot=(DotsIndicator) findViewById(R.id.dot);
        viewAdapter=new ViewAdapter(this);
        viewPager.setAdapter(viewAdapter);
        dot.setViewPager(viewPager);
    }
}