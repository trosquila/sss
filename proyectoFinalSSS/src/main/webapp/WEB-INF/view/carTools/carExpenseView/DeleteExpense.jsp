<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%    
//lo pongo en string porq en int no me deja verificarlo bien
Integer uuid = (Integer) session.getAttribute("UUID");
if (uuid == null || uuid == 0) { // Ajusta según el valor esperado para una sesión inválida
	response.sendRedirect("/WEB-INF/index.jsp");
}
String plate = request.getParameter("plate"); %>
    
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
		<section  class="contenedor">
			<h1>Eliminar gasto</h1>
			<div>
				<form action="${pageContext.request.contextPath}/ExpensiveTableController" method="POST">
					<%int expenseId = (int) request.getAttribute("expense");%>
					<input type="hidden" name="choose" value="2">
					<input type="hidden" name=expenseId value="<%= expenseId %>">
					<div>
						<p class="centrarTxt">Seguro que desea eliminar el gasto? ID: <%= expenseId %> </p>
					</div>
					<div class ="colocarBtnForm">
						<button class="btn">Eliminar</button>
						<a href="${pageContext.request.contextPath}/ExpensiveController?car=<%=plate %>" class="btn1 txtEnlacebtn colocarBtnCreateCar">Volver</a>
					</div>
				</form>
			</div>
		</section>
		<footer> </footer>
	</body>
</html>