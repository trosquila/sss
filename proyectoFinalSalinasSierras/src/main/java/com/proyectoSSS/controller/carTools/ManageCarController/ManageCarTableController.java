package com.proyectoSSS.controller.carTools.ManageCarController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.proyectoSSS.model.car.Car;
import com.proyectoSSS.model.car.ManageCarModel.IManageCarModel;
import com.proyectoSSS.model.car.ManageCarModel.ManageCarModel;

/**
 * Servlet implementation class ManageCarTableController
 */
@WebServlet("/ManageCarTableController")
public class ManageCarTableController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IManageCarModel manageCar;
	
    /**
     * @throws IOException 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     * @see HttpServlet#HttpServlet()
     */
    public ManageCarTableController() throws ClassNotFoundException, SQLException, IOException {
        super();
        manageCar = new ManageCarModel();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int choose = Integer.parseInt(request.getParameter("choose"));
		String carPlate =request.getParameter("car");
		
		switch (choose) {
		case 1:
				//se le manda a edit car
				request.getRequestDispatcher("/WEB-INF/view/carTools/ModifyCarView.jsp?car=\"+carPlate").forward(request, response);

			break;
		case 2:
				//se le manda a añadir propietario
				request.getRequestDispatcher("/WEB-INF/view/carTools/AddOwner.jsp?car="+carPlate).forward(request, response);
			
			break;
		case 3:
				//se le manda a añadir gastos
			break;
		case 4:
				//se le manda a eliminar vehiculo
			break;
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + choose);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int choose = Integer.parseInt(request.getParameter("choose"));
		
		switch (choose) {
		case 1:
			String brand = request.getParameter("brand");
			String model = request.getParameter("model");
			String licensePlate = request.getParameter("licensePlate");
			String engine = request.getParameter("engine");
			int year = Integer.parseInt(request.getParameter("year"));
			String insuranceCompany = request.getParameter("insuranceCompany");
			
			Car car = new Car(0, brand, model, licensePlate, engine, year, insuranceCompany);
			
			boolean updateCar = manageCar.updateCar(car);
			if (updateCar == true) {
				System.out.println("weno");
			}else {
				System.out.println("me mato");
			}
			break;
		case 2:
			//conseguimos el id del coche
			String licensePlateAddOwner = request.getParameter("licensePlate");			
			int searchCarId = manageCar.searchCarId(licensePlateAddOwner);
			
			//comprobamos que el user existe
			String owner = request.getParameter("newOwner");
			boolean searchOwner = manageCar.searchOwner(owner);
			if (searchOwner == true) {
				boolean addOwnerToCar = manageCar.insetNewOwnerInCar(searchCarId, owner);
				if(addOwnerToCar == true) {
					System.out.println("furrula");
				}else {
					//mensaje de error
					System.out.println("error 1");
				}
			}else {
				//mensaje de error
				System.out.println("error 2");
			}
			
			break;
		case 3:
				//se le manda a añadir gastos
			break;
		case 4:
				//se le manda a eliminar vehiculo
			break;
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + choose);
		}
	}

}
