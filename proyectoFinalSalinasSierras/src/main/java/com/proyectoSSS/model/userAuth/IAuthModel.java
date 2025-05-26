package com.proyectoSSS.model.userAuth;

public interface IAuthModel {

	boolean checkUser(String username);

	boolean InsertNewUser(UserAuth userAuth);

	String getPasswordForLogin(String string);

	UserAuth loadUser(String username);

}
