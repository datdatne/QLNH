<%-- 
    Document   : them
    Created on : 15 thg 6, 2025, 22:30:39
    Author     : a
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="them" method="post">
            ma<input type="text" name="MaNV"><br><!-- comment -->
            ten<input type="text" name="HoTen"><br><!-- comment -->
            ngaysinh<input type="date" name="NgaySinh"><br><!-- comment -->
            goi tinh<select name="GioiTinh"><br><!-- comment -->
                <option value="false">nam</option>
                <option value="true">nu</option>
                
            </select>

            Dien thoai<input type="text" name="DienThoai"><br><!-- comment -->
            <input type="submit" name="name" value="them">

        </form>
    </body>
</html>
