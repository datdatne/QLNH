/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.*;
/**
 *
 * @author ACER
 */
public class ThongKeDAO extends DBConnect{
    public void capNhatThongKeMon(String maMon, int soLuong) {
    try  {
        // Check tồn tại
        String sqlCheck = "SELECT * FROM thongke_monan WHERE MaMon=? AND Ngay=CURDATE()";
        PreparedStatement psCheck = getConnection().prepareStatement(sqlCheck);
        psCheck.setString(1, maMon);
        ResultSet rs = psCheck.executeQuery();

        if (rs.next()) {
            // Đã tồn tại => Cộng dồn
            String sqlUpdate = "UPDATE thongke_monan SET SoLuong = SoLuong + ? WHERE MaMon=? AND Ngay=CURDATE()";
            PreparedStatement psUpdate = getConnection().prepareStatement(sqlUpdate);
            psUpdate.setInt(1, soLuong);
            psUpdate.setString(2, maMon);
            psUpdate.executeUpdate();
        } else {
            // Chưa có => Insert
            String sqlInsert = "INSERT INTO thongke_monan (MaMon, Ngay, SoLuong) VALUES (?, CURDATE(), ?)";
            PreparedStatement psInsert = getConnection().prepareStatement(sqlInsert);
            psInsert.setString(1, maMon);
            psInsert.setInt(2, soLuong);
            psInsert.executeUpdate();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
     public static int demSoHoaDonTheoNgay(String ngay) {
        int soLuong = 0;
        String sql = "SELECT COUNT(*) FROM khotaichinh WHERE Ngay = ?";
        try (Connection conn = new DBConnect().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, ngay);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                soLuong = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return soLuong;
    }

    public static double tongTienTheoNgay(String ngay) {
        double tong = 0;
        String sql = "SELECT SUM(SoTien) FROM khotaichinh WHERE Ngay = ?";
        try (Connection conn = new DBConnect().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, ngay);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                tong = rs.getDouble(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tong;
    }

    public static int demSoHoaDonTheoThang(String thangNam) {
        int soLuong = 0;
        String sql = "SELECT COUNT(*) FROM khotaichinh WHERE DATE_FORMAT(Ngay, '%Y-%m') = ?";
        try (Connection conn = new DBConnect().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, thangNam);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                soLuong = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return soLuong;
    }

    public static double tongTienTheoThang(String thangNam) {
        double tong = 0;
        String sql = "SELECT SUM(SoTien) FROM khotaichinh WHERE DATE_FORMAT(Ngay, '%Y-%m') = ?";
        try (Connection conn = new DBConnect().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, thangNam);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                tong = rs.getDouble(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tong;
    }

    public static int demSoHoaDonTheoNam(String nam) {
        int soLuong = 0;
        String sql = "SELECT COUNT(*) FROM khotaichinh WHERE YEAR(Ngay) = ?";
        try (Connection conn = new DBConnect().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nam);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                soLuong = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return soLuong;
    }

    public static double tongTienTheoNam(String nam) {
        double tong = 0;
        String sql = "SELECT SUM(SoTien) FROM khotaichinh WHERE YEAR(Ngay) = ?";
        try (Connection conn = new DBConnect().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nam);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                tong = rs.getDouble(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tong;
    }
}
