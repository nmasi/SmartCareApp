package com.smartalia.smartcare.smartcareapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.smartalia.smartcare.smartcareapp.asynctask.AsyncTaskImage;

public class FarmacoDettaglioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmaco_dettaglio);
        Bundle bundle = getIntent().getExtras();
        ((TextView)findViewById(R.id.farmacoNome)).setText(bundle.getString("farmacoNome"));
        ((TextView)findViewById(R.id.farmacoNomeAzienda)).setText(bundle.getString("farmacoAzienda"));
        ((TextView)findViewById(R.id.farmacoDescrizione)).setText(bundle.getString("farmacoDescrizione"));
        new AsyncTaskImage((ImageView) findViewById(R.id.farmacoImg)).execute(bundle.getString("farmacoUrlImg"));
        //new AsyncTaskImage((ImageView) findViewById(R.id.farmacoImg)).execute("http://www.angelini.it/wps/wcm/connect/f39b7b74-46db-4707-9677-a1350ebb9c7f/logo-mob.png?MOD=AJPERES&CACHEID=f39b7b74-46db-4707-9677-a1350ebb9c7f");
    }
}
