/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.ChiTietHoaDon;
/**
 *
 * @author ACER
 */
public class ChiTietHoaDonDAO extends DBConnect {
  public List<ChiTietHoaDon> getChiTietHoaDonByMaHD(int maHD) {
    List<ChiTietHoaDon> ds = new ArrayList<>();
    try {
       
        String sql = "SELECT cthd.*, mon.TenMon FROM chitiethoadon cthd JOIN monan mon ON cthd.MaMon = mon.MaMon WHERE MaHD = ?";
        PreparedStatement ps = getConnection().prepareStatement(sql);
        ps.setInt(1, maHD);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            ChiTietHoaDon cthd = new ChiTietHoaDon();
            cthd.setMaHD(rs.getInt("MaHD"));
            cthd.setMaMon(rs.getString("MaMon"));
            cthd.setSoLuong(rs.getInt("SoLuong"));
            cthd.setDonGia(rs.getDouble("DonGia"));
            cthd.setTenMon(rs.getString("TenMon"));
            ds.add(cthd);
        }
        getConnection().close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return ds;
}
     public void themChiTiet(int maHD, String maMon, int soLuong, double donGia) {
        String sql = "INSERT INTO chitiethoadon (MaHD, MaMon, SoLuong, DonGia) VALUES (?, ?, ?, ?)";
        try (
             PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, maHD);
            ps.setString(2, maMon);
            ps.setInt(3, soLuong);
            ps.setDouble(4, donGia);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
}
}
