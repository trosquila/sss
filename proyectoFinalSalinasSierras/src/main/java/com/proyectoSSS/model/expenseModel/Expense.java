package com.proyectoSSS.model.expenseModel;

public class Expense {
	private int expenseId;
	private int mileage;
	private double price;
	private String expenseConcept;
	private int idCar;
	private int idUser;
	private String date;
	
	public Expense(int expenseId, int mileage, double price, String expenseConcept, int idCar, int idUser, String date) {
		//super();
		this.expenseId = expenseId;
		this.mileage = mileage;
		this.price = price;
		this.expenseConcept = expenseConcept;
		this.idCar = idCar;
		this.idUser = idUser;
		this.date = date;
	}
	public int getExpenseId() {
		return expenseId;
	}
	public void setExpenseId(int expenseId) {
		this.expenseId = expenseId;
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getExpenseConcept() {
		return expenseConcept;
	}
	public void setExpenseConcept(String expenseConcept) {
		this.expenseConcept = expenseConcept;
	}
	public int getIdCar() {
		return idCar;
	}
	public void setIdCar(int idCar) {
		this.idCar = idCar;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	
}