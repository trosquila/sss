<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
					<%String carPlate = request.getParameter("car");%>
					<input type="hidden" name="choose" value="1">
					<div class="formulario">

							<label>Marca:</label>
							<input type="text"  name="brand">
							<label>Modelo:</label>
							<input type="text" name="model">

							<label>Matricula:</label>
							<input type="text" name="licensePlate" value="<%= carPlate %>" readonly>
							<label>Motor:</label>
							<input type="text" name="engine">

							<label>Año:</label>
							<input type="number" name="year">
							<label>Aseguradora:</label>
							<input type="text" name="insuranceCompany">

					</div>
					<div class="colocarBtnForm">
						<button class="btn">Guardar</button>
						<input type="reset" value="Borrar" class="btn1">
						<a href="${pageContext.request.contextPath}/ManageCar" class="btn txtEnlacebtn colocarBtnCreateCar">Volver</a>
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