package com.plaurion.taskmaster.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.plaurion.taskmaster.R;

public class TaskDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);

        Intent intent = getIntent();
        String taskName = intent.getExtras().get(MainActivity.TASK_NAME_EXTRA_STRING).toString();
        TextView taskDetailsTitleTextView = (TextView) findViewById(R.id.taskDetailsTitleTextView);
        taskDetailsTitleTextView.setText(taskName);
    }
}