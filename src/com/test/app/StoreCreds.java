package com.test.app;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;

import com.test.model.Creds;
import com.test.model.User;

public class StoreCreds {

	public static boolean storeCredential(Creds cred, User user) {
		List<Creds> credList = ReadCreds.readCreds(user);
		if (!credList.isEmpty()) {
			credList = ReadCreds.readCreds(user);

		} else {
			credList = new LinkedList<Creds>();
			System.out.println("Store Credential !");
		}
		credList.add(cred);
		try {
			FileOutputStream file = new FileOutputStream(user.getUsername() + "lockme-db-creds.txt");
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(credList);
			out.close();
			file.close();
			System.out.println("Registration Sucessfull !");
		} catch (Exception e) {
			System.out.println("Registration Failed !");
		}
		return true;

	}

}
