/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Trong Nghia
 */
public class ChuyenTau {

    private String maChuyenTau;
    private Tau maTau;
    private LocalDate ngayKhoiHanh;
    private Ga gaDi;
    private Ga gaDen;

    public ChuyenTau(String maChuyenTau, String macTau, Date ngayKhoiHanh, String gaDi, String gaDen) {
    }

    public ChuyenTau(String maChuyenTau, Tau maTau, LocalDate ngayKhoiHanh, Ga gaDi, Ga gaDen) {
        this.maChuyenTau = maChuyenTau;
        this.maTau = maTau;
        this.ngayKhoiHanh = ngayKhoiHanh;
        this.gaDi = gaDi;
        this.gaDen = gaDen;
    }

    public String getMaChuyenTau() {
        return maChuyenTau;
    }

    public void setMaChuyenTau(String maChuyenTau) {
        this.maChuyenTau = maChuyenTau;
    }

    public Tau getMaTau() {
        return maTau;
    }

    public void setMaTau(Tau maTau) {
        this.maTau = maTau;
    }

    public LocalDate getNgayKhoiHanh() {
        return ngayKhoiHanh;
    }

    public void setNgayKhoiHanh(LocalDate ngayKhoiHanh) {
        this.ngayKhoiHanh = ngayKhoiHanh;
    }

    public Ga getGaDi() {
        return gaDi;
    }

    public void setGaDi(Ga gaDi) {
        this.gaDi = gaDi;
    }

    public Ga getGaDen() {
        return gaDen;
    }

    public void setGaDen(Ga gaDen) {
        this.gaDen = gaDen;
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
        final ChuyenTau other = (ChuyenTau) obj;
        return Objects.equals(this.maChuyenTau, other.maChuyenTau);
    }

    @Override
    public String toString() {
        return "ChuyenTau{" + "maChuyenTau=" + maChuyenTau + ", maTau=" + maTau + ", ngayKhoiHanh=" + ngayKhoiHanh + ", gaDi=" + gaDi + ", gaDen=" + gaDen + '}';
    }

}
