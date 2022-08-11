package com.example.myapplication.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.Fragments2;
import com.example.myapplication.Fragments3;
import com.example.myapplication.Frags;
import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentGalleryBinding;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigationrail.NavigationRailView;

public class GalleryFragment extends Fragment {


    private FragmentGalleryBinding binding;
    FrameLayout frameLayout;
    NavigationRailView navigationRailView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
            frameLayout=binding.navfram2;
            navigationRailView=binding.navigationRailView;
        getParentFragmentManager().beginTransaction().replace(R.id.navfram2,new Frags()).commit();
        navigationRailView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navhome:
                        getParentFragmentManager().beginTransaction().replace(R.id.navfram2, new Frags()).commit();
                        break;
                    case R.id.navabout:
                        getParentFragmentManager().beginTransaction().replace(R.id.navfram2, new Fragments2()).commit();
                        break;
                    case R.id.navcontact:
                        getParentFragmentManager().beginTransaction().replace(R.id.navfram2, new Fragments3()).commit();
                        break;

                }
                return true;
            }
        });
//        final TextView textView = binding.textGallery;
//        galleryViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}