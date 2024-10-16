/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author Trong Nghia
 */
public class ChiTietVe {

    private int maChiTietVe;
    private HanhKhach maHanhKhach;
    private Ve maVe;
    private BangGia maBangGia;
    private int soLuong;

    public ChiTietVe() {
    }

    public ChiTietVe(int maChiTietVe, HanhKhach maHanhKhach, Ve maVe, BangGia maBangGia, int soLuong) {
        this.maChiTietVe = maChiTietVe;
        this.maHanhKhach = maHanhKhach;
        this.maVe = maVe;
        this.maBangGia = maBangGia;
        this.soLuong = soLuong;
    }

    public ChiTietVe(HanhKhach maHanhKhach, Ve maVe, BangGia maBangGia, int soLuong) {
        this.maHanhKhach = maHanhKhach;
        this.maVe = maVe;
        this.maBangGia = maBangGia;
        this.soLuong = soLuong;
    }

    public int getMaChiTietVe() {
        return maChiTietVe;
    }

    public void setMaChiTietVe(int maChiTietVe) {
        this.maChiTietVe = maChiTietVe;
    }

    public HanhKhach getMaHanhKhach() {
        return maHanhKhach;
    }

    public void setMaHanhKhach(HanhKhach maHanhKhach) {
        this.maHanhKhach = maHanhKhach;
    }

    public Ve getMaVe() {
        return maVe;
    }

    public void setMaVe(Ve maVe) {
        this.maVe = maVe;
    }

    public BangGia getMaBangGia() {
        return maBangGia;
    }

    public void setMaBangGia(BangGia maBangGia) {
        this.maBangGia = maBangGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
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
        final ChiTietVe other = (ChiTietVe) obj;
        return this.maChiTietVe == other.maChiTietVe;
    }

    @Override
    public String toString() {
        return "ChiTietVe{" + "maChiTietVe=" + maChiTietVe + ", maHanhKhach=" + maHanhKhach + ", maVe=" + maVe + ", maBangGia=" + maBangGia + ", soLuong=" + soLuong + '}';
    }

}
