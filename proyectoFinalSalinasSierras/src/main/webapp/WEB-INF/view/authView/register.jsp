<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestor de vehiculos</title>
</head>
<body>
	<section>
		<h1>Inicio de sesión</h1>
		<form action="${pageContext.request.contextPath}/RegisterServlet"
			method="POST">
			<div>
				<label>Nombre de usuario</label> <input type="text" name="userName">
			</div>
			<div>
				<label>Contraseña</label> <input type="password" name="password">
			</div>
			<button type="submit">Iniciar sesión</button>
			<p>
				¿Ya tienes cuenta? <a href="${pageContext.request.contextPath}/LoginServlet">Inicia sesión aquí</a>
			</p>
		</form>
	</section>
</body>
</html>