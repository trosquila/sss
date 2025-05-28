package com.proyectoSSS.model.car.ManageCarModel;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.proyectoSSS.model.car.Car;
import com.proyectoSSS.model.dataBase.DatabaseConnection;

public class ManageCarModel implements IManageCarModel{
	private Connection connection;
	
	public ManageCarModel() throws ClassNotFoundException, SQLException, IOException {
		this.connection = DatabaseConnection.getConnection();
	}
	@Override
	public List<Car> getUserCars(int uuid) {
		List<Car>carList = new ArrayList<Car>();
		String query ="SELECT id, brand, model, licensePlate, engine, year, insuranceCompany FROM cars "
				+ "INNER JOIN owners on owners.car_id = cars.id "
				+ "INNER JOIN users on users.UUID = owners.user_uuid WHERE owners.user_uuid = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setInt(1, uuid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String brand = rs.getString(2);
				String model = rs.getString(3);
				String licensePlate = rs.getString(4);
				String engine = rs.getString(5);
				int year = rs.getInt(6);
				String insuranceCompany = rs.getString(7);
				Car car = new Car(id, brand, model, licensePlate ,engine,year, insuranceCompany);
				carList.add(car);
			}
			
			return carList;
		} catch (Exception e) {
			return null;
		}
	}

}
