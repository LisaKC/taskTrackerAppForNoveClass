package com.oosdclass.taskTrackerApp2.dao;

import java.util.List;

import org.springframework.scheduling.config.Task;

public interface TaskDAO {
	
	public List<Task> retrieveAllTasks();

}
