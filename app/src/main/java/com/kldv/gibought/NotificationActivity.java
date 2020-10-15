package com.kldv.gibought;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        ActionBar ab = getSupportActionBar();
        assert ab != null;
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setTitle(getResources().getString(R.string.notification_title));


    }

    public boolean onOptionsItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();

        if ( id == R.id.app_home ) {
            startActivity(new Intent(getApplicationContext(),HomeActivity.class));
            finish();
            return true;
        }else if ( id == R.id.app_add ) {
            startActivity(new Intent(getApplicationContext(),AddActivity.class));
            finish();
            return true;
        }

        else{
            startActivity(new Intent(getApplicationContext(),ConfigActivity.class));
            finish();
        }

        return super.onOptionsItemSelected(menuItem);
    }

}