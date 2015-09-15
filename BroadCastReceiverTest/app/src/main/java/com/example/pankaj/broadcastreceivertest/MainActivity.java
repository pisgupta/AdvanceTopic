package com.example.pankaj.broadcastreceivertest;

import android.app.Activity;
import android.content.IntentFilter;
import android.os.Bundle;


public class MainActivity extends Activity {
    MyReceriver receriver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        receriver = new MyReceriver();
    }
    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
       intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
        registerReceiver(receriver, intentFilter);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receriver);
    }
}
