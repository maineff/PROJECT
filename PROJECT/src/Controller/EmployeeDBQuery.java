/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javax.swing.JLabel;
//import javax.swing.JFrame;
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
   ArrayList<String>employeeName = new  ArrayList<String>();
   ArrayList<String>employeeLastname = new  ArrayList<String>();

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


   public  void recup()
   {

       try
       {
           while(rst.next())
            {
                employeeName.add( rst.getString("name"));
                employeeLastname.add( rst.getString("lastname"));
            }

       }catch (SQLException ex) {
           Logger.getLogger(EmployeeDBQuery.class.getName()).log(Level.SEVERE, null, ex);
       }
          System.out.println(employeeName);   
   }
   
   
   public ArrayList getEmployeeName()
   {
       return employeeName;
   }
   
   public ArrayList getEmployeeLastname()
   {
       return employeeLastname;
   }

   
  
    public static void main(String[] args) 
    {
        new EmployeeDBQuery();
        new ProductDBQuery();
      
    }
}
