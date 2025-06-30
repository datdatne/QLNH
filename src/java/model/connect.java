/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author a
 */
public class connect {

    private Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        // Thay đổi username và password nếu cần
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/quanly_sv", "root", "");
    }

    // Lấy tất cả khách hàng
    public List<vandongvien> getAll() {
        List<vandongvien> list = new ArrayList<>();
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement("SELECT * FROM qlvandongvien"); 
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                vandongvien vdv = new vandongvien(
                        rs.getString("mavdv"),
                        rs.getString("tenvdv"),
                        rs.getString("bomon"),
                        rs.getString("ngaysinh"),
                        rs.getString("sohc")
                );
                list.add(vdv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // Thêm khách hàng mới
    public void insert(vandongvien vdv) {
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO qlvandongvien (mavdv, tenvdv, bomon, ngaysinh, sohc) VALUES (?, ?, ?, ?, ?)")) {
            ps.setString(1, vdv.getMavdv());
            ps.setString(2, vdv.getTenvdv());
            ps.setString(3, vdv.getBomon());
            ps.setString(4, vdv.getNgaysinh());
            ps.setString(5, vdv.getSohc());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Sửa khách hàng
    public void update(vandongvien vdv) {
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(
                "UPDATE  qlvandongvien SET tenvdv=?, bomon=?, ngaysinh=?, sohc=? WHERE mavdv=?")) {
            ps.setString(5, vdv.getMavdv());
            ps.setString(1, vdv.getTenvdv());
            ps.setString(2, vdv.getBomon());
            ps.setString(3, vdv.getNgaysinh());
            ps.setString(4, vdv.getSohc());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Xóa khách hàng
    public void delete(String mavdv) {
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement("DELETE FROM qlvandongvien WHERE mavdv=?")) {
            ps.setString(1, mavdv);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Tìm kiếm theo số tài khoản (soTK)
    public vandongvien getById(String mavdv) {
        vandongvien vdv = null;
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement("SELECT * FROM qlvandongvien WHERE mavdv=?")) {
            ps.setString(1, mavdv);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    vdv = new vandongvien(
                            rs.getString("mavdv"),
                            rs.getString("tenvdv"),
                            rs.getString("bomon"),
                            rs.getString("ngaysinh"),
                            rs.getString("sohc")
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vdv;
    }
}
