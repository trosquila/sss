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
			return list;
			
			
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public boolean insertExpensive(Expense expensive) {
		String query = "INSERT INTO carexpense(mileage, price, expenseConcept, idCar, idUser) VALUES (?,?,?,?,?) ";
		try {
			PreparedStatement ps1 = connection.prepareStatement(query);

			ps1.setInt(1, expensive.getMileage());
			ps1.setDouble(2, expensive.getPrice());
			ps1.setString(3, expensive.getExpenseConcept());
			ps1.setInt(4, expensive.getIdCar());
			ps1.setInt(5, expensive.getIdUser());
			ps1.executeUpdate();

			
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	@Override
	public Expense getExpensive(int expenseId) {
		String query = "SELECT  mileage, price, expenseConcept, idCar, idUser FROM carexpense WHERE idExpense = ?";

		try {
			PreparedStatement ps2 = connection.prepareStatement(query);
			List <Expense> list = new ArrayList <Expense>();
			ps2.setInt(1, expenseId);
			ResultSet rs = ps2.executeQuery();
			if(rs.next()) {
				int idExpense =expenseId; 
				int mileage = rs.getInt(2); 
				double price = rs.getDouble(3); 
				String expeseConcept = rs.getString(4);
				int idCar = rs.getInt(5);
				int idUser = rs.getInt(6);
				String date = "";
				Expense expense = new Expense(idExpense, mileage, price, expeseConcept, idCar, idUser, date);
				return expense;
			}
			
		}catch (Exception e) {
			return null;
		}
		return null;
		
	}


}
