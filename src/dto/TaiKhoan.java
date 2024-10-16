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
public class TaiKhoan {

    private String tenTaiKhoan;
    private String password;
    private boolean trangThai;

    public TaiKhoan() {
    }

    public TaiKhoan(String tenTaiKhoan, String password, boolean trangThai) {
        this.tenTaiKhoan = tenTaiKhoan;
        this.password = password;
        this.trangThai = trangThai;
    }

    public String getTenTaiKhoan() {
        return tenTaiKhoan;
    }

    public void setTenTaiKhoan(String tenTaiKhoan) {
        this.tenTaiKhoan = tenTaiKhoan;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
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
        final TaiKhoan other = (TaiKhoan) obj;
        return Objects.equals(this.tenTaiKhoan, other.tenTaiKhoan);
    }

    @Override
    public String toString() {
        return "TaiKhoan{" + "tenTaiKhoan=" + tenTaiKhoan + ", password=" + password + ", trangThai=" + trangThai + '}';
    }

}
