package com.comjava.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.comjava.Entity.Result;
import com.comjava.Entity.User;
import com.comjava.Service.UserService;

@Controller
public class UserController {
	
@Autowired
private UserService userService;

@GetMapping("/loadFirstPage")
public String addUserForm(Model model) {
	model.addAttribute("user", new User());
	return "add-user"; 
}

@PostMapping("/add")
public ModelAndView addUser(@ModelAttribute User user) {
	Result result=new Result();
	result.setMessage(userService.addUser(user));
	ModelAndView modelAndView=new ModelAndView();
	modelAndView.setViewName("result-view");
	modelAndView.addObject("result",result);
	return modelAndView;
	} 
}