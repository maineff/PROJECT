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
    private double discount;
    private int quantitydiscount;
     
    //Constructors
    public Product()
    {
         
    }
    
   public Product(int id,String nom,double prix,int qty, double disc, int qtydisc)
    {
        this.productId=id;
        this.name=nom;
        this.price=prix;
        this.stock=qty;
        this.discount=disc;
        this.quantitydiscount=qtydisc;
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
    public double getProductDiscount()
    {
        return discount;
    }
    public int getProductQuantityDiscount()
    {
        return quantitydiscount;
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
     public void setProductDiscount(double disc)
    {
        discount=disc;
    }

    public void setProductQuantityDiscount(int qtydisc)
    {
        quantitydiscount=qtydisc;
    }
    
    
    
}
