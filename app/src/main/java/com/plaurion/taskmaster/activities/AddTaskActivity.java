package com.plaurion.taskmaster.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.plaurion.taskmaster.R;

public class AddTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        EditText taskTitleEditText = (EditText) findViewById(R.id.taskTitleEditText);
        EditText taskBodyEditText = (EditText) findViewById(R.id.taskBodyEditText);
        TextView submittedTextView = (TextView) findViewById(R.id.submittedTextView);

        Button submitAddTaskButton = (Button) findViewById(R.id.submitAddTaskButton);
        submitAddTaskButton.setOnClickListener(view ->
                {
                    submittedTextView.setText("Submitted!");

                }
        );

    }
}