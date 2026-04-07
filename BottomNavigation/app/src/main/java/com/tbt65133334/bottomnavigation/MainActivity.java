package com.tbt65133334.bottomnavigation;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private ActionBar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = getSupportActionBar();

        BottomNavigationView navigation = findViewById(R.id.navigation);

        navigation.setOnItemSelectedListener(mOnItemSelectedListener);

        if (toolbar != null) {
            toolbar.setTitle("Shop");
        }
    }

    private NavigationBarView.OnItemSelectedListener mOnItemSelectedListener
            = new NavigationBarView.OnItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            int itemId = item.getItemId();

            if (itemId == R.id.navigation_shop) {
                if (toolbar != null) toolbar.setTitle("Shop");
                return true;
            } else if (itemId == R.id.navigation_gifts) {
                if (toolbar != null) toolbar.setTitle("My Gifts");
                return true;
            } else if (itemId == R.id.navigation_cart) {
                if (toolbar != null) toolbar.setTitle("Cart");
                return true;
            } else if (itemId == R.id.navigation_profile) {
                if (toolbar != null) toolbar.setTitle("Profile");
                return true;
            }
            return false;
        }
    };
}