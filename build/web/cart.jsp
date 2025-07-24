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
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Giỏ hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background: #f6fff8;
            font-family: 'Segoe UI', sans-serif;
        }
        h2 {
            color: #2f855a;
            margin-top: 30px;
        }
        table {
            width: 90%;
            margin: 20px auto;
            border-collapse: collapse;
            background: #ffffff;
            box-shadow: 0 2px 6px rgba(0,0,0,0.1);
        }
        th {
            background-color: #48bb78;
            color: white;
            padding: 12px;
        }
        td {
            padding: 10px;
            border: 1px solid #dee2e6;
            vertical-align: middle;
        }
        .btn-action {
            border: none;
            padding: 6px 10px;
            border-radius: 4px;
            margin: 0 2px;
            font-size: 16px;
            cursor: pointer;
        }
        .btn-decrease {
            background-color: #f6ad55;
            color: white;
        }
        .btn-remove {
            background-color: #e53e3e;
            color: white;
        }
        .btn-pay {
            background-color: #38a169;
            color: white;
            padding: 10px 20px;
            border-radius: 6px;
            font-size: 16px;
            margin-top: 15px;
        }
        .link-back {
            margin-top: 20px;
            display: inline-block;
            color: #2b6cb0;
            text-decoration: none;
        }
        .link-back:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

    <h2 class="text-center">🛒 Giỏ hàng của bạn (Bàn số <%= maBan %>)</h2>

    <% if (cart.isEmpty()) { %>
        <p class="text-center">Giỏ hàng trống. <a href="Menu" class="link-back">⬅️ Quay lại Menu</a></p>
    <% } else { 
        double tongTien = 0;
    %>

    <table class="table table-bordered text-center">
        <thead>
            <tr>
                <th>Món ăn</th>
                <th>Đơn giá</th>
                <th>Số lượng</th>
                <th>Thành tiền</th>
                <th>Thao tác</th>
            </tr>
        </thead>
        <tbody>
            <% for (CartItem item : cart) {
                double thanhTien = item.getMon().getDonGia() * item.getSoLuong();
                tongTien += thanhTien;
            %>
            <tr>
                <td><%= item.getMon().getTenMon() %></td>
                <td><%= item.getMon().getDonGia() %> VNĐ</td>
                <td><%= item.getSoLuong() %></td>
                <td><%= thanhTien %> VNĐ</td>
                <td>
                    <form action="Cart" method="post" style="display:inline;">
                        <input type="hidden" name="action" value="decrease"/>
                        <input type="hidden" name="maMon" value="<%= item.getMon().getMaMon() %>"/>
                        <input type="hidden" name="maBan" value="<%= maBan %>"/>
                        <button type="submit" class="btn-action btn-decrease">➖</button>
                    </form>
                    <form action="Cart" method="post" style="display:inline;">
                        <input type="hidden" name="action" value="remove"/>
                        <input type="hidden" name="maMon" value="<%= item.getMon().getMaMon() %>"/>
                        <input type="hidden" name="maBan" value="<%= maBan %>"/>
                        <button type="submit" class="btn-action btn-remove">❌</button>
                    </form>
                </td>
            </tr>
            <% } %>
            <tr>
                <td colspan="3"><strong>Tổng cộng</strong></td>
                <td colspan="2"><strong><%= tongTien %> VNĐ</strong></td>
            </tr>
        </tbody>
    </table>

    <div class="text-center">
        <a href="Menu" class="link-back">⬅️ Tiếp tục mua</a>
    </div>

    <form action="ThanhToan" method="post" class="text-center">
        <input type="hidden" name="maBan" value="<%= maBan %>">
        <input type="hidden" name="maKH" value="<%= session.getAttribute("maKH") %>">
        <input type="hidden" name="tongTien" value="<%= tongTien %>">
        <button type="submit" class="btn-pay">✅ Thanh Toán Hóa Đơn</button>
    </form>
    <% } %>

</body>
</html>
