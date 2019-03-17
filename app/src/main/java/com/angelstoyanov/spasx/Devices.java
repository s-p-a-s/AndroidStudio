package com.angelstoyanov.spasx;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

import java.util.concurrent.ExecutionException;

import request.Requests;

public class Devices extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceBundle) {
        super.onCreate(savedInstanceBundle);
        setContentView(R.layout.activity_devices);
        Switch switch1 = findViewById(R.id.switch1);


        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isChecked = false;
                if (isChecked = true) {
                    try {
                        new Requests().execute("POST", "1").get();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    isChecked = false;
                } else if (isChecked) {
                    try {
                        new Requests().execute("GET").get();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });

    }

}