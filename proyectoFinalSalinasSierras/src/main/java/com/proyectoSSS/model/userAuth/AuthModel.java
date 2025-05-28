package com.proyectoSSS.model.userAuth;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.proyectoSSS.model.dataBase.DatabaseConnection;


public class AuthModel implements IAuthModel {

	private Connection connection;

	public AuthModel() throws ClassNotFoundException, SQLException, IOException {

		this.connection = DatabaseConnection.getConnection();
	}

	@Override
	public boolean checkUser(String username) {
		String query = "SELECT UserName, password FROM users WHERE UserName like ?";

		try {
			PreparedStatement ps2 = connection.prepareStatement(query);

			ps2.setString(1, username);

			ResultSet rs = ps2.executeQuery();

			if (rs.next()) {

				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public boolean InsertNewUser(UserAuth userAuth) {
		String query = "INSERT INTO users (UserName, password) VALUES (?, ?)";
		
		try {
			PreparedStatement ps1 = connection.prepareStatement(query);

			ps1.setString(1, userAuth.getUserName());
			ps1.setString(2, userAuth.getPassword());

			ps1.executeUpdate();

			
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	@Override
	public String getPasswordForLogin(String userName) {
		String query = "SELECT password FROM users WHERE UserName like ?";
		try {
			PreparedStatement ps2 = connection.prepareStatement(query);

			ps2.setString(1, userName);

			ResultSet rs = ps2.executeQuery();

			if (rs.next()) {
				String password = rs.getString(1);
				return password;
			}else {
				return null;
			}
			
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public UserAuth loadUser(String username) {
		String query = "SELECT UUID, UserName, password FROM users WHERE UserName like ?";

		try {
			PreparedStatement ps2 = connection.prepareStatement(query);

			ps2.setString(1, username);

			ResultSet rs = ps2.executeQuery();

			if (rs.next()) {
				int uuid = rs.getInt(1);
				String user = rs.getString(1);
				String password = rs.getString(3);
				UserAuth loadUser = new UserAuth(uuid, user, password);

				return loadUser;
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}

}
