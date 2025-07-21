/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ACER
 */
public class ChiTietHoaDon {
    private int MaHD;
    private String MaMon;
    private String TenMon;
    private int SoLuong;
    private double DonGia;

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(int MaHD, String MaMon, String TenMon, int SoLuong, double DonGia) {
        this.MaHD = MaHD;
        this.MaMon = MaMon;
        this.TenMon = TenMon;
        this.SoLuong = SoLuong;
        this.DonGia = DonGia;
    }

    public int getMaHD() {
        return MaHD;
    }

    public String getMaMon() {
        return MaMon;
    }

    public String getTenMon() {
        return TenMon;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public double getDonGia() {
        return DonGia;
    }

    public void setMaHD(int MaHD) {
        this.MaHD = MaHD;
    }

    public void setMaMon(String MaMon) {
        this.MaMon = MaMon;
    }

    public void setTenMon(String TenMon) {
        this.TenMon = TenMon;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public void setDonGia(double DonGia) {
        this.DonGia = DonGia;
    }

    
   
}

