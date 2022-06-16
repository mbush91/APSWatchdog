package org.mikebush.apswatchdog;

import android.os.Environment;
import android.util.Log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class APSWatchdogLogger {
    public static void d(String tag, String msg) {
        writeLog("DEBUG",tag,msg);
        Log.d(tag,msg);
    }

    public static void writeLog(String level, String tag, String msg) {
        Date time = Calendar.getInstance().getTime();

        String text = time.toString() + " " + level + ": " + tag + " - " + msg;

        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);

        File logFile = new File(folder,"APSWatchdog.txt");
        if (!logFile.exists())
        {
            try
            {
                logFile.createNewFile();
            }
            catch ( IOException e )
            {
                // TODO Auto-generated catch block
                Log.w("APSWatchdog.APSWatchdogLogger",e.toString());

            }
        }
        try
        {
            //BufferedWriter for performance, true to set append to file flag
            BufferedWriter buf = new BufferedWriter(new FileWriter(logFile, true));
            buf.append(text);
            buf.newLine();
            buf.close();
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
