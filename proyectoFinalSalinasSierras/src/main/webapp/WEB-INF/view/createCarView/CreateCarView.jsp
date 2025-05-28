<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Añadir un coche</title>
		<link rel="stylesheet" type="text/css"
		href="${pageContext.request.contextPath}/static/css/style.css">
	</head>
	<body>
		<section>
			<div>
				<form action="${pageContext.request.contextPath}/AddCarController" method="POST">
					<div>
						<label>Marca</label>
						<input type="text"  name="brand">
						<label>Modelo</label>
						<input type="text" name="model">
					</div>
					<div>
						<label>Matricula</label>
						<input type="text" name="licensePlate">
						<label>Motor</label>
						<input type="text" name="engine">
					</div>
					<div>
						<label>Año</label>
						<input type="number" name="year">
						<label>Compañia aseguradora</label>
						<input type="text" name="insuranceCompany">
					</div>
					<button>Guardar</button>
					<input type="reset" value="Borrar">
					<a href="${pageContext.request.contextPath}/home.jsp">Volver</a>
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
	</body>
</html>