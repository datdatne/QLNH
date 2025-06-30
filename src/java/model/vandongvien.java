package model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author a
 */
public class vandongvien {
    private String mavdv, tenvdv, bomon,ngaysinh,sohc;
  
    public vandongvien() {
        
    }
    public vandongvien(String mavdv, String tenvdv, String bomon, String ngaysinh, String sohc) {
        this.mavdv = mavdv;
        this.tenvdv = tenvdv;
        this.bomon = bomon;
        this.ngaysinh = ngaysinh;
        this.sohc = sohc;
    }

    public String getMavdv() {
        return mavdv;
    }

    public void setMavdv(String mavdv) {
        this.mavdv = mavdv;
    }

    public String getTenvdv() {
        return tenvdv;
    }

    public void setTenvdv(String tenvdv) {
        this.tenvdv = tenvdv;
    }

    public String getBomon() {
        return bomon;
    }

    public void setBomon(String bomon) {
        this.bomon = bomon;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getSohc() {
        return sohc;
    }

    public void setSohc(String sohc) {
        this.sohc = sohc;
    }
    
}
