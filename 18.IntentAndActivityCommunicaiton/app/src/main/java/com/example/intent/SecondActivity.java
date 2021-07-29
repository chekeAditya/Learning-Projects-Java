package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private TextView mTvUsername, mTvEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mTvUsername = findViewById(R.id.tvUserName);
        mTvEmail = findViewById(R.id.tvEmailId);
        if (getIntent() != null) {
            String username = getIntent().getStringExtra("username");
            mTvUsername.setText(username);
            String emailId = getIntent().getStringExtra("emailId");
            mTvEmail.setText(emailId);
        }
    }
}