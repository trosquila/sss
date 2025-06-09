<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="UTF-8">
		<title>Eliminar vehiculo</title>
		<link rel="stylesheet" type="text/css"
		href="${pageContext.request.contextPath}/static/css/style.css">
	</head>
	<body>
		<header></header>
		<section class="conetenedorPrincipal">
		<h1>Eliminar vehículo</h1>
			<div>
				<form action="${pageContext.request.contextPath}/ManageCarTableController" method="POST">
					<%String carPlate = request.getParameter("car");%>
					<input type="hidden" name="choose" value="4">
					<input type="hidden" name=licensePlate value="<%= carPlate %>">
					<div>
						<p>Seguro que desea eliminar el vehiculo con matricula <%= carPlate %> </p>
					</div>
					<div class="colocar2Botones">
						<button class="btn">Eliminar</button>
						<a href="${pageContext.request.contextPath}/ManageCar" class="btn1 txtEnlacebtn colocarBtnCreateCar">Volver</a>
					</div>
				</form>
			</div>
			<footer> </footer>
		</section>
	</body>
</html>