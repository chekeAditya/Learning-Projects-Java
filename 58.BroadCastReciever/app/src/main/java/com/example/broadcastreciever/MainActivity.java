package com.example.broadcastreciever;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity<onClick> extends AppCompatActivity implements View.OnClickListener {

    private LocalBroadcastReceiver localBroadcastReceiver;
    private AirplaneModeReciever receiver;
    private Button mBtnBetweenApps;
    private Button mBtnLocalBroadCast;
    private Button mBtnSecuredBroadcast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
//        if you need receiver then you will need two factor intent filter or receiver
//        after doing this code when you switch ON or OFF airplane you'll get a Toast
        receiver = new AirplaneModeReciever();
        IntentFilter intentFilter = new IntentFilter("android.intent.action.AIRPLANE_MODE");
        registerReceiver(receiver,intentFilter);

        localBroadcastReceiver = new LocalBroadcastReceiver();
        IntentFilter filter = new IntentFilter("com.lloyd.local");
        registerReceiver(localBroadcastReceiver,filter);
    }

    private void initViews() {
        mBtnBetweenApps = findViewById(R.id.btnBetweenApps);
        mBtnLocalBroadCast = findViewById(R.id.btnLocalBroadcast);
        mBtnSecuredBroadcast = findViewById(R.id.btnSecuredBroadcast);
        mBtnBetweenApps.setOnClickListener(this);
        mBtnLocalBroadCast.setOnClickListener(this);
        mBtnSecuredBroadcast.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
        unregisterReceiver(localBroadcastReceiver);
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btnBetweenApps:
// here we are receiving the message from the another app
// if the app is in the background then only you can send Broadcast between app
                Intent intent = new Intent("com.lloyd.customBroadcast");
                intent.putExtra("data","Hi");
                sendBroadcast(intent);
                break;
            case R.id.btnLocalBroadcast:
// how to send broadcast within the aap you are the sender and you are the receiver -> create receiver
                Intent localIntent = new Intent("com.lloyd.local");
                sendBroadcast(localIntent);
                break;
            case R.id.btnSecuredBroadcast:
// here you had to give permission to the app from the second one for that go to manifest and provide
// it will check if the permisison in the othen if permisison is givne the only. This is how you secure app  using permission, now only the app wihch had the persiion will send the data
// <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
                Intent secureBroadcastIntent = new Intent("com.lloyd.customBroadcast");
                secureBroadcastIntent.putExtra("data","Hi");
                sendBroadcast(secureBroadcastIntent, Manifest.permission.ACCESS_NETWORK_STATE);
                break;
        }
    }

}