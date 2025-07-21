/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.MonAnDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.CartItem;
import model.MonAn;

/**
 *
 * @author ACER
 */
@WebServlet(name = "Cart", urlPatterns = {"/Cart"})
public class Cart extends HttpServlet {

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
            out.println("<title>Servlet Cart</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Cart at " + request.getContextPath() + "</h1>");
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
         String action = request.getParameter("action"); // null, "decrease", "remove"
        String maMon = request.getParameter("maMon");
        int maBan = Integer.parseInt(request.getParameter("maBan")); // bắt buộc có

        // Key session giỏ hàng riêng cho từng bàn
        String cartKey = "cart_ban_" + maBan;

        HttpSession session = request.getSession();
        List<CartItem> cart = (List<CartItem>) session.getAttribute(cartKey);
        if (cart == null) {
            cart = new ArrayList<>();
        }

        // -------------------- XỬ LÝ GIẢM SỐ LƯỢNG --------------------
        if ("decrease".equals(action)) {
            Iterator<CartItem> iterator = cart.iterator();
            while (iterator.hasNext()) {
                CartItem item = iterator.next();
                if (item.getMon().getMaMon().equals(maMon)) {
                    int newQty = item.getSoLuong() - 1;
                    if (newQty <= 0) {
                        iterator.remove();
                    } else {
                        item.setSoLuong(newQty);
                    }
                    break;
                }
            }
            session.setAttribute(cartKey, cart);
            response.sendRedirect("cart.jsp?maBan=" + maBan);
            return;
        }

        // -------------------- XỬ LÝ XÓA HẲN MÓN --------------------
        if ("remove".equals(action)) {
            cart.removeIf(item -> item.getMon().getMaMon().equals(maMon));
            session.setAttribute(cartKey, cart);
            response.sendRedirect("cart.jsp?maBan=" + maBan);
            return;
        }

        // -------------------- MẶC ĐỊNH: THÊM MÓN --------------------
        try {
            int soLuong = Integer.parseInt(request.getParameter("soLuong"));
            boolean daCo = false;

            for (CartItem item : cart) {
                if (item.getMon().getMaMon().equals(maMon)) {
                    item.setSoLuong(item.getSoLuong() + soLuong);
                    daCo = true;
                    break;
                }
            }

            if (!daCo) {
                MonAnDAO dao = new MonAnDAO();
                MonAn mon = dao.getById(maMon);
                if (mon != null) {
                    cart.add(new CartItem(mon, soLuong));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Cập nhật giỏ và chuyển về menu
        session.setAttribute(cartKey, cart);
        response.sendRedirect("Menu?maBan=" + maBan);
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
