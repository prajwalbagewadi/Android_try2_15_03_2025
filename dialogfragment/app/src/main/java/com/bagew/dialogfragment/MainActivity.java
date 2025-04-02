package com.bagew.dialogfragment;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements MyDialogFragment.DialogListener {
    TextView tv;
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
        Button btn = findViewById(R.id.btn);
        tv = findViewById(R.id.Msg);
        btn.setOnClickListener(v->{
            MyDialogFragment dialog = new MyDialogFragment();
            dialog.show(getSupportFragmentManager(),"MyDialog");
        });

    }
    @Override
    public void onDialogResult(String result){
        tv.setText("Button pressed:"+result);
    }
}