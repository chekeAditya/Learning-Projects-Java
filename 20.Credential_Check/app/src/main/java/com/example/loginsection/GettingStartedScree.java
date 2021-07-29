package com.example.loginsection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GettingStartedScree extends AppCompatActivity {
    Button mBtnGettingStarted;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnGettingStarted = findViewById(R.id.btnGetStart);
        mBtnGettingStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GettingStartedScree.this,LoginScreen.class);
                startActivity(intent);
            }
        });
    }
}