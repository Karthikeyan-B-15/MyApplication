package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class RegFrag extends Fragment {

    EditText user,phone,pass;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reg, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button onreg=view.findViewById(R.id.onreg);
       user=view.findViewById(R.id.user);
       phone=view.findViewById(R.id.phone);
       pass=view.findViewById(R.id.pass);
        NavController navController= Navigation.findNavController(view);
        onreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegisterModel registerModel=new RegisterModel(
                        -1,user.getText().toString(),phone.getText().toString(),pass.getText().toString()
                );
                DBHandler dbHandler=new DBHandler(getContext());
                dbHandler.addData(registerModel);
                navController.navigate(R.id.action_regFrag_to_blankFragment);
            }
        });
    }
}