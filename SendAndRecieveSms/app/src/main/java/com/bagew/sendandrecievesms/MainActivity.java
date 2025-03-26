package com.bagew.sendandrecievesms;

import android.Manifest;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText phone,msg;
    Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        phone = findViewById(R.id.phoneno);
        msg=findViewById(R.id.msg);
        send=findViewById(R.id.send);
        if(ContextCompat.checkSelfPermission(this,Manifest.permission.SEND_SMS)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},1);
        }
        send.setOnClickListener(v->sendSms());
    }
    /*
    * private void sendSMS() {
        String phone = phoneNumber.getText().toString();
        String message = messageText.getText().toString();

        if (phone.isEmpty() || message.isEmpty()) {
            Toast.makeText(this, "Enter phone number and message", Toast.LENGTH_SHORT).show();
            return;
        }

        SmsManager smsManager = SmsManager.getDefault();
        Intent sentIntent = new Intent("SMS_SENT");
        PendingIntent sentPI = PendingIntent.getBroadcast(this, 0, sentIntent, PendingIntent.FLAG_IMMUTABLE);

        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Toast.makeText(context, "SMS Sent Successfully!", Toast.LENGTH_SHORT).show();
            }
        }, new IntentFilter("SMS_SENT"));

        smsManager.sendTextMessage(phone, null, message, sentPI, null);
    }
    * */
    private void sendSms(){
        String phoneno = phone.getText().toString();
        String text = msg.getText().toString();

        if(phoneno.isEmpty()||text.isEmpty()){
            Toast.makeText(this,"phoneNo or Msg is Empty.",Toast.LENGTH_SHORT).show();
            return;
        }
        SmsManager smsManager = SmsManager.getDefault();
        Intent sentIntent = new Intent("SMS_SENT");
        PendingIntent sentPi = PendingIntent.getBroadcast(this,0,sentIntent,PendingIntent.FLAG_IMMUTABLE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            registerReceiver(new BroadcastReceiver() {
                int resultcode = getResultCode();
                @Override
                public void onReceive(Context context, Intent intent) {
                    if(resultcode == RESULT_OK){
                        Toast.makeText(context,"Sms send Successfully!",Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(context,"Sms NOT send!",Toast.LENGTH_LONG).show();
                    }

                }
            },new IntentFilter("SMS_SENT"), Context.RECEIVER_EXPORTED);
            //send sms
            smsManager.sendTextMessage(phoneno,null,text,sentPi,null);
        }
    }
}