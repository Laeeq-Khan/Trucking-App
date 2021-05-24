package com.example.fyp.Company;

import android.content.Intent;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.fyp.Company.DriverRequests.CompanyDriverRequests;
import com.example.fyp.R;
import com.google.android.material.navigation.NavigationView;

public class CompanyMainPage extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private TextView companyName;
    private TextView companyEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_main_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        String x=getIntent().getStringExtra("uniqueid");
        if (x!=null)
            getSupportFragmentManager().beginTransaction().replace(R.id.container,new CompanyDriverRequests()).commit();

        /*if (x.equals(getIntent().getStringExtra("uniqueid"))){

        }*/


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);
        companyName = (TextView) headerView.findViewById(R.id.nav_company_name);
        companyEmail=(TextView) headerView.findViewById(R.id.nav_company_email);
        companyEmail.setText("Comapny@gmail.com");
        companyName.setText("TruckIt");




        navigationView.setNavigationItemSelectedListener(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new CompanyDriverRequests()).commit();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.company_main_page, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(this, "Setting Clicked", Toast.LENGTH_SHORT).show();
            return true;
        }



        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.companyDriverRequests) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container,new CompanyDriverRequests()).commit();
        } else if (id == R.id.progressingOrders) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container,new ProgressingOrders()).commit();

        } else if (id == R.id.history) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container,new History()).commit();

        } else if (id == R.id.companyDriverRequests) {

        } else if (id == R.id.registeredDrivers) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container,new CompanyAllDrivers()).commit();


        } else if (id == R.id.registeredCustomers) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container,new CompanyAllCustomers()).commit();


        }
        else if (id == R.id.suspendedDrivers) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container,new CompanySuspendedDrivers()).commit();

        }
        else if (id == R.id.settings) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container,new CompanySettings()).commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
