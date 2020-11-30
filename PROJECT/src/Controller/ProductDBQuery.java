/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Model.Product;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author alkassoumhaoua
 */
public class ProductDBQuery {
  
   static ResultSet rst;
  
   
   /*-----------------------GetALLproduct-----------------------*/
    public ArrayList<Product> getProducts() 
    {
        ArrayList<Product>products= new  ArrayList<Product>();
        String sqlStatement = "SELECT * FROM product";
        
        try
        {
           rst = Dbutils.executeQuery(sqlStatement);
           Product prod;
           while(rst.next())
           {
                prod= new Product();
                prod.setProductId(rst.getInt("productId"));
                prod.setProductName(rst.getString("name"));
                prod.setProductPrice(rst.getDouble("price"));
                prod.setProductStock(rst.getInt("stock"));
                products.add(prod);
            }

        }
        catch (SQLException ex) 
        {
            System.out.println("pb recup produit"+ex.getMessage());
        }
      
        return products;

    }
    
    public void addProduct(Product prod)
    {
        try
        {
            int id = Dbutils.max("product","productId");
             String query="INSERT INTO product"
                     +"(productId,name,price,stock)"
                     +"VALUES"
                     +"("+id+",'"+prod.getProductName()
                     +"','"+prod.getProductPrice()+"','"+prod.getProductStock()+"')";
             
             int rows= Dbutils.executeUpdate(query) ;
        }
        catch(Exception e)
        {
            System.out.println("pb ajout produit"+e.getMessage());
        }
    }
    
    
   public void deleteProduct(Product prod)
    {
        try
        {
             String query="DELETE  FROM product WHERE productId="+prod.getProductId();
            int rows= Dbutils.executeUpdate(query) ;
        }
        catch(Exception e)
        {
            System.out.println("pb suppression product"+e.getMessage());
        }
    }
   
    public void updateProduct(Product prod)
    {
        try
        {
           String query="UPDATE product SET name='"+prod.getProductName()
                    +"', price='"+prod.getProductPrice()
                    +"', stock="+prod.getProductStock()
                    +" WHERE productId = "+prod.getProductId();
           
             int rows= Dbutils.executeUpdate(query) ;
        }
        catch(Exception e)
        {
            System.out.println("pb update product"+e.getMessage());
        }
    } 
}
