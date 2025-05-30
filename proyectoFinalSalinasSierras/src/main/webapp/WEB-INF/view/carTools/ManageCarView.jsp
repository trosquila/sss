<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List" %>
    <%@ page import="com.proyectoSSS.model.car.Car" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Administador de vehiculos</title>
		
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

	</head>
	<body>
		<section>
			<h1>listado de vehiculos en propiedad</h1>
			<table>
				<tr>
					<td>ID</td>
						<td>MARCA</td>
						<td>MODELO</td>
						<td>MATRÍCULA</td>
						<td>MOTOR</td>
						<td>AÑO</td>
						<td>ASEGURADORA</td>
						<td>EDITAR VEHÍCULO</td>
						<td>AÑADIR PROPIETARIO</td>
						<td>AÑADIR GASTOS</td>
						<td>ELIMINAR</td>
				</tr>
				
				<%
				//Object obj = request.getAttribute("carList");
				//da error porque lo detecta como ojeto en un principio no deberia fallar
				List<Car> carList = (List<Car>) request.getAttribute("carList");
				for(Car car : carList){
					%>
				<tr>
					<td><%= car.getId() %></td>
					<td><%= car.getBrand() %></td>
					<td><%= car.getModel() %></td>
					<td><%= car.getLicensePlate() %></td>
					<td><%= car.getEngine() %></td>
					<td><%= car.getYear() %></td>
					<td><%= car.getInsuranceCompany() %></td>
					<td><a href="${pageContext.request.contextPath}/ManageCarTableController?choose=1&car=<%= car.getLicensePlate() %>"><i class="fa fa-pencil" aria-hidden="true"></i></a></td>
					<td><a href="${pageContext.request.contextPath}/ManageCarTableController?choose=2&car=<%= car.getLicensePlate() %>"><i class="fa fa-user-plus" aria-hidden="true"></i></a></td>
					<td><a href="${pageContext.request.contextPath}/ManageCarTableController?choose=3&car=<%= car.getLicensePlate() %>"><i class="fa fa-bar-chart" aria-hidden="true"></i></a></td>
					<td><a href="${pageContext.request.contextPath}/ManageCarTableController?choose=4&car=<%= car.getLicensePlate() %>"><i class="fa fa-trash-o" aria-hidden="true"></i></a></td>
				</tr>
				<%}%>
				
			</table>
			<%String alertUpdateCarOk = (String) request.getAttribute("AlertUpdateCarOk"); 
			if (alertUpdateCarOk != null) { %>
   				<div class=""><%= alertUpdateCarOk %></div>
			<% } 
			String alertUpdateCarError = (String) request.getAttribute("AlertUpdateCarError"); 
			if (alertUpdateCarError != null) { %>
   				<div class=""><%= alertUpdateCarError %></div>
			<% }
			String alertAddUserToCarOk = (String) request.getAttribute("AlertAddUserToCarOk"); 
			if (alertUpdateCarError != null) { %>
   				<div class=""><%= alertAddUserToCarOk %></div>
			<% }
			%>
		</section>
	</body>
</html>