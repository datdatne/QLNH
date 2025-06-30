<%-- 
    Document   : sua
    Created on : 15 thg 6, 2025, 22:43:05
    Author     : a
--%>

<%@page import="model.nhanvien"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        nhanvien nv= (nhanvien) request.getAttribute("nvs");
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="sua" method="post">
            ma<input type="hidden" name="MaNv" value="<%=nv.getMaNv()%>"><br><!-- comment -->
            ten<input type="text" name="HoTen" value="<%=nv.getHoTen()%>"><br><!-- comment -->
            ngaysinh<input type="date" name="NgaySinh" value="<%=nv.getNgaySinh()%>"><br><!-- comment -->
            goi tinh<select name="GioiTinh"><br><!-- comment -->
                <option value="<%=nv.isGioiTinh()%>">nam</option>
                <option value="<%=nv.isGioiTinh()%>">nu</option>
                
            </select>

            Dien thoai<input type="text" name="DienThoai"value="<%=nv.getDienThoai()%>"><br><!-- comment -->
            <input type="submit" name="name" value="sua">

        </form>
    </body>
</html>
