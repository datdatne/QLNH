<%@ page import="java.util.List" %>
<%@ page import="dao.BanAnDAO" %>
<%@ page import="model.BanAn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Chọn Bàn</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">
    <style>
        body {
            background: linear-gradient(to right, #e0f7fa, #ffffff);
            font-family: 'Segoe UI', sans-serif;
        }

        .table-card {
            border-radius: 15px;
            padding: 20px;
            text-align: center;
            transition: transform 0.3s, box-shadow 0.3s;
            cursor: pointer;
            color: #fff;
        }

        .table-card:hover {
            transform: scale(1.05);
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.2);
        }

        .trong {
            background-color: #16a085;
        }

        .da-dat {
            background-color: #f39c12;
        }

        .dang-an {
            background-color: #c0392b;
        }

        .table-icon {
            font-size: 30px;
            margin-bottom: 10px;
        }

        .status {
            font-size: 14px;
            opacity: 0.8;
        }
    </style>
</head>
<body>
   <%
    if (!(utils.PhanQuyenUtil.laAdmin(request) || utils.PhanQuyenUtil.laPhucVu(request))) {
        response.sendRedirect("access_denied.jsp");
        return;
    }
%>


    <div class="container py-5">
        <h2 class="text-center mb-4">
            🍽️ <span class="text-primary">Chọn Bàn Để Order</span>
        </h2>

        <% String thongbao = (String) request.getAttribute("thongbao");
           if (thongbao != null) { %>
            <div class="alert alert-info text-center">
                <%= thongbao %>
            </div>
        <% } %>

        <div class="row row-cols-1 row-cols-sm-2 row-cols-md-4 g-4">
            <%
                List<BanAn> dsBan = new BanAnDAO().getAll();
                for (BanAn ban : dsBan) {
                    String classTrangThai = "trong";
                    String icon = "bi-check-circle";
                    String trangThaiText = ban.getTrangThai();

                    if ("Đang ăn".equalsIgnoreCase(trangThaiText)) {
                        classTrangThai = "dang-an";
                        icon = "bi-cup-straw";
                    } else if ("Đã đặt".equalsIgnoreCase(trangThaiText)) {
                        classTrangThai = "da-dat";
                        icon = "bi-lock-fill";
                    }
                    
                    // Đặt đường dẫn form theo trạng thái bàn
                    String actionURL = "Trống".equalsIgnoreCase(trangThaiText) ? "themkhachhang.jsp" : "chonban";
            %>
            <div class="col">
                <form action="<%= actionURL %>" method="post">
                    <input type="hidden" name="maBan" value="<%= ban.getMaBan() %>"/>
                    <button type="submit" class="w-100 table-card <%= classTrangThai %> border-0">
                        <div class="table-icon">
                            <i class="bi <%= icon %>"></i>
                        </div>
                        <div class="fs-5">Bàn <%= ban.getMaBan() %></div>
                        <div class="status"><%= ban.getTrangThai() %></div>
                    </button>
                </form>
            </div>
            <% } %>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
