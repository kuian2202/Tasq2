package com.example.tasq;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import android.os.Bundle;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class Timer extends AppCompatActivity {
    private TextView tvTimer;
    private TimePicker timePicker;
    private Button btnStart;
    private Button btnStop;
    private CountDownTimer countDownTimer;
    private long timeLeftInMillis;
    private final long countdownInterval = 1000; // 1 second interval

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_timer);

        tvTimer = findViewById(R.id.tvTimer);
        timePicker = findViewById(R.id.timePicker);
        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTimer();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopTimer();
            }
        });
    }

    private void startTimer() {
        Calendar currentCalendar = Calendar.getInstance();
        int currentHour = currentCalendar.get(Calendar.HOUR_OF_DAY);
        int currentMinute = currentCalendar.get(Calendar.MINUTE);

        int selectedHour, selectedMinute;

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            selectedHour = timePicker.getHour();
            selectedMinute = timePicker.getMinute();
        } else {
            selectedHour = timePicker.getCurrentHour();
            selectedMinute = timePicker.getCurrentMinute();
        }

        long currentTimeInMillis = (currentHour * 3600000) + (currentMinute * 60000);
        long selectedTimeInMillis = (selectedHour * 3600000) + (selectedMinute * 60000);
        long remainingTimeInMillis = selectedTimeInMillis - currentTimeInMillis;

        if (remainingTimeInMillis <= 0) {
            Toast.makeText(this, "Please select a valid end time", Toast.LENGTH_SHORT).show();
            return;
        }

        timeLeftInMillis = remainingTimeInMillis;

        countDownTimer = new CountDownTimer(timeLeftInMillis, countdownInterval) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateTimer();
            }

            @Override
            public void onFinish() {
                tvTimer.setText("00:00:00");
                btnStop.setEnabled(false);
                btnStart.setEnabled(true);
            }
        };

        countDownTimer.start();
        btnStart.setEnabled(false);
        btnStop.setEnabled(true);
    }

    private void stopTimer() {
        if (countDownTimer != null) {
            countDownTimer.cancel();
            btnStop.setEnabled(false);
            btnStart.setEnabled(true);
        }
    }

    private void updateTimer() {
        int hours = (int) (timeLeftInMillis / 3600000);
        int minutes = (int) ((timeLeftInMillis % 3600000) / 60000);
        int seconds = (int) ((timeLeftInMillis % 60000) / 1000);

        String timeLeft = String.format("%02d:%02d:%02d", hours, minutes, seconds);
        tvTimer.setText(timeLeft);
    }
}