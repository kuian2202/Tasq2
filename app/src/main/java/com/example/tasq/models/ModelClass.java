package com.example.tasq.models;

import android.graphics.Bitmap;

public class ModelClass {
    private String name, password;
    private Bitmap image;
    public ModelClass(String name, String password) {
        this.name = name;
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}