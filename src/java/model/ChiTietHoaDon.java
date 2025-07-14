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
    private int SoLuong;

    public ChiTietHoaDon(int MaHD, String MaMon, int SoLuong) {
        this.MaHD = MaHD;
        this.MaMon = MaMon;
        this.SoLuong = SoLuong;
    }

    public ChiTietHoaDon() {
    }

    public int getMaHD() {
        return MaHD;
    }

    public String getMaMon() {
        return MaMon;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setMaHD(int MaHD) {
        this.MaHD = MaHD;
    }

    public void setMaMon(String MaMon) {
        this.MaMon = MaMon;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }
    
    
}

