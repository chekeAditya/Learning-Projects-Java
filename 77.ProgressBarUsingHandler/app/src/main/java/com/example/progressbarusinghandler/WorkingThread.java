package com.example.progressbarusinghandler;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

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
