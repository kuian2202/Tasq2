package com.example.tasq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class ActivityAchievements extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievements);
        getSupportActionBar().hide();
    }
    @Override
    public void onBackPressed() {
        // Add your additional functionality here

        // For example, if you want to go back to the Home activity
        Intent intent = new Intent(ActivityAchievements.this, Home.class);
        startActivity(intent);

        // Finish the current activity (optional)
        finish();
    }
}