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
         }
         else
            JOptionPane.showMessageDialog(null,"Add elements in your order");   
         
       } 
       catch (SQLException ex) 
       {
           Logger.getLogger(OrderDBQuery.class.getName()).log(Level.SEVERE, null, ex);
       }     
    }
}
