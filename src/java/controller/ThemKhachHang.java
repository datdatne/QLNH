/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.BanAnDAO;
import dao.KhachHangDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.KhachHang;

/**
 *
 * @author ACER
 */
@WebServlet(name = "ThemKhachHang", urlPatterns = {"/ThemKhachHang"})
public class ThemKhachHang extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ThemKhachHang</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ThemKhachHang at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        request.setCharacterEncoding("UTF-8");
        
        // Lấy thông tin khách hàng từ form
        String ten = request.getParameter("hoten");
        String sdt = request.getParameter("sdt");
        String diaChi = request.getParameter("diachi");
        String email = request.getParameter("email");
        int maBan = Integer.parseInt(request.getParameter("maBan"));

        // Gọi DAO để lưu khách hàng vào DB
        KhachHang kh = new KhachHang();
        kh.setHoTen(ten);
        kh.setSDT(sdt);
        kh.setDiaChi(diaChi);
        kh.setEmail(email);

        // Giả sử insert() trả về mã khách hàng mới
        int maKH = new KhachHangDAO().insert(kh);

        // Cập nhật trạng thái bàn thành "Đã đặt"
        new BanAnDAO().updateTrangThai(maBan, "Đã đặt");

        // Lưu mã bàn và mã khách hàng vào session
        HttpSession session = request.getSession();
        session.setAttribute("maBan", maBan);
        session.setAttribute("maKH", maKH);

       // response.sendRedirect("chonban.jsp"); // CHÚ Ý: sử dụng đúng đường dẫn
        request.getRequestDispatcher("chonban.jsp").forward(request, response);
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
