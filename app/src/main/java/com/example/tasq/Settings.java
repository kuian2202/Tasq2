package com.example.tasq;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tasq.database.DBHelper;
import com.example.tasq.models.ModelClass;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Set;

public class Settings extends AppCompatActivity {

    EditText uploadName, uploadPassword;
    ImageView uploadImage;
    TextView newName;
    Button saveButton;
    DBHelper dbHelper;
    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_settings);

        dbHelper = new DBHelper(this);

        newName = findViewById(R.id.newName);
        uploadPassword = findViewById(R.id.uploadPassword);
        uploadName = findViewById(R.id.uploadName);
        saveButton = findViewById(R.id.saveButton);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menuHome:
                        startActivity(new Intent(Settings.this, Home.class));
                        finish(); // Optional: Finish the current activity
                        return true;
                    case R.id.menuSchedule:
                        // Handle schedule menu item click
                        // Start the ScheduleActivity
                        startActivity(new Intent(Settings.this, Schedule.class));
                        finish(); // Optional: Finish the current activity
                        return true;
                    case R.id.menuCustomize:
                        // Handle customize menu item click
                        // Start the CharacterActivity
                        startActivity(new Intent(Settings.this, CharacterActivity.class));
                        finish(); // Optional: Finish the current activity
                        return true;
                    case R.id.menuSettings:
                }
                return false;
            }

        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                storeData();
            }
        });
    }

    @Override
    public void onBackPressed() {
        // Add your additional functionality here

        // For example, if you want to go back to the Home activity
        Intent intent = new Intent(Settings.this, Home.class);
        startActivity(intent);

        // Finish the current activity (optional)
        finish();
    }
    private void storeData() {
        String currentUsername = dbHelper.getUsername();
        String currentPassword = dbHelper.getPassword();
        String newUsername = uploadName.getText().toString();
        String newPassword = uploadPassword.getText().toString();

        boolean isUsernameChanged = !newUsername.isEmpty() && !newUsername.equals(currentUsername);
        boolean isPasswordChanged = !newPassword.isEmpty() && !newPassword.equals(currentPassword);

        if (isUsernameChanged || isPasswordChanged) {
            if (isPasswordChanged) {
                dbHelper.updatePassword(currentPassword, newPassword);
            }
            if (isUsernameChanged) {
                dbHelper.updateName(currentUsername, newUsername);
            }

            SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("username", newUsername);
            editor.putString("password", newPassword);
            editor.apply();

            newName.setText(newUsername);

            Toast.makeText(Settings.this, "Data Updated", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(Settings.this, "No changes made", Toast.LENGTH_SHORT).show();
        }
    }
}