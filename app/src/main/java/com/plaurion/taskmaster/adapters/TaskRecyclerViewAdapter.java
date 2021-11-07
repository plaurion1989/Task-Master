package com.plaurion.taskmaster.adapters;

import static com.plaurion.taskmaster.activities.MainActivity.TASK_NAME_EXTRA_STRING;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.plaurion.taskmaster.R;

import com.plaurion.taskmaster.activities.TaskDetails;
import com.plaurion.taskmaster.models.Task;

import java.util.List;

public class TaskRecyclerViewAdapter extends RecyclerView.Adapter<TaskRecyclerViewAdapter.TaskViewHolder>{


        AppCompatActivity associatedActivity;
        // Step 2-2: Pass data into RecyclerViewAdapter (need to create a holder here for it)
        List<Task> taskList;
        public final static String TAG =  "plaurion_taskmaster_taskrecyclerviewadapter";

        public TaskRecyclerViewAdapter(AppCompatActivity associatedActivity, List<Task> taskList)
        {
            this.associatedActivity = associatedActivity;
            this.taskList = taskList;
        }

        // Step 1-6: Instantiate the fragment that you made in step 1-6
        @NonNull
        @Override
        public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
        {
            View fragment = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_single_task, parent, false);
            // Step 1-7: Instantiate the ViewHolder and give it the fragment
            TaskViewHolder taskViewHolder = new TaskViewHolder(fragment);
            return taskViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull TaskViewHolder holder, int position)
        {
            // Step 2-4: Give the view holder the data
            // Don't forget to have a toString() that shows something for the recycler view
            Task singleTask = taskList.get(position);
            View taskFragment = holder.itemView;
            TextView taskFragmentTextView = taskFragment.findViewById(R.id.taskFragmentTextView);
            taskFragmentTextView.setText(singleTask.toString());

            // Step 3: Make an onClickListener in order to go to another page with the cart item's info
            holder.itemView.setOnClickListener(v -> {
                {
                    Intent taskDetailsIntent = new Intent(associatedActivity, TaskDetails.class);
                    taskDetailsIntent.putExtra(TASK_NAME_EXTRA_STRING, singleTask.taskTitle);
                    associatedActivity.startActivity(taskDetailsIntent);
                }
            });
        }

        // Step 2-5: Make this count dynamic
        @Override
        public int getItemCount()
        {
            return taskList.size();
        }
        public static class TaskViewHolder extends RecyclerView.ViewHolder
        {
            public TaskViewHolder(@NonNull View itemView)
            {
                super(itemView);
            }
        }

}

