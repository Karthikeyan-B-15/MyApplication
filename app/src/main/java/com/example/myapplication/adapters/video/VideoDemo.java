package com.example.myapplication.adapters.video;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class VideoDemo extends AppCompatActivity {
    ViewPager2 viewPager2;
    VideoAdapter videoAdapter;
    List<VideoModel> videolist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_demo);
        videolist =new ArrayList<>();
        viewPager2=findViewById(R.id.pager2);
        videolist.add(new VideoModel("android.resource://"+getPackageName()+"/"+R.raw.a));
        videolist.add(new VideoModel("android.resource://"+getPackageName()+"/"+R.raw.b));
        videolist.add(new VideoModel("android.resource://"+getPackageName()+"/"+R.raw.c));
        videolist.add(new VideoModel("android.resource://"+getPackageName()+"/"+R.raw.d));
        videoAdapter=new VideoAdapter(videolist);
        viewPager2.setAdapter(videoAdapter);
    }
}