package com.example.myapplication.adapters.tabadapt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.myapplication.Fragments2;
import com.example.myapplication.Fragments3;
import com.example.myapplication.Frags;
import com.example.myapplication.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class Tabs extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    ViewPager2 viewPager2;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs);
        drawerLayout = findViewById(R.id.drawerlayout);
        NavigationView  navigationView=(NavigationView)findViewById(R.id.nav);
        BottomNavigationView bottomNavigationView=(BottomNavigationView)findViewById(R.id.bottomnav);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        viewPager2=findViewById(R.id.pager3);
        tabLayout=findViewById(R.id.tabs);
        TabAdapter tabAdapter=new TabAdapter(this);
        viewPager2.setAdapter(tabAdapter);
        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText("Tab"+(position+1));

            }
        }).attach();
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.navfram,new Frags()).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navhome:
                        getSupportFragmentManager().beginTransaction().replace(R.id.navfram, new Frags()).commit();
                        break;
                    case R.id.navabout:
                        getSupportFragmentManager().beginTransaction().replace(R.id.navfram, new Fragments2()).commit();
                        break;
                    case R.id.navcontact:
                        getSupportFragmentManager().beginTransaction().replace(R.id.navfram, new Fragments3()).commit();
                        break;

                }return true;
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.navhome:
                getSupportFragmentManager().beginTransaction().replace(R.id.navfram,new Frags()).commit();
                break;
            case R.id.navabout:
                getSupportFragmentManager().beginTransaction().replace(R.id.navfram,new Fragments2()).commit();
                break;
            case R.id.navcontact:
                getSupportFragmentManager().beginTransaction().replace(R.id.navfram,new Fragments3()).commit();
                break;


        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}