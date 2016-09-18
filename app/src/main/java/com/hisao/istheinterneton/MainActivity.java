package com.hisao.istheinterneton;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.net.InetAddress;

public class MainActivity extends AppCompatActivity {

    private static MainActivity mainActivityInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(getResources().getString(R.string.app_name));
        this.mainActivityInstance = this;

        final IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver((BroadcastReceiver) new ConnectionSupport(), intentFilter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateUI(ConnectionSupport.isInternetAvailable(this));

    }

    public static MainActivity getInstace(){
        return mainActivityInstance ;
    }


    public void updateUI(final boolean isTheInternetOn){

        MainActivity.this.runOnUiThread(new Runnable() {
            public void run() {
                TextView txtAns = (TextView) findViewById(R.id.txtAnswer);
                if (isTheInternetOn){
                    txtAns.setText(getResources().getString(R.string.yes));
                }else{
                    txtAns.setText(getResources().getString(R.string.no));
                }
            }
        });

    }
}
