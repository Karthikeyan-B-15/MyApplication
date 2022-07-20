package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class FragB extends Fragment {
    private FragB.FragBlistener listener;
    private ShareView viewmodel;
    private Button fragbbtn;
    private EditText fragbtext;
    public interface FragBlistener{
        void onInputBsent(CharSequence input);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragb,container,false);
        fragbbtn=v.findViewById(R.id.fragbbtn);
        fragbtext=v.findViewById(R.id.fragbtext);
        fragbbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence input=fragbtext.getText();
                listener.onInputBsent(input);

            }
        });
        return v;
    }
    public void updateEditText(CharSequence newtext){
        fragbtext.setText(newtext);
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof FragB.FragBlistener){
            listener=(FragB.FragBlistener) context;
        }
        else{
            throw new RuntimeException(context.toString()+"implement fragblistener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener=null;
    }

}
