<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.proyectoSSS.model.car.Car" %>
<%
if (session == null) {
	response.sendRedirect(request.getContextPath() + "/index.jsp");
	return;
}

Integer uuid = (Integer) session.getAttribute("UUID");
if (uuid == null || uuid == 0) {
	response.sendRedirect(request.getContextPath() + "/index.jsp");
	return;
}
Car changeCar = (Car) request.getAttribute("changeCar");
%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="UTF-8">
		<title>Modificar un coche</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css">
	</head>
	<body>
		<header></header>
		<section class="conetenedorPrincipal">
			<h1>Editar vehiculo</h1>
			<div>
				<form action="${pageContext.request.contextPath}/ManageCarTableController" method="POST">
					<input type="hidden" name="choose" value="1">
					<div class="formulario">

							
							<label>Marca:</label>
							<input type="text"  name="brand" value="<%= changeCar.getBrand() %>">
							<label>Modelo:</label>
							<input type="text" name="model"  value="<%= changeCar.getBrand() %>">

							<label>Matricula:</label>
							<input type="text" name="licensePlate"  value="<%= changeCar.getLicensePlate() %>" readonly>
							<label>Motor:</label>
							<input type="text" name="engine" value="<%= changeCar.getEngine() %>">

							<label>Año:</label>
							<input type="number" name="year" value="<%= changeCar.getYear() %>">
							<label>Aseguradora:</label>
							<input type="text" name="insuranceCompany" value="<%= changeCar.getInsuranceCompany() %>">

					</div>
					<div class="colocarBtnForm">
						<button class="btn">Guardar</button>
						<input type="reset" value="Borrar" class="btn">
						<a href="${pageContext.request.contextPath}/ManageCar" class="btn1 txtEnlacebtn colocarBtnCreateCar">Volver</a>
					</div>
					
				</form>
			</div>
			<%
			if (request.getAttribute("upgrateOk") != null) {
			%>
				<p style="color: green;"><%=request.getAttribute("upgrateOk")%></p>
			<%
			}else if(request.getAttribute("upgrateError") != null){
			%>
				<p style="color: red;"><%=request.getAttribute("upgrateError")%></p>
			<%
			}
			
			%>
		</section>
		<footer> </footer>
	</body>
</html>