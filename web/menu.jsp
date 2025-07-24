<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Menu Món Ăn</title>
    <!-- Bootstrap 5 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background-color: #f0fff0; /* xanh lá rất nhẹ */
            font-family: 'Segoe UI', sans-serif;
        }
        .menu-title {
            color: #2e7d32; /* xanh lá đậm */
            font-weight: bold;
        }
        .item-card {
            background-color: #ffffff;
            border: 1px solid #c8e6c9;
            border-radius: 10px;
            padding: 15px;
            transition: transform 0.2s;
            height: 100%;
        }
        .item-card:hover {
            transform: scale(1.03);
            box-shadow: 0 4px 8px rgba(46, 125, 50, 0.2);
        }
        .item-card img {
            width: 100%;
            height: 150px;
            object-fit: cover;
            border-radius: 8px;
        }
    </style>
</head>
<body>
<%
    Integer maBan = (Integer) session.getAttribute("maBan");
    if (maBan == null) {
        response.sendRedirect("chonban.jsp");
        return;
    }

    if (!(utils.PhanQuyenUtil.laAdmin(request) || utils.PhanQuyenUtil.laPhucVu(request))) {
        response.sendRedirect("access_denied.jsp");
        return;
    }
%>

<div class="container py-4">
    <h2 class="menu-title">🍽️ Đang order cho <span class="text-success">Bàn số <%= maBan %></span></h2>
    <h3 class="menu-title mt-3">🍜 Danh sách món ăn</h3>
    <a href="cart.jsp" class="btn btn-outline-success mb-4">🛒 Xem giỏ hàng</a>

    <div class="row">
        <c:forEach var="mon" items="${monList}">
            <div class="col-md-4 mb-4">
                <div class="item-card h-100">
                    <img src="${pageContext.request.contextPath}/image/${mon.hinhAnh}" alt="${mon.tenMon}" />
                    <h5 class="mt-3">${mon.tenMon}</h5>
                    <p class="text-muted">${mon.donGia} VNĐ</p>
                    <form action="Cart" method="post" class="d-flex">
                        <input type="hidden" name="maBan" value="${maBan}">
                        <input type="hidden" name="maMon" value="${mon.maMon}">
                        <input type="number" name="soLuong" value="1" min="1" class="form-control me-2" style="width: 70px;">
                        <button type="submit" class="btn btn-success">Thêm</button>
                    </form>
                </div>
            </div>
        </c:forEach>
    </div>

    <div class="d-flex gap-2 mt-4">
        <!-- Thông báo phục vụ -->
        <form action="capnhatban" method="post">
            <input type="hidden" name="maBan" value="<%= maBan %>"/>
            <input type="hidden" name="hanhDong" value="dangan"/>
            <button class="btn btn-warning">🔔 Thông báo phục vụ</button>
        </form>

        <!-- Kết thúc bàn -->
        <form action="capnhatban" method="post">
            <input type="hidden" name="maBan" value="<%= maBan %>"/>
            <input type="hidden" name="hanhDong" value="trong"/>
            <button class="btn btn-outline-success">✅ Kết thúc bàn</button>
        </form>
    </div>
</div>
</body>
</html>
