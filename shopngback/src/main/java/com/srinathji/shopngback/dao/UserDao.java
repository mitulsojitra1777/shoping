package com.srinathji.shopngback.dao;

import java.util.List;

import com.srinathji.shopngback.dto.User;

public interface UserDao {
	boolean addUser(User user);
	boolean updateUser(User user);
	boolean deleteUser(User user);
	User getUserById(int id);
	User Login(String uid, String password);
	List<User> list();
	

}
