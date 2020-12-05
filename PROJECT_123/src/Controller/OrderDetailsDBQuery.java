/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.OrderDetails;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alkassoumhaoua
 */
public class OrderDetailsDBQuery {
    
    static ResultSet rst;
   
   //ajouter une commande dans la base de données 
   //Add an order in the database
   public void submitBucket(OrderDetails od)
    {
        
       try 
       {
         
            int id = Dbutils.max("orderdetails","orderdetailsId");
            String query="INSERT INTO orderdetails"
                    +"(orderdetailsId,orderId,productId,quantity,price,discount)" 
                    +" VALUES "
                    +"("+id+","+od.getOrderId()+","+od.getProductId()
                    +","+od.getQuantity()+",'"+od.getPrice()
                    +"','"+od.getDiscount()+"')";
           int rows= Dbutils.executeUpdate(query) ;
         
       } 
       catch (SQLException ex) 
       {
           Logger.getLogger(OrderDBQuery.class.getName()).log(Level.SEVERE, null, ex);
       }     
    }
    
    public ArrayList<OrderDetails> getAllOrderDetails() 
    {
        ArrayList<OrderDetails>orderdetails= new  ArrayList<>();
        String sqlStatement = "SELECT * FROM orderdetails";
       
        try
        {
           rst = Dbutils.executeQuery(sqlStatement);
           OrderDetails od ;
           while(rst.next())
           {
                od= new OrderDetails();
                od.setOrderDetailsId(rst.getInt("orderdetailsId"));
                od.setOrderId(rst.getInt("orderId"));
                od.setProductId(rst.getInt("productId"));
                od.setQuantity(rst.getInt("quantity"));
                od.setPrice(rst.getDouble("price"));
                od.setDiscount(rst.getInt("discount"));
                orderdetails.add(od);
           }
        }
        catch (SQLException ex) 
        {
            System.out.println("pb recup orders"+ex.getMessage());
        }
      
        return orderdetails;

    }
}
