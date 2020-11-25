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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.*;

/**
 *
 * @author alkassoumhaoua
 */

/**
       Constructor
   */
public class EmployeeDBQuery {
      
  
   static Connection conn;
   static Statement st;
   static ResultSet rst;
   ArrayList<String>noms = new  ArrayList<String>();
   JPanel panel;
   JFrame window;
   
    public EmployeeDBQuery()
   {
      
      try
      {
        conn=Dbutils.getDbConnection();
        st = conn.createStatement();
        String sqlStatement = "SELECT * FROM employee";
         rst = st.executeQuery(sqlStatement);
        recup();
       }
      catch (SQLException ex)
      {
         ex.printStackTrace();
      }
    
   }

   /**
       The getDatabaseConnection method loads the JDBC
       and gets a connection to the database.
   */
   public  void recup()
   {
        JLabel msg = new JLabel();
        panel= new JPanel();
       try
       {
           
           
        while(rst.next())
        {
           noms.add( rst.getString("name"));
           System.out.print(rst.getInt("employeeId")+"\t");
       }
        msg.setText(noms.toString());
        /*System.out.print(rst.getString("name")+"\t");
        System.out.print(rst.getString("lastname")+"\t");
        System.out.print(rst.getString("address")+"\t");
        System.out.print(rst.getInt("telephoneNumber")+"\t");
        System.out.println("");;*/
        window = new JFrame();
        window.setSize(300,300);
        window.setTitle("City");
        panel.add(msg);
        window.add(panel);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
               
         
       } catch (SQLException ex) {
           Logger.getLogger(EmployeeDBQuery.class.getName()).log(Level.SEVERE, null, ex);
       }
              
                System.out.println(noms);   
   }
   public ArrayList getNom()
   {
       return noms;
   }

   
  
    public static void main(String[] args) 
    {
        new EmployeeDBQuery();
        new ProductDBQuery();
      
    }
}
