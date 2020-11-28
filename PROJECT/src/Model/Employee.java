/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author alkassoumhaoua
 */

public class Employee 
{
    
    private int employeeId;
    private String name;
    private String lastName;
    private String username;
    private String password;
    
    ///////////////pas besoin je crois
 /*
    //cstct par defaut
     public Employee()
    {
        this.employeeId=0;
        this.name="";
    }
       
   public Employee(int id,String prenom,String nom,String username,String password )
   {
        this.employeeId=id;
        this.name=prenom;
        this.lastName=nom;
        this.username=username;
        this.password=password;
    }
   */

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
   
   
   public String getEmployeeUsername()
   {
       return username;
   }
   
   public String getEmployeePassword()
   {
       return password;
   }
  
   
}
