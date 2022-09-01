package com.example.myapplication.adapters.customadapt;

import android.annotation.SuppressLint;
import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.Data;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<Data> {
    ArrayList<Data> arrayList=new ArrayList<>();
    Context context;
    public CustomAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Data> objects) {
        super(context, resource, objects);
        arrayList=objects;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view=convertView;
        LayoutInflater layoutInflater=(LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view=layoutInflater.inflate(R.layout.customadapter,null,false);
        TextView textView=view.findViewById(R.id.ctext);
        ImageView imageView=view.findViewById(R.id.cimage);
        textView.setText(arrayList.get(position).getTitle());
        imageView.setImageResource(arrayList.get(position).getImage());
        return view;
    }
}
