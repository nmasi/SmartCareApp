package com.smartalia.smartcare.smartcareapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.smartalia.smartcare.smartcareapp.adapter.ArrayAdapterFarmaci;
import com.smartalia.smartcare.smartcareapp.model.Farmaco;
import com.smartalia.smartcare.smartcareapp.services.ConnectionHttp;

import java.util.ArrayList;

public class FarmaciListActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    private ArrayList<Farmaco> farmaci;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmaci_list);

        ConnectionHttp connectionHttp = new ConnectionHttp();
        String json = connectionHttp.getJsonByUrl("https://en.wikipedia.org/w/api.php?action=query&titles=Main%20Page&prop=revisions&rvprop=content&format=json");

       /* ArrayList<String> farmaci  = new ArrayList<>();
        for (int i=0; i<100; i++){
            farmaci.add("Farmaco "+i+" - Attivo");
        }*/

        farmaci = new ArrayList<Farmaco>();
        farmaci.add(new Farmaco("Tachipirina", "ANGELINI", "img" , "Il paracetamolo, meglio conosciuto in Italia come Tachipirina®,  è un principio attivo che si trova in vendita come farmaco da banco o meno a seconda del dosaggio; è molto usato come antipiretico (cioè per far diminuire la febbre), ma pochi sanno che è un ottimo analgesico (cioè come antidolorifico)."));
        for (int i = 0; i < 100; i++) {
            farmaci.add(new Farmaco("Farmaco " + i, "Azianda " + i, "img" + i, "Descrizione Bla bla bla.... Descrizione Bla bla bla.... Descrizione Bla bla bla.... Descrizione Bla bla bla.... Descrizione Bla bla bla.... Descrizione Bla bla bla.... Descrizione Bla bla bla.... " + i));
        }

        ArrayAdapter arrayAdapter = new ArrayAdapterFarmaci(this, R.layout.list_item, R.id.list_item_textview, farmaci);
        final ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Farmaco farmaco = farmaci.get(position);
                Intent intent = new Intent(FarmaciListActivity.this, FarmacoDettaglioActivity.class);
                intent.putExtra("farmacoNome", farmaco.getNomeFarmaco());
                intent.putExtra("farmacoAzienda", farmaco.getNomeAzienda());
                intent.putExtra("farmacoDescrizione", farmaco.getDescrizioneFarmaco());
                intent.putExtra("farmacoUrlImg", farmaco.getUrlImg());
                startActivity(intent);
            }
        });


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.smartalia.smartcare.smartcareapp/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.smartalia.smartcare.smartcareapp/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
