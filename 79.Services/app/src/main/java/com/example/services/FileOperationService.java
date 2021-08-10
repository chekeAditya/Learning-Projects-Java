package com.example.services;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Objects;

public class FileOperationService extends Service {

    private String name = "";


    public FileOperationService() {
    }


    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("Aditya", "onCreate");
        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.O) {
            showNotificationAndStartForeGround();
        }
    }

    //it's a interface
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    //it will invoke when we say service.start();
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("Aditya", "onStartCommand");
        if (intent != null){
            name = intent.getStringExtra("name");
        }
        launchBackgroundThread();
        return super.onStartCommand(intent, flags, startId);
    }

    private void launchBackgroundThread() {
        Thread thread = new Thread(task);
        thread.start();
    }

    //runs in the background
    private Runnable task = new Runnable() {
        @Override
        public void run() {
            saveToFile();
        }
    };

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("Aditya", "onDestroy");
    }

    /**
     * Saving details to the file
     */

    private void saveToFile() {
//        test();
        try {
            //Create a directory
            File directory = new File(getFilesDir() + File.separator + "AdityaFolder"); //it can be created for 3 places -> internal storage -> external storage -> external sd card
            if (!directory.exists()) {
                directory.mkdir(); //if not created then create a directory using this line
            }
            /*
             Create a file inside the directory
            */

            File file = new File(directory, "name.txt");
            if (!file.exists()) {
                file.createNewFile();
            }

            FileOutputStream fileOutputStream = new FileOutputStream(file, true);
            OutputStreamWriter writer = new OutputStreamWriter(fileOutputStream);
            writer.append(name + "\n");
            writer.close();

            Intent intent = new Intent("com.xyz.service");
            intent.putExtra("data","Write Done");
            sendBroadcast(intent);

        } catch (Exception e) {

        }

    }

    private void showNotificationAndStartForeGround() {
        createChannel();

        NotificationCompat.Builder notificationBuilder = null;
        notificationBuilder = new NotificationCompat.Builder(this, "CHANNEL_ID")
                .setContentTitle("Service is running : ")
                .setPriority(NotificationCompat.PRIORITY_HIGH);

        Notification notification = null;
        notification = notificationBuilder.build();
        startForeground(120, notification);
    }

    public void createChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("CHANNEL_ID", "CHANNEL_NAME", NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("Call Notifications");
            Objects.requireNonNull(this.getSystemService(NotificationManager.class)).createNotificationChannel(channel);
        }
    }

    //runs in the background
//    private void test() {
//
//    }
}

/*
name.txt

 */
