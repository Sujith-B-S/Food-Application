package com.sg.checkEncry;

import java.util.List;

import com.sg.userdaoimpl.UserDAOImpl;
import com.sg.userpojo.User;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UserDAOImpl udao = new UserDAOImpl();
		
		List<User> u = udao.fetchAll();
		
		for(User user : u)
		{
			System.out.println(user.getEmail());
		}
		

	}

}
