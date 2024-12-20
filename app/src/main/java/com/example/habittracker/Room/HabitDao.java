package com.example.habittracker.Room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface HabitDao {
    @Query("SELECT * FROM habit_table")
    List<Habit>getAll();

    @Insert
    void insert(Habit habit);

}
