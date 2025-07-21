/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.KhoTaiChinhDAO;
import dao.ThongKeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.KhoTaiChinh;
import org.json.JSONObject;


/**
 *
 * @author ACER
 */
@WebServlet(name = "ThongKeKhoTaiChinhServlet", urlPatterns = {"/thongke-khotc"})
public class ThongKeKhoTaiChinhServlet extends HttpServlet {

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
            out.println("<title>Servlet ThongKeKhoTaiChinhServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ThongKeKhoTaiChinhServlet at " + request.getContextPath() + "</h1>");
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
     String kieu = request.getParameter("kieu");  // ngay | thang | nam
        String giatri = request.getParameter("giatri");  // 2025-07-21 hoặc 2025-07 hoặc 2025

        int soHD = 0;
        double tongTien = 0;

        if ("ngay".equals(kieu)) {
            soHD = ThongKeDAO.demSoHoaDonTheoNgay(giatri);
            tongTien = ThongKeDAO.tongTienTheoNgay(giatri);
        } else if ("thang".equals(kieu)) {
            soHD = ThongKeDAO.demSoHoaDonTheoThang(giatri);
            tongTien = ThongKeDAO.tongTienTheoThang(giatri);
        } else if ("nam".equals(kieu)) {
            soHD = ThongKeDAO.demSoHoaDonTheoNam(giatri);
            tongTien = ThongKeDAO.tongTienTheoNam(giatri);
        }

        // Trả kết quả JSON về client
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        JSONObject obj = new JSONObject();
        obj.put("soHD", soHD);
        obj.put("tongTien", tongTien);

        PrintWriter out = response.getWriter();
        out.print(obj.toString());
        out.flush();
        
        
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
         processRequest(request, response);  
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
