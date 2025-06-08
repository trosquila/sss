package com.proyectoSSS.model.userAuth;

public class UserAuth {
	private int uuid;
	private String userName;
	private String password;
	
	public UserAuth(int uuid, String userName, String password) {
		super();
		this.uuid = uuid;
		this.userName = userName;
		this.password = password;
	}

	public int getUuid() {
		return uuid;
	}

	public void setUuid(int uuid) {
		this.uuid = uuid;
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
	 

}
