package com.example.myapplication.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    List<HomeModel> griditem;
    RecyclerClickListener listener;
    HomeAdapter(List<HomeModel> griditem,RecyclerClickListener listener){
        this.griditem=griditem;
        this.listener=listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.griditem,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.gbtn.setText(griditem.get(position).getText());

    }

    @Override
    public int getItemCount() {
        return griditem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        Button gbtn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            gbtn=(Button) itemView.findViewById(R.id.gbtn);
            itemView.setOnClickListener(this);
            gbtn.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            listener.onClick(view,getAbsoluteAdapterPosition());
        }
    }
 public interface RecyclerClickListener{
        void onClick(View view,int position);
 }
}
