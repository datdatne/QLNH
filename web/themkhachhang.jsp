<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Thêm Khách Hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #e8f5e9; /* xanh lá nhạt */
        }
        .card {
            background-color: #ffffff;
            border: none;
            border-radius: 15px;
            box-shadow: 0 4px 6px rgba(0,0,0,0.1);
        }
        .btn-custom {
            background-color: #43a047;
            color: white;
        }
        .btn-custom:hover {
            background-color: #388e3c;
        }
    </style>
</head>
<body>
    <div class="container py-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card p-4">
                    <h4 class="mb-4 text-center text-success">Thêm Thông Tin Khách Hàng</h4>

                    <%
                        String maBan = request.getParameter("maBan");
                        if (maBan != null) {
                            session.setAttribute("maBan", Integer.parseInt(maBan));
                        }
                    %>

                    <form action="ThemKhachHang" method="post">
                        <input type="hidden" name="maBan" value="<%= maBan %>">
                        <div class="mb-3">
                            <label for="hoten" class="form-label">Họ tên</label>
                            <input type="text" class="form-control" id="hoten" name="hoten" required>
                        </div>
                        <div class="mb-3">
                            <label for="sdt" class="form-label">Số điện thoại</label>
                            <input type="text" class="form-control" id="sdt" name="sdt" required>
                        </div>
                        <div class="mb-3">
                            <label for="diachi" class="form-label">Địa chỉ</label>
                            <input type="text" class="form-control" id="diachi" name="diachi">
                        </div>
                        <div class="mb-3">
                            <label for="email" class="form-label">Email</label>
                            <input type="email" class="form-control" id="email" name="email">
                        </div>
                        <div class="text-center">
                            <button type="submit" class="btn btn-custom px-4">Lưu và chọn bàn</button>
                        </div>
                    </form>

                </div>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
