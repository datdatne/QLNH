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
   public int themKhachHang(KhachHang kh) {
        int maKH = -1;
        String sql = "INSERT INTO khachhang (HoTen, SDT, DiaChi, Email) VALUES (?, ?, ?, ?)";
        
        try (
             PreparedStatement ps = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, kh.getHoTen());
            ps.setString(2, kh.getSDT());
            ps.setString(3, kh.getDiaChi());
            ps.setString(4, kh.getEmail());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    maKH = rs.getInt(1); // lấy mã khách hàng tự tăng
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return maKH;
    }
   public KhachHang getKhachHangById(int maKH) {
        String sql = "SELECT * FROM khachhang WHERE MaKH = ?";
        try (
             PreparedStatement ps = getConnection().prepareStatement(sql)) {

            ps.setInt(1, maKH);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new KhachHang(
                    rs.getInt("MaKH"),
                    rs.getString("HoTen"),
                    rs.getString("SDT"),
                    rs.getString("DiaChi"),
                    rs.getString("Email")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
