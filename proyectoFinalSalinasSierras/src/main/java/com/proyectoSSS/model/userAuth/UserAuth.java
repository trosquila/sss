package com.proyectoSSS.model.userAuth;

public class UserAuth {
	private String userName;
	private String password;
	
	public UserAuth(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserAuth [userName=" + userName + ", password=" + password + "]";
	}
	
}
