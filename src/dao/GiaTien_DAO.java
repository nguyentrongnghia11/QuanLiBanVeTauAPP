package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.connectDB;
import dto.BangGia;

public class GiaTien_DAO {

    private connectDB instance = connectDB.getInstance();
    Connection con = instance.connection();
    public static BangGia instaceBangGia = null;

    public boolean themGia(BangGia a) {
        String sqlBG = "INSERT INTO BangGia( MaChuyenTau, MaToa, GiaTien, TrangThai) "
                + "VALUE (?,?,?,?)";

        try {
            PreparedStatement insertBangGia = con.prepareStatement(sqlBG);

            insertBangGia.setString(1, a.getMaChuyenTau());
            insertBangGia.setString(2, a.getMaToa());
            insertBangGia.setDouble(3, a.getGiaTien());
            insertBangGia.setInt(4, a.getTrangThai());

            insertBangGia.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return false;
    }

    public boolean capNhatGia(BangGia a) {
        String sqlBG = "UPDATE BangGia SET GiaTien = ?, TrangThai = ? "
                + "WHERE MaChuyenTau = ? AND MaToa = ?";

        try {
            PreparedStatement updateBangGia = con.prepareStatement(sqlBG);

            updateBangGia.setString(1, a.getMaChuyenTau());
            updateBangGia.setString(2, a.getMaToa());
            updateBangGia.setDouble(3, a.getGiaTien());
            updateBangGia.setInt(4, a.getTrangThai());

            int rowsUpdated = updateBangGia.executeUpdate();

            return rowsUpdated > 0;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return false;
    }

    public List<BangGia> getDSBangGia() {
        List ds = new ArrayList<BangGia>();
        String sql = "SELECT * FROM BangGia";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int maBG = rs.getInt(1);
                float giaTien = rs.getFloat(2);
                String maChuyenTau = rs.getNString(4);
                String maToa = rs.getNString(5);
                int trangThai = rs.getInt(3);

                BangGia a = new BangGia(maBG, (double) giaTien, trangThai, maChuyenTau, maToa);
                ds.add(a);
            }
            return ds;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public BangGia timGiaTheoMaChuyenTau(String maCT, String maToa) {
        BangGia gia = null;
        String sql = "SELECT * FROM BangGia WHERE MaChuyenTau LIKE ? AND maToa LIKE ? AND TrangThai = 1";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, maCT);
            st.setString(2, maToa);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int maBG = rs.getInt(1);
                float giaTien = rs.getFloat(2);
                String maChuyenTau = rs.getNString(4);
                String maT = rs.getNString(5);
                int trangThai = rs.getInt(3);

                gia = new BangGia(maBG, giaTien, trangThai, maChuyenTau, maT);
            }
            return gia;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gia;
    }

    public BangGia timGiaTheoMaBangGia(int maBG) {
        BangGia gia = null;
        String sql = "SELECT * FROM BangGia WHERE MaBangGia = ?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, maBG);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int magia = rs.getInt(1);
                double giaTien = rs.getDouble(2);
                String maChuyenTau = rs.getNString(4);
                String maT = rs.getNString(5);
                int trangThai = rs.getInt(3);

                gia = new BangGia(maBG, giaTien, trangThai, maChuyenTau, maT);
            }
            return gia;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gia;
    }

    public static void main(String[] args) {
        GiaTien_DAO g = new GiaTien_DAO();

        BangGia bg = g.timGiaTheoMaBangGia(1);
        System.out.println("dao.GiaTien_DAO.main()" + bg);

    }
}
