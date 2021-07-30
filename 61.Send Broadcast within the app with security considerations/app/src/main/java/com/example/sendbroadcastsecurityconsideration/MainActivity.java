package com.example.sendbroadcastsecurityconsideration;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button mBtnGetData;
    LocalBroadCast localBroadCastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Aditya", "onCreate");
        initViews();
        buttonClicked();
    }

    private void buttonClicked() {
        mBtnGetData.setOnClickListener(v -> {
            Log.d("Aditya", "buttonclicked");
            Intent intent = new Intent();
            intent.setAction("com.aditya.customBroadcast");
            intent.putExtra("permission", "Permission given");
            sendBroadcast(intent);
            registeredBroadcast();
        });
    }

    private void initViews() {
        mBtnGetData = findViewById(R.id.btnGetData);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = new Intent("com.aditya.customBroadcast");
        intent.putExtra("permission", "permission given");
        sendBroadcast(intent, Manifest.permission.CAMERA);
    }

    private void registeredBroadcast() {
        localBroadCastReceiver = new LocalBroadCast();
        IntentFilter intentFilter = new IntentFilter("com.aditya.customBroadcast");
        registerReceiver(localBroadCastReceiver, intentFilter);
    }
}