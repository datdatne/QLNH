package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.KhachHang;

public class KhachHangDAO extends DBConnect {

    // Thêm khách hàng mới
    public int insert(KhachHang kh) {
        int maKH = -1;
        String sql = "INSERT INTO khachhang (HoTen, SDT, DiaChi, Email) VALUES (?, ?, ?, ?)";

        try (
            PreparedStatement ps = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, kh.getHoTen());
            ps.setString(2, kh.getSDT());
            ps.setString(3, kh.getDiaChi());
            ps.setString(4, kh.getEmail());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        maKH = rs.getInt(1);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return maKH;
    }

    // Lấy khách hàng theo mã
    public KhachHang getKhachHangById(int maKH) {
        String sql = "SELECT * FROM khachhang WHERE MaKH = ?";
        try (
            PreparedStatement ps = getConnection().prepareStatement(sql)) {

            ps.setInt(1, maKH);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new KhachHang(
                    rs.getInt("MaKH"),
                    rs.getString("HoTen"),
                    rs.getString("SDT"),
                    rs.getString("DiaChi"),
                    rs.getString("Email")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Cập nhật khách hàng
    public boolean update(KhachHang kh) {
        String sql = "UPDATE khachhang SET HoTen = ?, SDT = ?, DiaChi = ?, Email = ? WHERE MaKH = ?";
        try (
            PreparedStatement ps = getConnection().prepareStatement(sql)) {

            ps.setString(1, kh.getHoTen());
            ps.setString(2, kh.getSDT());
            ps.setString(3, kh.getDiaChi());
            ps.setString(4, kh.getEmail());
            ps.setInt(5, kh.getMaKH());

            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Xóa khách hàng
    public boolean delete(int maKH) {
        String sql = "DELETE FROM khachhang WHERE MaKH = ?";
        try (
            PreparedStatement ps = getConnection().prepareStatement(sql)) {

            ps.setInt(1, maKH);
            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Lấy toàn bộ danh sách khách hàng
    public List<KhachHang> getAllKhachHang() {
        List<KhachHang> list = new ArrayList<>();
        String sql = "SELECT * FROM khachhang";
        try (
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                KhachHang kh = new KhachHang(
                    rs.getInt("MaKH"),
                    rs.getString("HoTen"),
                    rs.getString("SDT"),
                    rs.getString("DiaChi"),
                    rs.getString("Email")
                );
                list.add(kh);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}

