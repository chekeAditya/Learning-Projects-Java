package com.example.opencustomactivityfromappselectorscreen2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ReceiveActivity extends AppCompatActivity {
    TextView mTvReceiveData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive);
        mTvReceiveData = findViewById(R.id.tvReceiveActivity);
        if (getIntent() != null && getIntent().getExtras() != null) {
            mTvReceiveData.setText(getIntent().getStringExtra("username"));
        }
    }
}