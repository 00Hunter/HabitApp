package com.example.habittracker.Activities;

import android.opengl.Visibility;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.habittracker.App;
import com.example.habittracker.R;
import com.example.habittracker.Room.Habit;
import com.example.habittracker.Room.HabitDao;
import com.example.habittracker.Room.Habit_Database;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AddHabitActivity extends AppCompatActivity {

    private Button add_button;
    private EditText editText;
    private Button done_button;
    public static Habit_Database db;
    private final ExecutorService executorService= Executors.newSingleThreadExecutor();
    private HabitDao habitDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_habit);
        initViews();
        handleAdd();
        habitDao= App.db.habitDao();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void initViews(){
        add_button=(Button) findViewById(R.id.Add);
        editText=(EditText) findViewById(R.id.editTextText);
        done_button=(Button) findViewById(R.id.Done);
    }

    private void handleAdd(){
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add_button.setVisibility(View.GONE);
                editText.setVisibility(View.VISIBLE);
                done_button.setVisibility(View.VISIBLE);
            }
        });

        done_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String habit=editText.getText().toString();

                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        Habit Newhabit=new Habit();
                        Newhabit.Name=habit;
                        habitDao.insert(Newhabit);
                    }
                });
            }
        });
    }
}