/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author Trong Nghia
 */
public class Ghe {
    private int maGhe;
    private ToaTau maToa;
    private LoaiGhe maLoaiGhe;
    private boolean trangThai;

    public Ghe(int maGhe) {
        this.maGhe = maGhe;
    }

    public Ghe(int maGhe, ToaTau maToa, LoaiGhe maLoaiGhe, boolean trangThai) {
        this.maGhe = maGhe;
        this.maToa = maToa;
        this.maLoaiGhe = maLoaiGhe;
        this.trangThai = trangThai;
    }

    public int getMaGhe() {
        return maGhe;
    }

    public void setMaGhe(int maGhe) {
        this.maGhe = maGhe;
    }

    public ToaTau getMaToa() {
        return maToa;
    }

    public void setMaToa(ToaTau maToa) {
        this.maToa = maToa;
    }

    public LoaiGhe getMaLoaiGhe() {
        return maLoaiGhe;
    }

    public void setMaLoaiGhe(LoaiGhe maLoaiGhe) {
        this.maLoaiGhe = maLoaiGhe;
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
        hash = 97 * hash + this.maGhe;
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
        final Ghe other = (Ghe) obj;
        return this.maGhe == other.maGhe;
    }

    @Override
    public String toString() {
        return "Ghe{" + "maGhe=" + maGhe + ", maToa=" + maToa + ", maLoaiGhe=" + maLoaiGhe + ", trangThai=" + trangThai
                + '}';
    }

}
