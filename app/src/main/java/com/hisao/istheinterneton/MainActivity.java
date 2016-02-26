package com.hisao.istheinterneton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.net.InetAddress;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle(getResources().getString(R.string.app_name));

        TextView txtAns = (TextView) findViewById(R.id.txtAnswer);
        if (ConnectionSupport.isInternetAvailable(getApplicationContext())){
            txtAns.setText(getResources().getString(R.string.yes));
        }else{
            txtAns.setText(getResources().getString(R.string.no));
        }
    }
}
