/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author Trong Nghia
 */
public class LoaiHanhKhach {

    private int maLoai;
    private String tenLoai;
    private double mucGiamGia;

    public LoaiHanhKhach(int maLoai) {
        this.maLoai = maLoai;
    }

    public LoaiHanhKhach(int maLoai, String tenLoai, double mucGiamGia) {
        this.maLoai = maLoai;
        this.tenLoai = tenLoai;
        this.mucGiamGia = mucGiamGia;
    }

    public int getmaLoai() {
        return maLoai;
    }

    public void setmaLoai(int maLoai) {
        this.maLoai = maLoai;
    }

    public LoaiHanhKhach(String tenLoai, double mucGiamGia) {

        this.tenLoai = tenLoai;
        this.mucGiamGia = mucGiamGia;
    }

    public int getMaLoai() {
        return maLoai;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public double getMucGiamGia() {
        return mucGiamGia;
    }

    public void setMucGiamGia(double mucGiamGia) {
        this.mucGiamGia = mucGiamGia;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
        final LoaiHanhKhach other = (LoaiHanhKhach) obj;
        return this.maLoai == other.maLoai;
    }

    @Override
    public String toString() {
        return "LoaiHanhKhach{" + "maHanhKhach=" + maLoai + ", tenLoai=" + tenLoai + ", mucGiamGia=" + mucGiamGia + '}';
    }

}
