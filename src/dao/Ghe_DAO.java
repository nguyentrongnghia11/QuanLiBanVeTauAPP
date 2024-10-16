package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import database.connectDB;

import dto.Ghe;
import dto.ToaTau;
import dto.LoaiGhe;

public class Ghe_DAO {
    private connectDB instance = connectDB.getInstance();
    Connection con = instance.connection();

    public boolean themGhe(Ghe ghe) {
        String sql = "INSERT INTO Ghe (MaGhe, MaToa, MaLoaiGhe, TrangThai) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, ghe.getMaGhe());
            stmt.setString(2, ghe.getMaToa().getMaToa()); // Assuming ToaTau has a getMaToa() method
            stmt.setString(3, ghe.getMaLoaiGhe().getMaLoai()); // Assuming LoaiGhe has a getMaLoai() method
            stmt.setBoolean(4, ghe.isTrangThai());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Ghe getGheTheoMa(int maGhe) {
        String sql = "SELECT * FROM Ghe WHERE MaGhe = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, maGhe);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int maghe = rs.getInt(1);
                    ToaTau matoa = new ToaTau(rs.getString(2));
                    LoaiGhe maloaighe = new LoaiGhe(rs.getString(3));
                    boolean trangthai = rs.getBoolean(4);

                    Ghe ghe = new Ghe(maghe, matoa, maloaighe, trangthai);
                    return ghe;

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Ghe> getGheTheoToa(String maToa) {
        List<Ghe> dsGhe = new ArrayList<>();
        String sql = "SELECT * FROM Ghe WHERE MaToa = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, maToa);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    dsGhe.add(new Ghe(
                            rs.getInt("MaGhe"),
                            new ToaTau(rs.getString("MaToa")),
                            new LoaiGhe(rs.getString("MaLoaiGhe")),
                            rs.getBoolean("TrangThai")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsGhe;
    }

    public boolean capNhatTrangThaiGhe(int maGhe, boolean trangThai) {
        String sql = "UPDATE Ghe SET TrangThai = ? WHERE MaGhe = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setBoolean(1, trangThai);
            stmt.setInt(2, maGhe);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // public boolean xoaGhe(int maGhe) {
    // String sql = "DELETE FROM Ghe WHERE MaGhe = ?";
    // try (PreparedStatement stmt = con.prepareStatement(sql)) {
    // stmt.setInt(1, maGhe);
    // return stmt.executeUpdate() > 0;
    // } catch (SQLException e) {
    // e.printStackTrace();
    // return false;
    // }
    // }

    public List<Ghe> getGheTrong(String maToa) {
        List<Ghe> dsGheTrong = new ArrayList<>();
        String sql = "SELECT * FROM Ghe WHERE MaToa = ? AND TrangThai = true";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, maToa);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    dsGheTrong.add(new Ghe(
                            rs.getInt("MaGhe"),
                            new ToaTau(rs.getString("MaToa")),
                            new LoaiGhe(rs.getString("MaLoaiGhe")),
                            rs.getBoolean("TrangThai")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsGheTrong;
    }
}