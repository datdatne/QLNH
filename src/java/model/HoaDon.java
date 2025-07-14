/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author ACER
 */
public class HoaDon {
    private int MaHD;
    private int MaKH;
    private Date NgayLap;
    private double TongTien;

    public HoaDon(int MaHD, int MaKH, Date NgayLap, double TongTien) {
        this.MaHD = MaHD;
        this.MaKH = MaKH;
        this.NgayLap = NgayLap;
        this.TongTien = TongTien;
    }

    public HoaDon() {
    }

    public int getMaHD() {
        return MaHD;
    }

    public int getMaKH() {
        return MaKH;
    }

    public Date getNgayLap() {
        return NgayLap;
    }

    public double getTongTien() {
        return TongTien;
    }

    public void setMaHD(int MaHD) {
        this.MaHD = MaHD;
    }

    public void setMaKH(int MaKH) {
        this.MaKH = MaKH;
    }

    public void setNgayLap(Date NgayLap) {
        this.NgayLap = NgayLap;
    }

    public void setTongTien(double TongTien) {
        this.TongTien = TongTien;
    }
    
    
}

