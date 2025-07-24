<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.KhachHang"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Chỉnh sửa / Thêm Khách Hàng</title>
    <!-- Bootstrap 5 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f6fff6;
        }
        .form-container {
            max-width: 600px;
            margin: 60px auto;
            background-color: #ffffff;
            padding: 30px;
            border: 1px solid #d4edda;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 128, 0, 0.1);
        }
    </style>
</head>
<body>

<%
    KhachHang kh = (KhachHang) request.getAttribute("kh");
    Integer maBanInt = (Integer) session.getAttribute("maBan");
    String maBan = maBanInt != null ? String.valueOf(maBanInt) : "";

    String maBanParam = request.getParameter("maBan");
    if (maBanParam != null && !maBanParam.trim().isEmpty()) {
        session.setAttribute("maBan", maBanParam);
        maBan = maBanParam;
    }
%>

<div class="form-container">
    <h3 class="text-success mb-4 text-center">Chỉnh sửa / Thêm Khách Hàng</h3>

    <form action="KhachHangServlet" method="post">
        <input type="hidden" name="maBan" value="<%= maBan %>">

        <div class="mb-3">
            <label class="form-label">Họ tên</label>
            <input type="text" class="form-control" name="hoten" value="<%= kh != null ? kh.getHoTen() : "" %>" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Số điện thoại</label>
            <input type="text" class="form-control" name="sdt" value="<%= kh != null ? kh.getSDT() : "" %>" required 
                   pattern="0[0-9]{9}" 
                   title="Số điện thoại phải bắt đầu bằng 0 và có 10 chữ số">
        </div>

        <div class="mb-3">
            <label class="form-label">Địa chỉ</label>
            <input type="text" class="form-control" name="diachi" value="<%= kh != null ? kh.getDiaChi() : "" %>">
        </div>

        <div class="mb-3">
            <label class="form-label">Email</label>
            <input type="text" class="form-control" name="email" value="<%= kh != null ? kh.getEmail() : "" %>" required 
                   pattern=".+@.+" 
                   title="Email phải chứa ký tự @">
        </div>

        <% if (kh != null) { %>
            <input type="hidden" name="id" value="<%= kh.getMaKH() %>">
        <% } %>

        <div class="d-flex justify-content-between">
            <button type="submit" class="btn btn-success">Lưu Khách Hàng</button>
            <a href="KhachHangServlet?action=list" class="btn btn-outline-secondary">Quay lại</a>
        </div>
    </form>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
