package com.plaurion.taskmaster.activities;

import static com.plaurion.taskmaster.activities.SettingsActivity.USER_NAME_KEY;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.plaurion.taskmaster.R;
import com.plaurion.taskmaster.adapters.TaskRecyclerViewAdapter;
import com.plaurion.taskmaster.models.Task;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


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
        // Step 1-1: Add a RecyclerView to your layout
        // Step 1-2: Grab the RecyclerView by ID
        RecyclerView taskMainRecyclerView = findViewById(R.id.taskMainRecyclerView);

        // Step 1-3: Assign a layout manager for this RecyclerView
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);  // vertical layout
        taskMainRecyclerView.setLayoutManager(lm);

        // Step 2-1: Create a data model class, and create that data by hand
        List<Task> taskList = new ArrayList<>();
        taskList.add(new Task("Sort shoes", new Date()));
        taskList.add(new Task("Pair socks", new Date()));
        taskList.add(new Task("Wash hair with shampoo", new Date()));
        taskList.add(new Task("Sort shoes 2", new Date()));
        taskList.add(new Task("Pair socks 2", new Date()));
        taskList.add(new Task("Wash hair with shampoo2", new Date()));
        taskList.add(new Task("Sort shoes 3", new Date()));
        taskList.add(new Task("Pair socks 3", new Date()));
        taskList.add(new Task("Wash hair with shampoo 3", new Date()));
        taskList.add(new Task("Sort shoes 4", new Date()));
        taskList.add(new Task("Pair socks 4", new Date()));
        taskList.add(new Task("Wash hair with shampoo 4", new Date()));

        // Step 1-4: Make a class whose sole purpose is to manage RecyclerViews and attach it to the RecyclerView
        // Step 2-2: Pass data into RecyclerViewAdapter
        TaskRecyclerViewAdapter taskRecyclerViewAdapter = new TaskRecyclerViewAdapter(this, taskList);
        taskMainRecyclerView.setAdapter(taskRecyclerViewAdapter);


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