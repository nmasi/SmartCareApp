package com.smartalia.smartcare.smartcareapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import java.util.ArrayList;

import com.smartalia.smartcare.smartcareapp.adapter.ArrayAdapterFarmaci;
import services.ConnectionHttp;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConnectionHttp connectionHttp = new ConnectionHttp();
        String json = connectionHttp.getJsonByUrl("https://en.wikipedia.org/w/api.php?action=query&titles=Main%20Page&prop=revisions&rvprop=content&format=json");

        ArrayList<String> farmaci  = new ArrayList<>();
        for (int i=0; i<100; i++){
            farmaci.add("Farmaco "+i+" - Attivo");
        }

        ArrayAdapter arrayAdapter = new ArrayAdapterFarmaci(this,R.layout.list_item,R.id.list_item_textview,farmaci);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(arrayAdapter);






    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }
}
