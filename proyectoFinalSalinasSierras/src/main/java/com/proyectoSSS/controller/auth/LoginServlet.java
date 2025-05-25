package com.proyectoSSS.controller.auth;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
				//datos metidos por el user
				UserAuth userAuth = new UserAuth(username, password);
				//buscamos los datos en la bbdd para comparar contraseñas
				String buscarContra = authModel.getPasswordForLogin(userAuth.getUserName());
				
				boolean result = this.passwordEncryptor.checkPassword(userAuth.getPassword(), buscarContra);
				System.out.println(result);
				if(result == true) {
					request.getRequestDispatcher("/WEB-INF/view/home/home.jsp").forward(request, response);
				}else {
					request.setAttribute("errorLogin", "Error al iniciar sesión. Intente nuevamente.");
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/authView/login.jsp");
					dispatcher.forward(request, response);
				}
			} else {
				request.setAttribute("errorLogin", "Error al iniciar sesión. Intente nuevamente.");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/authView/login.jsp");
				dispatcher.forward(request, response);
			}

		} catch (Exception e) {
			request.setAttribute("errorLogin", "Error al iniciar sesión. Intente nuevamente.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/authView/login.jsp");
			dispatcher.forward(request, response);
		}

	}

}
