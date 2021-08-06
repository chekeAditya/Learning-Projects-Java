package com.example.thread_ii;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.progressindicator.CircularProgressIndicator;

import java.time.LocalDate;

public class MainActivity extends AppCompatActivity {

    private TextView mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProgressBar = findViewById(R.id.progressBar);
//        WokingThread wokingThread = new WokingThread("Aditya"); //here its giving us the chance to choose any name
//        wokingThread.start();
//        asyncTask.execute();
//        mProgressBar.setOnClickListener(v -> {
//            wokingThread.addTaskToQueue(new Runnable() {
//                @Override
//                public void run() {
//                    Log.d("Aditya", "Thread name = " + Thread.currentThread().getName());
//                    for (int i = 0; i < 10; i++) {
//                        Log.d("Aditya", "value is " + i);
//                    }
//                }
//            });
//        });


    }
    //AsyncTask
    /**
     *
     */
//    private AsyncTask<String, Void, Boolean> asyncTask = new AsyncTask<String, Void, Boolean>() {
////        @Override
////        protected Boolean doInBackground(String... strings) {
////            return null;
////            /**
////             * this is the boolean method
////             * this method automatically run in the background
////             */
////        }
////
////        @Override
////        protected void onPreExecute() {
////            super.onPreExecute();
////            /**
////             * before downloading if you want to do somthing or show progress bar then that will done here
////             * it will run in main thread
////             */
////        }
////
////        @Override
////        protected void onPostExecute(Boolean aBoolean) {
////            super.onPostExecute(aBoolean);
////            /**
////             * run in the main thread
////             */
////        }
////
////        @Override
////        protected void onProgressUpdate(Void... values) {
////            super.onProgressUpdate(values);
////            /**
////             * ui runs in this thread
////             */
////        }
////    };
//
//    }
    //don't pass anything
//        private AsyncTask<Void, Void, Void> asyncTask = new AsyncTask<Void, Void, Void>() {
//        @Override
//        protected Void doInBackground(Void... voids) {
//            Log.d("Aditya", "doInBackground");
//            for (int i = 0; i < 10; i++) {
//                try {
//                    Thread.sleep(1000);
//                    Log.d("Aditya", "value is " + i);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//                return null;
//        }
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//            Log.d("Aditya", "onPreExecute");
//        }
//
//        @Override
//        protected void onPostExecute(Void unused) {
//            super.onPostExecute(unused);
//            Log.d("Aditya", "onPostExecute");
//        }
//    };
}
/*
2021-08-06 15:33:50.306 32061-32061/com.example.thread_ii D/Aditya: onPreExecute
2021-08-06 15:33:50.307 32061-2448/com.example.thread_ii D/Aditya: doInBackground
2021-08-06 15:33:51.308 32061-2448/com.example.thread_ii D/Aditya: value is 0
2021-08-06 15:33:52.312 32061-2448/com.example.thread_ii D/Aditya: value is 1
2021-08-06 15:33:53.314 32061-2448/com.example.thread_ii D/Aditya: value is 2
2021-08-06 15:33:54.315 32061-2448/com.example.thread_ii D/Aditya: value is 3
2021-08-06 15:33:55.316 32061-2448/com.example.thread_ii D/Aditya: value is 4
2021-08-06 15:33:56.316 32061-2448/com.example.thread_ii D/Aditya: value is 5
2021-08-06 15:33:57.318 32061-2448/com.example.thread_ii D/Aditya: value is 6
2021-08-06 15:33:58.319 32061-2448/com.example.thread_ii D/Aditya: value is 7
2021-08-06 15:33:59.320 32061-2448/com.example.thread_ii D/Aditya: value is 8
2021-08-06 15:34:00.321 32061-2448/com.example.thread_ii D/Aditya: value is 9
2021-08-06 15:34:00.323 32061-32061/com.example.thread_ii D/Aditya: onPostExecute
 */