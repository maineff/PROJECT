/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

//import java.sql.Date;
import java.sql.Timestamp;
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


}

