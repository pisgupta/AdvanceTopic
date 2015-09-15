package com.example.pankaj.broadcastreceivertest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Pankaj on 9/7/2015.
 */
public class MyReceriver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Receiver Call",Toast.LENGTH_SHORT).show();

    }
}
