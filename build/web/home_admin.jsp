<%-- 
    Document   : home_admin
    Created on : Jul 7, 2025, 1:25:33 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Admin Dashboard - Quản lý Nhà hàng</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
        <style>
        body {
            background-color: #f8f9fa;
        }
        .sidebar {
            min-height: 100vh;
            background-color: #343a40;
            color: white;
        }
        .sidebar a {
            color: white;
            text-decoration: none;
            display: block;
            padding: 10px 15px;
        }
        .sidebar a:hover {
            background-color: #495057;
        }
        .content {
            padding: 20px;
        }
        .header {
            border-bottom: 1px solid #dee2e6;
            padding-bottom: 10px;
            margin-bottom: 20px;
        }
    </style>
    </head>
    <body>
       <%@ page session="true" %>

<%
    if (!utils.PhanQuyenUtil.laAdmin(request)) {
        response.sendRedirect("access_denied.jsp");
        return;
    }
%>

<div class="container-fluid">
    <div class="row">
        <!-- Sidebar -->
        <div class="col-md-3 sidebar">
            <h4 class="text-center mt-3">Admin</h4>
            <a href="NhanVien">Quản lý Nhân viên</a>
            <a href="#">Khách hàng</a>
            <a href="#">Món ăn</a>
            <a href="chonban.jsp">Đặt bàn</a>
            <a href="DanhSachHoaDon">Hoá đơn và Chi tiết Hóa đơn</a>
            <a href="#">Xuất nhập kho</a>
            <a href="#">Tài khoản</a>
        </div>

        <!-- Main Content -->
        <div class="col-md-9 content">
            <div class="header">
                <h2>Quản lý nhà hàng - Bảng điều khiển Admin</h2>
            </div>
            <div class="row">
                <div class="col-md-4">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">Tổng Nhân Viên</h5>
                            <p class="card-text">12</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">Số Món ăn</h5>
                            <p class="card-text">35</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">Tổng doanh thu</h5>
                            <p class="card-text">45,000,000đ</p>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Thêm bài viết, thông báo, etc -->
        </div>
    </div>
</div>
    </body>
</html>


