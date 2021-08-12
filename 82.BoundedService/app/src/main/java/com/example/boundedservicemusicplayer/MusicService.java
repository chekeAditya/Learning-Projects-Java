package com.example.boundedservicemusicplayer;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;

public class MusicService extends Service {
//communication become very easy

    private MediaPlayer mediaPlayer;

    public MusicService() {

    }

    @Override
    public void onCreate() {
        super.onCreate();

    }

    //interface
    @Override
    public IBinder onBind(Intent intent) {
        return new ServiceBinder();
    }

    public void play() {
        mediaPlayer = MediaPlayer.create(this, R.raw.shape_of_you);
        if (!mediaPlayer.isPlaying()) {
            mediaPlayer.start();
        }
    }

    public void pause() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }

    public void stop() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
    }

    //need new music service that's why we create this
    public class ServiceBinder extends Binder {
        public MusicService getMusicService() {
            return MusicService.this;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.release();
    }
}