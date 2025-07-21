<%@page import="model.CartItem"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if (!(utils.PhanQuyenUtil.laPhucVu(request) || utils.PhanQuyenUtil.laAdmin(request))) {
        response.sendRedirect("access_denied.jsp");
        return;
    }

    int maBan = (session.getAttribute("maBan") != null) ? (Integer) session.getAttribute("maBan") : -1;
    String cartKey = "cart_ban_" + maBan;
    List<CartItem> cart = (List<CartItem>) session.getAttribute(cartKey);
    if (cart == null) cart = new java.util.ArrayList<>();
%>
<html>
<head>
    <title>Giỏ hàng</title>
    <style>
        table { border-collapse: collapse; width: 80%; margin: 0 auto; }
        th, td { border: 1px solid #ccc; padding: 8px; text-align: center; }
        button { padding: 5px 10px; }
    </style>
</head>
<body>

<h2 align="center">🛒 Giỏ hàng của bạn (Bàn số <%= maBan %>)</h2>

<% if (cart.isEmpty()) { %>
    <p style="text-align: center;">Giỏ hàng trống. <a href="Menu">⬅️ Quay lại Menu</a></p>
<% } else { %>
    <table>
        <tr>
            <th>Món ăn</th>
            <th>Đơn giá</th>
            <th>Số lượng</th>
            <th>Thành tiền</th>
            <th>Thao tác</th>
        </tr>
        <%
            double tongTien = 0;
            for (CartItem item : cart) {
                double thanhTien = item.getMon().getDonGia() * item.getSoLuong();
                tongTien += thanhTien;
        %>
        <tr>
            <td><%= item.getMon().getTenMon() %></td>
            <td><%= item.getMon().getDonGia() %> VNĐ</td>
            <td><%= item.getSoLuong() %></td>
            <td><%= thanhTien %> VNĐ</td>
            <td>
                <form action="Cart" method="post" style="display: inline;">
                    <input type="hidden" name="action" value="decrease"/>
                    <input type="hidden" name="maMon" value="<%= item.getMon().getMaMon() %>"/>
                    <input type="hidden" name="maBan" value="<%= maBan %>"/>
                    <button type="submit">➖</button>
                </form>
                <form action="Cart" method="post" style="display: inline;">
                    <input type="hidden" name="action" value="remove"/>
                    <input type="hidden" name="maMon" value="<%= item.getMon().getMaMon() %>"/>
                    <input type="hidden" name="maBan" value="<%= maBan %>"/>
                    <button type="submit">❌</button>
                </form>
            </td>
        </tr>
        <% } %>
        <tr>
            <td colspan="3"><strong>Tổng cộng</strong></td>
            <td colspan="2"><strong><%= tongTien %> VNĐ</strong></td>
        </tr>
    </table>

    <div style="text-align: center; margin-top: 20px;">
        <a href="Menu">⬅️ Tiếp tục mua</a>
    </div>

    <form action="ThanhToan" method="post" style="text-align: center; margin-top: 20px;">
        <input type="hidden" name="maBan" value="<%= maBan %>">
        <input type="hidden" name="maKH" value="<%= session.getAttribute("maKH") %>">
        <input type="hidden" name="tongTien" value="<%= tongTien %>">
        <button type="submit">✅ Thanh Toán Hóa Đơn</button>
    </form>
<% } %>

</body>
</html>
