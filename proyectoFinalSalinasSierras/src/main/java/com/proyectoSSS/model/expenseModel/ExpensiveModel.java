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
		String query = "SELECT idExpense, mileage, price, expenseConcept, idCar, idUser, date  FROM carexpense INNER JOIN users ON users.UUID = carexpense.idUser INNER JOIN cars on cars.id = carexpense.idCar WHERE users.UUID = ? AND cars.licensePlate LIKE ?";
		
		try {
			PreparedStatement ps2 = connection.prepareStatement(query);
			List <Expense> list = new ArrayList <Expense>();
			ps2.setInt(1, uuid);
			ps2.setString(2, plate);

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
			ps2.setInt(1, expenseId);
			ResultSet rs = ps2.executeQuery();
			if(rs.next()) {
				int mileage = rs.getInt(1); 
				int price = rs.getInt(2); 
				String expenseConcept = rs.getString(3);
				int idCar = rs.getInt(4);
				int idUser = rs.getInt(5);
				Expense expense = new Expense(expenseId, mileage, price, expenseConcept, idCar, idUser, "");
				System.out.println("Model: id "+expenseId+" Gasto: "+expense.toString());
				return expense;
				
			}
			
		}catch (Exception e) {
			System.out.println(e);
			return null;
		}
		return null;
		
	}
	@Override
	public boolean updateExpense(Expense expensiveAdd, int idExpense) {
		String query = "UPDATE carexpense SET mileage=?,price=?,expenseConcept=?,idCar=?,idUser=? WHERE idExpense =?";
		try {
			PreparedStatement ps1 = connection.prepareStatement(query);

			ps1.setInt(1, expensiveAdd.getMileage());
			ps1.setDouble(2, expensiveAdd.getPrice());
			ps1.setString(3, expensiveAdd.getExpenseConcept());
			ps1.setInt(4, expensiveAdd.getIdCar());
			ps1.setInt(5, expensiveAdd.getIdUser());
			ps1.setInt(6, idExpense);
			ps1.executeUpdate();

			
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	@Override
	public boolean deleteExpense(int idExpense) {
		String query = "DELETE FROM carexpense WHERE idExpense = ?";
		try {
			
			PreparedStatement ps1 = connection.prepareStatement(query);
			ps1.setInt(1, idExpense);
			ps1.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		return true;
	}


}
