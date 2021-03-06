package com.hisao.istheinterneton;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static MainActivity mainActivityInstance;
    private TextView txtAns;
    private static int counter = 0;
    ConnectionSupport connectionSupport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivityInstance = this;
        setContentView(R.layout.activity_main);
        setTitle(getResources().getString(R.string.app_name));
        txtAns = (TextView) findViewById(R.id.txtAnswer);


        txtAns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter > 5){
                    counter = 0;
                    ImageView image = new ImageView(MainActivity.this);
                    image.setImageResource(R.drawable.photo);
                    AlertDialog.Builder builder =
                            new AlertDialog.Builder(MainActivity.this).
                                    setView(image);
                    builder.create().show();
                }else{
                    counter ++;
                }
            }
        });

        final IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        connectionSupport = new ConnectionSupport();
        registerReceiver(connectionSupport, intentFilter);


    }

    public static MainActivity getInstance() {
        return mainActivityInstance;
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (connectionSupport != null){
            try{
                unregisterReceiver(connectionSupport);
            }catch (Exception e){

            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateUI();
    }


    public void updateUI() {

        AsyncTask<Void, Void, Boolean> asyncTask = new AsyncTask<Void, Void, Boolean>() {
            @Override
            protected Boolean doInBackground(Void... params) {
                return ConnectionSupport.isInternetAvailable();
            }

            @Override
            protected void onPostExecute(Boolean aBoolean) {
                super.onPostExecute(aBoolean);
                if (aBoolean) {
                    txtAns.setText(getResources().getString(R.string.yes));
                } else {
                    txtAns.setText(getResources().getString(R.string.no));
                }
            }
        };
        asyncTask.execute();
    }
}
