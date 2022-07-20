package com.example.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class Frags extends Fragment {
    private int broad_text;

    BroadcastReceiver br=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            broad_text=intent.getIntExtra("intval",0);
            Log.i("demo","broadcast receiver"+ String.valueOf(intent.getIntExtra("intval",0)));
            Toast.makeText(context,"Broadcast received",Toast.LENGTH_LONG).show();
        }
    };
    private Button fragbr_btn;
    private TextView fragbr_text;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.samplefrag,container,false);
        fragbr_btn=v.findViewById(R.id.fragbr_btn);
        fragbr_text=v.findViewById(R.id.fragbr_text);
        fragbr_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragbr_text.setText(String.valueOf(broad_text));
            }
        });
        return v;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.i("frag","onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("frag","onCreate");

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i("frag","onViewCreate");
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.i("frag","onViewStateRestored");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("frag","onStart");
        IntentFilter filter = new IntentFilter();
        filter.addAction("com.myapp.broad_cast_receiver");
//        LocalBroadcastManager lb=LocalBroadcastManager.getInstance();
        getActivity().registerReceiver(br,filter);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("frag","onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("frag","onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("frag","onstop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("frag","ondestroyView");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("frag","onDetach");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("frag","ondestroy");
    }

}
