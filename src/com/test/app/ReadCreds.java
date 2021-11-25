package com.test.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.LinkedList;
import java.util.List;

import com.test.model.Creds;
import com.test.model.User;

public class ReadCreds {

	public static List<Creds> readCreds(User user) {

		List<Creds> credlist = new LinkedList<Creds>();
		try {
			File f2 = new File(user.getUsername() + "lockme-db-creds.txt");
			if (f2.exists()) {
				FileInputStream file = new FileInputStream(user.getUsername() + "lockme-db-creds.txt");
				ObjectInputStream input = new ObjectInputStream(file);
				credlist = (List<Creds>) input.readObject();
				input.close();
				file.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		}
		return credlist;
	}
}
