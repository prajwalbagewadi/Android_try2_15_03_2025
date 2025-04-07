package com.bagew.sqlitedbcurdoperations;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
//Step 1 Create database Helper
public class MyDatabaseHelper extends SQLiteOpenHelper {
    public MyDatabaseHelper(Context context){
        super(context,"ClassDB.db",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("Create Table classes (id integer primary key autoincrement,name varchar(20),class varchar(20))");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
        db.execSQL("drop table if exists classes");
        onCreate(db);
    }
}
