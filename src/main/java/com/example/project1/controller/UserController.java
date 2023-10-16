package com.example.project1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.project1.entiities.User;
import com.example.project1.service.UserService;
@CrossOrigin (origins = "http://localhost:3000")
@RestController
public class UserController {
	@Autowired
	private UserService userService;
		
		@GetMapping("/users")
		public ResponseEntity<List<User>> getUsers() {
			List<User> allUser = userService.getAllUsers();
			return new ResponseEntity<List<User>>(allUser, HttpStatus.OK);
		}
		
		
		@PostMapping("/user")
		public ResponseEntity<String> createTirage(@RequestBody User user){
		String status = userService.UpdateOrInsert(user);
		
		return  new ResponseEntity<>(status,HttpStatus.CREATED);
		}
		
		
		@PutMapping("/user")
		public ResponseEntity<String> updateTirage(@RequestBody User user){
			String status = userService.UpdateOrInsert(user);
			
			return  new ResponseEntity<>(status,HttpStatus.OK);
			}
		
		@PostMapping("/login")
		public ResponseEntity<String> login(@RequestBody User user) {
		    User existingUser = userService.getByEmail(user.getEmail());

		    if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
		        return new ResponseEntity<>("Login successful", HttpStatus.OK);
		    } else {
		        return new ResponseEntity<>("Login failed", HttpStatus.UNAUTHORIZED);
		    }
		}

		
		@GetMapping("user/{pid}")
		public ResponseEntity<User> getUser(@PathVariable Integer pid) {
			User user = userService.getById(pid);
			return new ResponseEntity<>(user,HttpStatus.OK);
		}
		
		
		@DeleteMapping("user/{pid}")
		public ResponseEntity<String> deleteUser(@PathVariable Integer pid) {
			
			String status = userService.deleteById(pid);
			
			return new ResponseEntity<String>(status,HttpStatus.OK);
		}
		
		

}
