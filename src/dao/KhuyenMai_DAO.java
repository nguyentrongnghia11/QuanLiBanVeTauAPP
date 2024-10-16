/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.connectDB;
import dto.KhuyenMai;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Trong Nghia
 */
public class KhuyenMai_DAO {

    private connectDB instance = connectDB.getInstance();
    private Connection con = instance.connection();

    public List<KhuyenMai> getdsKM() {
        List ds = new ArrayList<KhuyenMai>();

        String sql = "Select * from KhuyenMai";

        try {
            PreparedStatement st = con.prepareStatement(sql);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                String maKhuyenMai = rs.getNString(1);
                String tenKM = rs.getNString(2);
                Double chietKhau = rs.getDouble(3);
                LocalDate ngayBatDau = rs.getDate(4).toLocalDate();
                LocalDate ngayKetThuc = rs.getDate(5).toLocalDate();
                String moTa = rs.getNString(6);
                KhuyenMai km = new KhuyenMai(maKhuyenMai, tenKM, chietKhau, ngayBatDau, ngayKetThuc, moTa);
                ds.add(km);
            }

            return ds;
        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        KhuyenMai_DAO kmd = new KhuyenMai_DAO();

        kmd.getdsKM().stream().forEach(t -> System.out.println("dao.KhuyenMai_DAO.main()" + t.getChietKhau()));
    }

}
