/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ACER
 */
public class CartItem {
    private MonAn mon;
    private int soLuong;

    public CartItem(MonAn mon, int soLuong) {
        this.mon = mon;
        this.soLuong = soLuong;
    }

    public MonAn getMon() {
        return mon;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setMon(MonAn mon) {
        this.mon = mon;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

  
    
}
