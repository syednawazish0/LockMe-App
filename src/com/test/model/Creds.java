package com.test.model;

import java.io.Serializable;

public class Creds implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String username;
	private String sitename;
	private String password;

	public Creds(String id, String username, String sitename, String password) {
		super();
		this.id = id;
		this.username = username;
		this.sitename = sitename;
		this.password = password;
	}

	public Creds() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSitename() {
		return sitename;
	}

	public void setSitename(String sitename) {
		this.sitename = sitename;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Creds [id=" + id + ", username=" + username + ", sitename=" + sitename + ", password=" + password + "]";
	}

}
