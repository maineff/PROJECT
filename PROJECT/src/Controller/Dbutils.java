/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author alkassoumhaoua
 */
public class Dbutils {
     
    //public final static String DB_URL ="jdbc:mysql://localhost:8889/projet"; 
    public final static String DB_URL ="jdbc:mysql://localhost:3306/projet"; 
    
     public static Connection getDbConnection()throws SQLException
    {
       String user="root";
       //String password="root"; 
       String password=""; 
       return DriverManager.getConnection(DB_URL, user, password);
    }
     
    public static Statement createStatement() throws SQLException
    {
        Connection conn= Dbutils.getDbConnection();
        return conn.createStatement();

    }
    
    public static ResultSet executeQuery(String rq) throws SQLException
    {
       return createStatement().executeQuery(rq);
    }
    
    
    public static int executeUpdate(String rq) throws SQLException
    {
        return createStatement().executeUpdate(rq); 
    }
    
    //on récupère l'id max pour insérer a la suite
    public static int max(String table,String iDtable) throws SQLException
    {
         ResultSet rst;
         String rq= "SELECT Max("+iDtable+") FROM "+table;
         rst=Dbutils.executeQuery(rq);
         rst.next();
         int orderId=rst.getInt(1);
         return orderId+1;
    }
    

}
