<%@page import="model.CartItem"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
    if (cart == null) cart = new java.util.ArrayList<>();
%>
<html>
<head>
    <title>Giỏ hàng</title>
    <style>
        table { border-collapse: collapse; width: 80%; margin: 0 auto; }
        th, td { border: 1px solid #ccc; padding: 8px; text-align: center; }
    </style>
</head>
<body>
    <h2 align="center">🛒 Giỏ hàng của bạn</h2>
    <table>
        <tr>
            <th>Món ăn</th>
            <th>Đơn giá</th>
            <th>Số lượng</th>
            <th>Thành tiền</th>
            <th>Thao tác</th> <!-- ✅ thêm cột -->
        </tr>
        <%
            double tong = 0;
            for (CartItem item : cart) {
                double thanhTien = item.getMon().getDonGia() * item.getSoLuong();
                tong += thanhTien;
        %>
        <tr>
            <td><%= item.getMon().getTenMon() %></td>
            <td><%= item.getMon().getDonGia() %> VNĐ</td>
            <td><%= item.getSoLuong() %></td>
            <td><%= thanhTien %> VNĐ</td>
            <td>
      <form action="Cart" method="post" style="margin:0;">
    <input type="hidden" name="action" value="decrease"/>
    <input type="hidden" name="maMon" value="<%= item.getMon().getMaMon() %>"/>
    <button type="submit">➖</button>
      </form>

    </td>
        </tr>
        <% } %>
        <tr>
            <td colspan="3"><strong>Tổng cộng</strong></td>
            <td><strong><%= tong %> VNĐ</strong></td>
        </tr>
    </table>
    <div style="text-align: center; margin-top: 20px;">
        <a href="Menu">⬅️ Tiếp tục mua</a>
    </div>
        <form action="" method="post">
    <button type="submit">✅ Thanh Toán Hóa Đơn</button>
        </form>

</body>
</html>
