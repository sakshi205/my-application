package com.e.childnutrition;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;
import android.widget.Toast;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class DashboardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Variables
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        //Hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        //using toolbar as action bar in the system
        setSupportActionBar(toolbar);

        //to show menu when the button is clicked
        navigationView.bringToFront();

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);//to make the menu items clickable
    }

    //to avoid the closing of application when pressed back and instead closing the drawer when back pressed
    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {
            case R.id.nav_feedback:
                Intent feedback_intent = new Intent(DashboardActivity.this,FeedbackActivity.class);
                startActivity(feedback_intent);
                break;
            case R.id.nav_help:
                Intent help_intent = new Intent(DashboardActivity.this,HelpActivity.class);
                startActivity(help_intent);
                break;

            case R.id.nav_logout:
                Intent logout_intent = new Intent(DashboardActivity.this,LogoutActivity.class);
                startActivity(logout_intent);
                break;

            case R.id.nav_share:
                Intent share_intent = new Intent();
//                share_intent.setAction(Intent.ACTION_SEND);
//                share_intent.putExtra(Intent.EXTRA_TEXT);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;

    }
}
