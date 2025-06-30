<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm Vận Động Viên</title>
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
        input[type="text"], input[type="date"], input[type="number"] {
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
            background: #007bff;
            border: none;
            color: white;
            font-weight: bold;
            margin-top: 25px;
            border-radius: 6px;
            cursor: pointer;
            transition: background 0.3s ease;
        }
        input[type="submit"]:hover {
            background: #0056b3;
        }
        .back-link {
            text-align: center;
            margin-top: 20px;
        }
        .back-link a {
            color: #28a745;
            text-decoration: none;
        }
        .back-link a:hover {
            text-decoration: underline;
        }
        @media (max-width: 600px) {
            .container {
                width: 90%;
                padding: 20px;
            }
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>THÊM THÔNG TIN VẬN ĐỘNG VIÊN</h2>
        <form action="them" method="post">
            <label>Mã vận động viên:</label>
            <input type="text" name="mavdv" placeholder="Nhập mã VĐV" value="${mavdv}" required />

            <label>Tên vận động viên:</label>
            <input type="text" name="tenvdv" placeholder="Nhập tên VĐV" value="${tenvdv}" required />

            <label>Bộ môn:</label>
            <input type="text" name="bomon" placeholder="Nhập bộ môn" value="${bomon}" required />

            <label>Ngày sinh:</label>
            <input type="text" name="ngaysinh" value="${ngaysinh}" required />

            <label>Số huy chương:</label>
            <input type="number" name="sohc" placeholder="Nhập số huy chương" value="${sohc}" min="0" required />

            <input type="submit" value="Thêm Mới" />
        </form>
        <div class="back-link">
            <a href="hienthi">← Quay lại danh sách</a>
        </div>
    </div>
</body>
</html>
