package com.oosdclass.taskTrackerApp2.dao;

import java.util.List;

import com.oosdclass.taskTrackerApp2.model.Task;

public interface TaskDAO {
	
	public List<Task> retrieveAllTasks();

	public Task retrieveByTaskID(int taskID);
	
	public void saveTask(Task task);

	//here's the update task method for the buttons
	public void updateTask(Task task);
	
	}