package com.example.pankaj.messagin_animation;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Pankaj on 9/8/2015.
 */
public class MessageReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bd = intent.getExtras();
        try {
            if(bd != null) {
                Object[] pdusdata = (Object[])bd.get("pdus");
                for(int i=0;i<pdusdata.length;i++){
                    SmsMessage smsMessage = SmsMessage.createFromPdu((byte[])pdusdata[i]);
                    String msg = smsMessage.getDisplayMessageBody();
                    String phoneno = smsMessage.getDisplayOriginatingAddress();
                    Toast.makeText(context,msg+"   "+phoneno,Toast.LENGTH_SHORT).show();
                }
            }
        } catch (Exception ex) {
            Log.e("Message Exception", ex.toString());
        }
    }
}
