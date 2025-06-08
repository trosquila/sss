<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	 
//lo pongo en string porq en int no me deja verificarlo bien
Integer uuid = (Integer) session.getAttribute("UUID");
if (uuid == null || uuid == 0) { // Ajusta según el valor esperado para una sesión inválida
	response.sendRedirect("/WEB-INF/index.jsp");
}
%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="UTF-8">
		<title>Añadir un propietario</title>
		<link rel="stylesheet" type="text/css"
		href="${pageContext.request.contextPath}/static/css/style.css">
	</head>
	<body>		
		<header></header>
		<section class="conetenedorPrincipal">
			<h1>Añadir un propietario al vehiculo</h1>
			<div>
				<form action="${pageContext.request.contextPath}/ManageCarTableController" method="POST">
					<%String carPlate = request.getParameter("car");%>
					<input type="hidden" name="choose" value="2">
					<input type="hidden" name=licensePlate value="<%= carPlate %>">
					<div>
						<label>UUID de nuevo propietario</label>
						<input type="text"  name="newOwner">
					</div>
					<div class="colocarBtnForm">
						<button  class="btn">Guardar</button>
						<input type="reset" value="Borrar"  class="btn">
						<a href="${pageContext.request.contextPath}/ManageCar" class="btn1 txtEnlacebtn colocarBtnCreateCar">Volver</a>
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