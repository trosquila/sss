<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Añadir un coche</title>
		<link rel="stylesheet" type="text/css"
		href="${pageContext.request.contextPath}/static/css/style.css">
	</head>
	<body>
		<header></header>
		<section class="conetenedorPrincipal">
		<h1>Añadir un vehiculo</h1>
			<div>
				<form action="${pageContext.request.contextPath}/AddCarController" method="POST">
					<div class="formulario">
						<label>Marca:</label>
						<input type="text"  name="brand">
						<label>Modelo:</label>
						<input type="text" name="model">
				
						<label>Matricula:</label>
						<input type="text" name="licensePlate">
						<label>Motor</label>
						<input type="text" name="engine">
				
						<label>Año:</label>
						<input type="number" name="year">
						<label>Aseguradora:</label>
						<input type="text" name="insuranceCompany">
					</div>
					<div class="colocarBtnForm">
						<button class="btn">Guardar</button>
						<input type="reset" value="Borrar" class="btn">
						<a href="${pageContext.request.contextPath}/ManageCar?goBack=true" class="btn1 txtEnlacebtn colocarBtnCreateCar">Volver</a>
					</div>
						
				</form>
			</div>
			<%
			if (request.getAttribute("saveCarOk") != null) {
			%>
				<p style="color: green;"><%=request.getAttribute("saveCarOk")%></p>
			<%
			}else if(request.getAttribute("saveCarFalse") != null){
			%>
				<p style="color: red;"><%=request.getAttribute("saveCarFalse")%></p>
			<%
			}
			
			%>
		</section>
		<footer> </footer>
	</body>
</html>