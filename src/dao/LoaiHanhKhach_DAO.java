package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.connectDB;
import dto.KhuyenMai;
import dto.LoaiHanhKhach;

public class LoaiHanhKhach_DAO {

    private connectDB instance = connectDB.getInstance();
    Connection con = instance.connection();
    public static LoaiHanhKhach instaceLoaiHK = null;

    public boolean them(LoaiHanhKhach a) {
        String sql = "INSERT INTO LoaiHanhKhach(TenLoai, MucGiamGia)"
                + "VALUES (?,?)";
        try {
            PreparedStatement insertLHK = con.prepareStatement(sql);
            insertLHK.setNString(1, a.getTenLoai());
            insertLHK.setDouble(2, a.getMucGiamGia());
            insertLHK.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public LoaiHanhKhach timLoaiHK(String a) {
        LoaiHanhKhach hk = null;
        String sql = "SELECT * FROM LoaiHanhKhach"
                + "WHERE TenLoai like ?";
        try {
            PreparedStatement tim = con.prepareStatement(sql);
            tim.setString(1, "%" + a + "%");
            ResultSet rs = tim.executeQuery();
            while (rs.next()) {
                int ma = rs.getInt(1);
                String tenLoai = rs.getNString(2);
                float giamGia = rs.getFloat(3);

                hk = new LoaiHanhKhach(ma, tenLoai, giamGia);

            }
            return hk;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hk;
    }

    public boolean capNhatLoaiHL(LoaiHanhKhach a) {
        String sql = "UPDATE LoaiHanhKhach SET TenLoai= ? and MucGiamGia = ?"
                + "WHERE MaLoai = ?";
        try {
            PreparedStatement update = con.prepareStatement(sql);
            update.setString(1, a.getTenLoai());
            update.setDouble(2, a.getMucGiamGia());
            update.setInt(3, a.getMaLoai());

            int rowUpdate = update.executeUpdate();
            return rowUpdate > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<LoaiHanhKhach> getDsHanhKhach() {
        String sql = "Select * from LoaiHanhKhach";
        List ds = new ArrayList<LoaiHanhKhach>();
        try {
            PreparedStatement st = con.prepareStatement(sql);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                int maLoai = rs.getInt(1);
                String tenLoai = rs.getNString(2);
                double mucGiamGia = rs.getDouble(3);

                LoaiHanhKhach km = new LoaiHanhKhach(maLoai, tenLoai, mucGiamGia);

                ds.add(km);

            }
            return ds;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        LoaiHanhKhach_DAO l = new LoaiHanhKhach_DAO();

        l.getDsHanhKhach().stream().forEach(t -> System.out.println("dao.LoaiHanhKhach_DAO.main()" + t));
    }
}
