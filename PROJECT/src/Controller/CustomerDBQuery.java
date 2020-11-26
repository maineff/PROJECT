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


/**
 *
 * @author alkassoumhaoua
 */
public class CustomerDBQuery {
    
   static Connection conn;
   static Statement st;
   static ResultSet rst;
   ArrayList<String>customerName = new  ArrayList<String>();
   ArrayList<String>customerLastname = new  ArrayList<String>();
   ArrayList<String>customerAddress = new  ArrayList<String>(); 
   ArrayList<String>customerCity = new  ArrayList<String>(); 
   ArrayList<String>customerUsername = new  ArrayList<String>(); 
   ArrayList<String>customerPassword = new  ArrayList<String>();

    public CustomerDBQuery() 
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
                customerName.add( rst.getString("name"));
                customerLastname.add( rst.getString("lastname"));
                customerAddress.add(rst.getString("address"));
                customerUsername.add(rst.getString("username"));
                customerPassword.add(rst.getString("password"));
                customerCity.add(rst.getString("city"));
            }

       }
       catch (SQLException ex) 
       {
            System.out.println("pb recup client"+ex.getMessage());
       }
         
   }
   
   /*-----------------------Getter-----------------------*/
   
   public ArrayList getCustomerName()
   {
       return customerName;
   }
   
   public ArrayList getCustomerLastname()
   {
       return customerLastname;
   }
   
   public ArrayList getCustomerAddress()
   {
       return customerAddress;
   }
   
   public ArrayList getCustomerUsername()
   {
       return customerUsername;
   }
   
   public ArrayList getCustomerPassword()
   {
       return customerPassword;
   }

   public ArrayList getCustomerCity()
   {
       return customerCity;
   }
   
   
   
    
}
