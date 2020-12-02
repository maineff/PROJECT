/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


/**
 *
 * @author alkassoumhaoua
 */

public class Order {
    
    private int orderId;
    private Customer client;
    private ArrayList<Product> produit;
    private int quantity;
    private double discount;
    private double totalPrice;
    private String orderDate;		
   
    //Constructor
    public Order(){
        
    }
    
    public Order(int id,Customer person, ArrayList<Product> pdt,int qty, double reduc,double prix)
    {
        this.orderId=id;
        this.client=person;
        this.produit=pdt;
        this.quantity=qty;
        this.discount=reduc;
        this.totalPrice=prix;
        this.orderDate=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
    }
    
       /*-----------------------Setter-----------------------*/
    
    public void setOrderId(int orderId)
   {
       this.orderId=orderId;
   }
   public void setCustomerName(Customer client)
   {
       this.client=client;
   }
   
   public void setProduct(ArrayList produit)
   {
       this.produit=produit;
   }
   
   
   public void setQuantity(int quantity)
   {
       this.quantity=quantity;
   }
   
   public void setDiscount(double discount)
   {
       this.discount=discount;
   }

    public void setTotalPrice(double totalPrice)
   {
       this.totalPrice=totalPrice;
   }

     public void setOrderDate(String orderDate)
   {
       this.orderDate=orderDate;
   }
     
        /*-----------------------Getter-----------------------*/

    public int getOrderId()
   {
       return orderId;
   }
   public Customer getEmployeeName()
   {
       return client;
   }
   
   public ArrayList getProduct()
   {
       return produit;
   }
      
   public int getQuantity()
   {
       return quantity;
   }
   
   public double getDiscount()
   {
       return discount;
   }

    public double getTotalPrice()
   {
       return totalPrice;
   }

     public String getOrderDate()
   {
       return orderDate;
   }
}

