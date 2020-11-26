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
public class ProductDBQuery {
  
   static Connection conn;
   static Statement st;
   static ResultSet rst;
   ArrayList<String>productName = new  ArrayList<>();
   ArrayList<Double>productPrice = new  ArrayList<>();
   ArrayList<Integer>productStock= new  ArrayList<>();
   ArrayList<Integer>productId= new  ArrayList<>();

    public ProductDBQuery() 
    {
      try
      {
        conn=Dbutils.getDbConnection();
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
           productId.add(rst.getInt("productId"));
           productName.add( rst.getString("name"));
           productPrice.add(Double.parseDouble(rst.getString("price")));
           productStock.add(Integer.parseInt(rst.getString("stock")));
        }
         
       } 
       catch (SQLException ex)
       {
           System.out.println("pb recup product"+ex.getMessage());
       }
        
        System.out.println(productId);
        System.out.println(productName); 
        System.out.println(productPrice);
        System.out.println(productStock);
   }
    
    /*-----------------------Getter-----------------------*/
     public ArrayList getProductId()
    {
        return productId;
    }
    
    public ArrayList getProductName()
    {
        return productName;
    }
       
    public ArrayList getProductPrice()
    {
        return productPrice;
    }

    public ArrayList getProductStock()
    {
        return productStock;
    }

    
}
