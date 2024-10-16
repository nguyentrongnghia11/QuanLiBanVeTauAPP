package dao;

import database.connectDB;
import dto.Tau;
import dto.ToaTau;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ToaTau_DAO {
    private connectDB instance = connectDB.getInstance();
    Connection con = instance.connection();

    public boolean themToaTau(ToaTau toaTau) {
        String sql = "INSERT INTO ToaTau (MaToa, MacTau, SucChua) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, toaTau.getMaToa());
            stmt.setString(2, toaTau.getMacTau().getMacTau());
            stmt.setInt(3, toaTau.getSucChua());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ToaTau getToaTauTheoMa(String maToa) {
        String sql = "SELECT * FROM ToaTau WHERE MaToa = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, maToa);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String ma = rs.getString("MaToa");
                    String macTau = rs.getString("MacTau");
                    int sucChua = rs.getInt("SucChua");
                    Tau tau = new Tau();
                    tau.setMacTau(macTau);

                    return new ToaTau(ma, tau, sucChua);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<ToaTau> getAllToaTau() {
        List<ToaTau> dsToaTau = new ArrayList<>();
        String sql = "SELECT * FROM ToaTau";
        try (PreparedStatement stmt = con.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String maToa = rs.getString("MaToa");
                String macTau = rs.getString("MacTau");
                int sucChua = rs.getInt("SucChua");
                Tau tau = new Tau();
                tau.setMacTau(macTau);

                dsToaTau.add(new ToaTau(maToa, tau, sucChua));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsToaTau;
    }

    public List<ToaTau> getToaTauTheoTau(String macTau) {
        List<ToaTau> dsToaTau = new ArrayList<>();
        String sql = "SELECT * FROM ToaTau WHERE MacTau = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, macTau);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String maToa = rs.getString("MaToa");
                    int sucChua = rs.getInt("SucChua");
                    Tau tau = new Tau();
                    tau.setMacTau(macTau);

                    dsToaTau.add(new ToaTau(maToa, tau, sucChua));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsToaTau;
    }

    public boolean capNhatToaTau(ToaTau toaTau) {
        String sql = "UPDATE ToaTau SET MacTau = ?, SucChua = ? WHERE MaToa = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, toaTau.getMacTau().getMacTau());
            stmt.setInt(2, toaTau.getSucChua());
            stmt.setString(3, toaTau.getMaToa());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // public boolean xoaToaTau(String maToa) {
    // String sql = "DELETE FROM ToaTau WHERE MaToa = ?";
    // try (PreparedStatement stmt = con.prepareStatement(sql)) {
    // stmt.setString(1, maToa);
    // return stmt.executeUpdate() > 0;
    // } catch (SQLException e) {
    // e.printStackTrace();
    // return false;
    // }
    // }

    public int getSoLuongGheTrong(String maToa) {
        String sql = "SELECT COUNT(*) FROM Ghe WHERE MaToa = ? AND TrangThai = 1";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, maToa);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}