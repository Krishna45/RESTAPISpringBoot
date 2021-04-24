package com.springuser.springuser.service;

import java.util.List;

import com.springuser.springuser.entity.User;

public interface UserService {

	
	//CRUD operations
	public List<User> getUsers();
	
	public User getUser(long id);
	
	public User addUser(User user);
	
	public User updateUser(User user);
	
	public void deleteUser(long id);
	
	
}
