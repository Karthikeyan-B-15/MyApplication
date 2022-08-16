package com.example.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.io.InputStream;
import java.util.List;

public class AsyncAdapter extends RecyclerView.Adapter<AsyncAdapter.ViewHolder> {
    List<AsyncModel> alist;

    public AsyncAdapter(List<AsyncModel> alist) {
        this.alist = alist;
    }
    String url;
    @NonNull
    @Override
    public AsyncAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.asyncview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AsyncAdapter.ViewHolder holder, int position) {
        holder.fname.setText(alist.get(position).getFirstName());
        holder.lname.setText(alist.get(position).getLastName());
        holder.email.setText(alist.get(position).getEmail());
        url=alist.get(position).getImgurl();
        Glide.with(holder.aimg.getContext()).load(url).into(holder.aimg);
    }

    @Override
    public int getItemCount() {
        return alist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView fname, lname, email;
        ImageView aimg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fname = (TextView) itemView.findViewById(R.id.fname);
            lname = (TextView) itemView.findViewById(R.id.lname);
            email = (TextView) itemView.findViewById(R.id.email);
            aimg = (ImageView) itemView.findViewById(R.id.aimg);
        }


    }

}
