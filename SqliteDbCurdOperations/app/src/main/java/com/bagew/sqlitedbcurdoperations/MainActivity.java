package com.bagew.sqlitedbcurdoperations;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.content.ContentValues;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
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

        //Step 2 Access created database
        MyDatabaseHelper dbHelper = new MyDatabaseHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        EditText user = findViewById(R.id.username);
        EditText class1 = findViewById(R.id.classname);

        //Step 3 Insert data into database
        Button insert = findViewById(R.id.insertBtn);
        insert.setOnClickListener(v->{
            ContentValues values = new ContentValues();
            values.put("name",user.getText().toString());
            values.put("class",class1.getText().toString());
            db.insert("classes",null,values);
            user.setText("");
            class1.setText("");
            Toast.makeText(this, "Inserted", Toast.LENGTH_SHORT).show();
            //db.close();
        });

        //Step 4 Update data in database
        Button update = findViewById(R.id.updateBtn);
        update.setOnClickListener(v->{
            ContentValues values = new ContentValues();
            values.put("class",class1.getText().toString());
            db.update("classes",values,"name = ?",new String[] {user.getText().toString()});
            Toast.makeText(this, "Updated", Toast.LENGTH_SHORT).show();
        });

        //Step 5 Delete data from database
        Button delete = findViewById(R.id.deleteBtn);
        delete.setOnClickListener(v->{
            String name = user.getText().toString();
            db.delete("classes","name = ?",new String[] {name});
            user.setText("");
            class1.setText("");
            Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show();
        });

        //Step 6 View Records from database
        Button show = findViewById(R.id.showBtn);
        show.setOnClickListener(v->{
            StringBuilder sb = new StringBuilder();
            Cursor cursor =   db.rawQuery("select * from classes",null);
            if(cursor.moveToFirst()){
                do{
                    int id = cursor.getInt(0);
                    String name = cursor.getString(1);
                    String clas = cursor.getString(2);
                    sb.append("ID:").append(id)
                            .append(" Name:").append(name)
                            .append(" Class:").append(clas).append("\n");
                }while(cursor.moveToNext());
            } else {
                sb.append("No records found.");
            }
            cursor.close();
            TextView output = findViewById(R.id.output);
            output.setText(sb.toString());
            Toast.makeText(this, "View Records", Toast.LENGTH_SHORT).show();
        });

        //Step 7 Close database
        //db.close();
    }
}