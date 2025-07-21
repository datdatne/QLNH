<%@ page import="java.util.List" %>
<%@ page import="model.ChiTietHoaDon" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chi Tiết Hóa Đơn</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-4">
    <h3 class="text-primary">Chi tiết hóa đơn #<%= request.getAttribute("maHD") %></h3>
    <table class="table table-bordered">
        <thead>
            <tr>
                <th>Tên món</th>
                <th>Số lượng</th>
                <th>Đơn giá</th>
                <th>Thành tiền</th>
            </tr>
        </thead>
        <tbody>
        <%
            List<ChiTietHoaDon> ds = (List<ChiTietHoaDon>) request.getAttribute("chiTietList");
            double tongTien = 0;
            for (ChiTietHoaDon ct : ds) {
                double thanhTien = ct.getSoLuong() * ct.getDonGia();
                tongTien += thanhTien;
        %>
            <tr>
                <td><%= ct.getMaMon() %></td>
                <td><%= ct.getSoLuong() %></td>
                <td><%= ct.getDonGia() %> VNĐ</td>
                <td><%= thanhTien    %> VNĐ</td>
            </tr>
        <%
            }
        %>
        </tbody>
    </table>

    <div class="text-end mb-3">
        <strong class="text-success">Tổng tiền: <%= tongTien %> VNĐ</strong>
    </div>

    <form action="ThuNganXuLy" method="post">
        <input type="hidden" name="maHD" value="<%= request.getAttribute("maHD") %>">
        <input type="hidden" name="tongTien" value="<%= tongTien %>">
        <button type="submit" class="btn btn-success">✅ Xác nhận thanh toán & Nhập kho</button>
    </form>
</body>
</html>
