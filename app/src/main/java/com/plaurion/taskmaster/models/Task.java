package com.plaurion.taskmaster.models;
import androidx.annotation.NonNull;

import java.util.Date;

public class Task
{
    public String taskTitle;
    public String taskStatus;
    public java.util.Date timeAdded;


    public Task(String taskTitle, String taskStatus, Date timeAdded)
    {
        this.taskTitle = taskTitle;
        this.timeAdded = timeAdded;
        this.taskStatus = taskStatus;
    }

    @Override
    @NonNull
    public String toString()
    {
        return taskTitle + "\nTime Added: " + timeAdded;
    }

}
