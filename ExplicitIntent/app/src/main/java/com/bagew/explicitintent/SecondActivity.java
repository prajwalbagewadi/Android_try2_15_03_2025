package com.bagew.explicitintent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        String msg = getIntent().getStringExtra("msg");
        EditText etxt = findViewById(R.id.editText);
        etxt.setText(msg);
        Log.d("lifeCycle", "SecondActivity onCreate()");
    }
}
