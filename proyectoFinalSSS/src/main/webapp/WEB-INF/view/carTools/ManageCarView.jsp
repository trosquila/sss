<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List" %>
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
List<Car> carList = (List<Car>) request.getAttribute("carList");


%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css">
		<title>Administador de vehiculos</title>
	</head>
	<body>
		<header></header>
		<section class="contenedor">
		<h1>Listado de vehiculos en propiedad</h1>
		<%if(carList.isEmpty()){
		%>
			<p class="centrarTxt">No se encontro ningún vehiculo a su nombre, pruebe a agregar uno desde la sección de añadir vehiculo en el menú de inicio.</p>
		<%
		}else{
		%>
			<table class="tablaManageCar">
				<tr class="pintarTablaMange">
					<th>ID</th>
					<th>MARCA</th>
					<th>MODELO</th>
					<th>MATRÍCULA</th>
					<th>MOTOR</th>
					<th>AÑO</th>
					<th>ASEGURADORA</th>
					<th>EDITAR VEHÍCULO</th>
					<th>AÑADIR PROPIETARIO</th>
					<th>GESTIONAR GASTOS</th>
					<th>ELIMINAR</th>
				</tr>
				
				<%
				//Object obj = request.getAttribute("carList");
				//da error porque lo detecta como ojeto en un principio no deberia fallar
				int count = 0;
				for(Car car : carList){
					if(count%2 == 1) {
						%>
						<tr class="pintarTablaMange">
							<td><%= car.getId() %></td>
							<td><%= car.getBrand() %></td>
							<td><%= car.getModel() %></td>
							<td><%= car.getLicensePlate() %></td>
							<td><%= car.getEngine() %></td>
							<td><%= car.getYear() %></td>
							<td><%= car.getInsuranceCompany() %></td>
							<td class="btnTabla"><a href="${pageContext.request.contextPath}/ManageCarTableController?choose=1&car=<%= car.getLicensePlate() %>"><i class="fa fa-pencil" aria-hidden="true"></i></a></td>
							<td class="btnTabla"><a href="${pageContext.request.contextPath}/ManageCarTableController?choose=2&car=<%= car.getLicensePlate() %>"><i class="fa fa-user-plus" aria-hidden="true"></i></a></td>
							<td class="btnTabla"><a href="${pageContext.request.contextPath}/ManageCarTableController?choose=3&car=<%= car.getLicensePlate() %>"><i class="fa fa-bar-chart" aria-hidden="true"></i></a></td>
							<td class="btnTabla"><a href="${pageContext.request.contextPath}/ManageCarTableController?choose=4&car=<%= car.getLicensePlate() %>"><i class="fa fa-trash-o" aria-hidden="true"></i></a></td>
						</tr>
					<%}else
					{%>
						<tr>
							<td><%= car.getId() %></td>
							<td><%= car.getBrand() %></td>
							<td><%= car.getModel() %></td>
							<td><%= car.getLicensePlate() %></td>
							<td><%= car.getEngine() %></td>
							<td><%= car.getYear() %></td>
							<td><%= car.getInsuranceCompany() %></td>
							<td class="btnTabla"><a href="${pageContext.request.contextPath}/ManageCarTableController?choose=1&car=<%= car.getLicensePlate() %>"><i class="fa fa-pencil" aria-hidden="true"></i></a></td>
							<td class="btnTabla"><a href="${pageContext.request.contextPath}/ManageCarTableController?choose=2&car=<%= car.getLicensePlate() %>"><i class="fa fa-user-plus" aria-hidden="true"></i></a></td>
							<td class="btnTabla"><a href="${pageContext.request.contextPath}/ManageCarTableController?choose=3&car=<%= car.getLicensePlate() %>"><i class="fa fa-bar-chart" aria-hidden="true"></i></a></td>
							<td class="btnTabla"><a href="${pageContext.request.contextPath}/ManageCarTableController?choose=4&car=<%= car.getLicensePlate() %>"><i class="fa fa-trash-o" aria-hidden="true"></i></a></td>
						</tr>
					
					<%}
					count++;
				}%>
				
			</table>
		<%
		}
		 %>
			<div>
				<a href="${pageContext.request.contextPath}/ManageCar?goBack=true" class="btnSoloCentrado txtEnlacebtn">Volver</a>
			</div>
			<%String alertUpdateCarOk = (String) request.getAttribute("AlertToTable");
			if (alertUpdateCarOk != null) {
				String[] part = alertUpdateCarOk.split(",");
				if(part[0].equals("Informacion")){
				%>
   					<div class="info"> <p><i class="fa fa-info-circle" aria-hidden="true"></i> <%= part[1] %></p></div>
				<% }else if(part[0].equals("Alert")){
				%>
   					<div class="alert"> <p><i class="fa fa-exclamation-triangle" aria-hidden="true"></i> <%= part[1] %></p></div>
				<%
				}
			} %>
		</section>
		<footer> </footer>
	</body>
</html>