package com.example.myapplication.mvvm.noteapp;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NoteRepository {
    private NoteDao noteDao;
    private LiveData<List<Note>> allNotes;
    ExecutorService executor= Executors.newSingleThreadExecutor();

    public NoteRepository(Application application){
        NoteDB db=NoteDB.getInstance(application);
        noteDao=db.noteDao();
        allNotes=noteDao.getAllNotes();

    }
    public void insert(Note note){
       executor.execute(new Runnable() {
           @Override
           public void run() {
               noteDao.insert(note);
           }
       });

    }
    public void update(Note note){

    }
    public void delete(Note note){

    }
    public void deleteAllNotes(){

    }
    public LiveData<List<Note>> getAllNotes(){
        return allNotes;
    }
}
