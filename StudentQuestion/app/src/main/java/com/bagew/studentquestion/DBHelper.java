package com.bagew.studentquestion;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper{
    public DBHelper(Context content){
        super(content,"StudentDB",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("Create table students(id int primary key AUTOINCREMENT,name Text)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
        db.execSQL("Drop table if Exists students");
        onCreate(db);
    }
    public void addStudent(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name",name);
        db.insert("students",null,values);
    }
    public Cursor getStudents(){
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("select * FROM students",null);
    }
    public void deleteStudent(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("students","id?",new String[]{String.valueOf(id)});
    }
}
