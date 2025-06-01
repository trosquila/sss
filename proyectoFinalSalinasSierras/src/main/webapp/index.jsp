<%@ page contentType="text/html; charset=UTF-8" %>
<%	Integer uuid = (Integer) session.getAttribute("UUID");
	System.out.println("UUID en CarView "+uuid);
    if (uuid != null) {
        response.sendRedirect(request.getContextPath() + "/WEB-INF/view/home/Home.jsp");
    } else {
        response.sendRedirect(request.getContextPath() + "/LoginServlet");
    }
%>