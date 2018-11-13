package com.ujjwalsingh.webservice;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ujjwalsingh.entity.Users;
import com.ujjwalsingh.service.UserService;
@Controller
@RequestMapping("/service")
public class User {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/user",method=RequestMethod.GET)
	public @ResponseBody ArrayList<Users> getAllUser() {
		ArrayList<Users> users = userService.allUsers();
		return users;
	}
	
	@RequestMapping(value="/user-departments",method=RequestMethod.GET)
	public @ResponseBody ArrayList<Users> getAllUserDepartments() {
		ArrayList<Users> user = new ArrayList<>();
		return user;
	}
}