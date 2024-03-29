package com.example.myapplication.mvvm.noteapp;

import android.app.Application;
import android.view.View;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.io.Closeable;
import java.util.List;

public class NoteViewModel extends AndroidViewModel {
    private NoteRepository repository;
    private LiveData<List<Note>>  allNotes;
    public NoteViewModel(Application application){
        super(application);
        repository=new NoteRepository(application);
        allNotes= repository.getAllNotes();
    }
    public void insert(Note note){
            repository.insert(note);
    }
    public LiveData<List<Note>> getAllNotes(){
        return allNotes;
    }
}
