package com.proyectoSSS.controller.expenseController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

import com.proyectoSSS.model.expenseModel.Expense;
import com.proyectoSSS.model.expenseModel.ExpensiveModel;
import com.proyectoSSS.model.expenseModel.IExpensiveModel;

/**
 * Servlet implementation class ExpensiveTableController
 */
@WebServlet("/ExpensiveTableController")
public class ExpensiveTableController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IExpensiveModel expensiveModel;
       
    /**
     * @throws IOException 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     * @see HttpServlet#HttpServlet()
     */
    public ExpensiveTableController() throws ClassNotFoundException, SQLException, IOException {
        super();
        expensiveModel = new ExpensiveModel();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int choose = Integer.parseInt(request.getParameter("choose"));
		
		
		switch (choose) {
		case 1:
				//se le manda a edit expenseexpense
			int expenseId = Integer.parseInt(request.getParameter("expense"));
			Expense expensive = expensiveModel.getExpensive(expenseId);
			request.setAttribute("expensive", expensive);
			request.getRequestDispatcher("/WEB-INF/view/carTools/carExpenseView/EditExpenseView.jsp").forward(request, response);
			break;
		case 2:
				//se le manda a añadir expense
			 expenseId = Integer.parseInt(request.getParameter("expenseexpense"));
			 
			
			break;
		case 3:
			String plate = request.getParameter("plate");
			request.getRequestDispatcher("/WEB-INF/view/carTools/carExpenseView/AddExpenseView.jsp?plate="+plate).forward(request, response);
			
		
		
		break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + choose);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		//miramos si la sesión esta activa para que la pagina no pete
		if (session.getAttribute("UUID") == null || session.getAttribute("UUID") == "") {
		    response.sendRedirect(request.getContextPath() + "/WEB-INF/view/authView/login.jsp");
		    return;
		}
		
		int choose = Integer.parseInt(request.getParameter("choose"));
		String plate = request.getParameter("plate");
		int mileage;
		int price;
	    String expenseConcept;
	    int idCar;
        int idUser = (int) session.getAttribute("UUID");
        
        switch (choose) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			mileage = Integer.parseInt(request.getParameter("mileage"));
			price = Integer.parseInt(request.getParameter("price"));
			expenseConcept = request.getParameter("expenseConcept");
			idCar = Integer.parseInt(request.getParameter("idCar"));
	        Expense expensive = new Expense(0, mileage, price, expenseConcept, idCar, idUser, "");
	        boolean insertExpensive = expensiveModel.insertExpensive(expensive);
	        System.out.println(expensive.toString());
	        System.out.println(choose);
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + choose);
		}
		
	}

}
