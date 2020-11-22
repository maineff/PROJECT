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
    private int telephoneNumber;
    private ArrayList<Order> commande;
    
    public Customer(int id,String prenom,String nom,String living,int num,ArrayList<Order> cmd)
   {
        this.customerId=id;
        this.name=prenom;
        this.lastName=nom;
        this.address=living;
        this.telephoneNumber=num;
        this.commande=cmd;
    }

}
