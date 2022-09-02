package com.example.myapplication.adapters.tabadapt;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.myapplication.fragments.Fragments2;
import com.example.myapplication.fragments.Fragments3;
import com.example.myapplication.fragments.Frags;

public class TabAdapter extends FragmentStateAdapter {
    public TabAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:return new Frags();
            case 1:return new Fragments2();
            default:return new Fragments3();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
