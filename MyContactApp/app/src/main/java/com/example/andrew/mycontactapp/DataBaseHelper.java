package com.example.andrew.mycontactapp;

import android.app.ActionBar;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Andrew on 5/11/2017.
 */

public class DataBaseHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME="Contact.db";
    public static final String TABLE_NAME="contact_table";
    public static final String COL_1="ID";
    public static final String COL_2="NAME";
    public static final String COL_3="ADDRESS";
    public static final String COL_4="PHONENUMBER";

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE "+ TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, PHONENUMBER TEXT, ADDRESS TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS"+ TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String name,String address, String phone){
        SQLiteDatabase db= this.getReadableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,address);
        contentValues.put(COL_4,phone);

        long result=db.insert(TABLE_NAME,null,contentValues);
        if(result==-1) return false;
        else return true;
    }

    public Cursor getAllData(){
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME, null);
        return res;
    }


}
