package org.mikebush.apswatchdog;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import java.util.Calendar;
import java.util.Date;

public class APSReceiver extends BroadcastReceiver {

    public static long wdTime = 12L * 60L; // Seconds

    private static String tag = "APSWatchdog.APSReceiver";
    public static Date lastReceived;

    @Override
    public void onReceive(Context context, Intent intent) {
        lastReceived = Calendar.getInstance().getTime();

        String msg = "Received Intent at: "+ APSReceiver.lastReceived.toString();
        APSWatchdogLogger.d(tag, msg );
        setAlarm(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void setAlarm(Context context)
    {
        APSWatchdogLogger.d(tag, "Setup Alarm" );
        AlarmManager am =( AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        assert am != null;
        Intent i = new Intent(context, AlarmReceiver.class);
        PendingIntent pi = PendingIntent.getBroadcast(context, 0, i, PendingIntent.FLAG_MUTABLE);
        am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, (System.currentTimeMillis()/1000L + wdTime) *1000L, pi); //Next alarm in 15s
    }


}