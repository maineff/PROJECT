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
   ArrayList<String>employeeAddress = new  ArrayList<String>(); 
   ArrayList<String>employeeUsername = new  ArrayList<String>(); 
   ArrayList<String>employeePassword = new  ArrayList<String>(); 

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
                employeeLastname.add(rst.getString("lastname"));
                employeeAddress.add(rst.getString("address"));
                employeeUsername.add(rst.getString("username"));
                employeePassword.add(rst.getString("password"));
            }

       }
       catch (SQLException ex) 
       {
           System.out.println("pb recup employee"+ex.getMessage());
       }

   }
   
   /*-----------------------Getter-----------------------*/
   
   public ArrayList getEmployeeName()
   {
       return employeeName;
   }
   
   public ArrayList getEmployeeLastname()
   {
       return employeeLastname;
   }
   
   public ArrayList getEmployeeAddress()
   {
       return employeeAddress;
   }
   
   public ArrayList getEmployeeUsername()
   {
       return employeeUsername;
   }
   
   public ArrayList getEmployeePassword()
   {
       return employeePassword;
   }

   
  
    public static void main(String[] args) 
    {
        new EmployeeDBQuery();
        new ProductDBQuery();
        new CustomerDBQuery();
      
    }
}
