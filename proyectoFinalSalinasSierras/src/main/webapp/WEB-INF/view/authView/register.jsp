<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
		href="${pageContext.request.contextPath}/static/css/style.css">
<title>Gestor de vehiculos</title>
</head>
<body>
	<header> </header>
	<section class="contenedor">
		<h1>Cree una cuenta</h1>
		<form action="${pageContext.request.contextPath}/RegisterServlet"
			method="POST" class="contenedorInicioSesion">
			<div class="contenidoFormInicioSesion">
				<label>Nombre de usuario</label> <input type="text" name="userName">
			</div>
			<div class="contenidoFormInicioSesion">
				<label>Contraseña</label> <input type="password" name="password">
			</div>
			<div class="contenedorBtnForm2">
					<button class="loginBtn">Crear usuario</button>
					<a href="${pageContext.request.contextPath}/index.jsp">Volver</a>
				</div>
			<p>¿Ya tienes cuenta? <a href="${pageContext.request.contextPath}/LoginServlet">Inicia sesión aquí</a></p>
		</form>
		<%if (request.getAttribute("errorRegistro") != null){%>
			<div>
				<div class="alert"> <p><i class="fa fa-exclamation-triangle" aria-hidden="true"></i> <%= request.getAttribute("errorRegistro") %></p></div>
			</div>
		<%}%>
	</section>
	<footer>
	</footer>
</body>
</html>