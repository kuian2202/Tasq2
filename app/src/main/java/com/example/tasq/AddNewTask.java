package com.example.tasq;

import android.Manifest;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.provider.Settings;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;

import com.example.tasq.database.DatabaseHandler;
import com.example.tasq.models.ToDoModel;

import java.util.Calendar;
import java.util.Date;

public class AddNewTask extends DialogFragment implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener,
        ActivityCompat.OnRequestPermissionsResultCallback {

    public static final String TAG = "AddNewTask";
    public static final String CHANNEL_ID = "task_channel";
    private static final int NOTIFICATION_ID = 1;
    private static final int PERMISSION_REQUEST_CODE = 1;

    private EditText newTaskText;
    private Button saveButton;
    private long taskId;

    private int year, month, day, hour, minute;

    public static AddNewTask newInstance() {
        return new AddNewTask();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.new_task, null);

        newTaskText = view.findViewById(R.id.newTaskText);
        saveButton = view.findViewById(R.id.newTaskButton);

        // Set an initial date and time value (e.g., current date and time)
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the save button click event
                String task = newTaskText.getText().toString().trim();

                // Validate task input
                if (task.isEmpty()) {
                    Toast.makeText(getActivity(), "Please enter a task", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Construct the reminder date and time
                Calendar reminderCalendar = Calendar.getInstance();
                reminderCalendar.set(Calendar.YEAR, year);
                reminderCalendar.set(Calendar.MONTH, month);
                reminderCalendar.set(Calendar.DAY_OF_MONTH, day);
                reminderCalendar.set(Calendar.HOUR_OF_DAY, hour);
                reminderCalendar.set(Calendar.MINUTE, minute);
                reminderCalendar.set(Calendar.SECOND, 0);

                // Save the task and reminder in the database
                taskId = saveTaskAndReminder(task, reminderCalendar.getTime());

                if (ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.SCHEDULE_EXACT_ALARM)
                        != PackageManager.PERMISSION_GRANTED) {
                    // Request the permission
                    ActivityCompat.requestPermissions(requireActivity(),
                            new String[]{Manifest.permission.SCHEDULE_EXACT_ALARM},
                            PERMISSION_REQUEST_CODE);
                } else {
                    // Permission granted, proceed with scheduling the notification
                    scheduleNotification(taskId, reminderCalendar.getTime()); // Pass the reminder time to the method
                }

                // Show a success message
                Toast.makeText(getActivity(), "Task saved", Toast.LENGTH_SHORT).show();

                // Close the dialog
                dismiss();
            }
        });

        newTaskText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().equals("")) {
                    saveButton.setEnabled(false);
                    saveButton.setTextColor(Color.GRAY);
                } else {
                    saveButton.setEnabled(true);
                    saveButton.setTextColor(Color.DKGRAY);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        builder.setView(view);

        return builder.create();
    }

    private long saveTaskAndReminder(String task, Date reminderTime) {
        // Save the task and reminder in the database
        DatabaseHandler db = new DatabaseHandler(getActivity());
        db.openDatabase();
        long taskId = db.addTask(task);
        db.addReminder(taskId, reminderTime.getTime());
        db.close();
        return taskId;
    }

    private void scheduleNotification(long taskId, Date reminderTime) {
        // Create an explicit intent to launch the notification receiver
        Context context = requireContext();
        Intent intent = new Intent(context, NotificationReceiver.class);
        intent.putExtra("taskId", taskId);

        // Create a PendingIntent with a unique ID
        int requestCode = (int) taskId;
        int flags = PendingIntent.FLAG_UPDATE_CURRENT;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            flags |= PendingIntent.FLAG_MUTABLE;
        } else {
            flags |= PendingIntent.FLAG_IMMUTABLE;
        }
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, requestCode, intent, flags);

        // Get the AlarmManager instance
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        // Set the reminder time in milliseconds
        long reminderTimeMillis = reminderTime.getTime();

        // Schedule the notification using the AlarmManager
        if (alarmManager != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                // For devices running on Android Marshmallow (6.0) and above
                alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, reminderTimeMillis, pendingIntent);
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                // For devices running on Android KitKat (4.4) and above
                alarmManager.setExact(AlarmManager.RTC_WAKEUP, reminderTimeMillis, pendingIntent);
            } else {
                // For devices before KitKat, use set()
                alarmManager.set(AlarmManager.RTC_WAKEUP, reminderTimeMillis, pendingIntent);
            }
        }
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        // Retrieve the selected date values
        this.year = year;
        this.month = month;
        this.day = dayOfMonth;

        // Show the time picker dialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(), AddNewTask.this, hour, minute, false);
        timePickerDialog.show();
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        // Retrieve the selected time values
        this.hour = hourOfDay;
        this.minute = minute;
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        Activity activity = getActivity();
        if (activity instanceof DialogCloseListener) {
            ((DialogCloseListener) activity).handleDialogClose(dialog);
        }
    }

}