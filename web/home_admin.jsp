<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%
    if (!utils.PhanQuyenUtil.laAdmin(request)) {
        response.sendRedirect("access_denied.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard - Quản lý Nhà hàng</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap 5 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Icon CDN (Font Awesome) -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" rel="stylesheet" />
    <style>
        body {
            background-color: #f3f6f4;
            font-family: 'Segoe UI', sans-serif;
        }

        .sidebar {
            min-height: 100vh;
            background-color: #a8d5ba;
            padding-top: 20px;
            box-shadow: 2px 0 8px rgba(0, 0, 0, 0.1);
        }

        .sidebar h4 {
            color: #2f4f4f;
            margin-bottom: 30px;
        }

        .sidebar a {
            color: #2f4f4f;
            text-decoration: none;
            padding: 12px 20px;
            display: flex;
            align-items: center;
            transition: background-color 0.3s ease;
            border-radius: 8px;
            font-weight: 500;
        }

        .sidebar a:hover {
            background-color: #92c9a3;
        }

        .sidebar a i {
            margin-right: 12px;
            font-size: 1.2rem;
            color: #1b5e20;
        }

        .header {
            background-color: #ffffff;
            padding: 25px;
            border-radius: 12px;
            box-shadow: 0px 2px 8px rgba(0,0,0,0.05);
            margin-bottom: 30px;
        }

        .content {
            padding: 30px;
        }

        .card {
            border: none;
            border-radius: 16px;
            box-shadow: 0px 3px 10px rgba(0, 0, 0, 0.06);
            background-color: #ffffff;
        }

        .card .card-icon {
            font-size: 2rem;
            margin-bottom: 10px;
        }

        .card-title {
            color: #2f4f4f;
        }

        .card-text {
            font-size: 1.5rem;
            font-weight: bold;
            color: #2e7d32;
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <!-- Sidebar -->
        <div class="col-md-3 sidebar">
            <h4 class="text-center"><i class="fas fa-user-shield"></i> Admin</h4>
            <a href="NhanVien"><i class="fas fa-users-gear"></i> Quản lý Nhân viên</a>
            <a href="KhachHangServlet"><i class="fas fa-user-friends"></i> Khách hàng</a>
            <a href="menu.jsp"><i class="fas fa-bowl-rice"></i> Món ăn</a>
            <a href="chonban.jsp"><i class="fas fa-utensils"></i> Đặt bàn</a>
            <a href="DanhSachHoaDon"><i class="fas fa-receipt"></i> Hóa đơn</a>
            <a href="#"><i class="fas fa-user-lock"></i> Tài khoản</a>
        </div>

        <!-- Main Content -->
        <div class="col-md-9 content">
            <div class="header">
                <h2 class="text-success"><i class="fas fa-chart-line"></i> Bảng điều khiển Admin</h2>
                <p class="text-muted">Chào mừng bạn đến hệ thống quản lý nhà hàng</p>
            </div>

            <div class="row g-4">
                <div class="col-md-4">
                    <div class="card text-center p-4">
                        <div class="card-icon text-primary"><i class="fas fa-user-tie"></i></div>
                        <h5 class="card-title">Tổng Nhân Viên</h5>
                        <p class="card-text">12</p>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card text-center p-4">
                        <div class="card-icon text-warning"><i class="fas fa-burger"></i></div>
                        <h5 class="card-title">Số Món ăn</h5>
                        <p class="card-text">35</p>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card text-center p-4">
                        <div class="card-icon text-danger"><i class="fas fa-sack-dollar"></i></div>
                        <h5 class="card-title">Tổng doanh thu</h5>
                        <p class="card-text">45,000,000đ</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
