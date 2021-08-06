package com.example.threads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

import java.util.function.LongFunction;

public class WorkingThread extends HandlerThread {

    private Handler mainThreadHandler;
//    private Handler handler;  //this handler will be assigning to the background thread

    public WorkingThread(String name, Handler mainThreadHandler) {
        super(name);
        this.mainThreadHandler = mainThreadHandler;
    }

    @Override
    protected void onLooperPrepared() {
        super.onLooperPrepared();
        int i;
        int progress = 0;
        for (i = 0; i <= 10; i++) {
            try {
                Thread.sleep(2000);
                progress += 10;

                Message message = Message.obtain();
                message.obj = progress;
                message.what = 1;

                if (i == 9) {
                    message.obj = "Task done";
                    message.what = 2;
                }
                mainThreadHandler.sendMessage(message); //sending message to the handler of the main thread

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
/*
when i=0; 10%
when i=1; 20%
when i=2; 30%
when i=3; 40%
when i=4; 50%
when i=5; 60%
when i=6; 70%
when i=7; 80%
when i=8; 90%
when i=9; 100%
 */