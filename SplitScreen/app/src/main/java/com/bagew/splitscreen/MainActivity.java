package com.bagew.splitscreen;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(v -> {
            Intent intent = new Intent(this, Main2Activity.class);
            //Split mode code line:
            intent.addFlags(Intent.FLAG_ACTIVITY_LAUNCH_ADJACENT| Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        });
    }
    @Override
    protected void onResume(){
        super.onResume();
        if(isInMultiWindowMode()){
            Toast.makeText(this, "Running in split Screen mode.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Running in fullscreen mode.", Toast.LENGTH_SHORT).show();
        }

    }
}