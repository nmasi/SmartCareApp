package com.smartalia.smartcare.smartcareapp.contentprovider;

import android.content.ContentUris;
import android.net.Uri;
import android.content.ContentResolver;

/**
 * Created by nicola on 02/07/16.
 */
public class SmartCareContract {
    public static final String CONTENT_AUTHORITY = "com.smartalia.smartcare.smartcareapp";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://"+CONTENT_AUTHORITY);

    private static final String PATH_DRUGS = "drug";
    public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_DRUGS).build();

    public static Uri buildDrugUri(long id){
        return ContentUris.withAppendedId(CONTENT_URI,id);
    }
    public static final class Drug{

        public static final String TABLE_NAME = "drug";

        public static final String COLUMN_ID = TABLE_NAME + "_id";
        public static final String COLUMN_ORDER = TABLE_NAME + "_order";
        public static final String COLUMN_NAME = TABLE_NAME + "_name";
        public static final String COLUMN_FARM = TABLE_NAME + "_farm";
        public static final String COLUMN_DESCRIPTION = TABLE_NAME + "_description";
        public static final String COLUMN_URL_IMG = TABLE_NAME + "_urlImage";
        public static final String COLUMN_TIME_END = TABLE_NAME + "_timeEnd";
        public static final String COLUMN_SCHEDULERS = TABLE_NAME + "_scheduler";


        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(TABLE_NAME).build();

        public static Uri buildUri(long id){
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + TABLE_NAME;

        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + TABLE_NAME;

    }


}
