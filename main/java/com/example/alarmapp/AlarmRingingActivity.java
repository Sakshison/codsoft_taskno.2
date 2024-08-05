package com.example.alarmapp;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import java.util.Calendar;

    public class AlarmRingingActivity extends Activity {

        private Ringtone ringtone;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_alarm_ringing);

            Uri alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
            if (alarmUri == null) {
                alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
            }

            ringtone = RingtoneManager.getRingtone(getApplicationContext(), alarmUri);
            ringtone.play();

            @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button snoozeButton = findViewById(R.id.snoozeButton);
            @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button dismissButton = findViewById(R.id.dismissButton);

            snoozeButton.setOnClickListener(v -> snoozeAlarm());
            dismissButton.setOnClickListener(v -> dismissAlarm());
        }

        private void snoozeAlarm() {
            ringtone.stop();

            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.MINUTE, 10);

            AlarmService alarmService = new AlarmService(this);
            alarmService.setAlarm(calendar, 1);

            finish();
        }

        private void dismissAlarm() {
            ringtone.stop();
            finish();
        }
    }


