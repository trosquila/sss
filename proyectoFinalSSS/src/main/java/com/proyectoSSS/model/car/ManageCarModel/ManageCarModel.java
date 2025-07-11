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
			//pruebo a cerrar la conexion porque en la tabla hay problemas
				if (rs != null) rs.close();
				if (ps != null) ps.close();
			return carList;
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public boolean updateCar(Car car) {
	    String query ="UPDATE cars SET brand=?, model=?, engine=?, year=?, insuranceCompany=? WHERE licensePlate = ?";
	    try {
	        PreparedStatement ps = connection.prepareStatement(query);
	        ps.setString(1, car.getBrand());
	        ps.setString(2, car.getModel());
	        ps.setString(3, car.getEngine());
	        ps.setInt(4, car.getYear());
	        ps.setString(5, car.getInsuranceCompany());
	        ps.setString(6, car.getLicensePlate());

	        ps.executeUpdate();
	       
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	    return true;
	}
	@Override
	public int searchCarId(String licensePlateAddOwner) {
		String query ="SELECT id FROM cars WHERE licensePlate = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, licensePlateAddOwner);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int licensePlate = rs.getInt(1);
				return licensePlate;
			}else {
				return -1;
			}
		} catch (Exception e) {
			return -1;
		}
	}
	@Override
	public boolean searchOwner(String owner) {
		
		String query ="SELECT UUID FROM users WHERE UUID = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, owner);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
	@Override
	public boolean insetNewOwnerInCar(int searchCarId, String owner, int uuidFirstOwner) {
		
	String query = "INSERT INTO owners (car_id, user_uuid, firstUser) VALUES (?, ?, ?)";
		
		try {
			PreparedStatement ps1 = connection.prepareStatement(query);

			ps1.setInt(1, searchCarId);
			ps1.setString(2, owner);
			ps1.setInt(3, uuidFirstOwner);

			ps1.executeUpdate();

		} catch (Exception e) {
			return false;
		}
		return true;
	}
	@Override
	public boolean deleteCar(int carId) {
		String query = "DELETE FROM owners WHERE car_id = ?";
		try {
			
			PreparedStatement ps1 = connection.prepareStatement(query);
			ps1.setInt(1, carId);
			ps1.executeUpdate();
			
			try {
				String query2 = "DELETE FROM cars WHERE id = ?";
				PreparedStatement ps2 = connection.prepareStatement(query2);
				ps2.setInt(1, carId);
				ps2.executeUpdate();
				
				try {
					String query3 = "DELETE FROM carexpense WHERE idCar = ?";
					PreparedStatement ps3 = connection.prepareStatement(query3);
					ps3.setInt(1, carId);
					ps3.executeUpdate();
					return true;
				} catch (Exception e) {
					return false;
				}
			} catch (Exception e) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		
	}
	@Override
	public Car getCarForEdit(String carPlate) {
		String query ="SELECT id, brand, model, licensePlate, engine, year, insuranceCompany FROM cars  WHERE licensePlate = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setString(1, carPlate);
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
				return car;
			}
			
		} catch (Exception e) {
			return null;
		}
		return null;
	}
	@Override
	public boolean checkFirstUser(int uuid, int searchCarId) {
		String query = "SELECT car_id, firstUser FROM owners WHERE car_id = ? AND firstUser = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, searchCarId);
			ps.setInt(2, uuid);

			ResultSet rs = ps.executeQuery();
			return rs.next();
			
		} catch (Exception e) {

			return false;
		}

	}


}
