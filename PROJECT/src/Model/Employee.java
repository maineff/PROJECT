/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.EmployeeDBQuery;
import java.util.ArrayList;

/**
 *
 * @author alkassoumhaoua
 */

public class Employee 
{
    
    private int employeeId;
    private String name;
    private String lastName;
    private String address;
    private String username;
    private String password;
    
    //cstct par defaut
     public Employee()
    {
        this.employeeId=0;
        this.name="";
    }
       
   public Employee(int id,String prenom,String nom,String living, String username,String password )
   {
        this.employeeId=id;
        this.name=prenom;
        this.lastName=nom;
        this.address=living;
        this.username=username;
        this.password=password;
    }
   

   /*-----------------------Setter-----------------------*/
    
    public void setEmployeeId(int employeeId)
   {
       this.employeeId=employeeId;
   }
   public void setEmployeeName(String name)
   {
       this.name=name;
   }
   
   public void setEmployeeLastname(String lastName)
   {
       this.lastName=lastName;
   }
   
   public void setEmployeeAddress(String address)
   {
       this.address=address;
   }
   
   public void setEmployeeUsername(String username)
   {
       this.username=username;
   }
   
   public void setEmployeePassword(String password)
   {
       this.password=password;
   }

    

   /*-----------------------Getter-----------------------*/
   public int getEmployeeId()
   {
       return employeeId;
   }
   
   public String getEmployeeName()
   {
       return name;
   }
   
   public String getEmployeeLastname()
   {
       return lastName;
   }
   
   public String getEmployeeAddress()
   {
       return address;
   }
   
   public String getEmployeeUsername()
   {
       return username;
   }
   
   public String getEmployeePassword()
   {
       return password;
   }
    
   //mettre le nom de la base de donnée dans une variable puis l'affficher
   public static void main(String[] args) 
    {
        ArrayList<String>nom = new  ArrayList<String>(); 
        EmployeeDBQuery dao = new EmployeeDBQuery();
        Employee nv= new Employee();
        nom=dao.getEmployeeName();
        for(int i=0;i<1;i++)
        nv.setEmployeeName(nom.get(i));
        
        System.out.println(nv.name);
      
    }
   
}
