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
public class Ga {

    private String maGa;
    private String tenGa;
    private String diaChiGa;

    public Ga() {
    }

    public Ga(String maGa, String tenGa, String diaChiGa) {
        this.maGa = maGa;
        this.tenGa = tenGa;
        this.diaChiGa = diaChiGa;
    }

    public String getMaGa() {
        return maGa;
    }

    public void setMaGa(String maGa) {
        this.maGa = maGa;
    }

    public String getTenGa() {
        return tenGa;
    }

    public void setTenGa(String tenGa) {
        this.tenGa = tenGa;
    }

    public String getDiaChiGa() {
        return diaChiGa;
    }

    public void setDiaChiGa(String diaChiGa) {
        this.diaChiGa = diaChiGa;
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
        final Ga other = (Ga) obj;
        return Objects.equals(this.maGa, other.maGa);
    }

    @Override
    public String toString() {
        return "Ga{" + "maGa=" + maGa + ", tenGa=" + tenGa + ", diaChiGa=" + diaChiGa + '}';
    }

}
