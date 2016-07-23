package com.smartalia.smartcare.smartcareapp.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by nicola on 20/07/16.
 */
public class AlarmFarm extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Toast toast = Toast.makeText(context,"Alarm ok",Toast.LENGTH_LONG);
        toast.show();


        Intent intent2 = new Intent(Intent.ACTION_SYNC, null, context, IntentServicesHttp.class);
        context.startService(intent2);
    }

}
