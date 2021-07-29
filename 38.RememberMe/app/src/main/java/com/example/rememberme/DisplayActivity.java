package com.example.rememberme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {
    TextView mtvUsername;
    private static final String SHARED_PREFERENCE_KEY = "FirstDir";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        mtvUsername = findViewById(R.id.tvUsername);
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCE_KEY, MODE_PRIVATE);
        String username = sharedPreferences.getString("name", "");
        mtvUsername.setText(username);
    }
}