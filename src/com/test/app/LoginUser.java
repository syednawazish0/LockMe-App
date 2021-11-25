package com.test.app;

import java.util.List;

import com.test.model.User;

public class LoginUser {
	
	public static  boolean login(User user) {
		List<User> userList  = ReadUsers.getUsers();
		int match = 0;
		for(User userInfo: userList) {
			if(user.getUsername().equals(userInfo.getUsername()) && user.getPassword().equals(userInfo.getPassword())){
				System.out.println("Login Sucessfull !");
				match++;
				return true;
			}
		}
		if(match==0) {
			System.out.println("Login Failed !");
		}
		return false;
	}
}
