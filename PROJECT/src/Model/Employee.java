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

public class Employee {
    
    private int employeeId;
    private String name;
    private String lastName;
    private String address;
    private int telephoneNumber;
  
    
   public Employee(int id,String prenom,String nom,String living,int num)
   {
        this.employeeId=id;
        this.name=prenom;
        this.lastName=nom;
        this.address=living;
        this.telephoneNumber=num;
        
    }


}
