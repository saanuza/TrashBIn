package com.saanuza.trashbin;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private FragmentStateManager fragmentStateManager;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_trash_levels:
                    fragmentStateManager.changeFragment(0);
                    return true;
                case R.id.navigation_schedule:
                    fragmentStateManager.changeFragment(1);
                    return true;
                case R.id.navigation_notifications:
                    fragmentStateManager.changeFragment(2);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FrameLayout mMainFrame = findViewById(R.id.mainFrame);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        fragmentStateManager = new FragmentStateManager(mMainFrame, getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return new TrashLevelsFragment();
                    case 1:
                        return new ScheduleFragment();
                    case 2:
                        return new NotificationsFragment();
                }
                return null;
            }
        };

        fragmentStateManager.changeFragment(0);
    }

}
