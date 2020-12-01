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
public class Store 
{
    private  ArrayList<Product> produit = new  ArrayList<Product>(); 
    private  ArrayList<Employee>employee= new  ArrayList<Employee>(); 
    private  ArrayList<Customer>customer= new  ArrayList<Customer>(); 
        
    
    public Store() 
    {
        this.produit=null;
        this.employee=null;
        this.customer=null;
        
    }
    
    
    
    
}
