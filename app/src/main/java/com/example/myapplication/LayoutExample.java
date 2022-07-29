package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.PictureInPictureParams;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

public class LayoutExample extends AppCompatActivity {
    Button snackbtn,dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_example);
        snackbtn=(Button) findViewById(R.id.snackbtn);
        dialog=(Button)findViewById(R.id.dialog);
        snackbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view,"Message deleted",Snackbar.LENGTH_LONG)
                        .setAction("Undo", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Snackbar.make(view,"Message recovered",Snackbar.LENGTH_LONG).show();
                            }
                        }).show();
            }
        });
        dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });

    }
    public void openDialog(){
        Dialog dialogOpen=new Dialog();
        dialogOpen.show(getSupportFragmentManager(),"open");
    }
    @Override
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        PictureInPictureParams pictureInPictureParams= null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            pictureInPictureParams = new PictureInPictureParams.Builder().build();
            enterPictureInPictureMode(pictureInPictureParams);
        }

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
    }
}