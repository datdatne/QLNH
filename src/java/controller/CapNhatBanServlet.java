/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.BanAnDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ACER
 */
@WebServlet(name = "CapNhatBanServlet", urlPatterns = {"/capnhatban"})
public class CapNhatBanServlet extends HttpServlet {

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
            out.println("<title>Servlet CapNhatBanServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CapNhatBanServlet at " + request.getContextPath() + "</h1>");
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
        String maBanStr = request.getParameter("maBan");
    String hanhDong = request.getParameter("hanhDong");

    if (maBanStr == null || maBanStr.isEmpty()) {
        request.setAttribute("thongbao", "❌ Không có mã bàn được gửi!");
        request.getRequestDispatcher("chonban.jsp").forward(request, response);
        return;
    }

    int maBan = Integer.parseInt(maBanStr);
    BanAnDAO dao = new BanAnDAO();
    HttpSession session = request.getSession();

    // Lấy trạng thái hiện tại của bàn
    String trangThai = dao.getTrangThai(maBan);

    if ("dangan".equalsIgnoreCase(hanhDong)) {
        dao.updateTrangThai(maBan, "Đang ăn");
        request.setAttribute("thongbao", "🍽️ Bàn đang phục vụ khách.");

    } else if ("trong".equalsIgnoreCase(hanhDong)) {
        dao.updateTrangThai(maBan, "Trống");
        session.removeAttribute("maBan");
        session.removeAttribute("cart");
        request.setAttribute("thongbao", "✅ Bàn đã được giải phóng.");

    } else if ("chon".equalsIgnoreCase(hanhDong)) {
        if ("Trống".equalsIgnoreCase(trangThai)) {
            dao.updateTrangThai(maBan, "Đã đặt");
            session.setAttribute("maBan", maBan);
            response.sendRedirect("menu.jsp");
            return;
        } else if ("Đã đặt".equalsIgnoreCase(trangThai)) {
            request.setAttribute("thongbao", "⚠️ Bàn này đã được đặt trước.");
        } else if ("Đang ăn".equalsIgnoreCase(trangThai)) {
            request.setAttribute("thongbao", "⚠️ Bàn này đang có khách dùng bữa.");
        } else {
            request.setAttribute("thongbao", "❌ Trạng thái bàn không hợp lệ.");
        }
    } else {
        request.setAttribute("thongbao", "⚠️ Không rõ hành động yêu cầu.");
    }

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
