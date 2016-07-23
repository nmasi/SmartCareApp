package com.smartalia.smartcare.smartcareapp.Utils;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import com.smartalia.smartcare.smartcareapp.services.AlarmFarm;

/**
 * Created by nicola on 20/07/16.
 */
public class AlarmUtils {
    public static final String ACTION_ALARM = "com.smartalia.smartcare.smartcareapp.services.AlarmFarm";

    public static final int PENDING_QUIZ = 1;

    public static void setTimer(Context context, long alarmTime){

        Intent intent = new Intent(context, AlarmFarm.class);
        intent.setAction(ACTION_ALARM);

        /**
         * chiamando getBroadcast sul PendingIntent, verrà eseguito un BroadcastReceiver,
         * di fatto potremmo anche eseguire un'activity o un service
         */
        PendingIntent pIntent = PendingIntent.getBroadcast(context, PENDING_QUIZ, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarm = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        /**
         * questo viene eseguito anche con doze attivo
         */
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            alarm.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, alarmTime, pIntent);

        /**
         * questo viene eseguito sul momento
         */
        else if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
            alarm.setExact(AlarmManager.RTC_WAKEUP, alarmTime, pIntent);

        /**
         * questo viene eseguito sul momento
         */
        else
            alarm.set(AlarmManager.RTC_WAKEUP, alarmTime, pIntent);

    }
}
