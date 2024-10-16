/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.Objects;

/**
 *
 * @author Trong Nghia
 */
public class HanhKhach {

    private String maHanhKhach;
    private String tenHanhKhach;
    private LoaiHanhKhach maLoai;
    private String CCCD;
    private String SDT;

    public HanhKhach(String maHanhKhach, String tenHanhKhach, LoaiHanhKhach maLoai, String CCCD, String SDT) {
        this.maHanhKhach = maHanhKhach;
        this.tenHanhKhach = tenHanhKhach;
        this.maLoai = maLoai;
        this.CCCD = CCCD;
        this.SDT = SDT;
    }

    public HanhKhach() {
    }

    public String getMaHanhKhach() {
        return maHanhKhach;
    }

    public void setMaHanhKhach(String maHanhKhach) {
        this.maHanhKhach = maHanhKhach;
    }

    public String getTenHanhKhach() {
        return tenHanhKhach;
    }

    public void setTenHanhKhach(String tenHanhKhach) {
        this.tenHanhKhach = tenHanhKhach;
    }

    public LoaiHanhKhach getMaLoai() {
        return maLoai;
    }
    
    public double getMucGiamGia (){
        return maLoai.getMucGiamGia();
    }

    public void setMaLoai(LoaiHanhKhach maLoai) {
        this.maLoai = maLoai;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final HanhKhach other = (HanhKhach) obj;
        return Objects.equals(this.maHanhKhach, other.maHanhKhach);
    }

    @Override
    public String toString() {
        return "HanhKhach{" + "maHanhKhach=" + maHanhKhach + ", tenHanhKhach=" + tenHanhKhach + ", maLoai=" + maLoai + ", CCCD=" + CCCD + ", SDT=" + SDT + '}';
    }

}
