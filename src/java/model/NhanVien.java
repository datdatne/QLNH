/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author ACER
 */
public class NhanVien {
    private int MaNV;
    private String HoTen;
    private Date NgaySinh;
    private String ChucVu;
    private String SDT; 

    public NhanVien(int MaNV, String HoTen, Date NgaySinh, String ChucVu, String SDT) {
        this.MaNV = MaNV;
        this.HoTen = HoTen;
        this.NgaySinh = NgaySinh;
        this.ChucVu = ChucVu;
        this.SDT = SDT;
    }

    public NhanVien() {
    }

    public int getMaNV() {
        return MaNV;
    }

    public String getHoTen() {
        return HoTen;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public String getChucVu() {
        return ChucVu;
    }

    public String getSDT() {
        return SDT;
    }

    public void setMaNV(int MaNV) {
        this.MaNV = MaNV;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public void setChucVu(String ChucVu) {
        this.ChucVu = ChucVu;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    
}
