package org.mikebush.apswatchdog;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class AlarmReceiver extends BroadcastReceiver {

    private static String tag = "APSWatchdog.AlarmReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(tag, "Alarm Triggered" );
    }
}