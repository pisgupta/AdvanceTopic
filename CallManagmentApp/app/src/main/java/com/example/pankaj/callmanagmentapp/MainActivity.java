package com.example.pankaj.callmanagmentapp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
TelephonyManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = (TelephonyManager)getSystemService(TELEPHONY_SERVICE);
        manager.listen(listener,PhoneStateListener.LISTEN_CALL_STATE);
    }
PhoneStateListener listener = new PhoneStateListener(){
    @Override
    public void onCallStateChanged(int state, String incomingNumber) {
        switch (state){
            case TelephonyManager.CALL_STATE_IDLE:
                Toast.makeText(MainActivity.this,"IDLE",Toast.LENGTH_SHORT).show();
                break;
            case TelephonyManager.CALL_STATE_OFFHOOK:
                Toast.makeText(MainActivity.this,"OFFHOOK",Toast.LENGTH_SHORT).show();
                break;
            case TelephonyManager.CALL_STATE_RINGING:
                Toast.makeText(MainActivity.this,"RINGING",Toast.LENGTH_SHORT).show();
                break;
        }
    }
};
}
