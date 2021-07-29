package com.example.boadcastreciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class ReceiverBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
//        sending message form one app to another
//        String data = intent.getStringExtra("data");
//        Toast.makeText(context,"Receiving broadcast from other app with message " + data,Toast.LENGTH_SHORT).show();
        Toast.makeText(context,"Local Broadcast Receiver",Toast.LENGTH_SHORT).show();
    }
}
