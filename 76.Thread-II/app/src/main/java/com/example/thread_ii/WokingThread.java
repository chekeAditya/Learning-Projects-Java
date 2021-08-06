package com.example.thread_ii;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;

import java.time.LocalDate;

public class WokingThread extends HandlerThread {
    /**
     * here we don't have to say Looper.prepare(); or Looper.loop();
     * it's the basic difference in HandlerThread or Thread as inside the run method it's already present
     * This handler thread won't kill it until we do by our own
     */

    private Handler handler;

    public WokingThread(String name) {
        super(name);
    }

    @Override
    protected void onLooperPrepared() {
        super.onLooperPrepared();
        Log.d("Aditya",Thread.currentThread().getName());
    }

    public void addTaskToQueue(Runnable task) {
        if (handler != null) {
            handler.post(task);
        }
    }
}
