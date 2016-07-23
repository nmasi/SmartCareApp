package com.smartalia.smartcare.smartcareapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

import com.smartalia.smartcare.smartcareapp.Utils.AlarmUtils;
import com.smartalia.smartcare.smartcareapp.model.Farmaco;
import com.smartalia.smartcare.smartcareapp.services.HttpRequest;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private ArrayList<Farmaco> farmaci;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                //submitOrder();
            }
        });

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
