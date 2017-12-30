package com.oosdclass.taskTrackerApp2.service;

import java.util.List;

import com.oosdclass.taskTrackerApp2.model.Task;

public interface TaskService {
	
	List<Task> getAllTask();

	public void saveTask(Task task);

	public void updateTask(Task task);
	
	Task getByTaskId(int taskID);

}
