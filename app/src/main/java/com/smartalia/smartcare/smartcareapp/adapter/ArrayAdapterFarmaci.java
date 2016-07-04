package com.smartalia.smartcare.smartcareapp.adapter;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by nicola on 29/06/16.
 */
public class ArrayAdapterFarmaci extends ArrayAdapter{


    public ArrayAdapterFarmaci(Context context, int resource, int textViewResourceId, List objects) {
        super(context, resource, textViewResourceId, objects);
    }
}
