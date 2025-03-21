package com.example.sqlitedb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static  final String DATABASE_NAME="students.db";
    public static  final String TABLE_NAME="s1_table";
    public static  final String COL_1="ID";
    public static  final String COL_2="NAME";
    public static  final String COL_3="SURNAME";
    public static  final String COL_4="MARKS";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,SURNAME TEXT,MARKS INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE if EXISTS " + TABLE_NAME);
        onCreate(db);

    }
    public boolean insertData(String name,String surname,String marks)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, surname);
        contentValues.put(COL_4, marks);
        long result=db.insert(TABLE_NAME,null ,contentValues);

        if(result==-1)
            return false;
        else
            return true;
    }
    public Cursor getData()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res=db.rawQuery("Select * from " +TABLE_NAME,null);
        return res;
    }
    public boolean updateData(String id, String name, String surname, String marks)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(COL_1, id);
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, surname);
        contentValues.put(COL_4, marks);
        db.update(TABLE_NAME,contentValues," id = ? ",new String[] {id});
        return false;
    }
    public int delData(String id)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        return db.delete(TABLE_NAME," id = ? ",new String[] {id});
    }
}
