/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.NhanVien;
/**
 *
 * @author ACER
 */
public class NhanVienDAO extends DBConnect {
     public List<NhanVien> getAllNhanVien() throws SQLException {
        List<NhanVien> list = new ArrayList<>();
        String sql = "SELECT * FROM nhanvien";
        try (
           PreparedStatement ps = getConnection().prepareStatement(sql);
           ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                NhanVien nv = new NhanVien(
                    rs.getInt("MaNV"),
                    rs.getString("HoTen"),
                    rs.getDate("NgaySinh"),
                  
                    rs.getString("SDT")
                );
                list.add(nv);
            }
        }
        return list;
    }
      public void insert(NhanVien nv) throws SQLException {
        String sql = "INSERT INTO nhanvien( MaNV ,HoTen, NgaySinh, SDT) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, nv.getMaNV());
            ps.setString(2, nv.getHoTen());
            ps.setDate(3, nv.getNgaySinh());
           
            ps.setString(4, nv.getSDT());
            ps.executeUpdate();
        }
    }
      public void update(NhanVien nv) throws SQLException {
        String sql = "UPDATE nhanvien SET HoTen=?, NgaySinh=?, SDT=? WHERE MaNV=?";
        try ( PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, nv.getHoTen());
            ps.setDate(2, nv.getNgaySinh());
           
            ps.setString(3, nv.getSDT());
            ps.setInt(4, nv.getMaNV());
            ps.executeUpdate();
        }
    }
      public void delete(int maNV) throws SQLException {
        String sql = "DELETE FROM nhanvien WHERE MaNV=?";
        try ( PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, maNV);
            ps.executeUpdate();
        }
    }
      public NhanVien getById(int maNV) throws SQLException {
        String sql = "SELECT * FROM nhanvien WHERE MaNV=?";
        try ( PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, maNV);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new NhanVien(
                    rs.getInt("MaNV"),
                    rs.getString("HoTen"),
                    rs.getDate("NgaySinh"),
                    rs.getString("SDT")
                );
            }
        }
        return null;
    }
}

