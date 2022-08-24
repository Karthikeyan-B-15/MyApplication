package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    public static final String ID = "ID";
    public static final String API_TABLE = "API_TABLE";
    public static final String EMAIL = "EMAIL";
    public static final String FIRST_NAME= "FIRST_NAME";
    public static final String LAST_NAME = "LAST_NAME";
    public static final String AVATAR = "AVATAR";

    public DBHelper(@Nullable Context context) {
        super(context, "api.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTable= "CREATE TABLE " + API_TABLE + "(" + ID + " INTEGER,"
                + EMAIL + " TEXT," + FIRST_NAME + " TEXT," + LAST_NAME + " TEXT," + AVATAR + " TEXT)";
        sqLiteDatabase.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void addData(AsyncModel asyncModel){
        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(ID,asyncModel.getId());
        cv.put(EMAIL,asyncModel.getEmail());
        cv.put(FIRST_NAME,asyncModel.getFirstName());
        cv.put(LAST_NAME,asyncModel.getLastName());
        cv.put(AVATAR,asyncModel.getImgurl());
        database.insert(API_TABLE,null,cv);
    }
    public List<AsyncModel> getAllData(){
        List<AsyncModel> alist = new ArrayList<AsyncModel>();
        SQLiteDatabase database=this.getReadableDatabase();
        Cursor cursor=database.rawQuery("SELECT * FROM API_TABLE",null);
        if(cursor.moveToFirst()){
            do{
            AsyncModel asyncModel=new AsyncModel(cursor.getString(2),
                    cursor.getString(3),cursor.getString(1),cursor.getString(4)
                    );
        alist.add(asyncModel);
            }while (cursor.moveToNext());
        }
        return alist;
    }

}
