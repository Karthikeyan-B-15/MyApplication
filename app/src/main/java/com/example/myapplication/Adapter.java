package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    List<ModelClass> list;
    public Adapter(List<ModelClass> list){
        this.list=list;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleitem,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        int resimg=list.get(position).getImage();
        String name=list.get(position).getName();
        holder.setData(resimg,name);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView rimg;
        TextView rtxt;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rimg=itemView.findViewById(R.id.rimg);
            rtxt=itemView.findViewById(R.id.rtxt);
        }

        public void setData(int resimg, String name) {
            rimg.setImageResource(resimg);
            rtxt.setText(name);
        }
    }
}
