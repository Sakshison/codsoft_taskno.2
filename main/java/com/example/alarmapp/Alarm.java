package com.example.alarmapp;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

    @Entity(tableName = "alarms")
    public class Alarm {
        @PrimaryKey(autoGenerate = true)
        public int id;

        public int hour;
        public int minute;
        public boolean isEnabled;
        public String toneUri;

        public Alarm(int hour, int minute, boolean isEnabled, String toneUri) {
            this.hour = hour;
            this.minute = minute;
            this.isEnabled = isEnabled;
            this.toneUri = toneUri;
        }

        // Getters and Setters
    }


