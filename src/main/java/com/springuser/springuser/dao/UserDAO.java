package com.springuser.springuser.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springuser.springuser.entity.User;

public interface UserDAO extends JpaRepository<User,Long> {
	
	

}
