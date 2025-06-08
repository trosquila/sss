package com.proyectoSSS.model.car;

public class Car {
	private int id;
	private String brand;
	private String model;
	private String licensePlate;
	private String engine;
	private int year;
	private String insuranceCompany;
	
	public Car(int id, String brand, String model, String licensePlate, String engine, int year, String insuranceCompany) {
		//super();
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.licensePlate = licensePlate;
		this.engine = engine;
		this.year = year;
		this.insuranceCompany = insuranceCompany;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getInsuranceCompany() {
		return insuranceCompany;
	}

	public void setInsuranceCompany(String insuranceCompany) {
		this.insuranceCompany = insuranceCompany;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", brand=" + brand + ", model=" + model + ", licensePlate=" + licensePlate
				+ ", engine=" + engine + ", year=" + year + ", insuranceCompany=" + insuranceCompany + "]";
	}
	
	
}
