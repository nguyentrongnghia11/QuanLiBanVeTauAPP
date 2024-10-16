/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package gui;

import database.connectDB;

/**
 *
 * @author Trong Nghia
 */
public class QuanLiBanVeTau {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        connectDB.getInstance().connection();
    }
}
