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
public class PhuongThucThanhToan {

    private String maPhuongThuc;
    private String tenPhuongThuc;

    public PhuongThucThanhToan() {
    }

    public PhuongThucThanhToan(String maPhuongThuc, String tenPhuongThuc) {
        this.maPhuongThuc = maPhuongThuc;
        this.tenPhuongThuc = tenPhuongThuc;
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
        final PhuongThucThanhToan other = (PhuongThucThanhToan) obj;
        return Objects.equals(this.maPhuongThuc, other.maPhuongThuc);
    }

    public String getMaPhuongThuc() {
        return maPhuongThuc;
    }

    public void setMaPhuongThuc(String maPhuongThuc) {
        this.maPhuongThuc = maPhuongThuc;
    }

    public String getTenPhuongThuc() {
        return tenPhuongThuc;
    }

    public void setTenPhuongThuc(String tenPhuongThuc) {
        this.tenPhuongThuc = tenPhuongThuc;
    }

    @Override
    public String toString() {
        return "PhuongThucThanhToan{" + "maPhuongThuc=" + maPhuongThuc + ", tenPhuongThuc=" + tenPhuongThuc + '}';
    }

}
