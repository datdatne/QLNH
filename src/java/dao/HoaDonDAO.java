/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.HoaDon;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.ChiTietHoaDon;
/**
 *
 * @author ACER
 */
public class HoaDonDAO extends DBConnect {
    public int insertHoaDon(HoaDon hd) throws Exception {
        String sql = "INSERT INTO hoadon (MaKH, NgayLap, TongTien) VALUES (?, ?, ?)";
        PreparedStatement ps = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, hd.getMaKH());
        ps.setDate(2, new java.sql.Date(hd.getNgayLap().getTime()));
        ps.setDouble(3, hd.getTongTien());
        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) return rs.getInt(1); // trả về mã hóa đơn tự tăng
        return 0;
    }
    public void insertChiTiet(List<ChiTietHoaDon> list) throws Exception {
        String sql = "INSERT INTO chitiethoadon (MaHD, MaMon, SoLuong) VALUES (?, ?, ?)";
        PreparedStatement ps = getConnection().prepareStatement(sql);
        for (ChiTietHoaDon ct : list) {
            ps.setInt(1, ct.getMaHD());
            ps.setString(2, ct.getMaMon());
            ps.setInt(3, ct.getSoLuong());
            ps.addBatch();
        }
        ps.executeBatch();
    }
    public List<HoaDon> getHoaDonChuaThanhToan() throws Exception {
    List<HoaDon> list = new ArrayList<>();
    String sql = "SELECT * FROM hoadon WHERE TrangThai = 'Chờ'";
    PreparedStatement ps = getConnection().prepareStatement(sql);
    ResultSet rs = ps.executeQuery();

    while (rs.next()) {
        HoaDon hd = new HoaDon();
        hd.setMaHD(rs.getInt("MaHD"));
        hd.setMaKH(rs.getInt("MaKH"));
        hd.setNgayLap(rs.getDate("NgayLap"));
        hd.setTongTien(rs.getDouble("TongTien"));
        hd.setTrangThai(rs.getString("TrangThai"));
        list.add(hd);
    }
    return list;
}

}
