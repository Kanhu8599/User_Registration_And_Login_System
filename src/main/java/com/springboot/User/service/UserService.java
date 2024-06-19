package com.springboot.User.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.springboot.User.dto.UserRegistrationDto;
import com.springboot.User.entity.User;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
	User findByEmail(String email);
}
