package com.example.tp1_havelka;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import static android.Manifest.permission.CALL_PHONE;

public class MainActivity extends AppCompatActivity {

    private IntentFilter usbIntentFilter;
    private UsbConectado usbConectado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if ((Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(CALL_PHONE) != PackageManager.PERMISSION_GRANTED)){
            requestPermissions(new String[]{CALL_PHONE}, 1000);
        }
        usbIntentFilter = new IntentFilter();
        usbIntentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
        usbIntentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);

    }

    @Override
    protected void onResume() {
        super.onResume();
        usbConectado = new UsbConectado();
        registerReceiver(usbConectado, usbIntentFilter);
    }

    protected  void  onPause(){
        super.onPause();
        unregisterReceiver(usbConectado);
    }
}