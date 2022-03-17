package com.example.sep17module.service;



import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;

import com.example.sep17module.R;

public class PlaySongService extends Service {

    MediaPlayer mediaPlayer;

    @Nullable

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {

        super.onCreate();

        mediaPlayer = MediaPlayer.create(this, R.raw.song);
        mediaPlayer.setVolume(100,100);
        mediaPlayer.setLooping(true);
    }

    @Nullable


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        mediaPlayer.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        mediaPlayer.stop();
        super.onDestroy();
    }
}
