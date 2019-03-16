package com.angelstoyanov.spasx;

import android.app.Activity;
import android.app.DownloadManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ToggleButton;

import java.util.concurrent.ExecutionException;

import request.Requests;

public class Devices extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceBundle){
        super.onCreate(savedInstanceBundle);
        setContentView(R.layout.activity_devices);

        final ToggleButton tb_relay1 = findViewById(R.id.toggleButton14);
        ToggleButton tb_relay2 = findViewById(R.id.toggleButton11);
        ToggleButton tb_relay3 = findViewById(R.id.toggleButton12);
        String status = "";
        try {
            status = new Requests().execute("GET").get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(status.equals("1")){
            tb_relay1.setChecked(true);
        }else if(status.equals("0")){
            tb_relay1.setChecked(false);
        }

        tb_relay1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int isChecked = 0;
                if(tb_relay1.isChecked()) {tb_relay1.setChecked(false);}else{tb_relay1.setChecked(true); isChecked = 1;}
                try {
                    new Requests().execute("POST", String.valueOf(isChecked)).get();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });










    }
}
