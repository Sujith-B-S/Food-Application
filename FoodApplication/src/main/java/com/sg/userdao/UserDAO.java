package com.sg.userdao;

import java.util.List;

import com.sg.userpojo.User;

public interface UserDAO {
	
	int insert(User u);
	List<User> fetchAll();
	User fetchSpecific(String email);
	int updateUser(User u);
	int deleteUser(String email);
}
