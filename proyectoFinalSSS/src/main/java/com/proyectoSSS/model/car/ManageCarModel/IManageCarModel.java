package com.proyectoSSS.model.car.ManageCarModel;

import java.util.List;

import com.proyectoSSS.model.car.Car;

public interface IManageCarModel {

	List<Car> getUserCars(int uuid);

	boolean updateCar(Car car);

	int searchCarId(String licensePlateAddOwner);

	boolean searchOwner(String owner);

	boolean insetNewOwnerInCar(int searchCarId, String owner, int uuid);

	boolean deleteCar(int searchCarIdDelete);

	Car getCarForEdit(String carPlate);

	boolean checkFirstUser(int uuid, int searchCarId);

}
