/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.HoaDon;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ACER
 */
public class HoaDonDAO extends DBConnect {
     public void insert(HoaDon hd) {
        String sql = "INSERT INTO hoadon (NgayLap, TongTien, TrangThai, MaBan, MaKH) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setDate(1, hd.getNgayLap());
            ps.setDouble(2, hd.getTongTien());
            ps.setString(3, hd.getTrangThai());
            ps.setInt(4, hd.getMaBan());
            ps.setInt(5, hd.getMaKH());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
}
     public List<HoaDon> getDSHoaDonCho() {
        List<HoaDon> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM hoadon WHERE TrangThai = 'Chờ'";
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHD(rs.getInt("MaHD"));
                hd.setNgayLap(rs.getDate("NgayLap"));
                hd.setTongTien(rs.getDouble("TongTien"));
                hd.setTrangThai(rs.getString("TrangThai"));
                hd.setMaBan(rs.getInt("MaBan"));
                hd.setMaKH(rs.getInt("MaKH"));
                list.add(hd);
            }
            getConnection().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
     public void capNhatTrangThai(int maHD, String trangThaiMoi) {
        try {
           
            String sql = "UPDATE hoadon SET TrangThai = ? WHERE MaHD = ?";
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, trangThaiMoi);
            ps.setInt(2, maHD);
            ps.executeUpdate();
            getConnection().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     public int insertAndReturnId(HoaDon hd) {
    int maHD = -1;
    try {
       
        String sql = "INSERT INTO hoadon (NgayLap, TongTien, TrangThai, MaBan, MaKH) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setDate(1, new java.sql.Date(hd.getNgayLap().getTime()));
        ps.setDouble(2, hd.getTongTien());
        ps.setString(3, hd.getTrangThai());
        ps.setInt(4, hd.getMaBan());
        ps.setInt(5, hd.getMaKH());
        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            maHD = rs.getInt(1); // lấy MaHD tự tăng
        }

        getConnection().close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return maHD;
}
public HoaDon getHoaDonById(int maHD) {
    HoaDon hd = null;
    try  {
        String sql = "SELECT * FROM hoadon WHERE MaHD = ?";
        PreparedStatement ps = getConnection().prepareStatement(sql);
        ps.setInt(1, maHD);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            hd = new HoaDon();
            hd.setMaHD(rs.getInt("MaHD"));
            hd.setNgayLap(rs.getDate("NgayLap"));
            hd.setTongTien(rs.getDouble("TongTien"));
            hd.setTrangThai(rs.getString("TrangThai"));
            hd.setMaBan(rs.getInt("MaBan"));
            hd.setMaKH(rs.getInt("MaKH"));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return hd;
}

}
