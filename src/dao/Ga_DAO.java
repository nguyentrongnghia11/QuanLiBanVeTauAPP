package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.connectDB;
import dto.Ga;

public class Ga_DAO {
    private connectDB instance = connectDB.getInstance();
    Connection con = instance.connection();

    public boolean themGa(Ga ga) {
        String sql = "INSERT INTO Ga (MaGa, TenGa, DiaChi) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, ga.getMaGa());
            stmt.setString(2, ga.getTenGa());
            stmt.setString(3, ga.getDiaChiGa());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Ga getGaTheoMa(String maGa) {
        String sql = "SELECT * FROM Ga WHERE MaGa = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, maGa);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Ga(
                            rs.getString("MaGa"),
                            rs.getString("TenGa"),
                            rs.getString("DiaChi"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Ga> getAllGa() {
        List<Ga> dsGa = new ArrayList<>();
        String sql = "SELECT * FROM Ga";
        try (PreparedStatement stmt = con.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                dsGa.add(new Ga(
                        rs.getString("MaGa"),
                        rs.getString("TenGa"),
                        rs.getString("DiaChi")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsGa;
    }

    public boolean capNhatGa(Ga ga) {
        String sql = "UPDATE Ga SET TenGa = ?, DiaChi = ? WHERE MaGa = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, ga.getTenGa());
            stmt.setString(2, ga.getDiaChiGa());
            stmt.setString(3, ga.getMaGa());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static void main(String[] args) {
        Ga_DAO gadao = new Ga_DAO();
        
        gadao.getAllGa().stream().forEach(t -> System.out.println("dao.Ga_DAO.main()" + t));
    }

    // public boolean xoaGa(String maGa) {
    // String sql = "DELETE FROM Ga WHERE MaGa = ?";
    // try (PreparedStatement stmt = con.prepareStatement(sql)) {
    // stmt.setString(1, maGa);
    // return stmt.executeUpdate() > 0;
    // } catch (SQLException e) {
    // e.printStackTrace();
    // return false;
    // }
    // }
}