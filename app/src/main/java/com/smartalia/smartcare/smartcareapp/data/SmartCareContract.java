package com.smartalia.smartcare.smartcareapp.data;

import android.content.ContentUris;
import android.net.Uri;

/**
 * Created by nicola on 02/07/16.
 */
public class SmartCareContract {
    public static final String CONTENT_AUTHORITY = "com.smartalia.smartcare";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://"+CONTENT_AUTHORITY);
    public static final String PATH_CODICE_FISCALE = "MSANCL85C16G273G";
    private static final String PATH_DRUGS = "drug";
    public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_DRUGS).build();

    public static Uri buildDrugUri(long id){
        return ContentUris.withAppendedId(CONTENT_URI,id);
    }
}
