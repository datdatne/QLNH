/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.TaiKhoan;
import java.sql.*;
/**
 *
 * @author ACER
 */
public class TaiKhoanDAO extends DBConnect {
    public TaiKhoan checkLogin(String user, String pass) {
        try {
            String sql = "SELECT * FROM taikhoan WHERE TenDangNhap=? AND MatKhau=?";
            PreparedStatement st = getConnection().prepareStatement(sql);
            st.setString(1, user);
            st.setString(2, pass);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new TaiKhoan(
                    rs.getString("TenDangNhap"),
                    rs.getString("MatKhau"),
                    rs.getString("VaiTro")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
