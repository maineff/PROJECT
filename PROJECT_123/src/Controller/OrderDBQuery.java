/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Model.Order;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author alkassoumhaoua
 */
public class OrderDBQuery {
     
   static ResultSet rst;
   
    //ajouter une commande dans la base de données 
   //Add an order in the database
   
    public void submitOrder(Order od)
    {
        
       try 
       {
         if(od.getTotalPrice()>0)
         {
            int id = Dbutils.max("order1","orderId");
            String date= new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
            String query="INSERT INTO order1"
                    +"(orderId,quantity,discount,totalPrice,date,username)" 
                    +" VALUES "
                    +"("+id+","+od.getQuantity()+","+od.getDiscount()
                    +","+od.getTotalPrice()+",'"+date
                    +"','"+od.getUsername()+"')";
           int rows= Dbutils.executeUpdate(query) ;
            od.setOrderId(id);
         }
         else
            JOptionPane.showMessageDialog(null,"Add elements in your order");   
         
       } 
       catch (SQLException ex) 
       {
           Logger.getLogger(OrderDBQuery.class.getName()).log(Level.SEVERE, null, ex);
       }     
    }
    
    public ArrayList<Order> getOrder() 
    {
        ArrayList<Order>orders= new  ArrayList<>();
        String sqlStatement = "SELECT * FROM order1";
       
        try
        {
           rst = Dbutils.executeQuery(sqlStatement);
           Order od ;
           while(rst.next())
           {
                od= new Order();
                od.setOrderId(rst.getInt("orderId"));
                od.setQuantity(rst.getInt("quantity"));
                od.setDiscount(rst.getDouble("discount"));
                od.setTotalPrice(rst.getDouble("totalPrice"));
                od.setOrderDate(rst.getString("date"));
                od.setUsername(rst.getString("username"));
                orders.add(od);
           }
        }
        catch (SQLException ex) 
        {
            System.out.println("pb recup orders"+ex.getMessage());
        }
      
        return orders;

    }
}
