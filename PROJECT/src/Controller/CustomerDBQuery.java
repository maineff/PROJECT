/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this tcustlate file, choose Tools | Tcustlates
 * and open the tcustlate in the editor.
 */
package Controller;


import Model.Customer;
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
    
   static ResultSet rst;
   
   
    
   public  void recup()
   {
       try
       {
           while(rst.next())
            {
                customerId.add( rst.getInt("customerId"));
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
   
    static ResultSet rst;
  
   
   /*-----------------------GetALLcustloyee-----------------------*/
    
    public ArrayList<Customer> getCustomers() 
    {
        ArrayList<Customer>custloyees= new  ArrayList<Customer>();
        String sqlStatement = "SELECT * FROM customer";
       
        try
        {
           rst = Dbutils.executeQuery(sqlStatement);
           Customer cust ;
           while(rst.next())
           {
                cust= new Customer();
                cust.setCustomerId(rst.getInt("customerId"));
                cust.setCustomerName(rst.getString("name"));
                cust.setCustomerLastname(rst.getString("lastname"));
                cust.setCustomerAddress(rst.getString("address"));
                cust.setCustomerCity(rst.getString("city"));
                cust.setCustomerUsername(rst.getString("username"));
                cust.setCustomerPassword(rst.getString("password"));
                custloyees.add(cust);
            }

        }
        catch (SQLException ex) 
        {
            System.out.println("pb recup customer"+ex.getMessage());
        }
      
        return custloyees;

    }
   
    
    public void addCustomer(Customer cust)
    {
        try
        {
             String query="INSERT INTO customer VALUES("+cust.getCustomerId()+",'"+cust.getCustomerName()+
                     "','"+cust.getCustomerLastname()+"','"+cust.getCustomerAddress() +"',"+cust.getCustomerCity()
                     +"',"+cust.getCustomerUsername()+"',"+cust.getCustomerPassword()+")";
             rst = Dbutils.executeQuery(query);
        }
        catch(Exception e)
        {
            System.out.println("pb ajout customer"+e.getMessage());
        }
    }
    
    public void deleteCustomer(Customer cust)
    {
        try
        {
             String query="DELETE  FROM customer WHERE customerId="+cust.getCustomerId();
             rst = Dbutils.executeQuery(query);
        }
        catch(Exception e)
        {
            System.out.println("pb suppression customer"+e.getMessage());
        }
    }
   
    public void updateCustomer(Customer cust)
    {
        try
        {
           String query="UPDATE customer SET name='"+cust.getCustomerName()
                    +"', lastname='"+cust.getCustomerLastname()
                    +"', address='"+cust.getCustomerAddress()
                    +"', city='"+cust.getCustomerCity()
                    +"', username="+cust.getCustomerUsername()
                    +"', password="+cust.getCustomerPassword()
                    +" WHERE customerId = "+cust.getCustomerId();
           
             rst = Dbutils.executeQuery(query);
        }
        catch(Exception e)
        {
            System.out.println("pb update customer"+e.getMessage());
        }
    } 
    
   
    
}
