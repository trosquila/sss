<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" type="text/css"
		href="${pageContext.request.contextPath}/static/css/style.css">
	</head>
	<body>
		<header> </header>
		<section class="conetenedorPrincipal">
			<h1>Home</h1>
			<div class ="colocarOpciones">
				<div>
					<a href="${pageContext.request.contextPath}/AddCarController" ><img class="colocarImgHome"src="<%= request.getContextPath() %>/static/img/addCar.png"></a>
				</div>
				<div>
					<a href="${pageContext.request.contextPath}/ManageCar"><img class="colocarImgHome" src="<%= request.getContextPath() %>/static/img/myCars.png"></a>
				</div>
				<div>
					<a href="${pageContext.request.contextPath}/SesionClose"><img class="colocarImgHome"" src="<%= request.getContextPath() %>/static/img/logout.png"></a>
				</div>
			</div>

		</section>
		<footer> </footer>
	</body>
</html>