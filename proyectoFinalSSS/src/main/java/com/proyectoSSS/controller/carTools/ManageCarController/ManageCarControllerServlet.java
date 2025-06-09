package com.proyectoSSS.controller.carTools.ManageCarController;

import jakarta.servlet.RequestDispatcher;
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

import com.proyectoSSS.model.car.Car;
import com.proyectoSSS.model.car.ManageCarModel.IManageCarModel;
import com.proyectoSSS.model.car.ManageCarModel.ManageCarModel;

/**
 * Servlet implementation class ManageCarServlet
 */
@WebServlet("/ManageCar")
public class ManageCarControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IManageCarModel manageCar;

       
    /**
     * @throws IOException 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     * @see HttpServlet#HttpServlet()
     */
    public ManageCarControllerServlet() throws ClassNotFoundException, SQLException, IOException {
        super();
        manageCar = new ManageCarModel();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		//nos permite ir al home si le damos al btn de volver de addCar
		String goBack = request.getParameter("goBack");
		if ("true".equals(goBack)) {  // Validación segura
		    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/home/Home.jsp");
		    dispatcher.forward(request, response);
		    return;
		}
		
		//por si falla la sesión, en el  || lo convierte en string y mira si está vacia
		if (session == null || session.getAttribute("UUID") == null || session.getAttribute("UUID").toString().isEmpty()) {
		    response.sendRedirect(request.getContextPath() + "/WEB-INF/view/authView/login.jsp");
		    return;
		}

		
		//variables para recoger mensajes
		Object alertUpdateCarOk = session.getAttribute("AlertToTable");
		if (alertUpdateCarOk != null) {
		    request.setAttribute("AlertToTable", alertUpdateCarOk);
		    session.removeAttribute("AlertToTable");
		}
		
		//para que sea un numero ya que el id es int
		int uuid = (int) session.getAttribute("UUID");
		List  <Car> carList = new ArrayList <Car>();
		carList = manageCar.getUserCars(uuid);
	
		
		request.setAttribute("carList", carList);
		request.getRequestDispatcher("/WEB-INF/view/carTools/ManageCarView.jsp").forward(request, response);


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
