package com.example.sendbroadcastsecurityconsideration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView mTvData;
    private LocalBroadCast localBroadCast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d("Aditya", "onCreate2");
        mTvData = findViewById(R.id.tvData);
        String message = getIntent().getStringExtra("permission");
        mTvData.setText(message);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(localBroadCast);
    }
}