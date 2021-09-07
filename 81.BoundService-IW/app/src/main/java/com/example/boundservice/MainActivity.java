package com.example.boundservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnPlay;
    private Button mBtnStopService;
    private Button mBtnPause;
    private Button mBtnStartService;
    private MusicService musicService;
    private boolean isServiceBound;

    /**
     * service connection is used to communicate with the service
     */
    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MusicService.MusicServiceBinder binder = (MusicService.MusicServiceBinder) service;
            musicService = binder.getMusicService();
            isServiceBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isServiceBound = false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViewsAndListeners();
    }

    private void initViewsAndListeners() {
        mBtnPause = findViewById(R.id.btnPause);
        mBtnPlay = findViewById(R.id.btnPlay);
        mBtnStopService = findViewById(R.id.btnStopService);
        mBtnStartService = findViewById(R.id.btnStartService);
        mBtnPause.setOnClickListener(this);
        mBtnPlay.setOnClickListener(this);
        mBtnStopService.setOnClickListener(this);
        mBtnStartService.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.btnStartService:
                Intent intent = new Intent(this, MusicService.class);
                bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
                break;

            case R.id.btnPlay:
                if (isServiceBound) {
                    musicService.startMusic();
                }
                break;

            case R.id.btnStopService:
                if (isServiceBound) {
                    musicService.pauseMusic();
                    unbindService(serviceConnection);
                    isServiceBound = false;
                }
                break;

            case R.id.btnPause:
                if (isServiceBound) {
                    musicService.pauseMusic();
                }
                break;
        }
    }
}