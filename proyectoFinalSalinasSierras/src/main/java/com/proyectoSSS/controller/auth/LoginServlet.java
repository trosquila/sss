package com.proyectoSSS.controller.auth;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

import org.jasypt.util.password.StrongPasswordEncryptor;

import com.proyectoSSS.model.userAuth.AuthModel;
import com.proyectoSSS.model.userAuth.IAuthModel;
import com.proyectoSSS.model.userAuth.UserAuth;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StrongPasswordEncryptor passwordEncryptor;
	IAuthModel authModel;

	/**
	 * @throws IOException
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() throws ClassNotFoundException, SQLException, IOException {
		super();
		authModel = new AuthModel();
		this.passwordEncryptor = new StrongPasswordEncryptor();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/authView/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String username = request.getParameter("userName");
			String password = request.getParameter("password");
			boolean checkUser = authModel.checkUser(username);

			// si no hay ningun usuario con ese nombre lo guardamos sino lanzamos un error
			if (checkUser == true) {
				UserAuth userAuth = new UserAuth(0,username, password);
				String searchPassword = authModel.getPasswordForLogin(userAuth.getUserName());
				
				boolean result = this.passwordEncryptor.checkPassword(userAuth.getPassword(), searchPassword);
				
				//si lo encuentra saca el user entero
				if(result == true) {
					UserAuth loadUser = authModel.loadUser(username);
					//si no hay ningun problema inica sesión
					if(loadUser != null) {
						HttpSession session = request.getSession(); 
					    session.setAttribute("UUID", loadUser.getUuid()); 
					    session.setAttribute("UserName", loadUser.getUserName()); 
					    session.setMaxInactiveInterval(1800); 
						request.getRequestDispatcher("/WEB-INF/view/home/home.jsp").forward(request, response);
					}else {
						request.setAttribute("errorLogin", "Error al iniciar sesión. Intente nuevamente.");
						RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/authView/login.jsp");
						dispatcher.forward(request, response);
						System.out.println("1");
					}
					
				}else {
					request.setAttribute("errorLogin", "Error al iniciar sesión. Intente nuevamente.");
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/authView/login.jsp");
					dispatcher.forward(request, response);
					System.out.println("2");
				}
			} else {
				request.setAttribute("errorLogin", "Error al iniciar sesión. Intente nuevamente.");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/authView/login.jsp");
				dispatcher.forward(request, response);
				System.out.println("3");
			}

		} catch (Exception e) {
			request.setAttribute("errorLogin", "Error al iniciar sesión. Intente nuevamente.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/authView/login.jsp");
			dispatcher.forward(request, response);
			System.out.println("4 "+ e);
		}

	}

}
