 package com.proyectoSSS.controller.carTools;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

import com.proyectoSSS.model.car.Car;
import com.proyectoSSS.model.car.CarModel;
import com.proyectoSSS.model.car.ICarModel;

/**
 * Servlet implementation class AddCarController
 */
@WebServlet("/AddCarController")
public class AddCarControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ICarModel carModel;
       
    /**
     * @throws IOException 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     * @see HttpServlet#HttpServlet()
     */
    public AddCarControllerServlet() throws ClassNotFoundException, SQLException, IOException {
        super();
        carModel = new CarModel();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/createCarView/CreateCarView.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String brand = request.getParameter("brand");
		String model = request.getParameter("model");
		String licensePlate = request.getParameter("licensePlate");
		String engine = request.getParameter("engine");
		int year = Integer.parseInt(request.getParameter("year"));
		String insuranceCompany = request.getParameter("insuranceCompany");
		
		Car car = new Car(0, brand, model, licensePlate, engine, year, insuranceCompany);
		boolean resulInsertCar = carModel.saveNewCar(car);
		if (resulInsertCar == true) {
			HttpSession session = request.getSession(false);
			//para que sea un numero ya que el id esint
			int uuid = (int) session.getAttribute("UUID");
			boolean assignOwner = carModel.assignOwner(car.getLicensePlate(), uuid);
			try {
				if(assignOwner == true) {
					request.setAttribute("saveCarOk", "El vehiculo fue registrado.");
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/createCarView/CreateCarView.jsp");
					dispatcher.forward(request, response);
				}else {
					request.setAttribute("saveCarFalse", "Hubo un error al asignar el dueño, vuelva a intentarlo más tarde.");
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/createCarView/CreateCarView.jsp");
					dispatcher.forward(request, response);
				}
			} catch (Exception e) {
				request.setAttribute("saveCarFalse", "Hubo un error al asignar el dueño, vuelva a intentarlo más tarde.");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/createCarView/CreateCarView.jsp");
				dispatcher.forward(request, response);
			}
			
		}else {
			request.setAttribute("saveCarFalse", "Hubo un error al guardar el vehiculo.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/createCarView/CreateCarView.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
