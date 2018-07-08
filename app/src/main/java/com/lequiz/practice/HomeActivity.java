package com.lequiz.practice;


import android.content.Intent;
import android.graphics.LinearGradient;
import android.graphics.Shader;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;


public class HomeActivity extends AppCompatActivity {


    protected DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    protected CardView currentAffairs, computer, mathematics, reasoning,
            generalScience, english, technology, sports, special, entertainment;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(null);



 // user name on home page gradient
        TextView txt = findViewById(R.id.user_name);
        Shader textShader=new LinearGradient(0,0, 180, 0,
                new int[]{getResources().getColor(R.color.blueOnHomeText),getResources().getColor(R.color.purpleOnHomeText)},
                new float[]{0, 1}, Shader.TileMode.CLAMP);
        txt.getPaint().setShader(textShader);

        TextView txt1 = findViewById(R.id.wishing);
        Shader textShader1=new LinearGradient(0,0, 180, 0,
                new int[]{getResources().getColor(R.color.blueOnHomeText),getResources().getColor(R.color.purpleOnHomeText)},
                new float[]{0, 1}, Shader.TileMode.CLAMP);
        txt1.getPaint().setShader(textShader1);






        mDrawerLayout = findViewById(R.id.drawer_layout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        Objects.requireNonNull(getSupportActionBar()).setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_drawer_indicator);

        // implementing item of navigation drawer
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);
        setupDrawerContent(navigationView); // default true


        currentAffairs = findViewById(R.id.current_affairs_card_view);
        computer = findViewById(R.id.computer_card_view);
        mathematics = findViewById(R.id.mathematics_card_view);
        reasoning = findViewById(R.id.reasoning_card_view);
        generalScience = findViewById(R.id.general_science_card_view);
        english = findViewById(R.id.english_card_view);
        technology = findViewById(R.id.technology_card_view);
        sports = findViewById(R.id.sports_card_view);
        special = findViewById(R.id.special_card_view);
        entertainment = findViewById(R.id.entertainment_card_view);

        currentAffairs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,CurrentAffairsActivity.class);
                startActivity(intent);
            }
        });
        computer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,ComputerActivity.class);
                startActivity(intent);
            }
        });
        mathematics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,MathematicsActivity.class);
                startActivity(intent);
            }
        });
        reasoning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,ReasoningActivity.class);
                startActivity(intent);
            }
        });
        generalScience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,GeneralScienceActivity.class);
                startActivity(intent);
            }
        });
        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,EnglishActivity.class);
                startActivity(intent);
            }
        });
        technology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,TechnologyActivity.class);
                startActivity(intent);
            }
        });
        sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,SportsActivity.class);
                startActivity(intent);
            }
        });
        special.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,SpecialActivity.class);
                startActivity(intent);
            }
        });
        entertainment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,EntertainmentActivity.class);
                startActivity(intent);
            }
        });





    } // onCreate method


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int res_if = item.getItemId();
        switch (res_if) {
            case R.id.profile:
                Toast.makeText(getApplicationContext(), "Profile", Toast.LENGTH_LONG).show();
                break;
            case R.id.notifications:
                Toast.makeText(getApplicationContext(), "Notifications", Toast.LENGTH_LONG).show();
                break;
            case R.id.leaderboard:
                Toast.makeText(getApplicationContext(), "LeaderBoard", Toast.LENGTH_LONG).show();
                break;
            case R.id.lesson_factory:
                Toast.makeText(getApplicationContext(), "Lesson Factory", Toast.LENGTH_LONG).show();
                break;
            case R.id.quiz_factory:
                Toast.makeText(getApplicationContext(), "Quiz Factory", Toast.LENGTH_LONG).show();
                break;
            case R.id.invite_friends:
                Toast.makeText(getApplicationContext(), "Invite Friends", Toast.LENGTH_LONG).show();
                break;
            case R.id.rate:
                Toast.makeText(getApplicationContext(), "Rate us", Toast.LENGTH_LONG).show();
                break;
            case R.id.settings:
                Toast.makeText(getApplicationContext(), "Settings", Toast.LENGTH_LONG).show();
                break;
        }
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return true;
    }


    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int res_id = menuItem.getItemId();
                switch (res_id) {
                    case R.id.profile:
                        Toast.makeText(getApplicationContext(), "Profile", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.home_activity:
                        Toast.makeText(getApplicationContext(), "Home", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.leaderboard:
                        Toast.makeText(getApplicationContext(), "Leaderboard", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.notifications:
                        Toast.makeText(getApplicationContext(), "Notifications", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.payment:
                        Toast.makeText(getApplicationContext(), "Payment", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.settings:
                        Toast.makeText(getApplicationContext(), "Settings", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.invite_friends:
                        Toast.makeText(getApplicationContext(), "Invite Friends", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.feedback:
                        Toast.makeText(getApplicationContext(), "Feedback", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.about_us:
                        Toast.makeText(getApplicationContext(), "About us", Toast.LENGTH_LONG).show();
                        break;
                }

                mDrawerLayout.closeDrawers();
                return true;
            }
        });
    }


} // activity class
