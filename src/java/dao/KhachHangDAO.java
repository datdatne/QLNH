/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.*;
import model.KhachHang;
/**
 *
 * @author ACER
 */
public class KhachHangDAO extends DBConnect {
    public int insert(KhachHang kh) throws Exception {
        String sql = "INSERT INTO khachhang (HoTen, SDT, DiaChi, Email) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, kh.getHoTen());
        ps.setString(2, kh.getSDT());
        ps.setString(3, kh.getDiaChi());
        ps.setString(4, kh.getEmail());
        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) return rs.getInt(1); 
        return 0;
    }
}
