<%@ page import="java.util.List" %>
<%@ page import="model.HoaDon" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Danh sách hóa đơn chờ</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #e6f5e6;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }
        h3.text-primary {
            color: #2e7d32 !important; /* Xanh lá đậm */
        }
        table {
            background-color: #ffffff;
            box-shadow: 0 0 10px rgba(0, 128, 0, 0.2);
        }
        th {
            background-color: #a5d6a7; /* Header xanh lá nhạt */
            color: #1b5e20;
        }
        td {
            background-color: #f1f8e9;
        }
        .btn-info {
            background-color: #66bb6a;
            border-color: #4caf50;
            color: white;
        }
        .btn-info:hover {
            background-color: #4caf50;
            border-color: #388e3c;
        }
        a {
            display: inline-block;
            margin-top: 15px;
            text-decoration: none;
            color: #2e7d32;
            font-weight: bold;
        }
        a:hover {
            color: #1b5e20;
            text-decoration: underline;
        }
    </style>
</head>
<body class="container mt-5">
    <h3 class="text-primary">🧾 Hóa Đơn Chờ Thanh Toán</h3>
    <table class="table table-bordered mt-4">
        <thead>
        <tr>
            <th>Mã HD</th>
            <th>Ngày lập</th>
            <th>Tổng tiền</th>
            <th>Trạng thái</th>
            <th>Mã bàn</th>
            <th>Mã KH</th>
            <th>Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<HoaDon> dsHoaDon = (List<HoaDon>) request.getAttribute("dsHoaDon");
            if (dsHoaDon != null) {
                for (HoaDon hd : dsHoaDon) {
        %>
        <tr>
            <td><%= hd.getMaHD() %></td>
            <td><%= hd.getNgayLap() %></td>
            <td><%= hd.getTongTien() %> VNĐ</td>
            <td><%= hd.getTrangThai() %></td>
            <td><%= hd.getMaBan() %></td>
            <td><%= hd.getMaKH() %></td>
            <td>
                <form action="ChiTietHoaDon" method="post" style="display:inline;">
                    <input type="hidden" name="maHD" value="<%= hd.getMaHD() %>">
                    <button type="submit" class="btn btn-info btn-sm">Xem chi tiết</button>
                </form>
            </td>
        </tr>
        <%
                }
            }
        %>
        </tbody>
    </table>
    <a href="XemKhoTaiChinh">📊 Xem kho tài chính</a>
</body>
</html>
