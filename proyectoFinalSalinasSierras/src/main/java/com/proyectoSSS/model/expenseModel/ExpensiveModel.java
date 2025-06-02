package com.proyectoSSS.model.expenseModel;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.proyectoSSS.model.dataBase.DatabaseConnection;

public class ExpensiveModel implements IExpensiveModel{
	private Connection connection;
	public ExpensiveModel() throws ClassNotFoundException, SQLException, IOException {
		this.connection = DatabaseConnection.getConnection();
	}
	@Override
	public List<Expense> getCarExpense(String plate, int uuid) {
		String query = "SELECT idExpense, mileage, price, expenseConcept, idCar, idUser, date"
				+ " FROM carexpense "
				+ " INNER JOIN users ON users.UUID = carexpense.idUser"
				+ " WHERE users.UUID = ?";
		
		try {
			PreparedStatement ps2 = connection.prepareStatement(query);
			List <Expense> list = new ArrayList <Expense>();
			ps2.setInt(1, uuid);

			ResultSet rs = ps2.executeQuery();

			while(rs.next()) {
				int idExpense = rs.getInt(1); 
				int mileage = rs.getInt(2); 
				double price = rs.getDouble(3); 
				String expeseConcept = rs.getString(4);
				int idCar = rs.getInt(5);
				int idUser = rs.getInt(6);
				String date = rs.getString(7);
				Expense expense = new Expense(idExpense, mileage, price, expeseConcept, idCar, idUser, date);
				list.add(expense);
			}
			System.out.println("bien");
			return list;
			
			
		} catch (Exception e) {
			System.out.println("mal "+e);
			return null;
		}
	}


}
