/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1.Entities;

/**
 *
 * @author Asus
 */
public class SinhVien {
    
    String mSSV;
    String hoTen;
    String gioiTinh;
    String cMND;

    public SinhVien(String mSSV, String hoTen, String gioiTinh, String cMND) {
        this.mSSV = mSSV;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.cMND = cMND;
    }

    public SinhVien() {
    }

    public String getmSSV() {
        return mSSV;
    }

    public void setmSSV(String mSSV) {
        this.mSSV = mSSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getcMND() {
        return cMND;
    }

    public void setcMND(String cMND) {
        this.cMND = cMND;
    }
    
     public  SinhVien ThemSinhVien(String[] metadata) {
        
         mSSV = metadata[0];
         hoTen = metadata[1];
         gioiTinh = metadata[2];
         cMND =  metadata[3];

        // create and return book of this metadata
        return new SinhVien(mSSV, hoTen, gioiTinh,cMND);
    }
    
    
    
}
