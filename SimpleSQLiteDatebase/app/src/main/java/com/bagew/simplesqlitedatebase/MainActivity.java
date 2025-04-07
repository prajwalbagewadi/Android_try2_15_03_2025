package com.bagew.simplesqlitedatebase;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

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
        // Step 2: Access Database in Activity
        MyDatabaseHelper dbHelper = new MyDatabaseHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        //Step 3: Insert Data
        ContentValues values = new ContentValues();
        values.put("name", "Prajwal");
        values.put("marks", 99);
        db.insert("Students", null, values);

        //Step 4: Query Data
        //db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM students",null);
        while (cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
            String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
            int marks = cursor.getInt(cursor.getColumnIndexOrThrow("marks"));
            //System.out.println("ID: " + id + " Name: " + name + " Marks: " + marks);
            TextView textView = findViewById(R.id.output);
            textView.setText("Result:"+"ID: " + id + " Name: " + name + " Marks: " + marks);
        }

        //Step 5: Close Database
        //db.close();
    }
}