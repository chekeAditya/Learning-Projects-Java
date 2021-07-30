package com.example.sendbroadcastsecurityconsideration;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class LocalBroadCast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            Intent activityIntent = new Intent(context, SecondActivity.class);
            String message = intent.getStringExtra("permission");
            activityIntent.putExtra("permission", message);
            context.startActivity(activityIntent);
        }
    }
}
