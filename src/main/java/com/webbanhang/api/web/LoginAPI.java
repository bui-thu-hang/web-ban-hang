package com.webbanhang.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webbanhang.dto.UserDTO;
import com.webbanhang.service.IUserService;

@RestController(value = "loginAPIOfWeb")
public class LoginAPI {

	@Autowired
	private IUserService userService;
	
	@PostMapping("/api/login")
	public UserDTO createUser(@RequestBody UserDTO userDTO) {
		return userService.saveLogin(userDTO);
	}
}
