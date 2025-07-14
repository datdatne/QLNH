/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ACER
 */
public class KhachHang {
    private int MaKH;
    private String HoTen;
    private String SDT;
    private String DiaChi;
    private String Email;

    public KhachHang(int MaKH, String HoTen, String SDT, String DiaChi, String Email) {
        this.MaKH = MaKH;
        this.HoTen = HoTen;
        this.SDT = SDT;
        this.DiaChi = DiaChi;
        this.Email = Email;
    }

    public KhachHang() {
    }

    public int getMaKH() {
        return MaKH;
    }

    public String getHoTen() {
        return HoTen;
    }

    public String getSDT() {
        return SDT;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public String getEmail() {
        return Email;
    }

    public void setMaKH(int MaKH) {
        this.MaKH = MaKH;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    
}
