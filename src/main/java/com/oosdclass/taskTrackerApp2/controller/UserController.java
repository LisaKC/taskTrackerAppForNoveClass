package com.oosdclass.taskTrackerApp2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.oosdclass.taskTrackerApp2.model.User;
import com.oosdclass.taskTrackerApp2.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/")
	public ModelAndView login(ModelAndView model) {
		User user = new User();
		model.addObject(user);
		model.setViewName("home");
		return model;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(User userLoginFormObject) {
		ModelAndView model = null;
		if(userService.isUserValid(userLoginFormObject)) {
			model = new ModelAndView("viewTask");
		} else {
			model = new ModelAndView("home");
			model.addObject("error", "Username does not exist");
		}
		return model;
	}

}
