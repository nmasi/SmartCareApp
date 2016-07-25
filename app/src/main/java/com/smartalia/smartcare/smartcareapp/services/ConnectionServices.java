package com.smartalia.smartcare.smartcareapp.services;

import android.util.Log;

import com.smartalia.smartcare.smartcareapp.contentprovider.SmartCareDbHelper;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by nicola on 25/07/16.
 */
public class ConnectionServices {
    private static ConnectionServices instance = null;


    private SmartCareDbHelper db;
    private ConnectionServices() {

    }

    public static synchronized ConnectionServices getInstance() {
        if (instance == null) {
            instance = new ConnectionServices();

        }
        return instance;
    }
    private static String LOG = ConnectionServices.class.getName();
    private JSONObject reader;

    public String getHTTPConnection(String myurl) {
        InputStream is = null;


        String responseString="";
        try {
            URL url = new URL(myurl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000 /* milliseconds */);
            conn.setConnectTimeout(15000 /* milliseconds */);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            // Starts the query
            conn.connect();
            int response = conn.getResponseCode();
            Log.d(LOG, "The response is: " + response);
            is = conn.getInputStream();

            // Convert the InputStream into a string

            String contentAsString = readIt(is);
            is.close();
            responseString = contentAsString;



            // Makes sure that the InputStream is closed after the app is
            // finished using it.
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return responseString;
            }
        }
        return responseString;
    }
    public String readIt(InputStream stream) throws IOException, UnsupportedEncodingException {

        StringBuffer buffer = new StringBuffer();
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        String line;
        while ((line = reader.readLine()) != null) {
            buffer.append(line + "\n");
        }
        if (buffer.length() == 0) { return null;}
        String result  = buffer.toString();
return  result;


    }
}
