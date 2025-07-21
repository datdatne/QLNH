<%-- 
    Document   : hoadon
    Created on : Jul 11, 2025, 1:49:48 PM
    Author     : ACER
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="model.CartItem" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hóa Đơn</title>
    </head>
    <body>
        <h2>🧾 Hóa đơn bán hàng</h2>
<p>Mã hóa đơn: ${maHD}</p>
<table border="1" cellpadding="10">
    <tr>
        <th>Món ăn</th>
        <th>Đơn giá</th>
        <th>Số lượng</th>
        <th>Thành tiền</th>
    </tr>
    <%
        List<CartItem> dsMon = (List<CartItem>) request.getAttribute("dsMon");
        for (CartItem item : dsMon) {
    %>
        <tr>
            <td><%= item.getMon().getTenMon() %></td>
            <td><%= item.getMon().getDonGia() %> VNĐ</td>
            <td><%= item.getSoLuong() %></td>
            <td><%= item.getMon().getDonGia() * item.getSoLuong() %> VNĐ</td>
        </tr>
    <%
        }
    %>
</table>
<p><strong>Tổng cộng: ${tongTien} VNĐ</strong></p>

<button onclick="window.print()">🖨️ In hóa đơn</button>
    </body>
</html>
