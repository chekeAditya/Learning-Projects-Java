package com.example.boundservice;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;


public class MusicService extends Service implements LooperPreparedListener {

    private MusicServiceBinder binder = new MusicServiceBinder();
    private BackgroundHandlerThread handlerThread;
    private MediaPlayer mediaPlayer;
    private boolean isLooperReady;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("Aditya", "onCreate of music service");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d("Aditya", "on bind");
        handlerThread = new BackgroundHandlerThread("Music Service", this);
        /*
        Start a new thread and play the music in a background thread
         */
        handlerThread.start();
        mediaPlayer = MediaPlayer.create(MusicService.this, R.raw.shape_of_you);
        return binder;
    }

    /**
     * This method will start the music in a background thread
     */
    public void startMusic() {
        if (isLooperReady) {
            handlerThread.addTaskToQueue(new Runnable() {
                @Override
                public void run() {
                    Log.d("Aditya", "Thread name" + Thread.currentThread().getName());
                    mediaPlayer.start();
                }
            });
        }
    }

    /**
     * This method is used to stop the music and again this method runs in a background thread
     */
    public void pauseMusic() {
        if (isLooperReady) {
            handlerThread.addTaskToQueue(new Runnable() {
                @Override
                public void run() {
                    Log.d("Aditya", "Thread name" + Thread.currentThread().getName());

                    mediaPlayer.pause();
                }
            });
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("Aditya", "onDestroy of music service");

    }

    /**
     * Callback is received once the Looper is ready
     */
    @Override
    public void onLooperReady() {
        isLooperReady = true;
    }


    public class MusicServiceBinder extends Binder {
        public MusicService getMusicService() {
            return MusicService.this;
        }
    }
}