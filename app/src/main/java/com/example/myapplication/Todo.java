package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator;

public class Todo extends AppCompatActivity {
    TodoAdapter todoAdapter;
    List<TodoModel> todolist;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    EditText text;
    Button todobtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);
        recyclerView=(RecyclerView) findViewById(R.id.retodo);
        text=(EditText)findViewById(R.id.totext);
        todobtn=(Button)findViewById(R.id.todobtn);

        todolist=new ArrayList<>();
        todolist.add(new TodoModel("Comple the all task"));
        todolist.add(new TodoModel("Comple the all task"));
        todobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                todolist.add(1,new TodoModel(text.getText().toString()));
                todoAdapter.notifyItemInserted(1);
//                todolist.add(new TodoModel(text.getText().toString()));
//                todoAdapter.notifyDataSetChanged();

            }
        });

        layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        todoAdapter=new TodoAdapter(todolist);
        recyclerView.setAdapter(todoAdapter);
        ItemTouchHelper itemTouchHelper=new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }
    String deletedtask=null;
    final ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            int position = viewHolder.getAbsoluteAdapterPosition();
            switch (direction) {
                case ItemTouchHelper.LEFT:
                    deletedtask = todolist.get(position).getTask();
                    todolist.remove(position);
                    todoAdapter.notifyItemRemoved(position);
                    Snackbar.make(recyclerView, deletedtask, Snackbar.LENGTH_LONG).setAction("UNDO", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            todolist.add(position, new TodoModel(deletedtask));
                            todoAdapter.notifyItemInserted(position);
                        }
                    }).show();
                    break;
                case ItemTouchHelper.RIGHT:
                    break;
            }
        }

        @Override
        public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
            new RecyclerViewSwipeDecorator.Builder(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
                    .addSwipeLeftBackgroundColor(ContextCompat.getColor(Todo.this, R.color.purple_500))
                    .addSwipeLeftActionIcon(R.drawable.ic_baseline_delete_24)
                    .create()
                    .decorate();
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        }
    };
}