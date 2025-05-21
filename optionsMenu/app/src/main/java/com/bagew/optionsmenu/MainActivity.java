package com.bagew.optionsmenu;
import com.bagew.optionsmenu.R.id;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
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
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.item_settings) {
            Toast.makeText(this, "Settings option selected.", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (id == R.id.item_about) {
            Toast.makeText(this, "About option selected.", Toast.LENGTH_SHORT).show();
            return true;
        }
        if(id == R.id.item_exit){
            Toast.makeText(this, "Exit option selected.", Toast.LENGTH_SHORT).show();
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
//        switch (item.getItemId()) {
//            case R.id.item_settings:
//                Toast.makeText(this, "Settings option selected.", Toast.LENGTH_SHORT).show();
//                return true;
//            case R.id.item_about:
//                Toast.makeText(this, "About option selected.", Toast.LENGTH_SHORT).show();
//                return true;
//            case R.id.item_exit:
//
//            default:
//                return super.onOptionsItemSelected(item);
//        }
    }
}