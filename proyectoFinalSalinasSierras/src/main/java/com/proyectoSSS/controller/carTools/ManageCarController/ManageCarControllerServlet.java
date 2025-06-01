package com.proyectoSSS.controller.carTools.ManageCarController;

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
		
		//miramos si la sesión esta activa para que la pagina no pete
		if (session == null || session.getAttribute("UUID") == null) {
		    response.sendRedirect(request.getContextPath() + "/WEB-INF/view/authView/login.jsp");
		    return;
		}
		//variables para recoger mensajes
		Object alertUpdateCarOk = session.getAttribute("AlertToTable");
		if (alertUpdateCarOk != null) {
		    request.setAttribute("AlertToTable", alertUpdateCarOk);
		    session.removeAttribute("AlertToTable"); // Muy importante: lo eliminas para que no se repita
		}
		
		//para que sea un numero ya que el id esint
		int uuid = (int) session.getAttribute("UUID");
		System.out.println("UUID: "+uuid);
		List  <Car> carList = new ArrayList <Car>();
		carList = manageCar.getUserCars(uuid);
		for(Car car : carList){
			System.out.println(car.toString());
		}
		
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
