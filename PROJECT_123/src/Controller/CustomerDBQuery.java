/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this tcustlate file, choose Tools | Tcustlates
 * and open the tcustlate in the editor.
 */
package Controller;


import Model.Customer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author alkassoumhaoua
 */
public class CustomerDBQuery {
    
   static ResultSet rst;
   
   
   /*-----------------------GetALLcustomer-----------------------*/
    
   //Method which creates and returns an array of customers taken from the database 
   public ArrayList<Customer> getCustomers() 
    {
        ArrayList<Customer>customers= new  ArrayList<Customer>();
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
                cust.setCustomerEmail(rst.getString("email"));
                cust.setCustomerUsername(rst.getString("username"));
                cust.setCustomerPassword(rst.getString("password"));
                customers.add(cust);
            }

        }
        catch (SQLException ex) 
        {
            System.out.println("pb recup customer "+ex.getMessage());
        }
      
        return customers;

    }
   
    
    //Method which adds a customer in the DataBase
    public void addCustomer(Customer cust)
    {
        try
        {
            int id = Dbutils.max("customer","customerId");
            
            String query="INSERT INTO customer"
                    +"(customerId,name,lastName,address,city,email,username,password)" 
                    +" VALUES "
                    +"("+id+",'"+cust.getCustomerName()+"','"+cust.getCustomerLastname()
                    +"','"+cust.getCustomerAddress()+"','"+cust.getCustomerCity()
                    +"','"+cust.getCustomerEmail()
                    +"','"+cust.getCustomerUsername()+"','"+cust.getCustomerPassword()+"')";
             
            int rows= Dbutils.executeUpdate(query) ;
        }
        catch(Exception e)
        {
            System.out.println("pb ajout customer "+e.getMessage());
        }
    }
    
    //Method which deletes a customer from the database
    public void deleteCustomer(Customer cust)
    {
        try
        {
             String query="DELETE  FROM customer WHERE customerId="+cust.getCustomerId();
             int rows= Dbutils.executeUpdate(query);
        }
        catch(Exception e)
        {
            System.out.println("pb suppression customer "+e.getMessage());
        }
    }
   
    //Method which updates customer data in the database
    public void updateCustomer(Customer cust)
    {
        try
        {
            String query="UPDATE customer SET name='"+cust.getCustomerName()
                    +"', lastname='"+cust.getCustomerLastname()
                    +"', address='"+cust.getCustomerAddress()
                    +"', city='"+cust.getCustomerCity()
                    +"', email="+cust.getCustomerEmail()
                    +"', username="+cust.getCustomerUsername()
                    +"', password="+cust.getCustomerPassword()
                    +" WHERE customerId = "+cust.getCustomerId();
           
            int rows= Dbutils.executeUpdate(query);
        }
        catch(Exception e)
        {
            System.out.println("pb update customer"+e.getMessage());
        }
    } 
}
