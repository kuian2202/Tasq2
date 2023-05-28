package com.example.tasq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class ActivityAchievements extends AppCompatActivity {
    boolean achievement5Unlocked;
    boolean achievement10Unlocked;
    boolean achievement50Unlocked;
    boolean achievement100Unlocked;
    boolean achievement500Unlocked;
    ImageView achievement5;
    ImageView achievement10;
    ImageView achievement50;
    ImageView achievement100;
    ImageView achievement500;
    TextView textView22;
    TextView textView23;
    TextView textView24;
    TextView textView25;
    TextView textView26;
    RelativeLayout bg1;
    RelativeLayout bg2;
    RelativeLayout bg3;
    RelativeLayout bg4;
    RelativeLayout bg5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievements);
        getSupportActionBar().hide();
        // Retrieve the intent extras inside the onCreate() method
        achievement5Unlocked = getIntent().getBooleanExtra("achievement5Unlocked", false);
        achievement10Unlocked = getIntent().getBooleanExtra("achievement10Unlocked", false);
        achievement50Unlocked = getIntent().getBooleanExtra("achievement50Unlocked", false);
        achievement100Unlocked = getIntent().getBooleanExtra("achievement100Unlocked", false);
        achievement500Unlocked = getIntent().getBooleanExtra("achievement500Unlocked", false);

        achievement5 = findViewById(R.id.achievement5);
        achievement10 = findViewById(R.id.achievement10);
        achievement50 = findViewById(R.id.achievement50);
        achievement100 = findViewById(R.id.achievement100);
        achievement500 = findViewById(R.id.achievement500);
        textView22 = findViewById(R.id.textView22);
        textView23 = findViewById(R.id.textView23);
        textView24 = findViewById(R.id.textView24);
        textView25 = findViewById(R.id.textView25);
        textView26 = findViewById(R.id.textView26);
        bg1 = findViewById(R.id.bg1);
        bg2 = findViewById(R.id.bg2);
        bg3 = findViewById(R.id.bg3);
        bg4 = findViewById(R.id.bg4);
        bg5 = findViewById(R.id.bg5);

        if (achievement5Unlocked) {
            textView26.setTextColor(Color.BLACK);
            achievement5.setImageResource(R.drawable.check);
            bg5.setBackgroundColor(getResources().getColor(R.color.achievement));
        }

        if (achievement10Unlocked) {
            textView25.setTextColor(Color.BLACK);
            achievement10.setImageResource(R.drawable.check);
            bg4.setBackgroundColor(getResources().getColor(R.color.achievement));
        }
        if (achievement50Unlocked) {
            textView24.setTextColor(Color.BLACK);
            achievement50.setImageResource(R.drawable.check);
            bg3.setBackgroundColor(getResources().getColor(R.color.achievement));
        }
        if (achievement100Unlocked) {
            textView22.setTextColor(Color.BLACK);
            achievement100.setImageResource(R.drawable.check);
            bg2.setBackgroundColor(getResources().getColor(R.color.achievement));
        }
        if (achievement500Unlocked) {
            textView23.setTextColor(Color.BLACK);
            achievement500.setImageResource(R.drawable.check);
            bg1.setBackgroundColor(getResources().getColor(R.color.achievement));
        }
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