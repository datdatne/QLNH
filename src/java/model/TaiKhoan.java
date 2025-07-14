/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ACER
 */
public class TaiKhoan {
    public String TenDangNhap ;
    public String MatKhau;
    public int MaNV;
    public String VaiTro;

    public TaiKhoan(String TenDangNhap, String MatKhau, int MaNV, String VaiTro) {
        this.TenDangNhap = TenDangNhap;
        this.MatKhau = MatKhau;
        this.MaNV = MaNV;
        this.VaiTro = VaiTro;
    }

    public TaiKhoan(String TenDangNhap, String MatKhau, String VaiTro) {
        this.TenDangNhap = TenDangNhap;
        this.MatKhau = MatKhau;
        this.VaiTro = VaiTro;
    }

    public TaiKhoan() {}

    public String getTenDangNhap() {return TenDangNhap;}

    public String getMatKhau() {return MatKhau;}

    public int getMaNV() {return MaNV;}

    public String getVaiTro() {return VaiTro;}
    
    
}
