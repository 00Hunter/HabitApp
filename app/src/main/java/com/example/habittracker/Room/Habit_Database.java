package com.example.habittracker.Room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = Habit.class ,version = 1)
public abstract class Habit_Database extends RoomDatabase {
    public abstract HabitDao habitDao();
}
