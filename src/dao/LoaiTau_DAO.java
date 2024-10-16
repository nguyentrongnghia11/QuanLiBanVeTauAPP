/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.connectDB;
import dto.LoaiTau;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class LoaiTau_DAO {
    
            private final connectDB instance = connectDB.getInstance();
        Connection con = instance.connection();
        
    public List<LoaiTau> getdsLoaiTau() {
    List<LoaiTau> ds = new ArrayList<>();

    String sql = "SELECT * FROM LoaiTau";

    try {
        PreparedStatement st = con.prepareStatement(sql);

        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            String maLoai = rs.getNString(1);  
            String tenLoai = rs.getNString(2); 

            LoaiTau loaiTau = new LoaiTau(maLoai, tenLoai); 

            ds.add(loaiTau); 
        }

        return ds; 
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return null;
}

}
