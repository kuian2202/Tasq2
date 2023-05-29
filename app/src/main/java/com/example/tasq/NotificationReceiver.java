package com.example.tasq;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;

import com.example.tasq.database.DatabaseHandler;
import com.example.tasq.models.ToDoModel;

public class NotificationReceiver extends BroadcastReceiver  {

    private static final String CHANNEL_ID = "task_channel";

    public void onReceive(Context context, Intent intent) {

        ToDoModel todo = new ToDoModel();
        // Check if the permission is granted
        if (hasVibratePermission(context)) {
            // Vibrate the device
            Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
            if (vibrator != null) {
                try {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        vibrator.vibrate(VibrationEffect.createOneShot(1000, VibrationEffect.DEFAULT_AMPLITUDE));
                    } else {
                        vibrator.vibrate(1000);
                    }
                } catch (SecurityException e) {
                    // Handle the case where the permission is rejected
                    return;
                }
            }
        } else {
            // Handle the case where the permission is not granted
            return;
        }

        // Create and display the notification
        createNotification(context, todo);
    }

    private boolean hasVibratePermission(Context context) {
        int permissionResult = ContextCompat.checkSelfPermission(context, Manifest.permission.VIBRATE);
        return permissionResult == PackageManager.PERMISSION_GRANTED;
    }


    private void createNotification(Context context, ToDoModel todo) {
        // Create the notification channel (if necessary) for Android Oreo and above
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNotificationChannel(context);
        }
        // Create the notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.check)
                .setContentTitle("Task Reminder")
                .setContentText("Finish Your Pending Tasks")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true);

        // Show the notification
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        notificationManager.notify(0, builder.build());
    }

    private void createNotificationChannel(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            if (notificationManager != null && notificationManager.getNotificationChannel(CHANNEL_ID) == null) {
                // Create a notification channel with the desired settings
                NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "Task Channel", NotificationManager.IMPORTANCE_DEFAULT);
                notificationManager.createNotificationChannel(channel);
            }
        }
    }
}