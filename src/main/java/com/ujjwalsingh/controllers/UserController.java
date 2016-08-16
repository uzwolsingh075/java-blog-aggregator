package com.ujjwalsingh.controllers;

import java.net.URL;
import java.util.List;

import javax.validation.Valid;
import javax.xml.transform.Source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ujjwalsingh.entity.Users;
import com.ujjwalsingh.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@ModelAttribute("user")
	public Users construct(){
		return new Users();
	}
	@RequestMapping("/users")
	public String all_users(Model model){
		List users = userService.allUsers();
		System.out.println(users);
		model.addAttribute("users", users);
		return "all_users";
	}
	@RequestMapping("/preauthorize")
	public String testPreAuthorize(Model model){
		Users user = userService.getUserById(2);
		System.out.println(user.getName());
		userService.testPreAuthorize(user);
		return "all_users";
	}
	@RequestMapping(value="/form",method=RequestMethod.GET)
	public String registerUser(){
		//URL url = new URL("http://www.amrood.com/index.htm?language=en#j2se");
		//userService.getItems(url);
		return "register-form";
	}
	@RequestMapping(value="/form",method=RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("user") Users user,BindingResult result){
		if(result.hasErrors()){
			return "register-form";
		}
		userService.saveUser(user);
		return "redirect:/form?success=true";
	}
}
