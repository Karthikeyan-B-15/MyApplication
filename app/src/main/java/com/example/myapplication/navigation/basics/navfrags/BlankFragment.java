package com.example.myapplication.navigation.basics.navfrags;

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
import android.widget.TextView;

import com.example.myapplication.navigation.basics.DBHandler;
import com.example.myapplication.R;
import com.example.myapplication.navigation.basics.RegisterModel;


public class BlankFragment extends Fragment {
TextView ltext;
Button navlog,navreg;
EditText loguser,logpass;
DBHandler dbHandler;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }
;;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navlog=view.findViewById(R.id.navlog);
        navreg=view.findViewById(R.id.navreg);
        logpass=view.findViewById(R.id.logpass);
        loguser=view.findViewById(R.id.loguser);
        ltext=view.findViewById(R.id.ltext);
        NavController navController= Navigation.findNavController(view);
        navreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_blankFragment_to_regFrag);

            }
        });
        navlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHandler=new DBHandler(getContext());
                if(dbHandler.checkUser(loguser.getText().toString())) {
                    RegisterModel registerModel=dbHandler.details(loguser.getText().toString());
                    Bundle bundle=new Bundle();
                    bundle.putString("user",registerModel.getUser());
                    bundle.putString("phone",registerModel.getNumber());
                    navController.navigate(R.id.action_blankFragment_to_homeFrag,bundle);

                }
                else{
                    ltext.setText("This account does not exist !!");
                }
            }
        });

    }
}