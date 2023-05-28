package com.example.tasq;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class Schedule extends AppCompatActivity {
    TextView april, june;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_schedule);

        june = findViewById(R.id.june);
        april = findViewById(R.id.april);

    april.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(Schedule.this, Schedule2.class);
            startActivity(intent);
        }
    });
    june.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(Schedule.this, Schedule3.class);
            startActivity(intent);
        }
    });

    }
    @Override
    public void onBackPressed() {
        // Add your additional functionality here

        // For example, if you want to go back to the Home activity
        Intent intent = new Intent(Schedule.this, Home.class);
        startActivity(intent);

        // Finish the current activity (optional)
        finish();
    }
}
