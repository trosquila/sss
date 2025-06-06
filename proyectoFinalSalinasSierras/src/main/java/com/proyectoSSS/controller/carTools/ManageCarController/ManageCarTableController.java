package com.proyectoSSS.controller.carTools.ManageCarController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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
			request.getRequestDispatcher("/WEB-INF/view/carTools/ModifyCarView.jsp?car="+carPlate).forward(request, response);

			break;
		case 2:
				//se le manda a añadir propietario
			request.getRequestDispatcher("/WEB-INF/view/carTools/AddOwner.jsp?car="+carPlate).forward(request, response);
			
			break;
		case 3:
				//se le manda a añadir gastos
			response.sendRedirect("ExpensiveController?car="+carPlate);
			break;
		case 4:
				//se le manda a eliminar vehiculo
			request.getRequestDispatcher("/WEB-INF/view/carTools/DeleteCar.jsp?car="+carPlate).forward(request, response);
			
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
		//iniciamos una variable de sesión ya creada
		HttpSession session = request.getSession(false);
		switch (choose) {
		case 1:
			//editar vehiculo
			try {
				String brand = request.getParameter("brand");
				String model = request.getParameter("model");
				String licensePlate = request.getParameter("licensePlate");
				String engine = request.getParameter("engine");
				int year = Integer.parseInt(request.getParameter("year"));
				String insuranceCompany = request.getParameter("insuranceCompany");
				
				Car car = new Car(0, brand, model, licensePlate, engine, year, insuranceCompany);
				
				boolean updateCar = manageCar.updateCar(car);
				if (updateCar == true) {
					
					session.setAttribute("AlertToTable", "Información, el vehículo con matricula "+licensePlate+" fue actualizado correctamente");  
		
					response.sendRedirect("ManageCar");
					
				}else {
					session.setAttribute("AlertToTable", "Alert,El vehículo con matricula "+licensePlate+" no pudo ser actualizado");
					response.sendRedirect("ManageCar");
				} 
			}catch (Exception e) {
				session.setAttribute("AlertToTable", "Alert,Para el correcto cambio de valores en el vehículo se deben rellenar todos los campos");
				response.sendRedirect("ManageCar");
			}
			
			break;
		case 2:
			//añadir un propietario
			try {
				String licensePlateAddOwner = request.getParameter("licensePlate");			
				int searchCarId = manageCar.searchCarId(licensePlateAddOwner);
				
				//comprobamos que el user existe
				String owner = request.getParameter("newOwner");
				boolean searchOwner = manageCar.searchOwner(owner);
				if (searchOwner == true) {
					boolean addOwnerToCar = manageCar.insetNewOwnerInCar(searchCarId, owner);
					if(addOwnerToCar == true) {
						session.setAttribute("AlertToTable", "Informacion,El usuario con UUID "+owner+" fue agregado al vehiculo con matricula "+licensePlateAddOwner); 
						response.sendRedirect("ManageCar");
					}else {
						session.setAttribute("AlertToTable", "Alert,Hubo un error al asignar al usuario"); 
						response.sendRedirect("ManageCar");
					}
				}else {
					session.setAttribute("AlertToTable", "Alert,Hubo un error al asignar al usuario"); 
					response.sendRedirect("ManageCar");
				}
			} catch (Exception e) {
				session.setAttribute("AlertToTable", "Alert,Hubo un error al asignar al usuario"); 
				response.sendRedirect("ManageCar");
			}
			
			break;
		case 4:
				try {
					//se le manda a eliminar vehiculo
					String plateForDelete = request.getParameter("licensePlate");	
					int searchCarIdDelete = manageCar.searchCarId(plateForDelete);
					boolean deleteCar = manageCar.deleteCar(searchCarIdDelete);
					if (deleteCar == true) {
						session.setAttribute("AlertToTable", "Informacion,El vehiculo con matricula "+plateForDelete+" fue eliminado"); 
						response.sendRedirect("ManageCar");
					}else {
						session.setAttribute("AlertToTable", "Alert,Hubo un error al borrar el vehiculo"); 
						response.sendRedirect("ManageCar");
					}
				} catch (Exception e) {
					session.setAttribute("AlertToTable", "Alert,Hubo un error al borrar el vehiculo"); 
					response.sendRedirect("ManageCar");
				}
			break;
		
		default:
			session.setAttribute("AlertToTable", "Hubo un error fatal"); 
			response.sendRedirect("ManageCar");
		}
	}

}
