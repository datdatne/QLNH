<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="model.KhoTaiChinh"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Kho Tài Chính</title>

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">

    <script>
        const contextPath = "<%= request.getContextPath() %>";
    </script>

    <style>
        :root {
            --primary: #4CAF50;
            --secondary: #2E7D32;
            --light: #f2f2f2;
            --dark: #333;
            --text: #212121;
        }

        * {
            box-sizing: border-box;
            padding: 0;
            margin: 0;
        }

        body {
            font-family: 'Roboto', sans-serif;
            background: linear-gradient(to right, #e8f5e9, #ffffff);
            color: var(--text);
            padding: 20px;
        }

        h2 {
            text-align: center;
            margin: 40px 0 20px;
            font-size: 32px;
            color: var(--secondary);
        }

        table {
            width: 90%;
            margin: auto;
            border-collapse: collapse;
            box-shadow: 0 8px 16px rgba(0,0,0,0.1);
            border-radius: 10px;
            overflow: hidden;
            background-color: white;
        }

        th, td {
            padding: 12px 16px;
            text-align: center;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: var(--primary);
            color: white;
            font-size: 16px;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        tr:hover {
            background-color: #e0f2f1;
            transition: background-color 0.3s ease;
        }

        #thongkeBox, #thongbao, #soHoaDon, #tongTien {
            width: 90%;
            margin: 30px auto;
            text-align: center;
            padding: 20px;
            background-color: white;
            border: 1px solid #ccc;
            border-radius: 12px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.05);
        }

        select, input[type="text"], button {
            padding: 12px 18px;
            margin: 10px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 8px;
            transition: all 0.3s ease;
        }

        select:focus, input[type="text"]:focus {
            border-color: var(--primary);
            outline: none;
            box-shadow: 0 0 5px rgba(76, 175, 80, 0.4);
        }

        button {
            background-color: var(--primary);
            color: white;
            border: none;
            cursor: pointer;
        }

        button:hover {
            background-color: var(--secondary);
            transform: scale(1.03);
        }

        #soHoaDon, #tongTien {
            font-size: 20px;
            font-weight: bold;
            color: var(--secondary);
        }

        #thongbao {
            color: red;
            font-size: 16px;
            margin-top: 10px;
        }
    </style>
</head>
<body>

    <h2>📦 Danh sách lịch sử nhập kho tài chính</h2>

    <%
        List<KhoTaiChinh> danhSach = (List<KhoTaiChinh>) request.getAttribute("danhSachKho");
        if (danhSach == null || danhSach.isEmpty()) {
    %>
        <p style="text-align: center;">Không có dữ liệu trong kho tài chính.</p>
    <%
        } else {
    %>
        <table>
            <tr>
                <th>Mã Kho</th>
                <th>Ngày Nhập</th>
                <th>Số Tiền (VNĐ)</th>
                <th>Mã Hóa Đơn</th>
            </tr>
            <%
                for (KhoTaiChinh kho : danhSach) {
            %>
            <tr>
                <td><%= kho.getMaKho() %></td>
                <td><%= kho.getNgay() %></td>
                <td><%= String.format("%,.0f", kho.getSoTien()) %></td>
                <td><%= kho.getMaHD() %></td>
            </tr>
            <% } %>
        </table>
    <%
        }
    %>

    <!-- Giao diện Thống Kê -->
    <div id="thongkeBox">
        <h3>📊 Thống kê kho tài chính</h3>
        <select id="chonKieu">
            <option value="ngay">Theo ngày</option>
            <option value="thang">Theo tháng</option>
            <option value="nam">Theo năm</option>
        </select>

        <input type="text" id="chonGiaTri" value="2025" placeholder="Nhập giá trị..." />
        <button onclick="thongKe()">Thống kê</button>

        <div id="soHoaDon"></div>
        <div id="tongTien"></div>
        <div id="thongbao"></div>
    </div>

    <!-- JavaScript -->
    <script>
        function thongKe() {
            const kieu = document.getElementById("chonKieu").value;
            const giatri = document.getElementById("chonGiaTri").value;

            console.log("Gửi request với:", kieu, giatri); // debug

            fetch('<%= request.getContextPath() %>/thongke-khotc?kieu=' + kieu + '&giatri=' + giatri)
                .then(response => {
                    if (!response.ok) throw new Error("HTTP lỗi");
                    return response.json();
                })
                .then(data => {
                    console.log("Kết quả:", data);
                    document.getElementById("soHoaDon").innerText = "Số hóa đơn: " + data.soHD;
                    document.getElementById("tongTien").innerText = "Tổng tiền: " + data.tongTien.toLocaleString("vi-VN") + " đ";
                    document.getElementById("thongbao").innerText = "";
                })
                .catch(error => {
                    console.error("Lỗi:", error);
                    document.getElementById("thongbao").innerText = "Có lỗi xảy ra!";
                });
        }
    </script>

</body>
</html>
