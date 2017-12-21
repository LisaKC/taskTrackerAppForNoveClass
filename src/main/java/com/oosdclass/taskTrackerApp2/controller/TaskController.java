package com.oosdclass.taskTrackerApp2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.oosdclass.taskTrackerApp2.model.Task;
import com.oosdclass.taskTrackerApp2.service.TaskService;

@Controller
public class TaskController {
	
	@Autowired
	TaskService taskService;
	
	@RequestMapping(value="/adminTasks")
	public ModelAndView viewTasks(ModelAndView model) {
		
		List<Task> taskList = taskService.getAllTask();
		model.addObject(taskList);
		model.setViewName("viewTask");
		return model;
	}
	
	

}