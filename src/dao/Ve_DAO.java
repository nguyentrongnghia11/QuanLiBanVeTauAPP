/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.connectDB;
import dto.BangGia;
import dto.ChiTietVe;
import dto.HanhKhach;
import dto.Ve;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Trong Nghia
 */
public class Ve_DAO {

    private connectDB instance = connectDB.getInstance();

    Connection con = instance.connection();
    KhuyenMai_DAO kmd = new KhuyenMai_DAO();
    LoaiHanhKhach_DAO lhk = new LoaiHanhKhach_DAO();
    GiaTien_DAO bgd = new GiaTien_DAO();

    public boolean insertVe(Ve ve) {
        String sql = "INSERT INTO Ve(MaVe, MaNhanVien, MaLoai, MaKhuyenMai, NgayBan,MaGhe ,TongTien, pttt, TrangThaiVe, maChuyenTau, maToa) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, ve.getMaVe());
            st.setString(2, ve.getMaNV().getMaNV());
            st.setString(3, ve.getMaLoai().getMaLoai());
            st.setString(4, ve.getMaKhuyenMai().getMaKhuyenMai());
            st.setDate(5, Date.valueOf(ve.getNgayBan()));
            st.setInt(6, ve.getSoGhe().getMaGhe());
            st.setInt(7, ve.getTrangThaiVe());
            st.setDouble(8, ve.getTongTien());
            st.setString(9, ve.getPTTT().getMaPhuongThuc());
            st.setString(10, ve.getMaChuyenTau().getMaChuyenTau());
            st.setString(11, ve.getMaToa().getMaToa());

            st.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean insertCTVe(ChiTietVe ctve) {
        String sql = "INSERT INTO ChiTietVe(MaVe, maBangGia, MaHanhKhach, SoLuong) "
                + "VALUES (?, ?, ?, ?))";

        try {
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, ctve.getMaHanhKhach().getMaHanhKhach());
            st.setString(2, ctve.getMaVe().getMaVe());
            st.setInt(3, ctve.getMaBangGia().getMaBangGia());
            st.setInt(4, ctve.getSoLuong());

            st.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean datVe(Ve ve, HanhKhach hk, int soluong, double tongKhuyenMai) {

        BangGia BangGia = bgd.timGiaTheoMaChuyenTau(ve.getMaChuyenTau().getMaChuyenTau(), ve.getMaToa().getMaToa());

        ChiTietVe ctVe = new ChiTietVe(hk, ve, BangGia, soluong);

        String loaiVe = ve.getMaLoai().getTenLoaiVe();

        if (loaiVe.equalsIgnoreCase("ca nhan")) {
            // get khuyen mai
            double chietKhau = kmd.getdsKM().stream().filter(t -> t.getMaKhuyenMai().equalsIgnoreCase(ve.getMaKhuyenMai().getTenKhuyenMai())).findFirst().orElse(null).getChietKhau();
//            double khuyenMaiHanhKhach = lhk.timLoaiHK(ctVe.getMaHanhKhach().getMaLoai().getTenLoai()).getMucGiamGia();
            double gia = BangGia.getGiaTien();

            double tongtien = gia * (soluong - tongKhuyenMai) * (1 - chietKhau);

            try {
                insertVe(ve);
                insertCTVe(ctVe);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {

        }

        if (ve.getMaLoai().getTenLoaiVe().equalsIgnoreCase("ca nhan")) {

            String loaiKhuyenMai = ve.getMaKhuyenMai().getMaKhuyenMai();

            String insertVe = "INSERT INTO Ve(MaVe, MaNhanVien, MaLoai, MaKhuyenMai, NgayBan,TongTien, pttt, TrangThaiVe, maChuyenTau, maToa) VALUES (?, ?, ?, ?,? ,?, ?, ?, ?, ?)";
            String insertCTVe = "INSERT INTO ChiTietVe(MaVe, maBangGia, MaHanhKhach, SoLuong) VALUES (?, ?, ?, ?)";

            int soluongVe = ctVe.getSoLuong();
            String maKM = ve.getMaKhuyenMai().getMaKhuyenMai();
            String maLoaiHanhKhach = ve.getMaLoai().getMaLoai();

            try {
                PreparedStatement st = con.prepareStatement(insertVe);
                PreparedStatement sttm = con.prepareStatement(insertCTVe);

                st.setString(1, ve.getMaVe());
                st.setString(2, ve.getMaNV().getMaNV());
                st.setString(3, ve.getMaLoai().getMaLoai());
                st.setString(4, ve.getMaKhuyenMai().getMaKhuyenMai());
                st.setDate(5, Date.valueOf(ve.getNgayBan()));
                st.setString(6, ve.getMaVe());
                st.setString(7, ve.getMaVe());
                st.setString(8, ve.getMaVe());
                st.setString(9, ve.getMaVe());
            } catch (Exception e) {

            }

            return true;
        } // lay ra so luong, muc giam, khuyen mai 
        // cap nhat lai tong tien  
        //double tongTien = ;
//        else {
//            String insertVe = "INSERT INTO Ve(MaVe, MaNhanVien, MaLoai, MaKhuyenMai, NgayBan,TongTien, pttt, TrangThaiVe, maChuyenTau, maToa) VALUES (?, ?, ?, ?,? ,?, ?, ?, ?, ?)";
//            String insertCTVe = "INSERT INTO ChiTietVe(MaVe, maBangGia, MaHanhKhach, SoLuong) VALUES (?, ?, ?, ?)";
//
//            int soluongVe = ctVe.getSoLuong();
//            String maKM = ve.getMaKhuyenMai().getMaKhuyenMai();
//            String maLoaiHanhKhach = ve.getMaLoai().getMaLoai();
//
//            try {
//                PreparedStatement st = con.prepareStatement(insertVe);
//                PreparedStatement sttm = con.prepareStatement(insertCTVe);
//
//                st.setString(1, ve.getMaVe());
//                st.setString(2, ve.getMaNV().getMaNV());
//                st.setString(3, ve.getMaLoai().getMaLoai());
//                st.setString(4, ve.getMaKhuyenMai().getMaKhuyenMai());
//                st.setDate(5, Date.valueOf(ve.getNgayBan()));
//                st.setString(6, ve.getMaVe());
//                st.setString(7, ve.getMaVe());
//                st.setString(8, ve.getMaVe());
//                st.setString(9, ve.getMaVe());
//            } catch (Exception e) {
//
//            }

        return true;
        //}

    }
    
    
    
//    public List getDsChoTrong (){
//        List ds = new ArrayList<Ve>();
//    }
}
