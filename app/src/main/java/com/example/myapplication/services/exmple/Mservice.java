package com.example.myapplication.services.exmple;


import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Log;

import androidx.annotation.Nullable;

public class Mservice extends Service {
    MediaPlayer player;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        player=MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
        player.setLooping(true);
        player.start();
        show(intent.getIntExtra("i",0));
        return START_STICKY;
    }
   public void show(int i){
        Log.d("res", String.valueOf(i));
   }

    @Override
    public void onDestroy() {
        super.onDestroy();
        player.stop();
    }
}
