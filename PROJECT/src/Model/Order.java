/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

//import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

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
    //private  Timestamp orderDate;		
   
    public Order(int id,Customer person, ArrayList<Product> pdt,int qty, double reduc,double prix,String date)
    {
        this.orderId=id;
        this.client=person;
        this.produit=pdt;
        this.quantity=qty;
        this.discount=reduc;
        this.totalPrice=prix;
       // this.orderDate=date;
    }


}

