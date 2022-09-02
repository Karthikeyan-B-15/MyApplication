package com.example.myapplication.fragments;

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

import com.example.myapplication.R;

public class FragA extends Fragment {
    private FragAlistener listener;
    private ShareView viewmodel;
    private Button fragabtn;
    private EditText fragatext;
    public interface FragAlistener{
        void onInputAsent(CharSequence input);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fraga,container,false);
        fragabtn=v.findViewById(R.id.fragabtn);
        fragatext=v.findViewById(R.id.fragatext);
        fragabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence input=fragatext.getText();
                listener.onInputAsent(input);
            }
        });
        return v;
    }
    public void updateEditText(CharSequence newtext){
        fragatext.setText(newtext);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof FragAlistener){
            listener=(FragAlistener) context;
        }
        else{
            throw new RuntimeException(context.toString()+"implement fragalistener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener=null;
    }
}
