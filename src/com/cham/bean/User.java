package com.cham.bean;

public class User {
	int UserID;
	String name;
	String password;
	int role;
	int type;
	
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public User(int userID, String name, String password, int role, int type) {
		super();
		UserID = userID;
		this.name = name;
		this.password = password;
		this.role = role;
		this.type = type;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getUserID() {
		return UserID;
	}
	public void setUserID(int userID) {
		UserID = userID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	

}
