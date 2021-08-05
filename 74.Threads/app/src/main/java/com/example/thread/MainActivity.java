package com.example.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mBtnTaskOne, mBtnTaskTwo;
    private WorkerThread workerThread;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        workerThread = new WorkerThread();
        handler = new Handler();
        workerThread.start();
        intiViews();
    }

    private void intiViews() {
        mBtnTaskOne = findViewById(R.id.btnTaskOne);
        mBtnTaskTwo = findViewById(R.id.btnTaskTwo);

        //task One
        mBtnTaskOne.setOnClickListener(v -> {
            workerThread.addTaskToMessageQueue(taskOne);
        });


        //Task Two
        mBtnTaskTwo.setOnClickListener(v -> {
            workerThread.addTaskToMessageQueue(taskTwo);
        });

    }

    private Runnable taskOne = new Runnable() {
        @Override
        public void run() {
            try {
                Log.d("Aditya","Task One Started");
                Thread.sleep(1000);
                Log.d("Aditya","Task One Completed");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    private Runnable taskTwo = new Runnable() {
        @Override
        public void run() {
            try {
                Log.d("Aditya","Task Two Started");
                Thread.sleep(1000);
                Log.d("Aditya","Task Two Completed");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
}