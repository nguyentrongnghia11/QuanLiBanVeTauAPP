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
public class Ve {

    private String maVe;
    private NhanVien maNV;
    private LoaiVe maLoai;
    private KhuyenMai maKhuyenMai;
    private LocalDate ngayBan;
    private Ghe soGhe;
    private int trangThaiVe;
    private double tongTien;
    private PhuongThucThanhToan PTTT;
    private ChuyenTau maChuyenTau;
    private ToaTau maToa;

    public Ve(String maVe, NhanVien maNV, LoaiVe maLoai, KhuyenMai maKhuyenMai, LocalDate ngayBan, Ghe soGhe, int trangThaiVe, double tongTien, PhuongThucThanhToan PTTT, ChuyenTau maChuyenTau, ToaTau maToa) {
        this.maVe = maVe;
        this.maNV = maNV;
        this.maLoai = maLoai;
        this.maKhuyenMai = maKhuyenMai;
        this.ngayBan = ngayBan;
        this.soGhe = soGhe;
        this.trangThaiVe = trangThaiVe;
        this.tongTien = tongTien;
        this.PTTT = PTTT;
        this.maChuyenTau = maChuyenTau;
        this.maToa = maToa;
    }

    public Ghe getSoGhe() {
        return soGhe;
    }

    public void setSoGhe(Ghe soGhe) {
        this.soGhe = soGhe;
    }

    public String getMaVe() {
        return maVe;
    }

    public void setMaVe(String maVe) {
        this.maVe = maVe;
    }

    public NhanVien getMaNV() {
        return maNV;
    }

    public void setMaNV(NhanVien maNV) {
        this.maNV = maNV;
    }

    public LoaiVe getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(LoaiVe maLoai) {
        this.maLoai = maLoai;
    }

    public KhuyenMai getMaKhuyenMai() {
        return maKhuyenMai;
    }

    public void setMaKhuyenMai(KhuyenMai maKhuyenMai) {
        this.maKhuyenMai = maKhuyenMai;
    }

    public LocalDate getNgayBan() {
        return ngayBan;
    }

    public void setNgayBan(LocalDate ngayBan) {
        this.ngayBan = ngayBan;
    }

    public int getTrangThaiVe() {
        return trangThaiVe;
    }

    public void setTrangThaiVe(int trangThaiVe) {
        this.trangThaiVe = trangThaiVe;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public PhuongThucThanhToan getPTTT() {
        return PTTT;
    }

    public void setPTTT(PhuongThucThanhToan PTTT) {
        this.PTTT = PTTT;
    }

    public ChuyenTau getMaChuyenTau() {
        return maChuyenTau;
    }

    public void setMaChuyenTau(ChuyenTau maChuyenTau) {
        this.maChuyenTau = maChuyenTau;
    }

    public ToaTau getMaToa() {
        return maToa;
    }

    public void setMaToa(ToaTau maToa) {
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
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ve other = (Ve) obj;
        return Objects.equals(this.maVe, other.maVe);
    }

    @Override
    public String toString() {
        return "Ve{" + "maVe=" + maVe + ", maNV=" + maNV + ", maLoai=" + maLoai + ", maKhuyenMai=" + maKhuyenMai + ", ngayBan=" + ngayBan + ", soGhe=" + soGhe + ", trangThaiVe=" + trangThaiVe + ", tongTien=" + tongTien + ", PTTT=" + PTTT + ", maChuyenTau=" + maChuyenTau + ", maToa=" + maToa + '}';
    }

}
