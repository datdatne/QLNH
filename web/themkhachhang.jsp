<%-- 
    Document   : themkhachhang
    Created on : Jul 15, 2025, 1:46:57 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thêm Khách Hàng</title>
    </head>
    <body>
        <%
    // Lưu maBan được chọn để gắn với khách hàng
    String maBan = request.getParameter("maBan");
    session.setAttribute("maBan", Integer.parseInt(maBan));
%>
       <form action="ThemKhachHang" method="post">
    <input type="hidden" name="maBan" value="<%= request.getParameter("maBan") %>">
    Họ tên: <input type="text" name="hoten" required><br>
    SĐT: <input type="text" name="sdt" required><br>
    Địa chỉ: <input type="text" name="diachi"><br>
    Email: <input type="text" name="email"><br>
    <button type="submit">Lưu và chọn bàn</button>
</form>


    </body>
</html>
