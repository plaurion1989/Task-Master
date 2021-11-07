package com.plaurion.taskmaster.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import com.plaurion.taskmaster.R;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addTaskButton = (Button) findViewById(R.id.addTaskButton);
        addTaskButton.setOnClickListener(view ->
                {
                    Intent addTaskIntent = new Intent(MainActivity.this, AddTaskActivity.class);
                    startActivity(addTaskIntent);
                }
        );
        Button allTasksButton = (Button) findViewById(R.id.allTasksButton);
        allTasksButton.setOnClickListener(view ->
                {
                    Intent allTasksIntent = new Intent(MainActivity.this, AllTasksActivity.class);
                    startActivity(allTasksIntent);
                }
        );
    }
}