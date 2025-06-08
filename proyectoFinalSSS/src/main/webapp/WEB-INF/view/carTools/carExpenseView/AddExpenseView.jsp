<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String plate = request.getParameter("plate");
    %>
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
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css">
		<title>Crear gasto</title>
	</head>
	<body>
		<header></header>
		<section class="conetenedorPrincipal">
			<h1>Añadir gastos</h1>
			<div>
				<form action="${pageContext.request.contextPath}/ExpensiveTableController" method="POST">
				<input type="hidden" name="choose" value="3">
				<input type="hidden" name="plate" value="<%=plate %>">
				
					<div class="formulario">
						<label>Kilometraje</label>
						<input type="text"  name="mileage">
						<label>precio</label>
						<input type="text" name="price">
						<label>Concepto</label>
						<select name="expenseConcept">
						    <option value="Aceite" >Aceite</option>
						    <option value="Gasolina">Gasolina</option>
						    <option value="Cambio de neumáticos">Cambio de neumáticos</option>
						    <option value="Revisión general">Revisión general</option>
						    <option value="Frenos">Frenos</option>
						    <option value="Batería">Batería</option>
						    <option value="Seguro">Seguro</option>
						    <option value="ITV">ITV</option>
						    <option value="Cambio de filtros">Cambio de filtros</option>
						    <option value="Reparaciones mecánicas">Reparaciones mecánicas</option>
						    <option value="Cambio de luces">Cambio de luces</option>
						    <option value="Alineación y balanceo">Alineación y balanceo</option>
						    <option value="Lavado y mantenimiento estético">Lavado y mantenimiento estético</option>
						    <option value="Sistema eléctrico">Sistema eléctrico</option>
						    <option value="Cambio de líquidos refrigerantes">Cambio de líquidos refrigerantes</option>
						    <option value="Amortiguadores y suspensión">Amortiguadores y suspensión</option>
						</select>
					</div>
					<div class="colocarBtnForm">
						<button class="btn">Guardar</button>
						<input type="reset" class="btn" value="Borrar">
						<a href="${pageContext.request.contextPath}/ManageCar?goBack=true" class="btn1 txtEnlacebtn colocarBtnCreateCar">Volver</a>
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
		<footer></footer>
	</body>
</html>