package com.oosdclass.taskTrackerApp2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.oosdclass.taskTrackerApp2.model.Task;
import com.oosdclass.taskTrackerApp2.service.TaskService;

@Controller
public class TaskController {
	
	//Link the UI to the Service layer
	@Autowired
	TaskService taskService;
	
	//GET: show the task view page - map viewTasks method to web page - for ADMIN
	@RequestMapping(value="/adminTasks")
	public ModelAndView viewAdminTasks(ModelAndView model) {
		//map list of tasks to table in view page
		List<Task> taskList = taskService.getAllTask();
		model.addObject(taskList);
		model.setViewName("adminTask");
		return model;	
	}
	//GET: show the task view page - for EMPLOYEES
	@RequestMapping(value="/empTasks/{username}")
	public ModelAndView viewEmpTasks(ModelAndView model, @PathVariable String username) {
		//map list of tasks to table in view page
		List<Task> taskList = taskService.getAllTask();
		model.addObject(taskList);
		model.addObject(username);
		model.setViewName("empTask");
		return model;	
	}
	//GET: show the admin-only "create task" form
	@RequestMapping(value="/createTaskForm") 
	public ModelAndView createTaskForm(ModelAndView model) {	
		//map create task form in the view page
		Task task = new Task();
		model.addObject(task);
		model.setViewName("createTask");
		return model;
	}
	//POST: post the newly created task to the DAO, and then display the updated table in "view task" page
	@RequestMapping(value="/createTask", method = RequestMethod.POST)
	public ModelAndView createTask(Task task) {
		ModelAndView model=null;
		taskService.saveTask(task); 
		model = new ModelAndView("redirect:/adminTasks");
		return model;
	}
	//GET: show the employee-only "update task" form
	@RequestMapping(value="/viewTask/{taskID}/{username}") 
	public ModelAndView viewTask(ModelAndView model, @PathVariable int taskID, @PathVariable String username) {	
		Task task = taskService.getByTaskId(taskID);
		model.addObject(task);
		model.addObject(username);
		model.setViewName("viewTask");
		return model;
	}
//	//POST: update the task properties STATUS and ASSIGNED TO, then send back to emp tasks page
//	//you can use post to create a new object or to update a pre-existing object
//	//however, this may not be the most efficient way to update the task object.
//	//I just used this method because I copied it from the "create task" method we already did
//	@RequestMapping(value="/updateTask", method = RequestMethod.POST)
//	public ModelAndView updateTask(Task task) {
//		ModelAndView model=null;
//		taskService.updateTask(task);
//		model = new ModelAndView("redirect:/empTasks");
//		return model;
//	}
	//attempts are being made to create a new viewpage/method for each button
	//BUTTON: ASSIGN TO ME
	@RequestMapping(value="/updateTask/{status}/{taskID}/{username}", method = RequestMethod.GET)
	public ModelAndView updateStatus(@PathVariable int taskID, @PathVariable String status, @PathVariable String username) {
		ModelAndView model=null;
		taskService.updateTaskStatus(taskID, status, username);
		model = new ModelAndView("redirect:/empTasks/{username}");
		return model;
	}	
	@RequestMapping(value="/updateTask/ASSIGN/{taskID}/{username}", method = RequestMethod.GET)
	public ModelAndView updateAssignedTo(@PathVariable int taskID, @PathVariable String username) {
		ModelAndView model=null;
		taskService.updateTaskAssignedTo(taskID, username);
		model = new ModelAndView("redirect:/empTasks/{username}");
		return model;
	}
}