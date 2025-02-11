package com.example.alarmapp;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;

    @Dao
    public interface AlarmDao {
        @Query("SELECT * FROM alarms")
        List<Alarm> getAllAlarms();

        @Insert
        void insertAlarm(Alarm alarm);

        @Update
        void updateAlarm(Alarm alarm);

        @Delete
        void deleteAlarm(Alarm alarm);
    }


