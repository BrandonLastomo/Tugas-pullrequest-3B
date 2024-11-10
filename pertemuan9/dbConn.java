/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pertemuan9;

import java.sql.Statement;
import java.sql.ResultSet;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.PreparedStatement;
import java.util.Scanner;

/**
 *
 * @author brand
 */
public class dbConn {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Insert username: ");
        String username = input.nextLine();
        System.out.print("Insert password: ");
        String password = input.next();
        try{
            Connection varConnection = connectDB.tryConnect();
            System.out.println("Connection succeded");
            Statement statement = varConnection.createStatement();
            
            String query = "SELECT * FROM users WHERE username = \"" + username + "\" AND password = \"" + password +"\"";
            System.out.println(query);
            ResultSet rs = statement.executeQuery(query);
            
            if(rs.next()){
                System.out.println("Login succeded");
            } else {
                System.out.println("Username or password is wrong");
            }
            
            rs.close();
            statement.close();
            varConnection.close();
        } catch (SQLException | ClassNotFoundException ex){
            Logger.getLogger(dbConn.class.getName());
            System.err.println("Error: connection failed " + ex.getMessage());
        }
    }
    
}
