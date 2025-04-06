package com.bagew.contextmenu;

import android.content.Context;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
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
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
        TextView tv = findViewById(R.id.textContext);
        registerForContextMenu(tv);
    }
    @Override
    public void onCreateContextMenu(ContextMenu contextMenu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(contextMenu,v,menuInfo);
        getMenuInflater().inflate(R.menu.context_main,contextMenu);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item){
       int id = item.getItemId();
       if(id==R.id.item_copy){
           Toast.makeText(this, "copy clicked", Toast.LENGTH_SHORT).show();
           return true;
       }
        if(id==R.id.item_cut){
            Toast.makeText(this, "cut clicked", Toast.LENGTH_SHORT).show();
            return true;
        }
        if(id==R.id.item_paste){
            Toast.makeText(this, "paste clicked", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onContextItemSelected(item);
    }
}