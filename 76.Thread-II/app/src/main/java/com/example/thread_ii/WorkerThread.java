package com.example.thread_ii;

import android.os.Looper;

public class WorkerThread extends Thread {

    @Override
    public void run() {
        super.run();
        Looper.prepare();
        for (int i = 0; i < 5; i++) {

        }
        Looper.loop(); //it will never go beyond this.
    }
}
