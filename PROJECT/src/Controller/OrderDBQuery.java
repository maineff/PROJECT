/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author alkassoumhaoua
 */
public class OrderDBQuery {
     
   static ResultSet rst;
   
    //ajouter une commande dans la base de données 
    public static void addOrder(int orderId,int qty,String date,double reduc,double prix) throws SQLException
    {  
        try 
        { 
            if(prix>0)
            {
                int id = Dbutils.max("order","orderId");
                String query = "INSERT INTO order"+"(orderId,quantity,discount,totalPrice,date)" +
                       "VALUES "+ "("+id+",'"+qty+"','"+reduc+"','"+prix+"','"+date+"')";
                int rows= Dbutils.executeUpdate(query) ;
            }
            else
                JOptionPane.showMessageDialog(null,"add elements in your order");   
        } 
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
