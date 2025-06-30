/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.nhanvien;

/**
 *
 * @author a
 */
public class connect {

    private Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/dangnhap","root","");
    }

    public List<nhanvien> getAll() {
        List<nhanvien> list = new ArrayList<>();
        try (Connection con = getConnection(); PreparedStatement pt = con.prepareStatement("SELECT * FROM qlynv"); ResultSet rs = pt.executeQuery();) {
            while (rs.next()) {
                nhanvien nv = new nhanvien(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getBoolean(4),
                        rs.getString(5)
                );
                list.add(nv);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void insert(nhanvien nv) {
        try (Connection con = getConnection(); PreparedStatement pt = con.prepareStatement("INSERT INTO qlynv (MaNV,HoTen,NgaySinh,GioiTinh,DienThoai) VALUES (?,?,?,?,?)");) {
            pt.setInt(1, nv.getMaNv());
            pt.setString(2, nv.getHoTen());
            pt.setString(3, nv.getNgaySinh());
            pt.setBoolean(4, nv.isGioiTinh());
            pt.setString(5, nv.getDienThoai());
           pt.executeUpdate();
        } catch (Exception e) {
        }
    }
    public void update(nhanvien nv) {
        try (Connection con = getConnection(); PreparedStatement pt = con.prepareStatement("UPDATE qlynv SET HoTen=?,NgaySinh=?,GioiTinh=?,DienThoai=? WHERE MaNV=? ");) {
            
            pt.setString(1, nv.getHoTen());
            pt.setString(2, nv.getNgaySinh());
            pt.setBoolean(3, nv.isGioiTinh());
            pt.setString(4, nv.getDienThoai());
            pt.setInt(5, nv.getMaNv());
           pt.executeUpdate();
        } catch (Exception e) {
        }
    }
    public void delete(int maNV) {
        try (Connection con = getConnection(); PreparedStatement pt = con.prepareStatement("DELETE FROM qlynv WHERE MaNV=?");) {
            pt.setInt(1, maNV);
           pt.executeUpdate();
        } catch (Exception e) {
        }
    }
    public nhanvien findbyid(int maNV) {
        nhanvien nv= null;
        try (Connection con = getConnection(); PreparedStatement pt = con.prepareStatement("SELECT * FROM qlynv WHERE maNV=?");) {
            pt.setInt(1, maNV);
            try(ResultSet rs= pt.executeQuery()) {
                if(rs.next()){
                    nv = new nhanvien(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getBoolean(4),
                        rs.getString(5)
                );
                }
            } catch (Exception e) {
            }
        } catch (Exception e) {
        }
        return nv;
    }
}
