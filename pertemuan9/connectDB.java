/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuan9;
import java.sql.Statement;
import java.sql.ResultSet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.PreparedStatement;
import java.util.Scanner;

/**
 *
 * @author brand
 */
public class connectDB {
    private static Connection connect;
    
    public static Connection tryConnect() throws SQLException, ClassNotFoundException{
        try {
            if (connect == null){
                Class.forName("com.mysql.cj.jdbc.Driver");
                connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_informatika_3b", "root", "");
                System.out.println("Connected");
            }
            return connect;
        } catch (SQLException e){
            System.err.println("Error: connection failed " + e.getMessage());
            throw e;
        }
    }
}
