<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, model.KhachHang" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quản Lí Khách Hàng</title>
    <!-- Bootstrap 5 CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f6fff6;
        }
        .table th, .table td {
            vertical-align: middle;
        }
    </style>
</head>
<body class="container mt-5">

<%
    String message = (String) session.getAttribute("message");
    if (message != null) {
%>
    <div class="alert alert-success alert-dismissible fade show" role="alert">
        <%= message %>
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
<%
        session.removeAttribute("message");
    }
%>

    <div class="d-flex justify-content-between align-items-center mb-4">
        <h2 class="text-success">Danh sách khách hàng</h2>
        <a href="KhachHangServlet?action=add" class="btn btn-success">+ Thêm khách hàng mới</a>
    </div>

    <table class="table table-bordered table-hover table-striped">
        <thead class="table-success">
            <tr>
                <th>Mã KH</th>
                <th>Họ Tên</th>
                <th>SĐT</th>
                <th>Địa Chỉ</th>
                <th>Email</th>
                <th>Thao tác</th>
            </tr>
        </thead>
        <tbody>
        <%
            List<KhachHang> ds = (List<KhachHang>) request.getAttribute("dsKhachHang");
            if (ds != null && !ds.isEmpty()) {
                for (KhachHang kh : ds) {
        %>
            <tr>
                <td><%= kh.getMaKH() %></td>
                <td><%= kh.getHoTen() %></td>
                <td><%= kh.getSDT() %></td>
                <td><%= kh.getDiaChi() %></td>
                <td><%= kh.getEmail() %></td>
                <td>
                    <a href="KhachHangServlet?action=edit&id=<%= kh.getMaKH() %>" class="btn btn-sm btn-outline-primary">Sửa</a>
                    <a href="KhachHangServlet?action=delete&id=<%= kh.getMaKH() %>" 
                       class="btn btn-sm btn-outline-danger"
                       onclick="return confirm('Bạn có chắc muốn xóa khách hàng này?');">Xóa</a>
                </td>
            </tr>
        <%
                }
            } else {
        %>
            <tr>
                <td colspan="6" class="text-center text-muted">Chưa có khách hàng nào.</td>
            </tr>
        <%
            }
        %>
        </tbody>
    </table>

    <!-- Bootstrap JS (cho alert close) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
