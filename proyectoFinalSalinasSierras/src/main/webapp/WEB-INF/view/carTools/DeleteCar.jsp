<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="UTF-8">
		<title>Eliminar vehiculo</title>
		<link rel="stylesheet" type="text/css"
		href="${pageContext.request.contextPath}/static/css/style.css">
	</head>
	<body>
		<section>
			<div>
				<form action="${pageContext.request.contextPath}/ManageCarTableController" method="POST">
					<%String carPlate = request.getParameter("car");%>
					<input type="hidden" name="choose" value="4">
					<input type="hidden" name=licensePlate value="<%= carPlate %>">
					<div>
						<p>Seguro que desea eliminar el vehiculo con matricula <%= carPlate %> </p>
					</div>
					<button>Eliminar</button>
					<a href="${pageContext.request.contextPath}/ManageCar">Volver</a>
				</form>
			</div>
			<footer> </footer>
		</section>
	</body>
</html>