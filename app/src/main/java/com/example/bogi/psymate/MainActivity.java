package com.example.bogi.psymate;


import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.bogi.psymate.utils.BottomNavigationHelper;

public class MainActivity extends AppCompatActivity implements ProfileFragment.OnFragmentInteractionListener, DiaryFragment.OnFragmentInteractionListener {

    private BottomNavigationView navigation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponent();

    }

    private void initComponent() {

        navigation = findViewById(R.id.navigation);
        BottomNavigationHelper.removeShiftMode(navigation);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame_layout, DiaryFragment.newInstance());
        ft.commit();
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                switch (item.getItemId()) {
                    case R.id.navigation_diary:
                        selectedFragment = DiaryFragment.newInstance();
                        break;
                    case R.id.navigation_chat:
                        //startActivity(new Intent(getApplicationContext(), ChatActivity.class));
                        return false;
                    case R.id.navigation_profile:
                        selectedFragment = ProfileFragment.newInstance();
                        break;
                }
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frame_layout, selectedFragment);
                ft.commit();
                return true;
            }
        });


    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}