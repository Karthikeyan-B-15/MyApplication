package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.PictureInPictureParams;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.PopupMenu;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.text.DateFormat;
import java.util.Calendar;

public class LayoutExample extends AppCompatActivity implements CustomDialog.customDialogListener,
        DatePickerDialog.OnDateSetListener, PopupMenu.OnMenuItemClickListener {
    Button snackbtn,dialog,customDialog,date,popup;
    private TextView dialogin,datetext,context;
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
        popup=(Button)findViewById(R.id.popup);
        context=(TextView)findViewById(R.id.context);
        registerForContextMenu(context);
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
        popup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopup(view);
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
    public void showPopup(View v){
        PopupMenu popupMenu=new PopupMenu(this,v);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.inflate(R.menu.popmenu);
        popupMenu.show();

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
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.custommenu,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(this,"Item1 is selected",Toast.LENGTH_LONG).show();
                return true;
            case R.id.item2:
                Toast.makeText(this,"Item2 is selected",Toast.LENGTH_LONG).show();
                return true;
            default:
        }
        return super.onOptionsItemSelected(item);

        }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.popmenu,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.pitem1:
                Toast.makeText(this,"context item 1 is selecteed",Toast.LENGTH_LONG).show();
                return true;
            case R.id.pitem2:
                Toast.makeText(this,"context item 2 is selecteed",Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }

    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.pitem1:
                Toast.makeText(this,"Item1 is poped",Toast.LENGTH_LONG).show();
                return true;
            case R.id.pitem2:
                Toast.makeText(this,"Item2 is poped",Toast.LENGTH_LONG).show();
                return true;
            case R.id.pitem3:
                Toast.makeText(this,"Item3 is poped",Toast.LENGTH_LONG).show();
                return true;
            default:
        }
        return false;
    }
}