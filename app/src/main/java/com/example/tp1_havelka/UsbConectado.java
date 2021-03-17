package com.example.tp1_havelka;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

public class UsbConectado extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String a = intent.getAction();
        boolean cargando = (a.equals(Intent.ACTION_POWER_CONNECTED));
        //a
        if(cargando){
            Toast.makeText(context,"  Llamando.", Toast.LENGTH_LONG).show();
            
            Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "2664677284"));

            context.startActivity(i);
        }else{
            Toast.makeText(context," USB Desconectado ", Toast.LENGTH_LONG).show();

        }
    }
}
