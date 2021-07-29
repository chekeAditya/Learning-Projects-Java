package com.example.eventlisteners;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTvWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTvWelcome = findViewById(R.id.tvWelcomeToMasai);
        mTvWelcome.setText("Welcome to Masai School");
        if (savedInstanceState != null) {
            String data = savedInstanceState.getString("key");
            mTvWelcome.setText(data);
        }
        Log.d("TAG","onCreate");
    }

    //storing it but not restoring it
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("key", "Screen Rotated");
        Log.d("TAG","onSavedInstanceState");
    }

    //storing nad restoring it
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
//        String data = savedInstanceState.getString("key");
//        mTvWelcome.setText(data);
        Log.d("TAG","onRestoreInstanceState");
    }
}
/*
onPause
onStop
onSavedInstanceState
onDestroy
onCreate
onStart
onRestoreInstanceState
onResume
 */