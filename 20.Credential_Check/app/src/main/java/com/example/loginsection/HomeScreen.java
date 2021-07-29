package com.example.loginsection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HomeScreen extends AppCompatActivity {

    TextView mtvEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        mtvEmail = findViewById(R.id.tvEmail);
        if (getIntent() != null) {
            String email = getIntent().getStringExtra("key");
            mtvEmail.setText(email);
        }
    }
}