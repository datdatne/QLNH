/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author a
 */
public class nhanvien {
    private int MaNv;
    private String HoTen,NgaySinh;
    private boolean GioiTinh;
    private String DienThoai;

     public nhanvien() {
       
    }
    public nhanvien(int MaNv, String HoTen, String NgaySinh, boolean GioiTinh, String DienThoai) {
        this.MaNv = MaNv;
        this.HoTen = HoTen;
        this.NgaySinh = NgaySinh;
        this.GioiTinh = GioiTinh;
        this.DienThoai = DienThoai;
    }

    public int getMaNv() {
        return MaNv;
    }

    public void setMaNv(int MaNv) {
        this.MaNv = MaNv;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public boolean isGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getDienThoai() {
        return DienThoai;
    }

    public void setDienThoai(String DienThoai) {
        this.DienThoai = DienThoai;
    }
    
}
