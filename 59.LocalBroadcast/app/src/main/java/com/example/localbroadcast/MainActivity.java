package com.example.localbroadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private LocalBroadCastReceiver localBroadCastReceiver;
    private TextView mTvData;
    private Button mBtnSendMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        registerLocalBroadcast();
    }

    private void initViews() {
        mTvData = findViewById(R.id.tvData);
        mBtnSendMessage = findViewById(R.id.btnSendMessage);
        mBtnSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.aditya.local.broadcast.masai");
                intent.putExtra("data","Hello Masai School");
                sendBroadcast(intent);
            }
        });
    }

    private void registerLocalBroadcast() {
        localBroadCastReceiver = new LocalBroadCastReceiver();
        IntentFilter intentFilter = new IntentFilter("com.aditya.local.broadcast.masai");
        registerReceiver(localBroadCastReceiver, intentFilter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(localBroadCastReceiver);
    }

    private class LocalBroadCastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getExtras() != null){
                String data = intent.getStringExtra("data");
                mTvData.setText(data);
            }
        }
    }
}