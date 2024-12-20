package com.example.habittracker;

import android.app.Application;

import com.example.habittracker.Room.Habit_Database;

public class App extends Application {
    public static Habit_Database db;

    @Override
    public void onCreate() {
        super.onCreate();
        db=Habit_Database.getInstance(this);
    }
}
