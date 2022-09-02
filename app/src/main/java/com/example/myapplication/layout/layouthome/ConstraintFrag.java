package com.example.myapplication.layout.layouthome;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

public class ConstraintFrag extends Fragment {
    ImageView imageView;
    Drawable drawable;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.constraintfrag,container,false);
        imageView=v.findViewById(R.id.image4);
        drawable=getResources().getDrawable(R.drawable.nature4);
        imageView.setImageDrawable(drawable);
        return v;
    }
}
