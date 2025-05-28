package com.proyectoSSS.model.car;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.proyectoSSS.model.dataBase.DatabaseConnection;

public class CarModel implements ICarModel {
	private Connection connection;
	
	public CarModel () throws ClassNotFoundException, SQLException, IOException {
		this.connection = DatabaseConnection.getConnection();
	}
	
	@Override
	public boolean saveNewCar(Car car) {
		String searchplate = "SELECT licensePlate FROM cars WHERE licensePlate like ?";
		try {
			PreparedStatement ps2 = connection.prepareStatement(searchplate);

			ps2.setString(1, car.getLicensePlate());

			ResultSet rs = ps2.executeQuery();

			if (!rs.next()) {
				String query = "INSERT INTO cars (brand, model, licensePlate, engine, year, insuranceCompany) VALUES (?, ?, ?, ?, ?, ?)";

				try {
					PreparedStatement ps1 = connection.prepareStatement(query);

					ps1.setString(1, car.getBrand());
					ps1.setString(2, car.getModel());
					ps1.setString(3, car.getLicensePlate());
					ps1.setString(4, car.getEngine());
					ps1.setInt(5, car.getYear());
					ps1.setString(6, car.getInsuranceCompany());

					ps1.executeUpdate();

				} catch (Exception e) {
					return false;
				}
				return true;
				
			} else {
				return false;
			}
		}catch (Exception e) {
				return false;
			}
		
	}

	@Override
	public boolean assignOwner(String licensePlate, int uuid) {
		
		String searchplate = "SELECT id FROM cars WHERE licensePlate like ?";
		try {
			PreparedStatement ps = connection.prepareStatement(searchplate);

			ps.setString(1, licensePlate);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int idUser = rs.getInt(1);
				String query = "INSERT INTO owners (car_id, user_uuid) VALUES (?, ?)";

				try {
					PreparedStatement ps1 = connection.prepareStatement(query);

					ps1.setInt(1, idUser);
					ps1.setInt(2, uuid);

					ps1.executeUpdate();

				} catch (Exception e) {
					return false;
				}
				return true;
				
			} else {
				System.out.println("falla subiendo el owner");
				return false;
			}
		}catch (Exception e) {
			System.out.println("falla buscando la matricula");
			return false;
				
		}
	}

}
