package com.hisao.istheinterneton;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.net.InetAddress;

/**
 * Created by viniciushisao
 */
public class ConnectionSupport extends BroadcastReceiver {

    public static final String SITE_TO_CHECK = "google.com";

    public static boolean isInternetAvailable() {
        try {
            InetAddress ipAddr = InetAddress.getByName(SITE_TO_CHECK); //You can replace it with your name
            Log.d("Vinicius", "messege " + ipAddr.toString());
            return !ipAddr.equals("");

        } catch (Exception e) {
            Log.d("Vinicius", "messege " + e.toString());
            return false;
        }
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        MainActivity.getInstance().updateUI();
    }

}
