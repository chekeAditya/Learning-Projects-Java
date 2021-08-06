package com.example.threads;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.progressindicator.CircularProgressIndicator;

public class MainActivity extends AppCompatActivity {

    private Button mBtnCallThread;
    private CircularProgressIndicator mCircularProgressIndicator;
    private WorkerThread workerThread;
    private ProgressBar mProgressBar;
    private Handler mHandler;
    private TextView mTvPercentageDone;
    private int initialCount;

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
        mCircularProgressIndicator = findViewById(R.id.circularProgressBar);
        workerThread = new WorkerThread();
        workerThread.start();
        mHandler = new Handler();

        WorkingThread workingThread = new WorkingThread("async", mainThreadHandler);
        workingThread.start();

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
            mProgressBar.setMax(3);
            for (int i = 0; i <= 3; i++) {
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
                        if (initialCount == 3) {
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


    //using this handler as a communication medium
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