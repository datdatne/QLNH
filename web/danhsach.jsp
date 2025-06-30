<%@page import="java.util.*, model.vandongvien"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.connect"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách vận động viên</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: #f5f7fa;
            margin: 0;
            padding: 0;
        }
        h2 {
            text-align: center;
            color: #333;
            margin-top: 30px;
        }
        .actions {
            text-align: center;
            margin: 20px 0;
        }
        .actions a button {
            padding: 10px 16px;
            margin: 5px;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            font-weight: bold;
            transition: background 0.3s ease;
        }
        .add-btn {
            background-color: #28a745;
            color: white;
        }
        .search-btn {
            background-color: #ffc107;
            color: black;
        }
        .table-container {
            width: 90%;
            margin: 0 auto 40px auto;
            overflow-x: auto;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 15px;
            background-color: #fff;
            box-shadow: 0 2px 8px rgba(0,0,0,0.05);
        }
        th {
            background-color: #343a40;
            color: white;
            padding: 12px;
        }
        td {
            padding: 10px;
            border: 1px solid #dee2e6;
            text-align: center;
        }
        a {
            text-decoration: none;
        }
        .btn {
            padding: 6px 12px;
            border: none;
            border-radius: 4px;
            font-weight: bold;
            cursor: pointer;
        }
        .edit-btn {
            background-color: #17a2b8;
            color: white;
        }
        .delete-btn {
            background-color: #dc3545;
            color: white;
        }
        .detail-link {
            color: #007bff;
        }
        .detail-link:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <h2>DANH SÁCH VẬN ĐỘNG VIÊN</h2>

    <div class="actions">
        <a href="them.jsp"><button class="add-btn">➕ Thêm</button></a>
        <a href="timkiem.jsp"><button class="search-btn">🔍 Tìm kiếm</button></a>
    </div>

    <div class="table-container">
        <table>
            <tr>
                <th>Mã VĐV</th>
                <th>Họ Tên</th>
                <th>Bộ Môn</th>
                <th>Ngày Sinh</th>
                <th>Số Huy Chương</th>
                <th>Chi Tiết</th>
                <th>Thao Tác</th>
            </tr>

            <%
                try {
                    connect db = new connect();
                    List<vandongvien> list = db.getAll();
                    for (vandongvien kh : list) {
            %>
                <tr>
                    <td><%= kh.getMavdv() %></td>
                    <td><%= kh.getTenvdv() %></td>
                    <td><%= kh.getBomon() %></td>
                    <td><%= kh.getNgaysinh() %></td>
                    <td><%= kh.getSohc() %></td>
                    <td><a class="detail-link" href="sua?mavdv=<%= kh.getMavdv() %>">Xem chi tiết</a></td>
                    <td>
                        <a href="sua?mavdv=<%= kh.getMavdv() %>">
                            <button class="btn edit-btn">Sửa</button>
                        </a>
                        <a href="xoa?mavdv=<%= kh.getMavdv() %>" onclick="return confirm('Bạn có chắc muốn xóa không?');">
                            <button class="btn delete-btn">Xóa</button>
                        </a>
                    </td>
                </tr>
            <%
                    }
                } catch (Exception e) {
                    out.println("<tr><td colspan='7'>Lỗi: " + e.getMessage() + "</td></tr>");
                }
            %>
        </table>
    </div>
</body>
</html>
