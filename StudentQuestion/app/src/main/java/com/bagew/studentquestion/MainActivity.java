package com.bagew.studentquestion;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etname,etDeleteid;
    Button btnadd,btnDelete,btnshow;
    ListView listView;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etname=findViewById(R.id.etname);
        etDeleteid=findViewById(R.id.etdeleteid);
        btnadd=findViewById(R.id.btnadd);
        btnDelete=findViewById(R.id.btndelete);
        btnshow=findViewById(R.id.btnshow);
        listView=findViewById(R.id.listview);
        dbHelper = new DBHelper(this);
        btnadd.setOnClickListener(v->{
            dbHelper.addStudent(etname.getText().toString());
            Toast.makeText(this,"studentadd",Toast.LENGTH_SHORT).show();
        });
        btnshow.setOnClickListener(v->showStudents());
        btnDelete.setOnClickListener(v->{
            dbHelper.deleteStudent(Integer.parseInt(etDeleteid.getText().toString()));
            Toast.makeText(this,"student delete",Toast.LENGTH_SHORT).show();
        });
    }
    private void showStudents(){
        Cursor cursor = dbHelper.getStudents();
        ArrayList<String> List = new ArrayList<>();
        while (cursor.moveToNext()){
            List.add(cursor.getInt(0)+"."+cursor.getString(1));
        }
        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1));
    }
}