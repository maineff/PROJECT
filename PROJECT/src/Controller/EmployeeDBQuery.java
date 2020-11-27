/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Employee;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author alkassoumhaoua
 */

/**
       Constructor
   */
public class EmployeeDBQuery implements DBQuery{
      
   static ResultSet rst;
  
   
   
   public EmployeeDBQuery()
   {
      
    
   }

    public ArrayList<Employee> getEmployees() 
    {
        ArrayList<Employee>employees= new  ArrayList<Employee>();
        String sqlStatement = "SELECT * FROM employee";
       
      
        try
        {
           rst = Dbutils.executeQuery(sqlStatement);
           Employee emp ;
           while(rst.next())
           {
                emp= new Employee();
                emp.setEmployeeId(rst.getInt("employeeId"));
                emp.setEmployeeName(rst.getString("name"));
                emp.setEmployeeLastname(rst.getString("lastname"));
                emp.setEmployeeAddress(rst.getString("address"));
                emp.setEmployeeUsername(rst.getString("username"));
                emp.setEmployeePassword(rst.getString("password"));
                employees.add(emp);
            }

        }
        catch (SQLException ex) 
        {
            System.out.println("pb recup employee"+ex.getMessage());
        }
      
        return employees;

   }
   public void add()
   {
//       try{
//            String query="INSERT INTO employee VALUES("+employeeId+",'"+name+"','"+lastname+"','"+address+"',"+telephoneNumber+")";
//            con=connecterDB();
//            st=con.createStatement();
//            st.executeUpdate(query);
//            System.out.println("produit ajoute");
//            
//        }catch(Exception e)
//        {
//            System.out.println(e.getMessage());
//        }
   }
   
   /*-----------------------Getter-----------------------*/
   
    


   
  
    public static void main(String[] args) 
    {
        new EmployeeDBQuery();
        new ProductDBQuery();
        new CustomerDBQuery();
      
    }
}
