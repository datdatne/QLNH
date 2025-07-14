/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import model.MonAn;

/**
 *
 * @author ACER
 */
public class MonAnDAO extends DBConnect {
    public List<MonAn> getAll() throws Exception {
        List<MonAn> list = new ArrayList<>();
        String sql = "SELECT * FROM monan";
        PreparedStatement ps = getConnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            MonAn m = new MonAn();
            m.setMaMon(rs.getString("MaMon"));
            m.setTenMon(rs.getString("TenMon"));
            m.setDonGia(rs.getDouble("DonGia"));
            m.setMoTa(rs.getString("MoTa"));
            m.setHinhAnh(rs.getString("HinhAnh"));
            list.add(m);
        }
        return list;
    }
    public MonAn getById(String MaMon) throws Exception {
    String sql = "SELECT * FROM monan WHERE MaMon = ?";
    PreparedStatement ps = getConnection().prepareStatement(sql);
    ps.setString(1, MaMon);
    ResultSet rs = ps.executeQuery();

    if (rs.next()) {
        MonAn m = new MonAn();
        m.setMaMon(rs.getString("MaMon"));
        m.setTenMon(rs.getString("TenMon"));
        m.setDonGia(rs.getDouble("DonGia"));
        m.setMoTa(rs.getString("MoTa"));
        m.setHinhAnh(rs.getString("HinhAnh"));
        return m;
    }
    return null;
}

}
