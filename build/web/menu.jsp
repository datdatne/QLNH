<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Menu Món Ăn</title>
    <style>
        .item { display: inline-block; width: 250px; margin: 10px; border: 1px solid #ccc; padding: 10px; }
        .item img { width: 100%; height: 150px; object-fit: cover; }
    </style>
</head>
<body>
    <%
    Integer maBan = (Integer) session.getAttribute("maBan");
    if (maBan == null) {
        response.sendRedirect("chonban.jsp");
        return;
    }
%>

<%
    if (!(utils.PhanQuyenUtil.laAdmin(request) || utils.PhanQuyenUtil.laPhucVu(request))) {
        response.sendRedirect("access_denied.jsp");
        return;
    }
%>


<h2>🍽️ Đang order cho Bàn số <%= maBan %></h2>
    <h2>🍜 Danh sách món ăn</h2>
    <a href="cart.jsp">🛒 Xem giỏ hàng</a><br/><br/>
    <c:forEach var="mon" items="${monList}">
        <div class="item">
            <img src="${pageContext.request.contextPath}/images/${mon.hinhAnh}" width="200" height="150"/>

            <h4>${mon.tenMon}</h4>
            <p>${mon.donGia} VNĐ</p>
            <a href="menu.jsp"></a> 
           <form action="Cart" method="post">
    <input type="hidden" name="maBan" value="${maBan}">
    <input type="hidden" name="maMon" value="${mon.maMon}">
    <input type="number" name="soLuong" value="1">
    <button type="submit">Thêm</button>
</form>

        </div>
    </c:forEach>
    <!-- Nút thông báo bàn đã bắt đầu ăn -->
<form action="capnhatban" method="post">
    <input type="hidden" name="maBan" value="<%= maBan %>"/>
    <input type="hidden" name="hanhDong" value="dangan"/>
    <button class="btn btn-warning">🔔 Thông báo phục vụ</button>
</form>

<!-- Nút kết thúc bàn -->
<form action="capnhatban" method="post">
    <input type="hidden" name="maBan" value="<%= maBan %>"/>
    <input type="hidden" name="hanhDong" value="trong"/>
    <button class="btn btn-success">✅ Kết thúc bàn</button>
</form>
</body>
</html>
