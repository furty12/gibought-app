package com.kldv.gibought;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class CalendarActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        ImageView add = findViewById(R.id.btnAdc);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView bt_add = findViewById(R.id.btnAdc);
                bt_add.setImageResource(R.drawable.baddoff);
                startActivity(new Intent(getApplicationContext(), AddActivity.class));
                finish();
            }

        });

        BottomNavigationView mbottomNavigationView = findViewById(R.id.bot_nav_view);

        mbottomNavigationView.setSelectedItemId(R.id.app_calendar);

        mbottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){

                    case R.id.app_home:
                        startActivity(new Intent(getApplicationContext(),HomeActivity.class));
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