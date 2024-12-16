package com.example.habittracker.Room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Habit.class ,version = 1)
public abstract class Habit_Database extends RoomDatabase {
    public abstract HabitDao habitDao();
    private static Habit_Database instance;

    public static synchronized Habit_Database getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            Habit_Database.class, "app_database")
                    .fallbackToDestructiveMigration() // Handle migrations automatically
                    .build();
        }
        return instance;
    }
}
