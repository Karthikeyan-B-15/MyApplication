package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

public class FragMain extends AppCompatActivity {
    private Button button2,pop,remove;
    FrameLayout frame;
    FragmentManager fragmentManager;
    TextView content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag_main);
        button2=(Button) findViewById(R.id.button2);
        frame=(FrameLayout)findViewById(R.id.fragcontainer);
        pop=(Button)findViewById(R.id.pop);
        remove=(Button)findViewById(R.id.remove);
        fragmentManager=getSupportFragmentManager();
        content=(TextView)findViewById(R.id.content);
        content.setText("Stack count :"+fragmentManager.getBackStackEntryCount());
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment=fragmentManager.findFragmentById(R.id.fragcontainer);
                if(fragment!=null) {
                    fragmentManager.beginTransaction().remove(fragment).commit();
                }
            }
        });
        pop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager.popBackStack(0,0);
            }
        });
        fragmentManager.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                content.setText("Stack count :"+fragmentManager.getBackStackEntryCount());

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addFragment();
            }


        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("main","onStart");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("main","onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("main","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("main","onPause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("main","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("main","onDestroy");
    }
    public void addFragment(){
        Fragment fragments;
//        switch (fragmentManager.getBackStackEntryCount()){
//            case 0:fragments=new Frags();break;
//            case 1:fragments=new Fragments2();break;
//            case 2:fragments=new Fragments3();break;
//            default:fragments=new Frags();break;
//
//
//        }

        fragments=fragmentManager.findFragmentById(R.id.fragcontainer);
        if(fragments instanceof Frags){
            fragments=new Fragments2();
        }
        else if(fragments instanceof Fragments2){
            fragments=new Fragments3();
        }
        else{
            fragments= new Frags();
        }
        String backStackName=fragments.getClass().getName();
        boolean fragmentpop=fragmentManager.popBackStackImmediate(backStackName,0);
        if(!fragmentpop) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragcontainer, fragments);
            fragmentTransaction.addToBackStack(backStackName);
            fragmentTransaction.commit();
        }
    }

//    @Override
//    public void onBackPressed() {
//        FragmentManager fragmentManager1=getSupportFragmentManager()
//        Fragment fragment = fragmentManager.findFragmentById(R.id.fragcontainer);
//        if (fragment != null) {
//            fragmentManager.beginTransaction().remove(fragment).commit();
//        } else {
//            super.onBackPressed();
//        }
//    }
}
