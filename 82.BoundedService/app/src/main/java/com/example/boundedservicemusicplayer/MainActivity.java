package com.example.boundedservicemusicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mBtnStartMusic, mBtnStopMusic, mBtnPause;
    private MusicService musicService;
    private Handler mainThreadHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        Intent intent = new Intent(this, MusicService.class);
        bindService(intent, serviceConnection, BIND_AUTO_CREATE);
    }

    public void setHandler(Handler handler){
        this.mainThreadHandler = handler;
    }

    private void initViews() {
        mBtnStartMusic = findViewById(R.id.btnStartMusic);
        mBtnStopMusic = findViewById(R.id.btnStopMusic);
        mBtnPause = findViewById(R.id.btnPauseMusic);
        mBtnStartMusic.setOnClickListener(v -> {
            Intent intent = new Intent(this, MusicService.class);
            bindService(intent, serviceConnection, BIND_AUTO_CREATE);
            if (musicService != null)
                musicService.play();
        });
        mBtnPause.setOnClickListener(v -> {
            musicService.pause();
        });
        mBtnStopMusic.setOnClickListener(v -> {
            musicService.stop();
        });
    }

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder binder) {
            MusicService.ServiceBinder serviceBinder = (MusicService.ServiceBinder) binder;
            musicService = serviceBinder.getMusicService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
}
