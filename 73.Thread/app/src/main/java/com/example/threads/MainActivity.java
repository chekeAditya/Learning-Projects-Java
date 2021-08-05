package com.example.threads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTvData1;
    private TextView mTvData2;
    private WorkerThread workerThread;
    private Handler handler;

//    private Runnable task = new Runnable() {
//        @Override
//        public void run() {
//            //it is the task only
//            Log.d("Adi -1", Thread.currentThread().getName());
//            for (int i = 0; i < 5; i++) {
//                Log.d("Aditya", "value = " + i);
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
////            mTvData.setText("TextData");//you cannot update ui here
////            in the background thread toast is even not possible
////            runOnUiThread(new Runnable() {
////                @Override
////                public void run() {
////                    //This runnable will work on the Main thread
////                    Log.d("Aditya-runOnUiThread",Thread.currentThread().getName());
////                    mTvData.setText("Updated");
////                }
////            });
//        }
//    };

    /**
     * Once the taks come outside the } then it's done it will not run agian
     */

//    private Runnable task2 = new Runnable() {
//        @Override
//        public void run() {
//            Log.d("Adi - 1", Thread.currentThread().getName());
//            for (int i = 5; i < 10; i++) {
//                Log.d("Aditya", "value = " + i);
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mTvData1 = findViewById(R.id.tvData1);
        mTvData2 = findViewById(R.id.tvData2);
        Log.d("Aditya", Thread.currentThread().getName());

//        Thread thread = new Thread(); //object of thread
//        WorkerThread thread = new WorkerThread(); //object of thread
//        thread.start(); //thread starts here and the here run() operation get called
//        Log.d("Aditya", Thread.currentThread().getName());

        workerThread.start();
        workerThread = new WorkerThread();
        handler = new Handler();
        workerThread.start();

        mTvData1.setOnClickListener(v -> {
            workerThread.addTaskToMessageQueue(taskOne);
        });

        mTvData2.setOnClickListener(v -> {
            workerThread.addTaskToMessageQueue(taskTwo);
        });
    }

    private Runnable taskOne = new Runnable() {
        @Override
        public void run() {
            Log.d("Aditya", "Task name " + Thread.currentThread().getName());
            try {
                Log.d("Aditya", "Task 1 Started");
                Thread.sleep(1000);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        mTvData1.setText("Done");
                    }
                });
                Log.d("Aditya", "Task 1 Started");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    private Runnable taskTwo = new Runnable() {
        @Override
        public void run() {
            Log.d("Aditya", "Task name " + Thread.currentThread().getName());
            try {
                Log.d("Aditya", "Task 2 Started");
                Thread.sleep(1000);
                Log.d("Aditya", "Task 2 completed");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
}