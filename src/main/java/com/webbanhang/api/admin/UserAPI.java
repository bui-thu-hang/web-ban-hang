package com.webbanhang.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webbanhang.dto.UserDTO;
import com.webbanhang.service.IUserService;

@RestController(value = "userAPIOfAdmin")
public class UserAPI {

	@Autowired
	private IUserService userService;
	
	@PostMapping("/api/user")
	public UserDTO createUser(@RequestBody UserDTO userDTO) {
		return userService.save(userDTO);
		
	}
	
	@PutMapping("/api/user")
	public UserDTO updateUser(@RequestBody UserDTO userDTO) {
		return userService.save(userDTO);
	}
	
	@DeleteMapping("/api/user")
	public void deleteUser(@RequestBody long[] ids) {	
		userService.delete(ids);
		
	}
	@GetMapping("/api/user/{id}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
	    UserDTO dto = userService.findById(id);
	    return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
	}
	

	// đoạn get này được thêm vào để hiển thị dữ liệu ra postman 
}
