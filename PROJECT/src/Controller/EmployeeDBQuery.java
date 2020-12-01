/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Employee;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author alkassoumhaoua
*/
public class EmployeeDBQuery
{
   static ResultSet rst;
  
   /*-----------------------GetALLemployee-----------------------*/
   
   //Method which creates and returns an array of employees taken from the database
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
   
    
    //Method which adds an employee in the DataBase
    public void addEmployee(Employee emp)
    {
        try
        {
             int id = Dbutils.max("employee","employeeId");
           
             String query="INSERT INTO employee"
                     +"(employeeId,name,lastName,username,password)"
                     +" VALUES "
                     +"("+id+",'"+emp.getEmployeeName()+"','"+emp.getEmployeeLastname()
                     +"','"+emp.getEmployeeUsername()+"','"+emp.getEmployeePassword()+"')";
             
             int rows= Dbutils.executeUpdate(query) ;
        }
        catch(Exception e)
        {
            System.out.println("pb ajout employee"+e.getMessage());
        }
    }
    
    //Method which deletes an employee from the DataBase
    public void deleteEmployee(Employee emp)
    {
        try
        {
             String query="DELETE  FROM employee WHERE employeeId="+emp.getEmployeeId();
             int rows= Dbutils.executeUpdate(query) ;
        }
        catch(Exception e)
        {
            System.out.println("pb suppression employee"+e.getMessage());
        }
    }
   
    //Method which updates employee data in the database
    public void updateEmployee(Employee emp)
    {
        try
        {
           String query="UPDATE employee SET name='"+emp.getEmployeeName()
                    +"', lastname='"+emp.getEmployeeLastname()
                    +"', username="+emp.getEmployeeUsername()
                    +"', password="+emp.getEmployeePassword()
                    +" WHERE employeeId = "+emp.getEmployeeId();
           
            int rows= Dbutils.executeUpdate(query) ;
        }
        catch(Exception e)
        {
            System.out.println("pb update employee"+e.getMessage());
        }
    } 
}
