<%-- 
    Document   : login
    Created on : Jul 7, 2025, 12:58:51 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Đăng Nhập</title>
    </head>
    <body>
        <form action="Login" method="post">
        Tên đăng nhập: <input type="text" name="username"><br>
        Mật khẩu: <input type="password" name="password"><br>
        <input type="submit" value="Đăng nhập">
    </form>
    <p style="color:red">${error}</p>
    </body>
</html>
