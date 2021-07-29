package com.example.receivenameandage;

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

    public TextView mTvName;
    private LocalBroadCastReceiver localBroadCastReceiver;
    public TextView mTvAge;
    public Button mBtnGetData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        getData();
        registeredBroadcast();
    }

    private void getData() {
        mBtnGetData.setOnClickListener(v -> {
            Intent intent = new Intent("com.action.local.broadcast.data");
            intent.putExtra("name", "Aditya");
            intent.putExtra("age", "19");
            sendBroadcast(intent);
        });
    }

    private void registeredBroadcast(){
        localBroadCastReceiver = new LocalBroadCastReceiver();
        IntentFilter intentFilter = new IntentFilter("com.action.local.broadcast.data");
        registerReceiver(localBroadCastReceiver, intentFilter);
    }

    private void initViews() {
        mTvName = findViewById(R.id.tvName);
        mTvAge = findViewById(R.id.tvAge);
        mBtnGetData = findViewById(R.id.btngetData);
    }

    public class LocalBroadCastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getExtras() != null) {
                String name = intent.getStringExtra("name");
                String age = intent.getStringExtra("age");
                mTvName.setText(name);
                mTvAge.setText(age);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(localBroadCastReceiver);
    }
}