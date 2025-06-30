<%-- 
    Document   : danhsach
    Created on : 15 thg 6, 2025, 21:56:19
    Author     : a
--%>

<%@page import="model.nhanvien"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <form action="timkiem" method="post">
            <input type="text" name="MaNV" placeholder="nhap ma">
            <input type="submit" name="name" value="tim kiem">
            
        </form>
        <div align="center"><a href="them.jsp"><button>them</button></a></div>
        <table border="1" align="center">
            <tr>
                <th>ma</th>
                <th>ten</th>
                <th>ngay sinh</th>
                <th>gioi tinh</th>
                <th>dien thoai</th>
                <th>thao tac</th>

            </tr>
            <%
                List<nhanvien> list = (List<nhanvien>) request.getAttribute("nvs");
                for (nhanvien nv : list) {
            %>
            <tr>
                <td><%=nv.getMaNv() %></td>
            <td><%=nv.getHoTen()%></td>
            <td><%=nv.getNgaySinh()%></td>
            <td><%=nv.isGioiTinh() ? "nam":"nu"%></td>
            <td><%=nv.getDienThoai()%></td>
            <td>
                <a href="sua?MaNv=<%=nv.getMaNv()%>"><button>sua</button></a>
                <a href="xoa?MaNv=<%=nv.getMaNv()%>"><button>xoa</button></a>

            </td>
            </tr>

            <%
                }
            %>
        </table>
    </body>
</html>
