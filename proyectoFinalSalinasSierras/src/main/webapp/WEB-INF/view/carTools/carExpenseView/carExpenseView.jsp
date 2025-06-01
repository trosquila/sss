<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Integer uuid = (Integer) session.getAttribute("UUID");
System.out.println("UUID en CarExpenseView "+uuid);
if (uuid == null || uuid == 0) { // Ajusta según el valor esperado para una sesión inválida
	response.sendRedirect("/WEB-INF/index.jsp");
}

%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<header></header>
		<section class="contenedor">
			<h1>Menú de gastos</h1>
			<h3>Matrícula del vehiculo: </h3>
			<div>
				<a href="">Añadir Gasto</a>
			</div>
			<table>
			
			</table>
		</section>
		<footer> </footer>
	</body>
</html>