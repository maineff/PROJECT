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

/**
       Constructor
   */
public class EmployeeDBQuery
{
   static ResultSet rst;
  
   /*-----------------------GetALLemployee-----------------------*/
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
   
    
    public void addEmployee(Employee emp)
    {
        try
        {
             String query="INSERT INTO employee VALUES("+emp.getEmployeeId()+",'"+emp.getEmployeeName()+
                     "','"+emp.getEmployeeLastname()+"','"+emp.getEmployeeAddress()
                     +"',"+emp.getEmployeeUsername()+"',"+emp.getEmployeePassword()+")";
             rst = Dbutils.executeQuery(query);
        }
        catch(Exception e)
        {
            System.out.println("pb ajout employee"+e.getMessage());
        }
    }
    
    public void deleteEmployee(Employee emp)
    {
        try
        {
             String query="DELETE  FROM employee WHERE employeeId="+emp.getEmployeeId();
             rst = Dbutils.executeQuery(query);
        }
        catch(Exception e)
        {
            System.out.println("pb suppression employee"+e.getMessage());
        }
    }
   
    public void updateEmployee(Employee emp)
    {
        try
        {
           String query="UPDATE employee SET name='"+emp.getEmployeeName()
                    +"', lastname='"+emp.getEmployeeLastname()
                    +"', address='"+emp.getEmployeeAddress()
                    +"', username="+emp.getEmployeeUsername()
                    +"', password="+emp.getEmployeePassword()
                    +" WHERE employeeId = "+emp.getEmployeeId();
           
             rst = Dbutils.executeQuery(query);
        }
        catch(Exception e)
        {
            System.out.println("pb update employee"+e.getMessage());
        }
    } 
}
