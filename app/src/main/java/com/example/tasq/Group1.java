package com.example.tasq;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Group1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);
        getSupportActionBar().hide();
    }
}