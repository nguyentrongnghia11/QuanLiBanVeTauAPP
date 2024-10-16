/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Trong Nghia
 */
public class NhanVien {

    private String maNV;
    private String tenNV;
    private String CCCD;
    private String SDT;
    private boolean tinhTrangNV;
    private LocalDate ngayVaoLam;
    private String vaiTro;

    public NhanVien() {
    }

    public NhanVien(String maNV, String tenNV, String CCCD, String SDT, boolean tinhTrangNV, LocalDate ngayVaoLam, String vaiTro) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.CCCD = CCCD;
        this.SDT = SDT;
        this.tinhTrangNV = tinhTrangNV;
        this.ngayVaoLam = ngayVaoLam;
        this.vaiTro = vaiTro;
    }

    public NhanVien(String tenNV, String CCCD, String SDT, boolean tinhTrangNV, LocalDate ngayVaoLam, String vaiTro) {

        this.tenNV = tenNV;
        this.CCCD = CCCD;
        this.SDT = SDT;
        this.tinhTrangNV = tinhTrangNV;
        this.ngayVaoLam = ngayVaoLam;
        this.vaiTro = vaiTro;
    }

    public String getMaNV() {
        return maNV;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public boolean isTinhTrangNV() {
        return tinhTrangNV;
    }

    public void setTinhTrangNV(boolean tinhTrangNV) {
        this.tinhTrangNV = tinhTrangNV;
    }

    public LocalDate getNgayVaoLam() {
        return ngayVaoLam;
    }

    public void setNgayVaoLam(LocalDate ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
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
        final NhanVien other = (NhanVien) obj;
        return Objects.equals(this.maNV, other.maNV);
    }

    @Override
    public String toString() {
        return "NhanVien{" + "maNV=" + maNV + ", tenNV=" + tenNV + ", CCCD=" + CCCD + ", SDT=" + SDT + ", tinhTrangNV=" + tinhTrangNV + ", ngayVaoLam=" + ngayVaoLam + ", vaiTro=" + vaiTro + '}';
    }

}
