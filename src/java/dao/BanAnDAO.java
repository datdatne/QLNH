/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import model.BanAn;

/**
 *
 * @author ACER
 */
public class BanAnDAO extends DBConnect {
     public List<BanAn> getAll() {
        List<BanAn> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM banan";
           
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                BanAn b = new BanAn(
                    rs.getInt("MaBan"),
                    rs.getString("TrangThai")
                );
                list.add(b);
            }

            rs.close(); ps.close(); 
            getConnection().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
     
     public String getTrangThai(int maBan) {
    String sql = "SELECT TrangThai FROM banan WHERE MaBan = ?";
    try (
         PreparedStatement stmt = getConnection().prepareStatement(sql)) {
        stmt.setInt(1, maBan);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getString("TrangThai");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}
        public boolean updateTrangThai(int maBan, String trangThaiMoi) {
    String sql = "UPDATE banan SET TrangThai = ? WHERE MaBan = ?";
    try (
         PreparedStatement stmt = getConnection().prepareStatement(sql)) {
        stmt.setString(1, trangThaiMoi);
        stmt.setInt(2, maBan);
        return stmt.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}


}
