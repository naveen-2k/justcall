package com.example.myemergentapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.provider.Settings;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        if(isairplaneon(context.getApplicationContext()))
        Toast.makeText(context, "airplane mode on", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(context, "airplane mode off", Toast.LENGTH_SHORT).show();
    }
    private static  boolean isairplaneon(Context c)
    {
        return Settings.System.getInt(c.getContentResolver(),Settings.Global.AIRPLANE_MODE_ON,0)!=0;
    }
}