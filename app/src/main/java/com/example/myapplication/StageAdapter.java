package com.example.myapplication;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StageAdapter extends RecyclerView.Adapter<StageAdapter.ViewHolder> {
    List<StageModel> stagelist;
    StageAdapter(List<StageModel> stagelist){
        this.stagelist=stagelist;
    }

    @NonNull
    @Override
    public StageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StageAdapter.ViewHolder holder, int position) {
        holder.imageView.setImageResource(stagelist.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return stagelist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=(ImageView) itemView.findViewById(R.id.pimg);
        }
    }
}
