package com.example.myapplication;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FrameFrag extends Fragment {
    ImageView imageView;
    Drawable drawable;
    FrameLayout frameLayout;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.framefrag,container,false);
        imageView=v.findViewById(R.id.image3);
        frameLayout=v.findViewById(R.id.frame);


        drawable=getResources().getDrawable(R.drawable.nature3);
        imageView.setImageDrawable(drawable);
        frameLayout.measure(View.MeasureSpec.UNSPECIFIED,View.MeasureSpec.UNSPECIFIED);
        int width = frameLayout.getMeasuredWidth();
        int height = frameLayout.getMeasuredHeight();
        Toast.makeText(getContext(), "width="+width+"  height="+height, Toast.LENGTH_LONG).show();
        return v;
    }
}
