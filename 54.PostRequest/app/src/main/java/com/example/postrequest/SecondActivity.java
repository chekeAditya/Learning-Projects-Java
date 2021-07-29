package com.example.postrequest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView mTvEmail, mTvTitle, mTvRequestType, mTvId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initViews();
        displayData();
    }

    private void displayData() {
        String email = getTitle().toString();
        mTvEmail.setText(email);
        String
    }

    private void initViews() {
        mTvEmail = findViewById(R.id.tvEmail);
        mTvTitle = findViewById(R.id.tvTitle);
        mTvRequestType = findViewById(R.id.tvRequestType);
        mTvId = findViewById(R.id.tvId);
    }
}