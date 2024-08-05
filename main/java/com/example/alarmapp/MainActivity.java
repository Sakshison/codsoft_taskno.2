package com.example.alarmapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView currentTime;
    private TextView currentDate;
    private Button setAlarmButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentTime = findViewById(R.id.currentTime);
        currentDate = findViewById(R.id.currentDate);
        setAlarmButton = findViewById(R.id.setAlarmButton);

        updateDateTime();

        setAlarmButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SetAlarm.class);
            startActivity(intent);
        });
    }

    private void updateDateTime() {
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, MMM d, yyyy", Locale.getDefault());
        String currentTimeStr = timeFormat.format(new Date());
        String currentDateStr = dateFormat.format(new Date());

        currentTime.setText(currentTimeStr);
        currentDate.setText(currentDateStr);
    }
}
