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
public class LoaiVe {
    private String maLoai;
    private String tenLoaiVe;

    public LoaiVe(String maLoai, String tenLoaiVe) {
        this.maLoai = maLoai;
        this.tenLoaiVe = tenLoaiVe;
    }

    public LoaiVe() {
    }

    public String getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    public String getTenLoaiVe() {
        return tenLoaiVe;
    }

    public void setTenLoaiVe(String tenLoaiVe) {
        this.tenLoaiVe = tenLoaiVe;
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
        final LoaiVe other = (LoaiVe) obj;
        return Objects.equals(this.maLoai, other.maLoai);
    }

    @Override
    public String toString() {
        return "LoaiVe{" + "maLoai=" + maLoai + '}';
    }
    
    
}
