package com.example.changingbackground;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mBtnBooks, mBtnPodcasts, mBtnNews, mBtnBusiness, mBtnEntertainment, mBtnSports, mBtnTechnology, mBtnPronounciation, mBtnGrammer, mBtnHealthy;
    private boolean isSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        mBtnBooks = findViewById(R.id.btnBooks);
        mBtnPodcasts = findViewById(R.id.btnPodcasts);
        mBtnNews = findViewById(R.id.btnNews);
        mBtnBusiness = findViewById(R.id.btnBusiness);
        mBtnEntertainment = findViewById(R.id.btnEntertainment);
        mBtnSports = findViewById(R.id.btnSports);
        mBtnTechnology = findViewById(R.id.btnTechnology);
        mBtnPronounciation = findViewById(R.id.btnPronunciation);
        mBtnGrammer = findViewById(R.id.btnGrammer);
        mBtnHealthy = findViewById(R.id.btnHealth);
    }
}