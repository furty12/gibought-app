package com.kldv.gibought;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AddActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

       BottomNavigationView mbottomNavigationView = findViewById(R.id.bot_nav_view);

       mbottomNavigationView.setSelectedItemId(R.id.app_add);

       mbottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

               switch (menuItem.getItemId()){

                   case R.id.app_home:
                       startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                       overridePendingTransition(0, 0 );
                       return true;

                   case R.id.app_calendar:
                       startActivity(new Intent(getApplicationContext(),CalendarActivity.class));
                       overridePendingTransition(0, 0 );
                       return true;

                   case R.id.app_graphics:
                       startActivity(new Intent(getApplicationContext(),GraphicsActivity.class));
                       overridePendingTransition(0, 0 );
                       return true;

                   case R.id.app_engine:
                       startActivity(new Intent(getApplicationContext(),ConfigActivity.class));
                       overridePendingTransition(0, 0 );
                       return true;

               }

               return false;
           }
       });

    }
}