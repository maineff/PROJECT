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


/**
 *
 * @author alkassoumhaoua
 */
public class OrderDBQuery {
     
   static ResultSet rst;
   
    //ajouter une commande dans la base de données 
    public void addOrder(Order od)
    {  
        try 
        { 
//            if(od.getTotalPrice()>0)
//            {
                int id = Dbutils.max("order","orderId");
                String date=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
                System.out.println(id);
                System.out.println(date);
                String query = "INSERT INTO order"
                        +"(orderId,quantity,discount,totalPrice,date)" 
                        +"VALUES"
                        +"("+id+","+od.getQuantity()
                        +","+od.getDiscount()+","
                        +od.getTotalPrice()+",'"+date+"')";
                
                System.out.println(query);
                int rows= Dbutils.executeUpdate(query) ;
//            }
//            else
//                JOptionPane.showMessageDialog(null,"add elements in your order");   
        }
        catch(Exception e)
        {
            System.out.println("pb ajout employee"+e.getMessage());
        }
    }
}
