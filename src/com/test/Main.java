package com.test;

import java.util.List;
import java.util.Scanner;

import com.test.app.FetchBySite;
import com.test.app.FetchCreds;
import com.test.app.LoginUser;
import com.test.app.ReadCreds;
import com.test.app.Registration;
import com.test.app.StoreCreds;
import com.test.model.Creds;
import com.test.model.User;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("-- Weolcome to Lockme Digital Locker --");
		System.out.println("-- Please select your option --");
		System.out.println("-- 1) Register    2) Login --");
		int option = scanner.nextInt();

		switch (option) {
		case 1:
			User userReg = registerData();
			Registration.register(userReg);
			break;
		case 2:
			User userlog = loginData();
			boolean response = LoginUser.login(userlog);
			if (response) {
				afterLogin(userlog);
			}
			break;
		default:
			break;
		}
	}

	private static void afterLogin(User userlog) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("-- Please select your option --");
		System.out.println("-- 1)Store Creds    2) Fetch Creds --");
		int option1 = keyboard.nextInt();
		switch (option1) {
		case 1:
			Creds credlog = credRegData();
			StoreCreds.storeCredential(credlog, userlog);
			break;
		case 2:
			afterFetch(userlog);

		}
	}

	private static String fetchSite() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your Sitename");
		return sc.nextLine();
	}

	private static void afterFetch(User userlog) {
		Scanner scan = new Scanner(System.in);
		System.out.println("-- Please Select Your Option --");
		System.out.println("-- 1)All Creds      2)Fetchbysite --");
		int option2 = scan.nextInt();
		switch (option2) {
		case 1: {
			FetchCreds.showCreds(userlog);
			break;
		}
		case 2: {
			String sitename = fetchSite();
			List<Creds> credlist = ReadCreds.readCreds(userlog);
			FetchBySite.fetchBySide(credlist, sitename);
		}

			break;
		default:
		}
	}

	private static User registerData() {
		User user = new User();
		Scanner scanner = new Scanner(System.in);
		System.out.println("-- Enter Registration Details  --");
		System.out.println("Enter username :");
		user.setUsername(scanner.nextLine());
		System.out.println("Enter password :");
		user.setPassword(scanner.nextLine());
		System.out.println("Enter confirm password :");
		user.setCnfPassword(scanner.nextLine());
		System.out.println("Enter email :");
		user.setEmail(scanner.nextLine());
//		scanner.close();
		return user;
	}

	private static Creds credRegData() {
		Creds cred = new Creds();
		Scanner scanner = new Scanner(System.in);
		System.out.println("-- Enter Creds Registration Details --");
		System.out.println(" Enter Username ");
		cred.setUsername(scanner.nextLine());
		System.out.println(" Enter Your Password ");
		cred.setPassword(scanner.nextLine());
		System.out.println("Enter Your ID ");
		cred.setId(scanner.nextLine());
		System.out.println("Enter Your Site Name ");
		cred.setSitename(scanner.nextLine());
//		scanner.close();
		return cred;
	}

	private static User loginData() {
		User user = new User();
		Scanner scanner = new Scanner(System.in);
		System.out.println("-- Enter Login Details  --");
		System.out.println("Enter username :");
		user.setUsername(scanner.nextLine());
		System.out.println("Enter password :");
		user.setPassword(scanner.nextLine());

//		scanner.close();
		return user;
	}

	private static Creds fetchData() {
		Creds cred = new Creds();
		Scanner scanner = new Scanner(System.in);
		System.out.println("-- Enter Login Details --");
		System.out.println("Enter Username :");
		cred.setUsername(scanner.nextLine());
		System.out.println("Enter Password");
		cred.setPassword(scanner.nextLine());
//		2scanner.close();
		return cred;
	}

}
