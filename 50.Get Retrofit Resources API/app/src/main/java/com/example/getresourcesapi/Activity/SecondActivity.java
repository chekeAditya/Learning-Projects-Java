package com.example.getresourcesapi.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ComplexColorCompat;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.getresourcesapi.R;

public class SecondActivity extends AppCompatActivity {
    private TextView mTvName;
    private TextView mTvYear;
    private TextView mTvCompany;
    private LinearLayout linearLayout;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initViews();
        if (getIntent() != null) {
            String firstName = getIntent().getStringExtra("firstName");
            String year = getIntent().getStringExtra("year");
            String companyName = getIntent().getStringExtra("companyName");
            String color = getIntent().getStringExtra("color");
            mTvName.setText(firstName);
            mTvYear.setText(year);
            mTvCompany.setText(companyName);
            linearLayout.setBackgroundColor(Color.parseColor(color));

        }
    }

    private void initViews() {
        mTvCompany = findViewById(R.id.tvCompany);
        mTvYear = findViewById(R.id.tvYear);
        mTvName = findViewById(R.id.tvName);
        linearLayout = findViewById(R.id.linearLayout);
    }
}