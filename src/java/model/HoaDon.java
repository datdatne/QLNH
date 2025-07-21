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
public class HoaDon {
    private int MaHD;
    private Date NgayLap;
    private double TongTien;
    private String trangThai;
    private int MaBan;
    private int MaKH;

    public HoaDon(int MaHD, Date NgayLap, double TongTien, String trangThai, int MaBan, int MaKH) {
        this.MaHD = MaHD;
        this.NgayLap = NgayLap;
        this.TongTien = TongTien;
        this.trangThai = trangThai;
        this.MaBan = MaBan;
        this.MaKH = MaKH;
    }

    public HoaDon() {
    }

    public int getMaHD() {
        return MaHD;
    }

    public Date getNgayLap() {
        return NgayLap;
    }

    public double getTongTien() {
        return TongTien;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public int getMaBan() {
        return MaBan;
    }

    public int getMaKH() {
        return MaKH;
    }

    public void setMaHD(int MaHD) {
        this.MaHD = MaHD;
    }

    public void setNgayLap(Date NgayLap) {
        this.NgayLap = NgayLap;
    }

    public void setTongTien(double TongTien) {
        this.TongTien = TongTien;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public void setMaBan(int MaBan) {
        this.MaBan = MaBan;
    }

    public void setMaKH(int MaKH) {
        this.MaKH = MaKH;
    }

  

    
}

