package com.smartalia.smartcare.smartcareapp.services;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by nicola on 20/07/16.
 */
public class IntentServicesHttp extends IntentService{
    private static final String TAG = "IntentService";

    public static final String REQUEST_TYPE = "requestType";

    public static final int TYPE_1 = 1;
    public static final int TYPE_2 = 2;

    public IntentServicesHttp() {
        super("");
    }

    @Override
    protected void onHandleIntent(Intent intent) {


        Vibrator vibrator = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
        ArrayList<Long> timeLong = new ArrayList<>();


        vibrator.vibrate(1000);



        Log.d(TAG, "start");

        Bundle extras = intent.getExtras();
        if(extras==null)return;

        final int requestType = extras.getInt(REQUEST_TYPE, -1);

        String action = "";


        switch (requestType) {

            case TYPE_1:

                break;

            case TYPE_2:

                break;

        }

    }
}
