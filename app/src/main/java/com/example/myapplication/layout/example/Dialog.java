package com.example.myapplication.layout.example;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.example.myapplication.R;

import java.util.ArrayList;

public class Dialog extends DialogFragment {


    @NonNull
    @Override
    public android.app.Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);
       ArrayList selectedItems=new ArrayList<>();
        String[] customer=getActivity().getResources().getStringArray(R.array.customer);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
           builder.setTitle("Warning");
        builder .setMultiChoiceItems(customer,null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i,boolean isChecked) {
                        if(isChecked){
                            selectedItems.add(i);
                        }else if(selectedItems.contains(i)){
                            selectedItems.remove(i);
                        }

                    }
                })
                .setPositiveButton("Start", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // START THE GAME!
                    }
                })
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
        // Create the AlertDialog object and return it
        AlertDialog dialog=builder.create();
        dialog.show();
        return dialog;
    }
}
