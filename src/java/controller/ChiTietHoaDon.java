/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.ChiTietHoaDonDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.CartItem;
import model.MonAn;
import utils.PhanQuyenUtil;

/**
 *
 * @author ACER
 */
@WebServlet(name = "ChiTietHoaDon", urlPatterns = {"/ChiTietHoaDon"})
public class ChiTietHoaDon extends HttpServlet {

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
            out.println("<title>Servlet ChiTietHoaDon</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ChiTietHoaDon at " + request.getContextPath() + "</h1>");
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
        if (! (PhanQuyenUtil.laThuNgan(request) || PhanQuyenUtil.laAdmin(request))  ) {
    response.sendRedirect("access_denied.jsp");
    return;
            }

      int maHD = Integer.parseInt(request.getParameter("maHD"));

        ChiTietHoaDonDAO cthdDAO = new ChiTietHoaDonDAO();

        // Lấy danh sách chi tiết hóa đơn từ DB
        List<model.ChiTietHoaDon> chiTietList = cthdDAO.getChiTietHoaDonByMaHD(maHD);

        // Nếu chưa có, thì lấy từ giỏ hàng (session) để insert
        if (chiTietList == null || chiTietList.isEmpty()) {
            HttpSession session = request.getSession();
            List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");

            if (cart != null) {
                for (CartItem item : cart) {
                    MonAn mon = item.getMon(); // lấy món ăn
                    String maMon = mon.getMaMon();
                    int soLuong = item.getSoLuong();
                    double donGia = mon.getDonGia(); // đơn giá từ bảng món ăn

                    cthdDAO.themChiTiet(maHD, maMon, soLuong, donGia);
                }

                // Lấy lại dữ liệu chi tiết hóa đơn sau khi thêm
                chiTietList = cthdDAO.getChiTietHoaDonByMaHD(maHD);
            }
        }

        // Gửi dữ liệu sang JSP
        request.setAttribute("maHD", maHD);
        request.setAttribute("chiTietList", chiTietList);

        request.getRequestDispatcher("chitiethoadon.jsp").forward(request, response);
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
