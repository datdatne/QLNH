/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ACER
 */
public class MonAn {
     private String MaMon;
    private String TenMon;
    private double DonGia;
    private String MoTa;
    private String HinhAnh;

    public MonAn(String MaMon, String TenMon, double DonGia, String MoTa, String HinhAnh) {
        this.MaMon = MaMon;
        this.TenMon = TenMon;
        this.DonGia = DonGia;
        this.MoTa = MoTa;
        this.HinhAnh = HinhAnh;
    }

    public MonAn() {
    }

    public String getMaMon() {
        return MaMon;
    }

    public String getTenMon() {
        return TenMon;
    }

    public double getDonGia() {
        return DonGia;
    }

    public String getMoTa() {
        return MoTa;
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public void setMaMon(String MaMon) {
        this.MaMon = MaMon;
    }

    public void setTenMon(String TenMon) {
        this.TenMon = TenMon;
    }

    public void setDonGia(double DonGia) {
        this.DonGia = DonGia;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public void setHinhAnh(String HinhAnh) {
        this.HinhAnh = HinhAnh;
    }
        
}
