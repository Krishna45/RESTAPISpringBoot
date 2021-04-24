package com.springuser.springuser.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springuser.springuser.dao.UserDAO;
import com.springuser.springuser.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDao;
	
	public UserServiceImpl()
	{
		
	}
	
	
	@Override
	public List<User> getUsers() {
		
		return userDao.findAll();
		
	}

	@Override
	public User getUser(long id) {
		
		User user = userDao.findById(id)
			      .orElseThrow(() -> new IllegalArgumentException("User does not exist"));
		return user;
	}

	@Override
	public User addUser(User user) {
		
		userDao.save(user);
		return user;
		
	}

	@Override
	public User updateUser(User user) {
		
		userDao.save(user);
		return user;
		
	}

	@Override
	public void deleteUser(long id) {
		
		User user=userDao.getOne(id);
		userDao.delete(user);
		
		
	}

}
