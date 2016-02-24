package com.hisao.istheinterneton;

import java.net.InetAddress;

/**
 * Created by viniciushisao
 */
public class ConnectionSupport {

    public static boolean isInternetAvailable() {
        try {
            InetAddress ipAddr = InetAddress.getByName("google.com"); //You can replace it with your name

            if (ipAddr.equals("")) {
                return false;
            } else {
                return true;
            }

        } catch (Exception e) {
            return false;
        }

    }
}
