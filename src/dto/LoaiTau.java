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
public class LoaiTau {

    private String maLoai;
    private String tenLoai;

    public LoaiTau() {
    }

    public LoaiTau(String maLoai, String tenLoai) {
        this.maLoai = maLoai;
        this.tenLoai = tenLoai;
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
        final LoaiTau other = (LoaiTau) obj;
        return Objects.equals(this.maLoai, other.maLoai);
    }

    @Override
    public String toString() {
        return "LoaiTau{" + "maLoai=" + maLoai + ", tenLoai=" + tenLoai + '}';
    }

}
