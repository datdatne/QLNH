<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tìm Kiếm Vận Động Viên</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f5f7fa;
            margin: 0;
            padding: 0;
        }
        h2 {
            text-align: center;
            color: #333;
            margin-top: 30px;
        }
        form {
            width: 400px;
            margin: 30px auto;
            padding: 25px 30px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
        }
        label {
            font-weight: bold;
            display: block;
            margin-bottom: 8px;
        }
        input[type="text"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 6px;
            margin-bottom: 15px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            width: 100%;
            padding: 12px;
            background-color: #20c997;
            color: white;
            border: none;
            border-radius: 6px;
            font-weight: bold;
            cursor: pointer;
            transition: background 0.3s ease;
        }
        input[type="submit"]:hover {
            background-color: #17a589;
        }
        .error {
            color: red;
            text-align: center;
            margin-top: 20px;
        }
        .result {
            width: 500px;
            margin: 30px auto;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            background-color: #fff;
            box-shadow: 0 2px 10px rgba(0,0,0,0.05);
        }
        th {
            background-color: #343a40;
            color: white;
            padding: 10px;
        }
        td {
            padding: 10px;
            text-align: center;
            border: 1px solid #ddd;
        }
        .back-link {
            text-align: center;
            margin-top: 20px;
        }
        .back-link a {
            text-decoration: none;
            color: #007bff;
        }
        .back-link a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

<h2>Tìm kiếm vận động viên theo mã</h2>

<form action="timkiem" method="post">
    <label>Nhập mã vận động viên:</label>
    <input type="text" name="mavdv" required />
    <input type="submit" value="Tìm" />
</form>

<%
    model.vandongvien vdv = (model.vandongvien) request.getAttribute("result");
    String error = (String) request.getAttribute("error");

    if (error != null) {
%>
    <div class="error"><%= error %></div>
<% } else if (vdv != null) { %>
    <div class="result">
        <h3 style="text-align:center;">Kết quả:</h3>
        <table>
            <tr><th>Mã vận động viên</th><td><%= vdv.getMavdv() %></td></tr>
            <tr><th>Họ tên</th><td><%= vdv.getTenvdv() %></td></tr>
            <tr><th>Bộ môn</th><td><%= vdv.getBomon() %></td></tr>
            <tr><th>Ngày sinh</th><td><%= vdv.getNgaysinh() %></td></tr>
            <tr><th>Số huy chương</th><td><%= vdv.getSohc() %></td></tr>
        </table>
    </div>
<% } %>

<div class="back-link">
    <a href="hienthi">← Quay lại danh sách</a>
</div>

</body>
</html>
