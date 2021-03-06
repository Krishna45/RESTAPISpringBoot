package com.springuser.springuser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springuser.springuser.entity.User;
import com.springuser.springuser.service.UserService;

@RestController
public class MyController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/home")
	public String home()
	{
		return "This is the home page";
	}
	
	@GetMapping("/users")
	public List<User> getUsers()
	{
		return this.userService.getUsers();
	}
	
	@GetMapping("/users/{id}")
    public User getUser(@PathVariable String id)
    {
	    return this.userService.getUser(Long.parseLong(id));
    }
	
	@PostMapping("/users")
	public User addUser(@RequestBody User user)
	{
		return this.userService.addUser(user);
	}
	
	@PutMapping("/users")
	public User updateUser(@RequestBody User user)
	{
		return this.userService.updateUser(user);
	}
	
	@DeleteMapping("users/{id}")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable String id)
	{
		try
		{
			this.userService.deleteUser(Long.parseLong(id));
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
