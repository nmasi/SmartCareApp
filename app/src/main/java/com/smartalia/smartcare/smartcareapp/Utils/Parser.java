package com.smartalia.smartcare.smartcareapp.Utils;

import com.smartalia.smartcare.smartcareapp.contentprovider.SmartCareDbHelper;

import org.json.JSONObject;

/**
 * Created by nicola on 25/07/16.
 */
public class Parser {
    private static Parser instance = null;


    private SmartCareDbHelper db;
    private Parser() {

    }

    public static synchronized Parser getInstance() {
        if (instance == null) {
            instance = new Parser();

        }
        return instance;
    }
    public static JSONObject getJsonByString(String jsonStrign){



        try {
          JSONObject jsonObject = new JSONObject(jsonStrign);
          return jsonObject;
      }catch (Exception ex){
          return null;
      }

    }
}
