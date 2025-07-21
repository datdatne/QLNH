/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.HoaDonDAO;
import dao.BanAnDAO;
import dao.KhoTaiChinhDAO;
import dao.ChiTietHoaDonDAO;
import dao.ThongKeDAO;
import model.ChiTietHoaDon;
import model.HoaDon;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.PhanQuyenUtil;

/**
 *
 * @author ACER
 */
@WebServlet(name = "ThuNganXuLy", urlPatterns = {"/ThuNganXuLy"})
public class ThuNganXuLy extends HttpServlet {

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
            out.println("<title>Servlet ThuNganXuLy</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ThuNganXuLy at " + request.getContextPath() + "</h1>");
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
        if (!PhanQuyenUtil.laThuNgan(request) || PhanQuyenUtil.laAdmin(request)) {
    response.sendRedirect("access_denied.jsp");
    return;
            }
        
     int maHD = Integer.parseInt(request.getParameter("maHD"));
        double tongTien = Double.parseDouble(request.getParameter("tongTien"));

        HoaDonDAO hoaDonDAO = new HoaDonDAO();
        BanAnDAO banAnDAO = new BanAnDAO();
        KhoTaiChinhDAO khoDAO = new KhoTaiChinhDAO();
        ChiTietHoaDonDAO chiTietDAO = new ChiTietHoaDonDAO();
        ThongKeDAO thongKeDAO = new ThongKeDAO();

        // 1. Cập nhật trạng thái hóa đơn thành "Đã thanh toán"
        hoaDonDAO.capNhatTrangThai(maHD, "Đã thanh toán");

        // 2. Lấy mã bàn từ hóa đơn
        HoaDon hd = hoaDonDAO.getHoaDonById(maHD);
        int maBan = hd.getMaBan();

        // 3. Cập nhật bàn về trạng thái "Trống"
        banAnDAO.updateTrangThai(maBan, "Trống");

        // 4. Nhập tiền vào kho
        khoDAO.luuVaoKho(tongTien, maHD);

        // 5. Cập nhật thống kê số món ăn đã bán
        List<ChiTietHoaDon> dsMon = chiTietDAO.getChiTietHoaDonByMaHD(maHD);
        for (ChiTietHoaDon ct : dsMon) {
            thongKeDAO.capNhatThongKeMon(ct.getMaMon(), ct.getSoLuong());
        }

        // 6. Chuyển hướng
        response.sendRedirect("DanhSachHoaDon?message=thanhcong");
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
