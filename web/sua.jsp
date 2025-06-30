<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="model.vandongvien" %>
<%
    vandongvien vdv = (vandongvien) request.getAttribute("vdv");
    if (vdv == null) {
%>
    <p>Không tìm thấy thông tin vận động viên.</p>
<%
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sửa Vận Động Viên</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: #f5f7fa;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 500px;
            margin: 60px auto;
            background: #ffffff;
            padding: 30px 40px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
            border-radius: 10px;
        }
        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 25px;
        }
        label {
            display: block;
            margin-top: 15px;
            font-weight: bold;
            color: #444;
        }
        input[type="text"], input[type="date"] {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 6px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            width: 100%;
            padding: 12px;
            background: #28a745;
            border: none;
            color: white;
            font-weight: bold;
            margin-top: 25px;
            border-radius: 6px;
            cursor: pointer;
            transition: background 0.3s ease;
        }
        input[type="submit"]:hover {
            background: #218838;
        }
        .back-link {
            text-align: center;
            margin-top: 20px;
        }
        .back-link a {
            color: #007bff;
            text-decoration: none;
        }
        .back-link a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>SỬA THÔNG TIN VẬN ĐỘNG VIÊN</h2>
        <form action="sua" method="post">
            <input type="hidden" name="mavdv" value="<%=vdv.getMavdv()%>" />

            <label>Tên vận động viên:</label>
            <input type="text" name="tenvdv" value="<%=vdv.getTenvdv()%>" required />

            <label>Bộ môn:</label>
            <input type="text" name="bomon" value="<%=vdv.getBomon()%>" required />

            <label>Ngày sinh:</label>
            <input type="text" name="ngaysinh" value="<%=vdv.getNgaysinh()%>" required />

            <label>Số huy chương:</label>
            <input type="text" name="sohc" value="<%=vdv.getSohc()%>" required />

            <input type="submit" value="Cập Nhật" />
        </form>
        <div class="back-link">
            <a href="hienthi">← Quay lại danh sách</a>
        </div>
    </div>
</body>
</html>
