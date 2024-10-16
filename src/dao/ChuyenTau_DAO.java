package dao;

import database.connectDB;
import dto.ChuyenTau;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChuyenTau_DAO {
    private connectDB instance = connectDB.getInstance();
    Connection con = instance.connection();

    public List<ChuyenTau> getAllChuyenTau() {
        List<ChuyenTau> list = new ArrayList<>();
        String sql = "SELECT * FROM Chuyentau";
        try (PreparedStatement stmt = con.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                ChuyenTau ct = new ChuyenTau(
                        rs.getString("MaChuyenTau"),
                        rs.getString("MacTau"),
                        rs.getDate("NgayKhoiHanh"),
                        rs.getString("GaDi"),
                        rs.getString("GaDen"));
                list.add(ct);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public ChuyenTau getChuyenTauById(String maChuyenTau) {
        String sql = "SELECT * FROM Chuyentau WHERE MaChuyenTau = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, maChuyenTau);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new ChuyenTau(
                            rs.getString("MaChuyenTau"),
                            rs.getString("MacTau"),
                            rs.getDate("NgayKhoiHanh"),
                            rs.getString("GaDi"),
                            rs.getString("GaDen"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean addChuyenTau(ChuyenTau ct) {
        String sql = "INSERT INTO Chuyentau (MaChuyenTau, MacTau, NgayKhoiHanh, GaDi, GaDen) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, ct.getMaChuyenTau());
            stmt.setDate(3, Date.valueOf(ct.getNgayKhoiHanh()));
            stmt.setString(4, String.valueOf(ct.getGaDi()));
            stmt.setString(5, String.valueOf(ct.getGaDen()));
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateChuyenTau(ChuyenTau ct) {
        String sql = "UPDATE Chuyentau SET MacTau = ?, NgayKhoiHanh = ?, GaDi = ?, GaDen = ? WHERE MaChuyenTau = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setDate(2, Date.valueOf(ct.getNgayKhoiHanh()));
            stmt.setString(3, String.valueOf(ct.getGaDi()));
            stmt.setString(4, String.valueOf(ct.getGaDen()));
            stmt.setString(5, ct.getMaChuyenTau());
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // public boolean deleteChuyenTau(String maChuyenTau) {
    // String sql = "DELETE FROM Chuyentau WHERE MaChuyenTau = ?";
    // try (PreparedStatement stmt = con.prepareStatement(sql)) {
    // stmt.setString(1, maChuyenTau);
    // int rowsAffected = stmt.executeUpdate();
    // return rowsAffected > 0;
    // } catch (SQLException e) {
    // e.printStackTrace();
    // return false;
    // }
    // }
}