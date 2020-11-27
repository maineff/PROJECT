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
    private int stock;
     
    public Product()
     {
         
     }
    public Product(int id,String nom,int prix,int qty)
    {
        this.productId=id;
        this.name=nom;
        this.price=prix;
        this.stock=qty;
    }


    
    /*-----------------------Getter-----------------------*/
    
    public int getProductId()
    {
        return productId;
    }
    
    public String getProductName()
    {
        return name;
    }
       
    public double getProductPrice()
    {
        return price;
    }

    public int getProductStock()
    {
        return stock;
    }
    
    /*-----------------------Setter-----------------------*/
    
    public void setProductId(int ind)
    {
        productId=ind;
    }
    
    public void setProductName(String nom)
    {
         name=nom;
    }
       
    public void setProductPrice(double p)
    {
        price=p;
    }

    public void setProductStock(int stk)
    {
        stock=stk;
    }

}
