package com.example.tasq.models;

import android.graphics.Bitmap;

public class ModelClass {
    private String name, password;
    private Bitmap image;
    public ModelClass(String name, String password, Bitmap image) {
        this.name = name;
        this.password = password;
        this.image = image;
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
    public Bitmap getImage() {
        return image;
    }
    public void setImage(Bitmap image) {
        this.image = image;
    }
}