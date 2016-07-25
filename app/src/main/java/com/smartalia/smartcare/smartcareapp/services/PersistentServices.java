package com.smartalia.smartcare.smartcareapp.services;

import android.database.Cursor;

import com.smartalia.smartcare.smartcareapp.contentprovider.SmartCareDbHelper;

/**
 * Created by nicola on 24/07/16.
 */
public class PersistentServices {
    private static PersistentServices instance = null;


    private SmartCareDbHelper db;
    private PersistentServices() {

    }

    public static synchronized PersistentServices getInstance() {
        if (instance == null) {
            instance = new PersistentServices();

        }
        return instance;
    }

public Cursor putValue(){

   return null;
}


}
