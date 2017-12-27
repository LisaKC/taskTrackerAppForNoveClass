package com.oosdclass.taskTrackerApp2.service;

import java.util.List;

import com.oosdclass.taskTrackerApp2.model.Task;

public interface TaskService {
	
	List<Task> getAllTask();

	//to be replaced with whatever the savetask method is
	void saveTask(Task task);

}
