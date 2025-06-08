<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Gestor de vehiculos</title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css"
		href="${pageContext.request.contextPath}/static/css/style.css">
	</head>
	<body>
		<header> </header>
		<section class="contenedor">
			<h1>Inicio de sesión</h1>
			<form action="${pageContext.request.contextPath}/LoginServlet" method="POST" class="contenedorInicioSesion">
				<div class="contenidoFormInicioSesion">
					<label>Nombre de usuario:</label> <input type="text" name="userName">
				</div>
				<div class="contenidoFormInicioSesion">
					<label>Contraseña:</label> <input type="password" name="password">
				</div>
				<div class="contenedorBtnForm">
					<button class="loginBtn">Iniciar sesión</button>
				</div>
				<p class ="linkInico">¿No tienes cuenta? <a href="${pageContext.request.contextPath}/RegisterServlet">Regístrate aquí</a></p>
			</form>
			<%
		if (request.getAttribute("errorLogin") != null) {
		%>
		<div class="alert"> <p><i class="fa fa-exclamation-triangle" aria-hidden="true"></i> <%= request.getAttribute("errorLogin") %></p></div>
		<%
		}
		%>
		</section>
		
		<footer>
		</footer>
	</body>
</html>