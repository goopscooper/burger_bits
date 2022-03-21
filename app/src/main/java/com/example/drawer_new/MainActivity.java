package com.example.drawer_new;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MaterialToolbar toolbar = findViewById(R.id.topAppBar);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.navigation_view);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                drawerLayout.openDrawer(GravityCompat.START);

            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @org.jetbrains.annotations.NotNull MenuItem item) {

                int id = item.getItemId();
                item.setChecked(true);
                drawerLayout.closeDrawer(GravityCompat.START);
                switch (id)
                {

                    case R.id.nav_profile:
                        replaceFragment(new ProfileFragment());break;
                    case R.id.nav_home:
                        replaceFragment(new HomeFragment());break;
                    case R.id.nav_notifications:
                        replaceFragment(new NotificationsFragment());break;
                    case R.id.nav_leaderboards:
                        replaceFragment(new LeaderboardsFragment());break;
                    case R.id.nav_create_wager:
                        replaceFragment(new CreateWagerFragment());break;
                    case R.id.nav_my_wagers:
                        replaceFragment(new MyWagersFragment());break;
                    case R.id.nav_assessments:
                        replaceFragment(new AssessmentsFragment());break;
                    case R.id.nav_create_class:
                        replaceFragment(new CreateClassFragment());break;
                    case R.id.nav_create_assessment:
                        replaceFragment(new CreateAssessmentFragment());break;
                    case R.id.nav_authentication:
                        replaceFragment(new AuthenticationFragment());break;
                    case R.id.nav_logout:
                        replaceFragment(new LogoutFragment());break;
                    default:
                        return true;

                }
                return true;
            }
        });


    }

    private void replaceFragment(Fragment fragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }
}