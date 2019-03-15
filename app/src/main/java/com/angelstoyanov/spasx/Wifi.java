package com.angelstoyanov.spasx;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Formatter;

public class Wifi extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi);
    }
    @Override
    protected void onPause(){
        super.onPause();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
    }
    @Override
    protected void onResume(){
        super.onResume();
    }



}
