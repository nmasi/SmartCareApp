package com.smartalia.smartcare.smartcareapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.smartalia.smartcare.smartcareapp.R;
import com.smartalia.smartcare.smartcareapp.model.Farmaco;

import java.util.List;

/**
 * Created by nicola on 29/06/16.
 */
public class ArrayAdapterFarmaci extends ArrayAdapter<Farmaco>{


    public ArrayAdapterFarmaci(Context context, int resource, int textViewResourceId, List objects) {
        super(context, resource, textViewResourceId, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        convertView = inflater.inflate(R.layout.list_item, null);

        TextView nome = (TextView)convertView.findViewById(R.id.farmacoNome);
        TextView azienda = (TextView)convertView.findViewById(R.id.farmacoNomeAzienda);
        TextView descrizione = (TextView)convertView.findViewById(R.id.farmacoDescrizione);
        Farmaco c = getItem(position);
        nome.setText(c.getNomeFarmaco());
        azienda.setText(c.getNomeAzienda());
        descrizione.setText(c.getDescrizioneFarmaco());
        return convertView;
    }
}
