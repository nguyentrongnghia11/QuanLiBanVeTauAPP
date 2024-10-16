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
public class Tau {

    private String macTau;
    private LoaiTau maLoai;
    private String tenTau;
    private int soLuongToa;
    private boolean tinhTrangTau;

    public Tau() {
    }

    public Tau(String macTau, LoaiTau maLoai, String tenTau, int soLuongToa, boolean tinhTrangTau) {
        this.macTau = macTau;
        this.maLoai = maLoai;
        this.tenTau = tenTau;
        this.soLuongToa = soLuongToa;
        this.tinhTrangTau = tinhTrangTau;
    }

    public String getMacTau() {
        return macTau;
    }

    public void setMacTau(String macTau) {
        this.macTau = macTau;
    }

    public LoaiTau getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(LoaiTau maLoai) {
        this.maLoai = maLoai;
    }

    public String getTenTau() {
        return tenTau;
    }

    public void setTenTau(String tenTau) {
        this.tenTau = tenTau;
    }

    public int getSoLuongToa() {
        return soLuongToa;
    }

    public void setSoLuongToa(int soLuongToa) {
        this.soLuongToa = soLuongToa;
    }

    public boolean isTinhTrangTau() {
        return tinhTrangTau;
    }

    public void setTinhTrangTau(boolean tinhTrangTau) {
        this.tinhTrangTau = tinhTrangTau;
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
        final Tau other = (Tau) obj;
        return Objects.equals(this.macTau, other.macTau);
    }

    @Override
    public String toString() {
        return "Tau{" + "macTau=" + macTau + ", maLoai=" + maLoai + ", tenTau=" + tenTau + ", soLuongToa=" + soLuongToa + ", tinhTrangTau=" + tinhTrangTau + '}';
    }

    public String getMaNhanVien() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
