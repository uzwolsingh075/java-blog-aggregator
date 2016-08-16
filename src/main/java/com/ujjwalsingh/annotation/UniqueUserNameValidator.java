package com.ujjwalsingh.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.ujjwalsingh.repositories.UserRepository;
import com.ujjwalsingh.service.UserService;

public class UniqueUserNameValidator implements ConstraintValidator<UniqueUserName, String> {

	@Autowired
	UserService userService;

	@Override
	public void initialize(UniqueUserName constraintAnnotation) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isValid(String username, ConstraintValidatorContext context) {
		return userService.findUserExist(username);
	}

}
