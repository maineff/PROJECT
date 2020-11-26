/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author alkassoumhaoua
 */
public class Dbutils {
     
    public final static String DB_URL ="jdbc:mysql://localhost:8889/projet"; 
    
     public static Connection getDbConnection()throws SQLException
    {
       String user="root";
       String password="root"; 
        //String password=""; 
        return DriverManager.getConnection(DB_URL, user, password);
    }
}
