package com.plaurion.taskmaster.activities;

import static com.plaurion.taskmaster.activities.SettingsActivity.USER_NAME_KEY;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.plaurion.taskmaster.R;


public class MainActivity extends AppCompatActivity {


    public final static String TASK_NAME_EXTRA_STRING = "taskName";
    protected static SharedPreferences sharedPreferences;
    protected static Resources res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        res = getResources();

        ImageView settingsLinkImageView = (ImageView) findViewById(R.id.settingsLinkImageView);
        settingsLinkImageView.setOnClickListener(view ->
                {

                    Intent settingsIntent = new Intent(MainActivity.this, SettingsActivity.class);
                    startActivity(settingsIntent);
                }
        );

        TextView taskOneMainTextView = (TextView) findViewById(R.id.taskOneMainTextView);
        taskOneMainTextView.setOnClickListener(view ->
                {
                    Intent taskDetailIntent = new Intent(MainActivity.this, TaskDetails.class);
                    taskDetailIntent.putExtra(TASK_NAME_EXTRA_STRING, taskOneMainTextView.getText());

                    startActivity(taskDetailIntent);

                }
        );

        TextView taskTwoMainTextView = (TextView) findViewById(R.id.taskTwoMainTextView);
        taskTwoMainTextView.setOnClickListener(view ->
                {
                    Intent taskDetailIntent = new Intent(MainActivity.this, TaskDetails.class);
                    taskDetailIntent.putExtra(TASK_NAME_EXTRA_STRING, taskTwoMainTextView.getText());

                    startActivity(taskDetailIntent);

                }
        );


        TextView taskThreeMainTextView = (TextView) findViewById(R.id.taskThreeMainTextView);
        taskThreeMainTextView.setOnClickListener(view ->
                {
                    Intent taskDetailIntent = new Intent(MainActivity.this, TaskDetails.class);
                    taskDetailIntent.putExtra(TASK_NAME_EXTRA_STRING, taskThreeMainTextView.getText());

                    startActivity(taskDetailIntent);

                }
        );

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
    @Override
    protected void onResume()
    {
        super.onResume();

        String userName = sharedPreferences.getString(USER_NAME_KEY, "");

        if (!userName.equals(""))
        {
            ((TextView) findViewById(R.id.userNameMainTextView)).setText(res.getString(R.string.WelcomeUsername, userName));
        }
    }
}