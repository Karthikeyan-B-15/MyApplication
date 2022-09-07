package com.example.myapplication.mvvm.noteapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityNoteBinding;

import java.util.List;

public class NoteActivity extends AppCompatActivity {
    NoteViewModel noteViewModel;
    private ActivityNoteBinding binding;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityNoteBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);
        noteViewModel= new ViewModelProvider(this).get(NoteViewModel.class);

        recyclerView=binding.nrecycle;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final NoteAdapter adapter=new NoteAdapter();
        recyclerView.setAdapter(adapter);

        noteViewModel.insert(new Note("Home","This is Home"));
        noteViewModel.getAllNotes().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {

            adapter.setNotes(notes);
            }
        });
        binding.addnote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(NoteActivity.this,CreateNote.class);
                startActivity(intent);
            }
        });

    }
}