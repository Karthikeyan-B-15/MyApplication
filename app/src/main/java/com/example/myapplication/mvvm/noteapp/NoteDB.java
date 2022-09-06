package com.example.myapplication.mvvm.noteapp;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Note.class},version = 1)
public abstract class NoteDB extends RoomDatabase {
    private static NoteDB instance;
    public abstract NoteDao noteDao();

    public static synchronized NoteDB getInstance(Context context){
        if(instance==null){
            instance= Room.databaseBuilder(context.getApplicationContext(),
                    NoteDB.class,"note_db")
                    .fallbackToDestructiveMigration()

                    .build();
        }
        return instance;
    }
//    private static RoomDatabase.Callback roomcallback=new Callback() {
//        @Override
//        public void onCreate(@NonNull SupportSQLiteDatabase db) {
//            super.onCreate(db);
//            new PopulateDb(instance).execute();
//
//
//        }
//    };
//    private static class PopulateDb extends AsyncTask<Void, Void, Void> {
//        private NoteDao noteDao;
//        public PopulateDb(NoteDB db){
//            noteDao=db.noteDao();
//        }
//        @Override
//        protected Void doInBackground(Void... voids) {
//            noteDao.insert(new Note("Home","this is home"));
//            return null;
//        }
//
//
//    }
}
