/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.connectDB;
import dto.NhanVien;
import dto.TaiKhoan;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author Trong Nghia
 */
public class NhanVien_DAO {

    private connectDB instance = connectDB.getInstance();
    Connection con = instance.connection();

    public static TaiKhoan instaceNV = null;

    public boolean themNV(NhanVien nv) {

        TaiKhoan tk = new TaiKhoan(nv.getMaNV(), nv.getTenNV(), false);

        String sql = "INSERT INTO NhanVien (MaNhanVien, TenNhanVien, CCCD, SDT, TinhTrangNV, NgayVaoLam, VaiTro) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        String sql1 = "INSERT INTO TaiKhoan(TenTaiKhoan, MatKhau, TrangThaiTK) "
                + " VALUES (?, ?, ?)";

        try {
            PreparedStatement insertNV = con.prepareStatement(sql);
            PreparedStatement insertTK = con.prepareStatement(sql1);

            insertNV.setString(1, nv.getMaNV());
            insertNV.setString(2, nv.getTenNV());
            insertNV.setString(3, nv.getCCCD());
            insertNV.setString(4, nv.getSDT());
            insertNV.setBoolean(5, nv.isTinhTrangNV());
            insertNV.setDate(6, Date.valueOf(nv.getNgayVaoLam()));
            insertNV.setString(7, nv.getVaiTro());

            insertTK.setString(1, tk.getTenTaiKhoan());
            insertTK.setString(2, tk.getPassword());
            insertTK.setBoolean(3, tk.isTrangThai());

            insertNV.executeUpdate();
            insertTK.executeUpdate();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public TaiKhoan checkTK(String tenTK, String matKhau) {
        String sql = "select * from taikhoan where TenTaiKhoan like ? and MatKhau like ?";
        TaiKhoan tk = null;
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, tenTK);
            st.setString(2, matKhau);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                tk = new TaiKhoan(rs.getString(1), rs.getString(2), rs.getBoolean(3));

            }

            NhanVien_DAO.instaceNV = tk;
            return tk;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean dangNhap(String tk, String mk) {
        TaiKhoan currentHt = this.checkTK(tk, mk);
        System.out.println("Tai khoan hien tai" + currentHt);
        if (currentHt != null) {
            NhanVien_DAO.instaceNV = currentHt;
            System.out.println("Login success");
            return true;
        }
        System.out.println("Login fail");
        return false;
    }

    public boolean dangXuat() {

//        String sql = "update taikhoan set TrangThaiTK = 0  where TenTaiKhoan like ? ";
//
//        try {
//            PreparedStatement st = con.prepareStatement(sql);
//            st.setBoolean(1, false);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        this.instaceNV = null;
        return true;
    }

    public List<NhanVien> getdsNV() {
        List ds = new ArrayList<NhanVien>();

        String sql = "Select * from NhanVien";

        try {
            PreparedStatement st = con.prepareStatement(sql);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                String manv = rs.getNString(1);
                String tenNV = rs.getNString(2);
                String cccd = rs.getNString(3);
                String sdt = rs.getNString(4);
                boolean tt = rs.getBoolean(5);
                LocalDate ngayVaoLam = rs.getDate(6).toLocalDate();
                String vaiTro = rs.getNString(7);

                NhanVien nv = new NhanVien(manv, tenNV, cccd, sdt, tt, ngayVaoLam, vaiTro);

                ds.add(nv);
            }

            return ds;
        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }

    public NhanVien timTheoMaNV(String manv) {
        NhanVien nv = null;
        String sql = "select * from NhanVien where MaNhanVien like ?";

        try {

            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, manv);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                String ma = rs.getNString(1);
                String tenNV = rs.getNString(2);
                String cccd = rs.getNString(3);
                String sdt = rs.getNString(4);
                boolean tt = rs.getBoolean(5);
                LocalDate ngayVaoLam = rs.getDate(6).toLocalDate();
                String vaiTro = rs.getNString(7);

                nv = new NhanVien(ma, tenNV, cccd, sdt, tt, ngayVaoLam, vaiTro);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return nv;
    }

    public boolean capNhatNV(NhanVien nvNew) {

        List<NhanVien> ds = this.getdsNV();

        NhanVien nvOld = ds.stream().filter(x -> x.getMaNV().equals(nvNew.getMaNV())).findFirst().orElse(null);

        if (nvOld == null) {
            System.out.println("Khong tim thay nhan vien");
            return false;
        }

        String sql = "update NhanVien set TenNhanVien = ?,CCCD = ?,SDT = ?,tinhTrangNV = ?, vaiTro = ? where maNhanVien = ?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, nvNew.getTenNV());
            st.setString(2, nvNew.getCCCD());
            st.setString(3, nvNew.getSDT());
            st.setBoolean(4, nvNew.isTinhTrangNV());
            st.setString(5, nvNew.getVaiTro());
            st.setString(6, nvNew.getMaNV());

            st.executeUpdate();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
