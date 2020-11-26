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


/**
 *
 * @author alkassoumhaoua
 */
public class OrderDBQuery {
     
   static Connection conn;
   static Statement st;
   static ResultSet rst;
   
   public OrderDBQuery ()
   {
        try
        {
          conn=Dbutils.getDbConnection();
          st = conn.createStatement();
          //String sqlStatement = "SELECT * FROM Iceorder";
          //rst = st.executeQuery(sqlStatement);
          System.out.println("GREAT");
        }
        catch (SQLException ex)
        {
           ex.printStackTrace();
        }
   }
   
   
   //ajouter une commande dans la base de données 
    public static void submitOrder(int orderId,int qty,String date,double reduc,double prix) throws SQLException
    {  
        
        try 
        { 
              orderId=max()+1;
              String sqlStatement = "INSERT INTO order"+"(orderId,quantity,discount,totalPrice)" +
                      "VALUES "+ "("+orderId+",'"+qty+"','"+reduc+"','"+prix+"','"+date+"')";
              st.executeUpdate(sqlStatement);
            
        } 
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
   
    }
    
    public static int max() throws SQLException
    {
        conn=Dbutils.getDbConnection();
        st=conn.createStatement();

        //on récupère l'id max
         String rq= "SELECT Max(orderNumber) FROM Iceorder";
         rst=st.executeQuery(rq);
         rst.next();
         int orderId=rst.getInt(1);
         return orderId;
    }
    
   
}
