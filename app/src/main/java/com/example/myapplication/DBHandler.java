package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHandler extends SQLiteOpenHelper {
    public static final String USER_TABLE = "USER_TABLE";
    public static final String USER_NAME = "USER_NAME";
    public static final String PHONE_NUMBER = "PHONE_NUMBER";
    public static final String PASS = "PASS";

    public DBHandler(@Nullable Context context) {
        super(context,"users.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
    String createTable= "CREATE TABLE " + USER_TABLE + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,"
            + USER_NAME + " TEXT," + PHONE_NUMBER + " TEXT," + PASS + " TEXT)";
    sqLiteDatabase.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void addData(RegisterModel registerModel){
        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(USER_NAME,registerModel.getUser());
        cv.put(PHONE_NUMBER,registerModel.getNumber());
        cv.put(PASS,registerModel.getPass());
        database.insert(USER_TABLE,null,cv);
        database.close();
    }
    public Boolean checkUser(String user){
        SQLiteDatabase database=this.getReadableDatabase();
        Cursor cursor=database.rawQuery("SELECT * FROM USER_TABLE WHERE USER_NAME=?", new String[]{user});
        if(cursor.getCount()>0){
            cursor.close();
            return true;
        }
        else {
            cursor.close();
            return false;
        }

    }
    public RegisterModel details(String user){
        SQLiteDatabase database=this.getReadableDatabase();
        Cursor cursor=database.rawQuery("SELECT * FROM USER_TABLE WHERE USER_NAME="+"'"+user+"'",null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        @SuppressLint("Range") RegisterModel registerModel=new RegisterModel(
                cursor.getInt(cursor.getColumnIndex("ID")),
                cursor.getString(cursor.getColumnIndex(USER_NAME)),
                cursor.getString(cursor.getColumnIndex(PHONE_NUMBER)),
                cursor.getString(cursor.getColumnIndex(PASS))
        );
        cursor.close();
        return registerModel;
    }

}
