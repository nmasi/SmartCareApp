package com.smartalia.smartcare.smartcareapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.TextView;

import com.smartalia.smartcare.smartcareapp.Utils.AlarmUtils;
import com.smartalia.smartcare.smartcareapp.Utils.Constants;
import com.smartalia.smartcare.smartcareapp.model.Drug;
import com.smartalia.smartcare.smartcareapp.services.HttpRequest;
import com.smartalia.smartcare.smartcareapp.services.IntentServicesHttp;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private ArrayList<Drug> farmaci;
    private static String LOG = MainActivity.class.getName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent2 = new Intent(Intent.ACTION_SYNC, null, this, IntentServicesHttp.class);
        intent2.putExtra(IntentServicesHttp.REQUEST_TYPE,IntentServicesHttp.TYPE_HTTP);
        this.startService(intent2);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FarmaciListActivity.class);
                startActivity(intent);
            }
        });


        FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.jsonButton);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlarmUtils alarmUtils = new AlarmUtils();
                alarmUtils.setTimer(getApplicationContext(),System.currentTimeMillis()+1000);
                submitOrder();
            }
        });


        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("myCodiceFiscale", "MSANCL85C16G273G");
        editor.commit();

        TextView myCodiceFiscale = (TextView) findViewById(R.id.codiceFiscaleString);
        myCodiceFiscale.setText(pref.getString(Constants.JSON_PROPERTIES_PATIENT_CODICEFISCALE,"Non Impostato"));
        TextView myName = (TextView) findViewById(R.id.NameString);
        myName.setText(pref.getString(Constants.JSON_PROPERTIES_PATIENT_NAME,"Non Impostato"));
        TextView mySurname = (TextView) findViewById(R.id.surnameString);
        mySurname.setText(pref.getString(Constants.JSON_PROPERTIES_PATIENT_SURNAME,"Non Impostato"));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    public void submitOrder() {
        HttpRequest my_http = new HttpRequest(this);
        my_http.myClickHandler();

            }

}
