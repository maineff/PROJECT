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

public class Product {
    
    private int productId;
    private String name;
    private double price;
    private int quantity;
    
    public Product(int id,String nom,int prix,int qty)
    {
        this.productId=id;
        this.name=nom;
        this.price=prix;
        this.quantity=qty;
    }



}
