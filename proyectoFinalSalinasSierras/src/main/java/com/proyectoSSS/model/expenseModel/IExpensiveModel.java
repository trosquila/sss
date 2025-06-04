package com.proyectoSSS.model.expenseModel;

import java.util.List;

public interface IExpensiveModel {

	List<Expense> getCarExpense(String plate, int uuid);

	boolean insertExpensive(Expense expensive);

	Expense getExpensive(int expenseId);


	boolean updateExpense(Expense expensiveAdd, int idExpense);

}
