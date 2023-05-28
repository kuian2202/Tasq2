package com.example.tasq;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

public class MyApplication extends Application {
    Home home = new Home();
    public void onTerminate() {
        super.onTerminate();
    }

    // Other methods and code for your application class

}