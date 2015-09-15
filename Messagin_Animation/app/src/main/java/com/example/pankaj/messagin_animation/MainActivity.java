package com.example.pankaj.messagin_animation;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity {
EditText edtnumber,edtmsg;
    Button btnsend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnsend = (Button)findViewById(R.id.btnsend);
        edtnumber = (EditText)findViewById(R.id.number);
        edtmsg = (EditText)findViewById(R.id.message);

        btnsend.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                SmsManager manager = SmsManager.getDefault();
                manager.sendTextMessage(edtnumber.getText().toString().trim(),null,edtmsg.getText().toString().trim(),null,null);
            }
        });
    }

}
