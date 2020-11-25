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

/**
 *
 * @author alkassoumhaoua
 */
public class ProductDBQuery {
   public final String DB_URL ="jdbc:mysql://localhost:3306/projet";
   static Connection conn;
   static Statement st;
   static ResultSet rst;
   ArrayList<String>productName = new  ArrayList<>();
   ArrayList<String>productPrice = new  ArrayList<>();
    ArrayList<String>productQuantity= new  ArrayList<>();

    public ProductDBQuery() {
        
        try
      {
         // Create a Statement object for the query.
        String user="root";
        //String password="root"; 
        String password=""; 
        conn=DriverManager.getConnection(DB_URL, user, password);
        st = conn.createStatement();
        String sqlStatement = "SELECT * FROM product";
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
           productName.add( rst.getString("name"));
           productPrice.add(rst.getString("price"));
           productQuantity.add(rst.getString("quantity"));
           
       }
         
       } catch (SQLException ex) {
           Logger.getLogger(EmployeeDBQuery.class.getName()).log(Level.SEVERE, null, ex);
       }
              
                System.out.println(productName); 
                System.out.println(productPrice);
                System.out.println(productQuantity);
   }
    
    public ArrayList getProductName()
   {
       return productName;
   }
       
    public ArrayList getProductPrice()
    {
        return productPrice;
    }

    public ArrayList getProductQuantity()
    {
        return productQuantity;
    }

    
}
