package com.bagew.emailintent;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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
        Button button = findViewById(R.id.button);
        button.setOnClickListener(v -> {
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setType("message/rfc2822"); //MIME type for Email

            emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"bagewadi.prajwal44@gmail.com"});
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Test Email");
            emailIntent.putExtra(Intent.EXTRA_TEXT, "This is a test email");

            try{
                startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            }catch(android.content.ActivityNotFoundException ex){
                Toast.makeText(this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}