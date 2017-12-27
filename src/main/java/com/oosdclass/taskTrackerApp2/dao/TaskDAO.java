package com.oosdclass.taskTrackerApp2.dao;

import java.util.List;

import com.oosdclass.taskTrackerApp2.model.Task;

public interface TaskDAO {
	
	public List<Task> retrieveAllTasks();

	public Task retrieveByTaskID(int taskID);
	
	//to be replaced with whatever the DAO team creates
	public static void saveTask(Task task) {
		
	}
	
	}
