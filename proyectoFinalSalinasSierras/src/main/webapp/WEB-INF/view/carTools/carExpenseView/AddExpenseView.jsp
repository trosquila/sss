<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String plate = request.getParameter("plate");
    %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Crear gasto</title>
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
						<input type="text"  name="mileage">
						<label>precio</label>
						<input type="text" name="price">
					</div>
					<div>
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
					<div>
						<label>ID del vehiculo</label>
						<input type="number" name="idCar">
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