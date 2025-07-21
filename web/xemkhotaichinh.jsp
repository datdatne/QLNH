<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="model.KhoTaiChinh"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Kho Tài Chính</title>
    <script>
    const contextPath = "<%= request.getContextPath() %>";
</script>

    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        h2 {
            text-align: center;
            margin-top: 30px;
        }
        table {
            width: 80%;
            margin: auto;
            border-collapse: collapse;
            margin-top: 30px;
        }
        th, td {
            border: 1px solid #333;
            padding: 10px;
            text-align: center;
        }
        th {
            background-color: #4CAF50;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        #thongkeBox {
            width: 80%;
            margin: 40px auto;
            text-align: center;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 10px;
        }

        input, select, button {
            padding: 10px;
            margin: 10px;
            font-size: 16px;
        }

        #ketQuaThongKe {
            margin-top: 20px;
            font-size: 18px;
            font-weight: bold;
        }
    </style>
</head>
<body>

    <h2>Danh sách lịch sử nhập kho tài chính</h2>

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
    <% } %>

    <div id="thongkeBox">
        <h3>📊 Thống kê Kho Tài Chính</h3>
        <select id="kieuThongKe">
            <option value="ngay">Theo ngày</option>
            <option value="thang">Theo tháng</option>
            <option value="nam">Theo năm</option>
        </select>

        <input type="text" id="giatriThongKe" placeholder="Nhập giá trị (vd: 2025-07-19 hoặc 2025-07 hoặc 2025)">
        <button onclick="thongKe()">Thống kê</button>

        <div id="ketQuaThongKe"></div>
    </div>

    <script>
    function thongKe() {
        const kieu = document.getElementById('kieuThongKe').value;
        const giatri = document.getElementById('giatriThongKe').value;

        if (!giatri.trim()) {
            alert("Vui lòng nhập giá trị cần thống kê.");
            return;
        }

        fetch(`${contextPath}/thongke-khotc?kieu=${kieu}&giatri=${giatri}`)

            .then(response => {
                if (!response.ok) throw new Error("Lỗi phản hồi từ server");
                return response.json();
            })
            .then(data => {
                document.getElementById('ketQuaThongKe').innerHTML =
                    `<p><b>Số hóa đơn:</b> ${data.soHD}</p>` +
                    `<p><b>Tổng tiền:</b> ${data.tongTien.toLocaleString()} VNĐ</p>`;
            })
            .catch(err => {
                console.error('Lỗi khi thống kê:', err);
                document.getElementById('ketQuaThongKe').innerHTML =
                    `<p style="color:red;">Không thể lấy dữ liệu thống kê. Kiểm tra server hoặc đầu vào!</p>`;
            });
    }
    </script>

</body>
</html>
