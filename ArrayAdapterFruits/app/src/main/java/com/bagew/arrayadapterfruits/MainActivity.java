package com.bagew.arrayadapterfruits;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Step 1: Find ListView by ID
        ListView lv = findViewById(R.id.listview);
        // Step 2: Create a list of fruits
        String[] fruits={"Apple", "Banana", "Mango", "Orange", "Pineapple", "Grapes"};
        // Step 3: Use ArrayAdapter to bind data
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,fruits);
        lv.setAdapter(adapter);
    }
}