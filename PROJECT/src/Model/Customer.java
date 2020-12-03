/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author alkassoumhaoua
 */

public class Customer {
    
    private int customerId;
    private String name;
    private String lastName;
    private String address;
    private String city;
    private ArrayList<Order> commandes = new ArrayList<Order>();
    private String username;
    private String password;
    
    // Constructors
    public Customer()
    {
          
    }
    
     public Customer(int id,String prenom,String nom,String living,int num,ArrayList<Order> cmd,
            String ville,String username,String password)
    {
        this.customerId=id;
        this.name=prenom;
        this.lastName=nom;
        this.address=living;
        this.commandes=cmd;
        this.city=ville;
        this.username=username;
        this.password=password;
    }
    
    /*-----------------------Getter-----------------------*/
    
   public int getCustomerId()
   {
       return customerId;
   }
   
   public ArrayList<Order>  getCommandes()
   {
       return commandes;
   }
   
   public String getCustomerName()
   {
       return name;
   }
   
    public String getCustomerCity()
   {
       return city;
   }
   
   public String getCustomerLastname()
   {
       return lastName;
   }
   
   public String getCustomerAddress()
   {
       return address;
   }
   
   public String getCustomerUsername()
   {
       return username;
   }
   
   public String getCustomerPassword()
   {
       return password;
   } 

   
   /*-----------------------Setter-----------------------*/
   
   public void setCustomerId(int customerId)
   {
       this.customerId=customerId;
   }
   
   public void setCustomerName(String name)
   {
       this.name=name;
   }
   
   public void setCustomerLastname(String lastName)
   {
       this.lastName=lastName;
   }
   
   public void setCustomerAddress(String address)
   {
       this.address=address;
   }
   
   public void setCustomerCity(String ville)
   {
       this.city=ville;
   }
   
   
   public void setCustomerUsername(String username)
   {
       this.username=username;
   }
   
   public void setCustomerPassword(String password)
   {
       this.password=password;
   }
   
}
