/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Trong Nghia
 */
public class connectDB {

    private static connectDB instance = new connectDB();

    private Connection con = null;

    public Connection connection() {
        String url = "jdbc:sqlserver://localhost:1433;databasename=QuanLiBanVeTau;encrypt=false";
        String password = "123";
        String user = "sa";

        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connect database success");
        } catch (Exception e) {
            System.out.println("database.connectDB.connection()" + e);
        }

        return con;

    }

    public static connectDB getInstance() {
        return instance;
    }

}
