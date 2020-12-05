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
public class OrderDetails {
    
    
    private int orderdetailsId;
    private int orderId;
    private int productId;
    private int quantity;
    private double price;
    private double discount;
    
    
    /*-----------------------Setter-----------------------*/
    
    public void setOrderDetailsId(int id)
    {
        this.orderdetailsId=id;
    }
    public void setOrderId(int id)
    {
        this.orderId=id;
    }

    public void setProductId(int id)
    {
        this.productId=id;
    }

    public void setQuantity(int quantity)
    {
        this.quantity=quantity;
    }

    public void setDiscount(double discount)
    {
        this.discount=discount;
    }

    public void setPrice(double p)
    {
        this.price=p;
    }

 
    /*-----------------------Getter-----------------------*/

    public int getOrderDetailsId()
    {
       return orderdetailsId;
    }
    public int getOrderId()
    {
        return orderId;
    }

    public int getProductId()
    {
         return productId;
    }

    public int getQuantity()
    {
         return quantity;
    }

    public double getDiscount()
    {
         return discount;
    }

    public double getPrice()
    {
         return price;
    }
}
