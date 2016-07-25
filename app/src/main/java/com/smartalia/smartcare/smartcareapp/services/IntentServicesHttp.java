package com.smartalia.smartcare.smartcareapp.services;

import android.app.IntentService;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.util.Log;

import com.smartalia.smartcare.smartcareapp.Utils.Constants;
import com.smartalia.smartcare.smartcareapp.contentprovider.SmartCareContract;
import com.smartalia.smartcare.smartcareapp.contentprovider.SmartCareDbHelper;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by nicola on 20/07/16.
 */
public class IntentServicesHttp extends IntentService{
    private static final String TAG = "IntentService";

    public static final String REQUEST_TYPE = "requestType";

    public static final int TYPE_HTTP = 1;
    public static final int TYPE_HTTPS = 2;
    public static final int TYPE_HTTP_BASIC_AUTHENTICATION = 3;
    public static final int TYPE_HTTPS_BASIC_AUTHENTICATION = 4;


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
        if(extras==null){
            return;
        }

        final int requestType = extras.getInt(REQUEST_TYPE, -1);

        String action = "";

        String stringResponse = null;
        switch (requestType) {

            case TYPE_HTTP:


                    stringResponse = ConnectionServices.getInstance().getHTTPConnection(Constants.URL_GET_JSON_START);
                    saveInDB(stringResponse);

                break;

            case TYPE_2:

                break;

        }

    }

    private void saveInDB(String stringResponse) {
        try{
            JSONObject jsonObject = new JSONObject(stringResponse);
            JSONObject globalJson = new JSONObject();
            JSONObject patientJson = new JSONObject();


            globalJson = jsonObject.getJSONObject(Constants.JSON_PROPERTIES_GLOBAL);

            patientJson = globalJson.getJSONObject(Constants.JSON_PROPERTIES_PATIENT);

            SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            SharedPreferences.Editor editor = pref.edit();
            editor.putString(Constants.JSON_PROPERTIES_PATIENT_NAME, (String)patientJson.get(Constants.JSON_PROPERTIES_PATIENT_NAME));
            editor.putString(Constants.JSON_PROPERTIES_PATIENT_SURNAME, (String)patientJson.get(Constants.JSON_PROPERTIES_PATIENT_SURNAME));
            editor.putString(Constants.JSON_PROPERTIES_PATIENT_CODICEFISCALE, (String)patientJson.get(Constants.JSON_PROPERTIES_PATIENT_CODICEFISCALE));
            editor.commit();


            JSONArray drugsJsonArray = new JSONArray();
            drugsJsonArray = globalJson.getJSONArray(Constants.JSON_PROPERTIES_DRUGS);
            ContentValues contentDrogsValues;
            for(int i=0; i<drugsJsonArray.length();i++){
                contentDrogsValues = new ContentValues();
                contentDrogsValues.put(SmartCareContract.Drug.COLUMN_NAME,(String)((JSONObject)drugsJsonArray.get(i)).get(Constants.JSON_PROPERTIES_DRUG_NAME));
                contentDrogsValues.put(SmartCareContract.Drug.COLUMN_DESCRIPTION,(String)((JSONObject)drugsJsonArray.get(i)).get(Constants.JSON_PROPERTIES_DRUG_DESCRIPTION));
                contentDrogsValues.put(SmartCareContract.Drug.COLUMN_FARM,(String)((JSONObject)drugsJsonArray.get(i)).get(Constants.JSON_PROPERTIES_DRUG_FARM));
                //contentDrogsValues.put(SmartCareContract.Drug.COLUMN_SCHEDULERS,(String)((JSONObject)((JSONArray)((JSONObject)drugsJsonArray.get(i)).get(Constants.JSON_PROPERTIES_DRUG_SCHEDULERS)).get(0)).get(Constants.JSON_PROPERTIES_DRUG_SCHEDULERS));
                contentDrogsValues.put(SmartCareContract.Drug.COLUMN_TIME_END,Integer.parseInt(""+((JSONObject)drugsJsonArray.get(i)).get(Constants.JSON_PROPERTIES_DRUG_TIME_END)));
                contentDrogsValues.put(SmartCareContract.Drug.COLUMN_URL_IMG,(String)((JSONObject)drugsJsonArray.get(i)).get(Constants.JSON_PROPERTIES_DRUG_URL_IMG));
                Uri insertedUri = getContentResolver().insert(
                        SmartCareContract.Drug.CONTENT_URI,
                        contentDrogsValues
                );
                Long grugId = ContentUris.parseId(insertedUri);
            }



            SmartCareDbHelper smartCareDbHelper = new SmartCareDbHelper(getApplicationContext());
            SQLiteDatabase db = smartCareDbHelper.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            //contentValues.put(SmartCareContract.Drug.COLUMN_ID,1);
            contentValues.put(SmartCareContract.Drug.COLUMN_NAME,"test");
            //Long id = db.insert(SmartCareContract.Drug.TABLE_NAME,null,contentValues);

            Uri insertedUri = getContentResolver().insert(
                    SmartCareContract.Drug.CONTENT_URI,
                    contentValues
            );

            Long grugId = ContentUris.parseId(insertedUri);
        }catch(Exception ex){
            return;
        }

    }

}
