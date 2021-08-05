package com.example.threads;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

public class WorkerThread extends Thread {

    /**
     * Every Looper wil have a message queue associated with it
     * Queue ->  Every Looper wil have a message queue associated with it
     */

    /**
     * Handler is adding the music to the message queue
     * Handler is created in the background thread
     * Handler get associated to the thread where it get created
     * Handler is a object.
     * You can use handler as a communication source
     * You are creating the tread in the background thread and posting the message in the background thread only.
     * Looper.loop willl pick one task and the perform it then again pick another and perform it as go on.
     */

    /**
     * due to looper thread never died
     */

    private Handler handler;

    @Override
    public void run() {
        super.run();
        Looper.prepare();
        handler = new Handler();
//        Log.d("Aditya-", Thread.currentThread().getName());
//        for (int i = 0; i < 5; i++) {
//            try {
//                Log.d("Aditya", "val " + i);
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

        //here Thread is not dying after the exectuion one it will still alive
        Log.d("Aditya", "before the Looping");
        Looper.loop();
        Log.d("Aditya", "After Looping");
    }

    public void addTaskToMessageQueue(Runnable task) {

//        can be used to post the message to the message queue
        if (handler != null) {
            handler.post(task);
        }
    }
}
