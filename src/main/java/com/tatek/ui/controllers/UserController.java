package com.tatek.ui.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tatek.ui.model.response.UserRest;

@RestController
@RequestMapping("/users")
public class UserController {

	
	 // @GetMapping public String getUsers() { return "get user was called"; }
	 

	@GetMapping
	public String getUsers(@RequestParam(value = "page",defaultValue ="1") int page,
			@RequestParam(value = "limit",defaultValue ="50") int limit) {
		return "get user was called with page = " + page + " and limit = " + limit;
	}

	/*
	 * @GetMapping(path = "/{userId}") public String getUser(@PathVariable String
	 * userId) { return userId + " user was called"; }
	 */
	
	@GetMapping(path = "/{userId}",
			produces = {MediaType.APPLICATION_XML_VALUE, 
						MediaType.APPLICATION_JSON_VALUE}) 
	public ResponseEntity <UserRest> getUser(@PathVariable String userId) {
		UserRest userObject = new UserRest();
		userObject.setFirstName("Tatek");
		userObject.setLastName("Ahmed");
		userObject.setEmail("tatek.ahmed443@gmail.com");
		return new ResponseEntity<UserRest>(userObject, HttpStatus.OK); 
	}

	@PostMapping
	public String createUser() {
		return "create user was called";
	}

	@PutMapping
	public String updateUser() {
		return "update user was called";
	}

	@DeleteMapping
	public String deleteUser() {
		return "Delete user was called";
	}
}
