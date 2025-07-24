<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, model.NhanVien" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quản Lí Nhân Viên</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        <%
            if (!utils.PhanQuyenUtil.laAdmin(request)) {
                response.sendRedirect("access_denied.jsp");
                return;
            }
        %>
        body {
            background-color: #f6fff8;
            font-family: 'Segoe UI', sans-serif;
        }

        h2 {
            color: #2d6a4f;
            border-bottom: 2px solid #40916c;
            padding-bottom: 10px;
            margin-top: 30px;
        }

        .table thead {
            background-color: #40916c;
            color: white;
        }

        .table td, .table th {
            vertical-align: middle;
            text-align: center;
        }

        .btn-custom {
            background-color: #52b788;
            color: white;
        }

        .btn-custom:hover {
            background-color: #40916c;
            color: white;
        }

        .btn-danger {
            background-color: #d00000;
            border: none;
        }

        .btn-danger:hover {
            background-color: #9b0000;
        }

        .btn-add {
            margin-top: 20px;
            display: inline-block;
            background-color: #74c69d;
            color: white;
            padding: 8px 16px;
            border-radius: 5px;
            text-decoration: none;
        }

        .btn-add:hover {
            background-color: #52b788;
            color: white;
        }

        .alert {
            margin-top: 20px;
        }
    </style>
</head>
<body class="container mt-5">
    <h2>📋 Danh sách nhân viên</h2>

    <!-- Hiển thị thông báo thành công nếu có -->
    <%
        String success = (String) session.getAttribute("success");
        if (success != null) {
    %>
        <div class="alert alert-success" role="alert">
            <%= success %>
        </div>
    <%
            session.removeAttribute("success");
        }
    %>

    <%
    String error = (String) session.getAttribute("error");
    if (error != null) {
%>
    <div class="alert alert-danger" role="alert">
        <%= error %>
    </div>
<%
        session.removeAttribute("error");
    }
%>

    <table class="table table-bordered mt-3">
        <thead>
            <tr>
                <th>Mã NV</th>
                <th>Tên NV</th>
                <th>Ngày sinh</th>
                <th>SĐT</th>
                <th>Thao tác</th>
            </tr>
        </thead>
        <tbody>
        <%
            List<NhanVien> ds = (List<NhanVien>) request.getAttribute("dsNhanVien");
            if (ds != null) {
                for (NhanVien nv : ds) {
        %>
        <tr>
            <td><%= nv.getMaNV() %></td>
            <td><%= nv.getHoTen() %></td>
            <td><%= nv.getNgaySinh() %></td>
            <td><%= nv.getSDT() %></td>
            <td>
                <a href="NhanVienServlet?action=edit&id=<%= nv.getMaNV() %>" class="btn btn-sm btn-custom">Sửa</a>
                <a href="NhanVienServlet?action=delete&id=<%= nv.getMaNV() %>"
                   class="btn btn-sm btn-danger"
                   onclick="return confirm('Bạn có chắc chắn muốn xóa nhân viên này không?');">
                   Xóa
                </a>
            </td>
        </tr>
        <%
                }
            }
        %>
        </tbody>
    </table>

    <a href="NhanVienServlet?action=add" class="btn-add">➕ Thêm nhân viên mới</a>
</body>
</html>
