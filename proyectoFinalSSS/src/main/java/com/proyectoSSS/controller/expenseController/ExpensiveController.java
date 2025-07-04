package com.proyectoSSS.controller.expenseController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.proyectoSSS.model.expenseModel.Expense;
import com.proyectoSSS.model.expenseModel.ExpensiveModel;
import com.proyectoSSS.model.expenseModel.IExpensiveModel;

/**
 * Servlet implementation class ExpensiveController
 */
@WebServlet("/ExpensiveController")
public class ExpensiveController extends HttpServlet {
	IExpensiveModel expensiveModel;
	private static final long serialVersionUID = 1L;
       
    /**
     * @throws IOException 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     * @see HttpServlet#HttpServlet()
     */
    public ExpensiveController() throws ClassNotFoundException, SQLException, IOException {
        super();
        expensiveModel = new ExpensiveModel();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String plate = request.getParameter("car");
		HttpSession session = request.getSession(false);
		
		//por si falla la sesión, en el  || lo convierte en string y mira si está vacia
		if (session == null || session.getAttribute("UUID") == null || session.getAttribute("UUID").toString().isEmpty()) {
			request.getRequestDispatcher("/WEB-INF/view/authView/login.jsp").forward(request, response);
		    return;
		}

		
		//para madar el error
		Object alertExpense = session.getAttribute("AlertExpensive");
		request.setAttribute("AlertExpensive", alertExpense);
		
		//para que sea un numero ya que el id es int
		int uuid = (int) session.getAttribute("UUID");
		List <Expense> expensiveList = new ArrayList<Expense>();
		
		expensiveList = expensiveModel.getCarExpense(plate, uuid);
		
		request.setAttribute("expensiveList", expensiveList);
	
		request.getRequestDispatcher("/WEB-INF/view/carTools/carExpenseView/carExpenseView.jsp?plate="+plate).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
