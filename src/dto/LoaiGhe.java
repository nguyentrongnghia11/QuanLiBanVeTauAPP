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
public class LoaiGhe {
    private String maLoai;
    private String tenLoaiGhe;

    public LoaiGhe() {
    }

    public LoaiGhe(String maLoai, String tenLoaiGhe) {
        this.maLoai = maLoai;
        this.tenLoaiGhe = tenLoaiGhe;
    }

    public LoaiGhe(String maLoai) {
        this.maLoai = maLoai;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    public String getTenLoaiGhe() {
        return tenLoaiGhe;
    }

    public void setTenLoaiGhe(String tenLoaiGhe) {
        this.tenLoaiGhe = tenLoaiGhe;
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
        final LoaiGhe other = (LoaiGhe) obj;
        return Objects.equals(this.maLoai, other.maLoai);
    }

    @Override
    public String toString() {
        return "LoaiGhe{" + "maLoai=" + maLoai + ", tenLoaiGhe=" + tenLoaiGhe + '}';
    }
    
    
      
}
