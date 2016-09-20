package com.hisao.istheinterneton;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.net.InetAddress;

/**
 * Created by viniciushisao
 */
public class ConnectionSupport extends BroadcastReceiver {


    public static boolean isInternetAvailable(Context ctx) {
        try {
            InetAddress ipAddr = InetAddress.getByName("google.com"); //You can replace it with your name
            return !ipAddr.equals("");

        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        MainActivity.getInstace().updateUI(isInternetAvailable(context));
    }

}
