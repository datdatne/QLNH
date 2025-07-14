<%-- 
    Document   : home_bep
    Created on : Jul 7, 2025, 1:25:52 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@ page session="true" %>
<%
    if (!"Bep".equals(session.getAttribute("vaitro"))) {
        response.sendRedirect("access_denied.jsp");
        return;
    }
%>
<h2>Trang BẾP</h2>
<p>Xin chào: <%= session.getAttribute("username") %></p>

    </body>
</html>
