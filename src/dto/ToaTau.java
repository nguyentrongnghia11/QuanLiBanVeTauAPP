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
public class ToaTau {

    private String maToa;
    private Tau macTau;
    private int sucChua;
    // private Ghe loaiGhe;

    public ToaTau() {
    }

    public ToaTau(String maToa, Tau macTau, int sucChua) {
        this.maToa = maToa;
        this.macTau = macTau;
        this.sucChua = sucChua;
    }

    public ToaTau(String maToa) {
        this.maToa = maToa;
    }

    public String getMaToa() {
        return maToa;
    }

    public void setMaToa(String maToa) {
        this.maToa = maToa;
    }

    public Tau getMacTau() {
        return macTau;
    }

    public void setMacTau(Tau macTau) {
        this.macTau = macTau;
    }

    public int getSucChua() {
        return sucChua;
    }

    public void setSucChua(int sucChua) {
        this.sucChua = sucChua;
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
        // if (getClass() != obj.getClass()) {
        // return false;
        // }
        final ToaTau other = (ToaTau) obj;
        return Objects.equals(this.maToa, other.maToa);
    }

    @Override
    public String toString() {
        return "ToaTau{" + "maToa=" + maToa + ", macTau=" + macTau + ", sucChua=" + sucChua + '}';
    }

}
