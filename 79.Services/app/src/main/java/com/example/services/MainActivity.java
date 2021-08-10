package com.example.services;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mEtEditText;
    private Button mBtnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        IntentFilter intentFilter = new IntentFilter("com.xyz.service");
        registerReceiver(serviceReceiver, intentFilter);
    }

    private void initViews() {
        mEtEditText = findViewById(R.id.etEditText);
        mBtnStart = findViewById(R.id.btnStart);
        mBtnStart.setOnClickListener(v -> {
            Intent intent = new Intent(this, FileOperationService.class);
            intent.putExtra("name", mEtEditText.getText().toString());
            startService(intent);
        });
    }

    private BroadcastReceiver serviceReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context,intent.getStringExtra("data"),Toast.LENGTH_SHORT).show();
        }
    };
}