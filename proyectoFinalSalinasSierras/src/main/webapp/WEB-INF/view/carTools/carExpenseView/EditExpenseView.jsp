<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ page import="java.util.List, com.proyectoSSS.model.expenseModel.Expense" %>
    <%
    String plate = request.getParameter("plate");
    Expense expense = (Expense) request.getAttribute("expensive");
    %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Editar gasto</title>
	</head>
	<body>
		<header></header>
		<section>
			<div>
				<form action="${pageContext.request.contextPath}/ExpensiveTableController" method="POST">
				<input type="hidden" name="choose" value="3">
				<input type="hidden" name="plate" value="<%=plate %>">
					<div>
						<label>Kilometraje</label>
						<input type="text"  name="mileage" value="<%= expense.getMileage()%>">
						<label>precio</label>
						<input type="text" name="price" value="<%= expense.getIdCar()%>">
					</div>
					<div>
						<label>Concepto</label>
						<select name="expenseConcept">
						    <option value="Aceite" <%= expense.getExpenseConcept().equals("Aceite") ? "selected" : "" %>>Aceite</option>
						    <option value="Gasolina" <%= expense.getExpenseConcept().equals("Gasolina") ? "selected" : "" %>>Gasolina</option>
						    <option value="Cambio de neumáticos" <%= expense.getExpenseConcept().equals("Cambio de neumáticos") ? "selected" : "" %>>Cambio de neumáticos</option>
						    <option value="Revisión general" <%= expense.getExpenseConcept().equals("Revisión general") ? "selected" : "" %>>Revisión general</option>
						    <option value="Frenos" <%= expense.getExpenseConcept().equals("Frenos") ? "selected" : "" %>>Frenos</option>
						    <option value="Batería" <%= expense.getExpenseConcept().equals("Batería") ? "selected" : "" %>>Batería</option>
						    <option value="Seguro" <%= expense.getExpenseConcept().equals("Seguro") ? "selected" : "" %>>Seguro</option>
						    <option value="ITV" <%= expense.getExpenseConcept().equals("ITV") ? "selected" : "" %>>ITV</option>
						    <option value="Cambio de filtros" <%= expense.getExpenseConcept().equals("Cambio de filtros") ? "selected" : "" %>>Cambio de filtros</option>
						    <option value="Reparaciones mecánicas" <%= expense.getExpenseConcept().equals("Reparaciones mecánicas") ? "selected" : "" %>>Reparaciones mecánicas</option>
						    <option value="Cambio de luces" <%= expense.getExpenseConcept().equals("Cambio de luces") ? "selected" : "" %>>Cambio de luces</option>
						    <option value="Alineación y balanceo" <%= expense.getExpenseConcept().equals("Alineación y balanceo") ? "selected" : "" %>>Alineación y balanceo</option>
						    <option value="Lavado y mantenimiento estético" <%= expense.getExpenseConcept().equals("Lavado y mantenimiento estético") ? "selected" : "" %>>Lavado y mantenimiento estético</option>
						    <option value="Sistema eléctrico" <%= expense.getExpenseConcept().equals("Sistema eléctrico") ? "selected" : "" %>>Sistema eléctrico</option>
						    <option value="Cambio de líquidos refrigerantes" <%= expense.getExpenseConcept().equals("Cambio de líquidos refrigerantes") ? "selected" : "" %>>Cambio de líquidos refrigerantes</option>
						    <option value="Amortiguadores y suspensión" <%= expense.getExpenseConcept().equals("Amortiguadores y suspensión") ? "selected" : "" %>>Amortiguadores y suspensión</option>
						</select>
					</div>
					<div>
						<label>ID del vehiculo</label>
						<input type="number" name="idCar"  value="<%= expense.getIdCar()%>">
					</div>
					<button>Guardar</button>
					<input type="reset" value="Borrar">
					<a href="${pageContext.request.contextPath}/ManageCar?goBack=true">Volver</a>
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
		<footer></footer>
	</body>
</html>