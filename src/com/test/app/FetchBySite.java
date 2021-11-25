package com.test.app;

import java.util.List;

import com.test.model.Creds;

public class FetchBySite {

	public static void fetchBySide(List<Creds> cred, String sitename) {
		try {
			int match = 0;

			for (Creds credInfo : cred) {

				if (credInfo.getSitename().equals(sitename)) {
//					System.out.println(credlist);
					System.out.println("Sitename: " + credInfo.getSitename());
					System.out.println("Site Username : " + credInfo.getUsername());
					System.out.println("Id :" + credInfo.getId());
					System.out.println("Password :" + credInfo.getPassword());
					match++;
				}
			}
			if (match == 0) {
				System.out.println("Site Does Not Exist");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
