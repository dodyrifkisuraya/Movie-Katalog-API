package com.dorizu.ms3;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigationView = findViewById(R.id.navigasi);
        navigationView.setOnNavigationItemSelectedListener(saatNavigasiDiKlik);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES); //mode malam

        if (savedInstanceState == null){
            navigationView.setSelectedItemId(R.id.nav_movie);
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener saatNavigasiDiKlik
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment fragment;

            switch (menuItem.getItemId()) {
                case R.id.nav_movie:
                    fragment = new MovieFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container_main, fragment, fragment.getClass().getSimpleName())
                            .commit();
                    return true;
                case R.id.nav_tv:
                    fragment = new TvShowFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container_main, fragment, fragment.getClass().getSimpleName())
                            .commit();
                    return true;
                case R.id.nav_setting:
                    fragment = new SettingFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container_main, fragment, fragment.getClass().getSimpleName())
                            .commit();
                    return true;
            }
            return false;
        }
    };
}
