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
public class KhoTaiChinh {
    private int MaKho;
    private Date Ngay;
    private double SoTien;
    private int MaHD;

    public KhoTaiChinh(int MaKho, Date Ngay, double SoTien, int MaHD) {
        this.MaKho = MaKho;
        this.Ngay = Ngay;
        this.SoTien = SoTien;
        this.MaHD = MaHD;
    }

    public KhoTaiChinh() {
    }

    public int getMaKho() {
        return MaKho;
    }

    public Date getNgay() {
        return Ngay;
    }

    public double getSoTien() {
        return SoTien;
    }

    public int getMaHD() {
        return MaHD;
    }

    public void setMaKho(int MaKho) {
        this.MaKho = MaKho;
    }

    public void setNgay(Date Ngay) {
        this.Ngay = Ngay;
    }

    public void setSoTien(double SoTien) {
        this.SoTien = SoTien;
    }

    public void setMaHD(int MaHD) {
        this.MaHD = MaHD;
    }
    
}
