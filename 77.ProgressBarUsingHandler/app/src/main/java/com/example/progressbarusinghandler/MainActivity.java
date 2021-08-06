package com.example.progressbarusinghandler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import com.google.android.material.progressindicator.CircularProgressIndicator;

public class MainActivity extends AppCompatActivity {

    private CircularProgressIndicator mCircularProgressIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCircularProgressIndicator = findViewById(R.id.circularProgressBar);
        WorkingThread workingThread = new WorkingThread("async", mainThreadHandler);
        workingThread.start();

    }

    private Handler mainThreadHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            //receiving message from working Thread
            switch (msg.what){
                case 1:
                    int progress = (int) msg.obj;
                    Log.d("Aditya","Process" + progress);
                    mCircularProgressIndicator.setProgress(progress);
                    break;
                case 2:
                    String message = (String) msg.obj;
                    Toast.makeText(MainActivity.this,"Task done",Toast.LENGTH_SHORT).show();
            }
        }
    };
}