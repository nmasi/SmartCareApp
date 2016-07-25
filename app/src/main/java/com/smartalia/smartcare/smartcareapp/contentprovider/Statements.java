package com.smartalia.smartcare.smartcareapp.contentprovider;

/**
 * Created by nicola on 24/07/16.
 */
public class Statements {

    private static final String START_STATEMENTS = "create table if not exists ";

    public static final String FARMACO_STATEMENT = START_STATEMENTS + SmartCareContract.Drug.TABLE_NAME + " (" +
            SmartCareContract.Drug.COLUMN_ID + " integer primary key, " +
            SmartCareContract.Drug.COLUMN_ORDER + " integer default 0, " +
            SmartCareContract.Drug.COLUMN_NAME + " text, " +
            SmartCareContract.Drug.COLUMN_SCHEDULERS + " text, " +
            SmartCareContract.Drug.COLUMN_DESCRIPTION + " text, " +
            SmartCareContract.Drug.COLUMN_TIME_END + " integer default 0, " +
            SmartCareContract.Drug.COLUMN_URL_IMG + " text, " +
            SmartCareContract.Drug.COLUMN_FARM + " text);";

}
