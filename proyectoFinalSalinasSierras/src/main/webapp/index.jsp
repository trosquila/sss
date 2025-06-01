<%@ page contentType="text/html; charset=UTF-8" %>
<%	Integer uuid = (Integer) session.getAttribute("UUID");
    if (uuid != null) {
    	//se cambio de redirect a dispatcher porque daba error
    	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/home/Home.jsp");
    	dispatcher.forward(request, response);
    } else {
        response.sendRedirect(request.getContextPath() + "/LoginServlet");
    }
%>