package com.sg.userpojo;

public class User {
	
	private int uid;
	private String username;
	private String email;
	private String password;
	private String mobile;
	private String address;
	
	public User(String username, String email, String password, String mobile,String address) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.address = address;
	}



	public User(int uid, String username, String email, String password, String mobile,String address) {
		super();
		this.uid = uid;
		this.username = username;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.address = address;
	}


	public User() {
		super();
	}
	
	public User(String address , String email)
	{
		this.address = address;
		this.email =email;
	}

	public User(int uid, String username, String email, String password, String mobile) {
		// TODO Auto-generated constructor stub
	}



	@Override
	public String toString() {
		return uid + "  " + username + "  " + email + "  " + password
				+ "  " + mobile +"  "+address;
	}


	public String getAddress()
	{
		return address;
	}
	
	public void setAddress(String address)
	{
		this.address = address;
	}

	public int getUid() {
		return uid;
	}



	public void setUid(int uid) {
		this.uid = uid;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getMobile() {
		return mobile;
	}



	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


}


