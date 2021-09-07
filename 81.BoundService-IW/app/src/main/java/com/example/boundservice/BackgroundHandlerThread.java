package com.example.boundservice;

import android.os.Handler;
import android.os.HandlerThread;

public class BackgroundHandlerThread extends HandlerThread {

    private Handler mHandler;
    private LooperPreparedListener listener;

    public BackgroundHandlerThread(String name, LooperPreparedListener looperPreparedListener) {
        super(name);
        listener = looperPreparedListener;
    }

    @Override
    protected void onLooperPrepared() {
        super.onLooperPrepared();
        mHandler = new Handler(getLooper());
        if (listener != null) {
            listener.onLooperReady();
        }
    }

    public void addTaskToQueue(Runnable task) {
        mHandler.post(task);
    }
}
