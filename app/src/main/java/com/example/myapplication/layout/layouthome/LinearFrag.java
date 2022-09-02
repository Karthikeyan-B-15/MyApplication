package com.example.myapplication.layout.layouthome;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

public class LinearFrag extends Fragment {
    ImageView imageView;
    Drawable drawable;
    LinearLayout linearLayout;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.linearfrag,container,false);
        imageView=v.findViewById(R.id.image1);
        linearLayout=v.findViewById(R.id.childlinear);
//        linearLayout.setOrientation(LinearLayout.VERTICAL);
        drawable=getResources().getDrawable(R.drawable.nature1);
        imageView.setImageDrawable(drawable);
        return v;
    }
}
