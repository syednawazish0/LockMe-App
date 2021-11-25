package com.test.app;

import java.util.List;

import com.test.model.Creds;
import com.test.model.User;

public class FetchCreds {
	public static boolean showCreds(User user) {
		List<Creds> credlist = ReadCreds.readCreds(user);

		for (Creds credInfo : credlist) {
			System.out.println(credInfo);
		}
		
		return false;

	}
}
