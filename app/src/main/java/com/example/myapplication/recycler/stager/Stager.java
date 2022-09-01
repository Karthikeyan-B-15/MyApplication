package com.example.myapplication.recycler.stager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class Stager extends AppCompatActivity {
    StaggeredGridLayoutManager staggeredGridLayoutManager;
    List<StageModel> stagelist;
    RecyclerView recyclerView;
    StageAdapter stageAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stager);
        recyclerView=(RecyclerView) findViewById(R.id.stage);
        stagelist=new ArrayList<>();
//        stagelist.add(new StageModel(R.drawable.a));
        stagelist.add(new StageModel(R.drawable.b));
        stagelist.add(new StageModel(R.drawable.c));
        stagelist.add(new StageModel(R.drawable.d));
        stagelist.add(new StageModel(R.drawable.e));
        stagelist.add(new StageModel(R.drawable.f));
        stagelist.add(new StageModel(R.drawable.g));
        staggeredGridLayoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        stageAdapter=new StageAdapter(stagelist);
        recyclerView.setAdapter(stageAdapter);
        recyclerView.setHasFixedSize(true);
        ItemTouchHelper itemTouchHelper=new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }
    int deletedtask;
    ItemTouchHelper.SimpleCallback simpleCallback=new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            int position = viewHolder.getAbsoluteAdapterPosition();
            switch (direction) {
                case ItemTouchHelper.LEFT:
                    deletedtask = stagelist.get(position).getImg();
                    stagelist.remove(position);
                    stageAdapter.notifyItemRemoved(position);
                    Snackbar.make(recyclerView, deletedtask, Snackbar.LENGTH_LONG).setAction("UNDO", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            stagelist.add(position, new StageModel(deletedtask));
                            stageAdapter.notifyItemInserted(position);
                        }
                    }).show();
                    break;
                case ItemTouchHelper.RIGHT:
//                    deletedtask = stagelist.get(position).getImg();
//                    stagelist.remove(position);
//                    stageAdapter.notifyItemRemoved(position);
//                    Snackbar.make(recyclerView, deletedtask, Snackbar.LENGTH_LONG).setAction("UNDO", new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//                            stagelist.add(position, new StageModel(deletedtask));
//                            stageAdapter.notifyItemInserted(position);
//                        }
//                    }).show();
                    break;
            }
        }
    };
}