/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.connectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class TaiKhoan_DAO {
        private final connectDB instance = connectDB.getInstance();
        Connection con = instance.connection();
        
    public boolean doiMatKhau(String tenTaiKhoan, String matKhauMoi) {
    String sql = "UPDATE TaiKhoan SET MatKhau = ? WHERE TenTaiKhoan = ?";

    try {
        PreparedStatement doiMatKhauStmt = con.prepareStatement(sql);

        doiMatKhauStmt.setString(1, matKhauMoi);     
        doiMatKhauStmt.setString(2, tenTaiKhoan);     

        int rowsAffected = doiMatKhauStmt.executeUpdate();
        
        return rowsAffected > 0; 

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return false;
}

}
