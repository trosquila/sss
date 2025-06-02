<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List, com.proyectoSSS.model.expenseModel.Expense" %>
<%

Integer uuid = (Integer) session.getAttribute("UUID");
System.out.println("UUID en CarExpenseView "+uuid);
if (uuid == null || uuid == 0) { // Ajusta según el valor esperado para una sesión inválida
	response.sendRedirect("/WEB-INF/index.jsp");
}

List<Expense> expensiveList = (List<Expense>) request.getAttribute("expensiveList");
if(expensiveList.isEmpty()){
	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/home/Home.jsp");
	dispatcher.forward(request, response);
}
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css">
		<title>Gastos del vehiculo</title>
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
				<tr class="pintarTablaMange">
						<th>ID</th>
						<th>KILOMETRAJE</th>
						<th>PRECIO</th>
						<th>CONCEPTO</th>
						<th>ID VEHICULO</th>
						<th>UUID USUARIO</th>
						<th>FECHA DE REALIZACIÓN</th>
						<th>EDITAR GASTO</th>
						<th>ELIMINAR GASTO</th>
					</tr>
				<%
				//Object obj = request.getAttribute("carList");
				//da error porque lo detecta como ojeto en un principio no deberia fallar
				int count = 0;
				for(Expense expense :expensiveList){
					if(count%2 == 1) {
						%>
						<tr class="pintarTablaMange">
							<td><%= expense.getExpenseId() %></td>
							<td><%= expense.getMileage() %></td>
							<td><%= expense.getPrice() %></td>
							<td><%= expense.getExpenseConcept() %></td>
							<td><%= expense.getIdCar() %></td>
							<td><%= expense.getIdUser() %></td>
							<td><%= expense.getDate() %></td>
							<td class="btnTabla"><a href="${pageContext.request.contextPath}/ExpensiveTableController?choose=1&expense=<%= expense.getExpenseId() %>"><i class="fa fa-pencil" aria-hidden="true"></i></a></td>
							<td class="btnTabla"><a href="${pageContext.request.contextPath}/ExpensiveTableController?choose=2&expense=<%= expense.getExpenseId() %>"><i class="fa fa-user-plus" aria-hidden="true"></i></a></td>
						</tr>
					<%}else
					{%>
						<tr>
							<td><%= expense.getExpenseId() %></td>
							<td><%= expense.getMileage() %></td>
							<td><%= expense.getPrice() %></td>
							<td><%= expense.getExpenseConcept() %></td>
							<td><%= expense.getIdCar() %></td>
							<td><%= expense.getIdUser() %></td>
							<td><%= expense.getDate() %></td>
							<td class="btnTabla"><a href="${pageContext.request.contextPath}/ExpensiveTableController?choose=1&expense=<%= expense.getExpenseId() %>"><i class="fa fa-pencil" aria-hidden="true"></i></a></td>
							<td class="btnTabla"><a href="${pageContext.request.contextPath}/ExpensiveTableController?choose=2&expense=<%= expense.getExpenseId() %>"><i class="fa fa-user-plus" aria-hidden="true"></i></a></td>
						</tr>
					<%}
					count++;
				}%>
			</table>
		</section>
		<footer> </footer>
	</body>
</html>