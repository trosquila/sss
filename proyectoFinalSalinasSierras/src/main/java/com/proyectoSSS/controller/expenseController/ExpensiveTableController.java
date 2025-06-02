package com.proyectoSSS.controller.expenseController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ExpensiveTableController
 */
@WebServlet("/ExpensiveTableController")
public class ExpensiveTableController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExpensiveTableController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int choose = Integer.parseInt(request.getParameter("choose"));
		int expenseId = Integer.parseInt(request.getParameter("expenseexpense"));ç
		
		switch (choose) {
		case 1:
				//se le manda a edit expenseexpense
		

			break;
		case 2:
				//se le manda a añadir expense
			
			
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + choose);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
