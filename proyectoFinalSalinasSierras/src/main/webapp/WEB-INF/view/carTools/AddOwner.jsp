<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="UTF-8">
		<title>Añadir un propietario</title>
		<link rel="stylesheet" type="text/css"
		href="${pageContext.request.contextPath}/static/css/style.css">
	</head>
	<body>
		<section>
			<div>
				<form action="${pageContext.request.contextPath}/ManageCarTableController" method="POST">
					<%String carPlate = request.getParameter("car");%>
					<input type="hidden" name="choose" value="2">
					<input type="hidden" name=licensePlate value="<%= carPlate %>">
					<div>
						<label>UUID de nuevo propietario</label>
						<input type="text"  name="newOwner">
					</div>
					<button>Guardar</button>
					<input type="reset" value="Borrar">
					<a href="${pageContext.request.contextPath}/ManageCar">Volver</a>
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