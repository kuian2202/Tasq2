package com.example.tasq;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tasq.adapters.ToDoAdapter;
import com.example.tasq.database.DatabaseHandler;
import com.example.tasq.models.ToDoModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.switchmaterial.SwitchMaterial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Home extends AppCompatActivity implements DialogCloseListener {
    private RecyclerView taskRecyclerView;
    private ToDoAdapter taskAdapter;
    private FloatingActionButton fab;
    private DatabaseHandler db;
    private List<ToDoModel> taskList;
    private BottomNavigationView bottomNavigationView;
    TextView levelTextView;
    private int currentLevel;
    private Switch switchTheme;
    boolean nightMODE;
    private boolean isClosing = false;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_home);

        ImageView myImageView1 = findViewById(R.id.group1);
        ImageView myImageView2 = findViewById(R.id.group2);
        ImageView ach = findViewById(R.id.profile_rectangle);
        levelTextView = findViewById(R.id.textView3);

        currentLevel = getLevelFromSharedPreferences();
        levelTextView.setText("Level " + currentLevel);


        switchTheme = findViewById(R.id.switchBtn);
        sharedPreferences = getSharedPreferences("MODE", Context.MODE_PRIVATE);
        nightMODE = sharedPreferences.getBoolean("night", false);
        if(nightMODE){
            switchTheme.setChecked(true);
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }

        switchTheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nightMODE){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    editor = sharedPreferences.edit();
                    editor.putBoolean("night", false);
                }else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    editor = sharedPreferences.edit();
                    editor.putBoolean("night", true);
                }
                editor.apply();
            }
        });
        db = new DatabaseHandler(this);
        db.openDatabase();
        ach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click event here
                boolean achievement5Unlocked = hasUnlockedAchievement("achievement 5");
                boolean achievement50Unlocked = hasUnlockedAchievement("achievement 10");
                boolean achievement100Unlocked = hasUnlockedAchievement("achievement 50");
                boolean achievement500Unlocked = hasUnlockedAchievement("achievement 100");
                boolean achievement1000Unlocked = hasUnlockedAchievement("achievement 500");
                Intent intent = new Intent(Home.this, ActivityAchievements.class);
                intent.putExtra("achievement5Unlocked", achievement5Unlocked);
                intent.putExtra("achievement10Unlocked", achievement50Unlocked);
                intent.putExtra("achievement50Unlocked", achievement100Unlocked);
                intent.putExtra("achievement100Unlocked", achievement500Unlocked);
                intent.putExtra("achievement500Unlocked", achievement1000Unlocked);
                startActivity(intent);
            }
        });
        myImageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click event
                Intent intent = new Intent(Home.this, Group1.class);
                startActivity(intent);
            }
        });
        myImageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click event
                Intent intent = new Intent(Home.this, Group2.class);
                startActivity(intent);
            }
        });


        taskList = new ArrayList<>();

        taskRecyclerView = findViewById(R.id.taskRecyclerView);
        taskRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        taskAdapter = new ToDoAdapter(db, this, this);
        taskRecyclerView.setAdapter(taskAdapter);

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new RecyclerItemTouchHelper(taskAdapter));
        itemTouchHelper.attachToRecyclerView(taskRecyclerView);

        fab = findViewById(R.id.fab_add);

        taskList = db.getAllTasks();
        Collections.reverse(taskList);

        taskAdapter.setTasks(taskList);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddNewTask.newInstance().show(getSupportFragmentManager(), AddNewTask.TAG);
            }
        });
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menuHome:
                        // Handle home menu item click
                        // No need to start a new activity, as we are already in the HomeActivity
                        return true;
                    case R.id.menuSchedule:
                        // Handle schedule menu item click
                        // Start the ScheduleActivity
                        startActivity(new Intent(Home.this, Schedule.class));
                        finish(); // Optional: Finish the current activity
                        return true;
                    case R.id.menuCustomize:
                        // Handle customize menu item click
                        // Start the CharacterActivity
                        startActivity(new Intent(Home.this, CharacterActivity.class));
                        finish(); // Optional: Finish the current activity
                        return true;
                    case R.id.menuSettings:
                        // Handle settings menu item click
                        // Start the SettingsActivity
                        startActivity(new Intent(Home.this, Settings.class));
                        finish(); // Optional: Finish the current activity
                        return true;
                }
                return false;
            }

        });


    }

    public boolean hasUnlockedAchievement(String achievementName) {
        int completedTasks = db.getCompletedTaskCount();
        if (achievementName.equals("achievement 5")) {
            return completedTasks >= 5;
        } else if (achievementName.equals("achievement 10")) {
            return completedTasks >= 10;
        } else if (achievementName.equals("achievement 50")) {
            return completedTasks >= 50;
        } else if (achievementName.equals("achievement 100")) {
            return completedTasks >= 100;
        } else if (achievementName.equals("achievement 500")) {
            return completedTasks >= 500;
        }
        return false;
    }

    public void changeHeadImageProfile(int resourceId) {
        ImageView headImageViewProfile = findViewById(R.id.head_image_view_profile);
        headImageViewProfile.setImageResource(resourceId);
    }

    @Override
    public void handleDialogClose(DialogInterface dialog) {
        taskList = db.getAllTasks();
        Collections.reverse(taskList);
        taskAdapter.setTasks(taskList);
        taskAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        super.onResume();

        int savedLevel = getLevelFromSharedPreferences();

        // Update the currentLevel only if it has changed
        if (savedLevel != currentLevel) {
            currentLevel = savedLevel;
            levelTextView.setText("Level " + currentLevel);
        }
    }

    private int getLevelFromSharedPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        return sharedPreferences.getInt("currentLevel", 1);
    }
    public void saveLevelToSharedPreferences(int level) {
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("currentLevel", level);
        editor.apply();
    }


}