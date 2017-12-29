package com.oosdclass.taskTrackerApp2.service;

import java.util.List;

import com.oosdclass.taskTrackerApp2.model.Task;

public interface TaskService {
	
	List<Task> getAllTask();

	void saveTask(Task task);

	void updateTask(Task task);
	
	Task getByTaskId(int taskID);

}
