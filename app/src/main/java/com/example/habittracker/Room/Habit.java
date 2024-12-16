package com.example.habittracker.Room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Habit {
    @PrimaryKey
    int id;

    @ColumnInfo(name="Habit_Name")
    public String Name;

}
