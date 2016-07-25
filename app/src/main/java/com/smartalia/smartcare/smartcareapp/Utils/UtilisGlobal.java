package com.smartalia.smartcare.smartcareapp.Utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.smartalia.smartcare.smartcareapp.R;

/**
 * Created by nicola on 23/07/16.
 */
public class UtilisGlobal {

    public static boolean verifyConnection(Context context, boolean viewMessageTosast) {
        ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
                if(viewMessageTosast)Toast.makeText(context, context.getResources().getString(R.string.connection_ok), Toast.LENGTH_LONG).show();
            return true;
            } else {
                if(viewMessageTosast)Toast.makeText(context, context.getResources().getString(R.string.connection_ko), Toast.LENGTH_LONG).show();
            return false;
            }
    }

}
