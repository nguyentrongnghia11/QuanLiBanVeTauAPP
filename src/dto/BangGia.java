/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author Trong Nghia
 */
public class BangGia {

    private int maBangGia;
    private double giaTien;
    private int trangThai;
    private String maChuyenTau;
    private String maToa;

    public BangGia() {
    }

    public BangGia(int maBangGia, double giaTien, int trangThai, String maChuyenTau, String maToa) {
        this.maBangGia = maBangGia;
        this.giaTien = giaTien;
        this.trangThai = trangThai;
        this.maChuyenTau = maChuyenTau;
        this.maToa = maToa;
    }

    public int getMaBangGia() {
        return maBangGia;
    }

    public void setMaBangGia(int maBangGia) {
        this.maBangGia = maBangGia;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getMaChuyenTau() {
        return maChuyenTau;
    }

    public void setMaChuyenTau(String maChuyenTau) {
        this.maChuyenTau = maChuyenTau;
    }

    public String getMaToa() {
        return maToa;
    }

    public void setMaToa(String maToa) {
        this.maToa = maToa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final BangGia other = (BangGia) obj;
        return this.maBangGia == other.maBangGia;
    }

    @Override
    public String toString() {
        return "BangGia{" + "maBangGia=" + maBangGia + ", giaTien=" + giaTien + ", trangThai=" + trangThai + ", maChuyenTau=" + maChuyenTau + ", maToa=" + maToa + '}';
    }

}
