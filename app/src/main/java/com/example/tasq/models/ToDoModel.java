package com.example.tasq.models;

import java.util.Date;

public class ToDoModel {
    private int id, status;
    private String task;
    private long reminder;
    private Date reminderTime;

    private boolean checked;
    public long getReminder() {
        return reminder;
    }

    public void setReminder(long reminder) {
        this.reminder = reminder;
    }
    public Date getReminderTime() {
        return reminderTime;
    }

    public void setReminderTime(Date reminderTime) {
        this.reminderTime = reminderTime;
    }
    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
}
