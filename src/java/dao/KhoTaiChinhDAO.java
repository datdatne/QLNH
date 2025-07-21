package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.KhoTaiChinh;


public class KhoTaiChinhDAO extends DBConnect {

    public void themKhoTaiChinh(KhoTaiChinh kho) {
        String sql = "INSERT INTO khotaichinh (Ngay, SoTien, MaHD) VALUES (?, ?, ?)";

        try (
             PreparedStatement ps = getConnection().prepareStatement(sql)) {

            ps.setDate(1, kho.getNgay());
            ps.setDouble(2, kho.getSoTien());
            ps.setInt(3, kho.getMaHD());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<KhoTaiChinh> getAllKhoTaiChinh() {
        List<KhoTaiChinh> list = new ArrayList<>();
        String sql = "SELECT * FROM khotaichinh";

        try (
             PreparedStatement ps = getConnection().prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                KhoTaiChinh kho = new KhoTaiChinh();
                kho.setMaKho(rs.getInt("MaKho"));
                kho.setNgay(rs.getDate("Ngay"));
                kho.setSoTien(rs.getDouble("SoTien"));
                kho.setMaHD(rs.getInt("MaHD"));
                list.add(kho);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    public void luuVaoKho(double soTien, int maHD) {
    try {
        String sql = "INSERT INTO khotaichinh (Ngay, SoTien, MaHD) VALUES (CURDATE(), ?, ?)";
        PreparedStatement ps = getConnection().prepareStatement(sql);
        ps.setDouble(1, soTien);
        ps.setInt(2, maHD);
        ps.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}
