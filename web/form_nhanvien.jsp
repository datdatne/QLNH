

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, model.NhanVien" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản Lí Nhân Viên</title>
    </head>
    <body>
        <h2>Danh sách nhân viên</h2>
    <table border="1">
        <tr>
            <th>Mã NV</th>
            <th>Tên NV</th>
            <th>Giới tính</th>
            <th>SĐT</th>
            <th>Chức vụ</th>
            <th>Thao tác</th>
        </tr>
        <%
            List<NhanVien> ds = (List<NhanVien>) request.getAttribute("dsNhanVien");
            if (ds != null) {
                for (NhanVien nv : ds) {
        %>
        <tr>
            <td><%= nv.getMaNV() %></td>
            <td><%= nv.getHoTen() %></td>
            <td><%= nv.getNgaySinh() %></td>
            <td><%= nv.getChucVu() %></td>
            <td><%= nv.getSDT() %></td>
            <td>
                <a href="suaNhanVien.jsp?id=<%= nv.getMaNV() %>">Sửa</a> |
                <a href="NhanVienServlet?action=xoa&id=<%= nv.getMaNV() %>">Xóa</a>
            </td>
        </tr>
        <%
                }
            }
        %>
    </table>
    <a href="themNhanVien.jsp">Thêm nhân viên mới</a>
    </body>
</html>
