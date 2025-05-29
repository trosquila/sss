package com.proyectoSSS.model.car.ManageCarModel;

import java.util.List;

import com.proyectoSSS.model.car.Car;

public interface IManageCarModel {

	List<Car> getUserCars(int uuid);

	boolean updateCar(Car car);

	int searchCarId(String licensePlateAddOwner);

	boolean searchOwner(String owner);

	boolean insetNewOwnerInCar(int searchCarId, String owner);

}
