package com.example.myapplication.adapters.video;

import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> {
    List<VideoModel> videolist;
    public VideoAdapter(List<VideoModel> videolist){
        this.videolist=videolist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.video,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setData(videolist.get(position));
    }

    @Override
    public int getItemCount() {
        return videolist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        VideoView videoView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            videoView=(VideoView) itemView.findViewById(R.id.video);

        }

        public void setData(VideoModel videoModel) {
            videoView.setVideoPath(videoModel.getVideoUrl());
            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    mediaPlayer.start();
                    float videoratio=mediaPlayer.getVideoWidth()/(float)mediaPlayer.getVideoHeight();
                    float screenratio=videoView.getWidth()/(float)videoView.getHeight();
                    float scale=videoratio/screenratio;
                    if(scale>=1f){
                        videoView.setScaleX(scale);
                    }
                    else{
                        videoView.setScaleY(1f/scale);
                    }
                }
            });
            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.start();
                }
            });
        }
    }
}
