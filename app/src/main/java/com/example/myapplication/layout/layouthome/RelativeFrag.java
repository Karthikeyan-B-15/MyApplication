package com.example.myapplication.layout.layouthome;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.myapplication.R;

public class RelativeFrag extends Fragment {
    ImageView imageView;
    Drawable drawable;
    TextView textView,retext;
    private Button rbtn1;
    RelativeLayout relativeLayout;
    SwipeRefreshLayout swipeRefreshLayout;
    int a=2;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.relativefrag,container,false);
        imageView=v.findViewById(R.id.image2);
        textView=v.findViewById(R.id.textView4);
        retext=v.findViewById(R.id.retext);
        swipeRefreshLayout=v.findViewById(R.id.refresh);
        textView.setSelected(true);
        relativeLayout=v.findViewById(R.id.relative);
        drawable=getResources().getDrawable(R.drawable.nature2);
        imageView.setImageDrawable(drawable);
        rbtn1=new Button(getContext());
        rbtn1.setText("Relative");
        rbtn1.setId(a);
        rbtn1.setBackgroundColor(Color.parseColor("#5bcc2e"));
//        rbtn1.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT));
        relativeLayout.addView(rbtn1);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                retext.setText("Refreshed text!");
                swipeRefreshLayout.setRefreshing(false);
            }
        });
        return v;
    }
}
