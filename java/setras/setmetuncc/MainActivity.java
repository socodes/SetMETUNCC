package setras.setmetuncc;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    ImageView metumail, oc, restaurants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawerLayout = findViewById(R.id.drawer);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener) MainActivity.this);

        mToggle = new ActionBarDrawerToggle(MainActivity.this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        metumail = findViewById(R.id.metumail);

        oc = findViewById(R.id.oc);

        restaurants = findViewById(R.id.restaurants);

        oc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent oc_intent = new Intent(MainActivity.this, oc_activity.class);
                startActivity(oc_intent);

            }
        });

        restaurants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent restaurants = new Intent(getApplicationContext(),restaurants_activity.class);
                startActivity(restaurants);
            }
        });
        metumail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent metumail_intent = new Intent(MainActivity.this, metumail_activity.class);
                startActivity(metumail_intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.us:
                Intent us_intent = new Intent(MainActivity.this, us_activity.class);
                startActivity(us_intent);
                break;
            case R.id.gym:
                Intent gym_intent = new Intent(MainActivity.this, gym_activity.class);
                startActivity(gym_intent);
                break;

            case R.id.carsi:
                Intent carsi_intent = new Intent(MainActivity.this, carsi.class);
                startActivity(carsi_intent);
                break;

            case R.id.dorms:
                Intent dorms_intent = new Intent(MainActivity.this, dorms.class);
                startActivity(dorms_intent);
                break;

            case R.id.schedule:
                Intent schedule_intent = new Intent(MainActivity.this, schedule.class);
                startActivity(schedule_intent);
                break;
            case R.id.thisweekcampus:
                Intent thisweek_intent = new Intent(MainActivity.this, activity_thisweek.class);
                startActivity(thisweek_intent);
                break;
            case R.id.transportation:
                Intent transportation_intent = new Intent(MainActivity.this, transportation.class);
                startActivity(transportation_intent);
                break;
            case R.id.phonebook:
                Intent phone_intent = new Intent(MainActivity.this, activity_phonebook.class);
                startActivity(phone_intent);
                break;
        }
        return true;
    }

}
