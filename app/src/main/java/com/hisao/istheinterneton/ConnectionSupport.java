package com.hisao.istheinterneton;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

/**
 * Created by viniciushisao
 */
public class ConnectionSupport extends BroadcastReceiver {


    public static boolean isInternetAvailable(Context ctx) {
        ConnectivityManager conMgr = (ConnectivityManager) ctx
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = conMgr.getActiveNetworkInfo();
        boolean isOn = false;
        if (activeNetworkInfo == null)
            isOn = true;
        if (!activeNetworkInfo.isConnected())
            isOn = true;
        if (!activeNetworkInfo.isAvailable())
            isOn = false;
        return isOn;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        MainActivity.getInstace().updateUI(isInternetAvailable(context));
    }

}
