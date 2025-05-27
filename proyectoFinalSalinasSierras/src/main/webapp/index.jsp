<%@ page contentType="text/html; charset=UTF-8" %>
<%
    if (session.getAttribute("UUID") != null) {
        response.sendRedirect(request.getContextPath() + "/home.jsp");
    } else {
        response.sendRedirect(request.getContextPath() + "/LoginServlet");
    }
%>