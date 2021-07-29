package com.example.eventbooking;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {

    TextView mTvFN, mTvLS, mTvEA,mTvPN,mTVNoOfSeats, mTVDateOfShow;
    Button mBtnConfirmed;
    AlertDialog.Builder builder;
    private static final String SHARED_PREFERENCE_KEY = "FirstDir";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        initViews();
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCE_KEY,MODE_PRIVATE);
        String fn  = sharedPreferences.getString("firstName","");
        String ln  = sharedPreferences.getString("lastName","");
        String ei  = sharedPreferences.getString("emailid","");
        String pn  = sharedPreferences.getString("phoneNumber","");
        String ns  = sharedPreferences.getString("NoOfSeats","");
        String dt  = sharedPreferences.getString("DateOfShow","");
        mTvFN.setText(fn);
        mTvLS.setText(ln);
        mTvEA.setText(ei);
        mTvPN.setText(pn);
        mTVNoOfSeats.setText(ns);
        mTVDateOfShow.setText(dt);

        mBtnConfirmed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alert = builder.create();
                alert.setTitle("Confirmed");
                alert.show();
            }
        });

    }


    private void initViews() {
        mTvFN = findViewById(R.id.tvFN);
        mTvLS = findViewById(R.id.tvLN);
        mTvEA = findViewById(R.id.tvEI);
        mTvPN = findViewById(R.id.tvPn);
        mTVNoOfSeats = findViewById(R.id.tvNumberOfSeats);
        mTVDateOfShow = findViewById(R.id.etDateOfShow);
        mBtnConfirmed = findViewById(R.id.btnConfirmed);
    }
}