/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.connectDB;
import dto.Tau;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class Tau_DAO {
        private final connectDB instance = connectDB.getInstance();
        Connection con = instance.connection();
    
    public boolean themTau(Tau tau) {
         

    String sql = "INSERT INTO Tau (MaTau, MaLoai, MaNhanVien, TenTau, SoLuongToa, TinhTrangTau) "
               + "VALUES (?, ?, ?, ?, ?, ?)";

    try {
        PreparedStatement insertTau = con.prepareStatement(sql);

        insertTau.setString(1, tau.getMacTau());        
        insertTau.setObject(2, tau.getMaLoai());      
        insertTau.setString(3, tau.getMaNhanVien());   
        insertTau.setString(4, tau.getTenTau());     
        insertTau.setInt(5, tau.getSoLuongToa());      
        insertTau.setBoolean(6, tau.isTinhTrangTau()); 

        insertTau.executeUpdate();

        return true;

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return false;
}
        public boolean xoaTau(String maTau){
            String sql = "DELETE FROM Tau WHERE MacTau = ?";
               try {
        PreparedStatement deleteTau = con.prepareStatement(sql);
        deleteTau.setString(1, maTau);

        int rowsAffected = deleteTau.executeUpdate();
        
        return rowsAffected > 0; 

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return false;
        }
        
        
        public boolean capNhatTau(Tau tau) {
    String sql = "UPDATE Tau SET MaLoai = ?, MaNhanVien = ?, TenTau = ?, SoLuongToa = ?, TinhTrangTau = ? "
               + "WHERE MacTau = ?";

    try {
        PreparedStatement updateTau = con.prepareStatement(sql);

        updateTau.setObject(1, tau.getMaLoai());    
        updateTau.setString(2, tau.getMaNhanVien()); 
        updateTau.setString(3, tau.getTenTau());      
        updateTau.setInt(4, tau.getSoLuongToa());    
        updateTau.setBoolean(5, tau.isTinhTrangTau());
        updateTau.setString(6, tau.getMacTau());      

        int rowsAffected = updateTau.executeUpdate();
        
        return rowsAffected > 0;

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return false;
}


}
