package com.test.app;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;

import com.test.model.User;

public class Registration {

	public static boolean register(User user) {
		List<User> userlist = ReadUsers.getUsers();
		if (!userlist.isEmpty()) {
			userlist = ReadUsers.getUsers();
		} else {
			userlist = new LinkedList<User>();
			System.out.println("First Registration");
		}
		userlist.add(user);
		try {
			FileOutputStream file = new FileOutputStream("lockme-db-users.txt");
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(userlist);
			out.close();
			file.close();
			System.out.println("Registration Successfull !");
		} catch (Exception e) {
			System.out.println("Registration Failed !");
		}
		return true;
	}
}
