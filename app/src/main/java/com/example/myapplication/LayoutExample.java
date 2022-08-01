package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.PictureInPictureParams;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.text.DateFormat;
import java.util.Calendar;

public class LayoutExample extends AppCompatActivity implements CustomDialog.customDialogListener, DatePickerDialog.OnDateSetListener{
    Button snackbtn,dialog,customDialog,date;
    private TextView dialogin,datetext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_example);
        snackbtn=(Button) findViewById(R.id.snackbtn);
        dialog=(Button)findViewById(R.id.dialog);
        customDialog=(Button)findViewById(R.id.custom);
        dialogin=(TextView)findViewById(R.id.dilogin);
        datetext=(TextView)findViewById(R.id.datetext);
        date=(Button)findViewById(R.id.date);
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
        customDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCustomDialog();
            }
        });
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDate();
            }
        });

    }

    @Override
    public void setUser(String user) {
        dialogin.setText("Welcome"+" "+user);
    }

    public void openDialog(){
        Dialog dialogOpen=new Dialog();
        dialogOpen.show(getSupportFragmentManager(),"open");
    }
    public void openCustomDialog(){
        CustomDialog customDialog=new CustomDialog();
        customDialog.show(getSupportFragmentManager(),"custoOpen");
    }
    public void openDate(){
        com.example.myapplication.DatePicker datePicker=new com.example.myapplication.DatePicker();
        datePicker.show(getSupportFragmentManager(),"date");
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        Calendar calendar=Calendar.getInstance();
        calendar.set(Calendar.YEAR,i);
        calendar.set(Calendar.MONTH,i1);
        calendar.set(Calendar.DAY_OF_MONTH,i2);
        String dates= DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        datetext.setText(dates);

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