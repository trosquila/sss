package com.proyectoSSS.model.userAuth;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.proyectoSSS.model.dataBase.DatabaseConnection;



public class AuthModel implements IAuthModel{

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
	            System.out.println("Si encontrado");

				return true;
			} else {
	            return false;
	        }
		} catch (Exception e) {
            return false;
		}
		
	}
	
}
