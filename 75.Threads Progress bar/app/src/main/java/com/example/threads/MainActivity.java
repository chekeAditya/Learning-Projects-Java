package com.example.threads;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button mBtnCallThread;
    private WorkerThread workerThread;
    private ProgressBar mProgressBar;
    private Handler mHandler;
    private TextView mTvPercentageDone;
    private int initialCount;
    private EditText mEtGiveTiming;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        mProgressBar = findViewById(R.id.progressBar);
        mTvPercentageDone = findViewById(R.id.tvPercentageDone);
        mBtnCallThread = findViewById(R.id.btnCallThread);
        mEtGiveTiming = findViewById(R.id.etGiveTime);
        workerThread = new WorkerThread();
        workerThread.start();
        mHandler = new Handler();


        mBtnCallThread.setOnClickListener(v -> {
//            performStuff();
            workerThread.addTaskToMessageQueue(task);
        });
    }

//    private void performStuff() {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                mHandler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        Log.d("Aditay", "Runnable method Started");
//                        mProgressBar.setProgress(initialCount);
//                        mTvPercentageDone.setText(String.valueOf(initialCount));
//                        Log.d("Aditay", "Completed");
//                    }
//                });
//            }
//        }).start();
//    }

    private Runnable task = new Runnable() {
        @Override
        public void run() {
            Log.d("Aditay", "Run method Started");
            int number = Integer.parseInt(mEtGiveTiming.getText().toString());
            for (int i = 0; i <= number; i++) {
                initialCount = i;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mHandler.post(new Runnable() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void run() {
                        Log.d("Aditay", "Runnable method Started");
                        mProgressBar.setProgress(initialCount);
                        if (initialCount == number) {
                            mTvPercentageDone.setText("Task Done");
                        } else {
                            mTvPercentageDone.setText(String.valueOf(initialCount) + " % " + "done");
                        }
                        Log.d("Aditay", "Completed");
                    }
                });
            }
        }
    };
}