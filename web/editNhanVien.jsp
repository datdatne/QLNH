<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.NhanVien" %>
<%
    NhanVien nv = (NhanVien) request.getAttribute("nv");
    boolean isUpdate = (nv != null);
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><%= isUpdate ? "Cập nhật" : "Thêm" %> Nhân Viên</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
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

        .form-container {
            background-color: #ffffff;
            border-radius: 10px;
            padding: 30px;
            max-width: 600px;
            margin: 0 auto;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }

        .btn-custom {
            background-color: #52b788;
            color: white;
            border: none;
        }

        .btn-custom:hover {
            background-color: #40916c;
        }

        .btn-back {
            background-color: #adb5bd;
            color: white;
            border: none;
        }

        .btn-back:hover {
            background-color: #6c757d;
        }
    </style>
</head>
<body class="container mt-5">
    <h2><%= isUpdate ? "📝 Cập nhật" : "➕ Thêm" %> Nhân Viên</h2>
        <% 
    String success = (String) request.getAttribute("success");
    String error = (String) request.getAttribute("error");
%>

<% if (success != null) { %>
    <div class="alert alert-success" role="alert">
        <%= success %>
    </div>
<% } %>

<% if (error != null) { %>
    <div class="alert alert-danger" role="alert">
        <%= error %>
    </div>
<% } %>

    <div class="form-container mt-4">
        <form action="NhanVienServlet" method="post">
            <input type="hidden" name="action" value="<%= isUpdate ? "update" : "insert" %>" />

            <div class="mb-3">
                <label class="form-label">Mã NV:</label>
                <input type="text" class="form-control" name="maNV" 
                       value="<%= isUpdate ? nv.getMaNV() : "" %>" 
                       <%= isUpdate ? "readonly" : "" %> required />
            </div>

            <div class="mb-3">
                <label class="form-label">Họ Tên:</label>
                <input type="text" class="form-control" name="hoTen" 
                       value="<%= isUpdate ? nv.getHoTen() : "" %>" required />
            </div>

            <div class="mb-3">
                <label class="form-label">Ngày Sinh:</label>
                <input type="date" class="form-control" name="ngaySinh" 
                       value="<%= isUpdate ? nv.getNgaySinh() : "" %>" required />
            </div>

            <div class="mb-3">
                <label class="form-label">SĐT:</label>
                <input type="text" class="form-control" name="sdt" 
                       value="<%= isUpdate ? nv.getSDT() : "" %>" required />
            </div>

            <div class="d-flex justify-content-between">
                <button type="submit" class="btn btn-custom px-4">
                    <%= isUpdate ? "✔️ Cập nhật" : "➕ Thêm" %>
                </button>
                <a href="NhanVienServlet?action=list" class="btn btn-back px-4">⬅️ Quay lại</a>
            </div>
        </form>
    </div>
</body>
</html>
