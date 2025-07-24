/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.NhanVienDAO;
import model.NhanVien;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ACER
 */
@WebServlet(name = "NhanVienServlet", urlPatterns = {"/NhanVienServlet"})
public class NhanVienServlet extends HttpServlet {

    private NhanVienDAO dao;

    public void init() {
        dao = new NhanVienDAO();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NhanVienServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NhanVienServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String action = request.getParameter("action");
        try {
            if (action == null || action.equals("list")) {
                List<model.NhanVien> ds = dao.getAllNhanVien();
                request.setAttribute("dsNhanVien", ds);
                request.getRequestDispatcher("form_nhanvien.jsp").forward(request, response);
            } else if (action.equals("delete")) {
                int id = Integer.parseInt(request.getParameter("id"));
                dao.delete(id);
                response.sendRedirect("NhanVienServlet?action=list");
            } else if (action.equals("edit")) {
                int id = Integer.parseInt(request.getParameter("id"));
                model.NhanVien nv = dao.getById(id);
                request.setAttribute("nv", nv);
                request.getRequestDispatcher("editNhanVien.jsp").forward(request, response);
            } else if (action.equals("add")) {
                request.getRequestDispatcher("editNhanVien.jsp").forward(request, response);
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String action = request.getParameter("action");

    try {
        int maNV = Integer.parseInt(request.getParameter("maNV"));
        String hoTen = request.getParameter("hoTen");
        String sdt = request.getParameter("sdt");
        Date ngaySinh = Date.valueOf(request.getParameter("ngaySinh"));

        // Kiểm tra định dạng số điện thoại: 10 số, bắt đầu bằng 0
        if (!sdt.matches("^0\\d{9}$")) {
            // Trả lỗi và giữ lại dữ liệu đã nhập
            NhanVien nv = new NhanVien(maNV, hoTen, ngaySinh, sdt);
            request.setAttribute("nv", nv);
            request.setAttribute("error", "Số điện thoại phải có 10 chữ số và bắt đầu bằng số 0.");
            request.getRequestDispatcher("editNhanVien.jsp").forward(request, response);
            return; // Ngừng xử lý tiếp
        }

        NhanVien nv = new NhanVien(maNV, hoTen, ngaySinh, sdt);

      if ("insert".equals(action)) {
    dao.insert(nv);
    request.getSession().setAttribute("success", "Thêm nhân viên thành công!");
} else if ("update".equals(action)) {
    dao.update(nv);
    request.getSession().setAttribute("success", "Cập nhật nhân viên thành công!");
}
response.sendRedirect("NhanVienServlet?action=list");

    } catch (Exception e) {
        throw new ServletException(e);
    }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}