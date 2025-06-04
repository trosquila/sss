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
				<form action="${pageContext.request.contextPath}/ExpensiveTableController" method="POST">
					<%int expenseId = (int) request.getAttribute("expense");;%>
					<input type="hidden" name="choose" value="2">
					<input type="hidden" name=expenseId value="<%= expenseId %>">
					<div>
						<p>Seguro que desea eliminar el gasto?<%= expenseId %> </p>
					</div>
					<button>Eliminar</button>
					<a href="${pageContext.request.contextPath}/ExpensiveTableController">Volver</a>
				</form>
			</div>
			<footer> </footer>
		</section>
	</body>
