<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Gestor de vehiculos</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css">
	</head>
	<body>
		<header>
		</header>
		<section class="contenedorPincipal">
			<h1>Inicio de sesión</h1>
			<form action="${pageContext.request.contextPath}/LoginServlet" method="POST">
				<div>
					<label>Nombre de usuario</label>
					<input type ="text" name="userName">
				</div>
				<div>
					<label>Contraseña</label>
					<input type="password" name="password">
				</div>
				<button type="submit">Iniciar sesión</button>
				<p>¿No tienes cuenta? <a href="${pageContext.request.contextPath}/RegisterServlet">Regístrate aquí</a></p>
			</form>
		</section>
		<%-- Mostrar error si existe --%>
    <% if(request.getAttribute("error") != null) { %>
        <p style="color: red;"><%= request.getAttribute("error") %></p>
    <% } %>
	</body>
</html>