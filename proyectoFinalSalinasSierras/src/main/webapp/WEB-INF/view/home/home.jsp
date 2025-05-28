<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" type="text/css"
		href="${pageContext.request.contextPath}/static/css/style.css">
	</head>
	<body>
		<h1>Home</h1>
		<header> </header>
		<section class="menuHome">
			<div class ="colocarOpciones">
				<div>
					<a href="${pageContext.request.contextPath}/AddCarController">Añadir Vehiculo</a>
				</div>
				<div>
					<a href="${pageContext.request.contextPath}/MangeCar">Administrar mis vehiculos</a>
				</div>
				<div>
					<a href="${pageContext.request.contextPath}/SesionClose">Cerrar sesión</a>
				</div>
			</div>

		</section>
		<footer> </footer>
	</body>
</html>