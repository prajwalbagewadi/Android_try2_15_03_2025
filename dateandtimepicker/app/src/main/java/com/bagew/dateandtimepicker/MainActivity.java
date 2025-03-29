package com.bagew.dateandtimepicker;

import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
        TimePicker tp = findViewById(R.id.time);
        DatePicker dp = findViewById(R.id.date);
        TextView output1 = findViewById(R.id.output1);
        TextView output2 = findViewById(R.id.output2);
        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(v -> {
            output1.setText(tp.getHour() + ":" + tp.getMinute());
            output2.setText(dp.getDayOfMonth() + "/" + dp.getMonth() + "/" + dp.getYear());
        });
    }
}