/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.connectDB;
import dto.HanhKhach;
import dto.LoaiHanhKhach;
import dto.NhanVien;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Trong Nghia
 */
public class HanhKhach_DAO {

    private connectDB intances = connectDB.getInstance();

    Connection con = intances.connection();

    public List<HanhKhach> getdsHK() {
        List ds = new ArrayList<HanhKhach>();

        String sql = "Select * from HanhKhach";

        try {
            PreparedStatement st = con.prepareStatement(sql);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                String maHK = rs.getNString(1);
                LoaiHanhKhach loaiHK = new LoaiHanhKhach(rs.getInt(2));
                String tenHK = rs.getNString(3);
                String cccd = rs.getNString(4);
                String sdt = rs.getNString(5);

                HanhKhach hk = new HanhKhach(maHK, tenHK, loaiHK, cccd, sdt);

                ds.add(hk);
            }

            return ds;
        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }

    public HanhKhach timTheoCCCD(String cccd) {
        return this.getdsHK().stream().filter(x -> x.getCCCD().equals(cccd)).findFirst().orElse(null);
    }

    public HanhKhach timTheoSDT(String sdt) {
        return this.getdsHK().stream().filter(x -> x.getSDT().equals(sdt)).findFirst().orElse(null);
    }

    public boolean themHK(HanhKhach hk) {

        String sql = "INSERT INTO HanhKhach (MaHanhKhach, MaLoai, TenHanhKhach, CCCD, SDT) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement insertHK = con.prepareStatement(sql);

            insertHK.setString(1, hk.getMaHanhKhach());
            insertHK.setInt(2, hk.getMaLoai().getMaLoai());
            insertHK.setString(3, hk.getTenHanhKhach());
            insertHK.setString(4, hk.getCCCD());
            insertHK.setString(5, hk.getSDT());

            insertHK.executeUpdate();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean capNhatHK(HanhKhach hkNew) {

        List<HanhKhach> ds = this.getdsHK();

        HanhKhach hkOld = ds.stream().filter(x -> x.getMaHanhKhach().equals(hkNew.getMaHanhKhach())).findFirst().orElse(null);

        if (hkOld == null) {
            System.out.println("Khong tim thay hanh khach");
            return false;
        }

        String sql = "update HanhKhach set MaLoai = ?,TenHanhKhach = ?, CCCD = ?,SDT = ? where MaHanhKhach = ?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, hkNew.getMaLoai().getMaLoai());
            st.setString(2, hkNew.getTenHanhKhach());
            st.setString(3, hkNew.getCCCD());
            st.setString(4, hkNew.getSDT());
            st.setString(5, hkNew.getMaHanhKhach());

            st.executeUpdate();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public int getSize() {
        return this.getdsHK().size();
    }
    
    public double getMucGiamGia(){
        return 0.0;
    } 
}
