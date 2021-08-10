package com.example.musicapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView mBtnStartMusic;
    private ImageView mBtnStopMusic;
    private Intent intent;
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        mBtnStartMusic = findViewById(R.id.btnStart);
        mBtnStopMusic = findViewById(R.id.btnStop);
        intent = new Intent(this, MusicService.class);
        mBtnStartMusic.setOnClickListener(v -> startService(intent));
        mBtnStopMusic.setOnClickListener(v-> stopService(intent));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy in MainActivity");
    }
}