/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.Dbutils;
import Controller.OrderDetailsDBQuery;
import Controller.ProductDBQuery;
import java.awt.Color;
import java.awt.GradientPaint;
import java.sql.Connection;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author gsans
 */
public class Statistical {
    
    private final OrderDetailsDBQuery orderDetailsdb=new OrderDetailsDBQuery();
    private  ArrayList<OrderDetails> purchasedProduct = new  ArrayList<OrderDetails>(); 
    private final ProductDBQuery productdb=new ProductDBQuery();
    private  ArrayList<Product> produit = new  ArrayList<Product>(); 
    private ArrayList<String> nomProduit = new ArrayList<String>();
    private double[][] valeursStat;
    static JFreeChart chart;
    
    public Statistical (int i) {
        
        //We establish the connexion
        try{
            Connection conn= Dbutils.getDbConnection();
            purchasedProduct=orderDetailsdb.getAllOrderDetails();
            produit=productdb.getProducts();
            valeursStat=new double[produit.size()][2];
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        CategoryDataset dataset = createDataset(i);
        if (i==1){
            chart = createChartP(dataset);
        }
        else if (i==2){
            chart = createChartQ(dataset);
        }
        else{
            chart = createChartP(dataset);
        }
        
    }
    
    private CategoryDataset createDataset(int statut) {
        
        // Row keys...
        String series1 = "With discount";
        String series2 = "Without discount";
      

        //Initialization of Column keys...
        for (int i=0;i<produit.size();i++){
           
            double prix=0; 
            double quantity=0;
            
            for(int j=0;j<purchasedProduct.size();j++){
                if(purchasedProduct.get(j).getProductId()==produit.get(i).getProductId()){
                    prix=prix+purchasedProduct.get(j).getPrice();
                    quantity=quantity+purchasedProduct.get(j).getQuantity();
                }
                
                valeursStat[i][0]=prix;
                valeursStat[i][1]=quantity;
            }
            nomProduit.add(produit.get(i).getProductName());      
        }

        // create the dataset...
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        if (statut==1){
            for(int i=0;i<produit.size();i++){
                if (produit.get(i).getProductDiscount()==0){
                    dataset.addValue(valeursStat[i][0],series2 , nomProduit.get(i));
                }
                else{
                    dataset.addValue(valeursStat[i][0],series1 , nomProduit.get(i));
                }
            }
        }
        if (statut==2){
            for(int i=0;i<produit.size();i++){
                if (produit.get(i).getProductDiscount()==0){
                    dataset.addValue(valeursStat[i][1],series2 , nomProduit.get(i));
                }
                else{
                    dataset.addValue(valeursStat[i][1],series1 , nomProduit.get(i));
                }
            }
        }
        
        
        return dataset;
    }

    
    private JFreeChart createChartP(CategoryDataset dataset) {
        
        //Create the chart...
            JFreeChart chart = ChartFactory.createBarChart(
            "Statistical by price",         // chart title
            "Products",               // domain axis label
            "Money earned ($)",                  // range axis label
            dataset,                  // data
            PlotOrientation.VERTICAL, // orientation
            true,                     // include legend
            true,                     // tooltips?
            false                     // URLs?
        );          

        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...

        //Set the background color for the chart...
        chart.setBackgroundPaint(Color.white);

        //Get a reference to the plot for further customisation...
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setDomainGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.white);

        //Set the range axis to display integers only...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        //Disable bar outlines...
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setDrawBarOutline(false);
        
        //Set up gradient paints for series...
        GradientPaint gp0 = new GradientPaint(
            0.0f, 0.0f, Color.blue, 
            0.0f, 0.0f, new Color(0, 0, 64)
        );
        GradientPaint gp1 = new GradientPaint(
            0.0f, 0.0f, Color.green, 
            0.0f, 0.0f, new Color(0, 64, 0)
        );
        
        renderer.setSeriesPaint(0, gp0);
        renderer.setSeriesPaint(1, gp1);

        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(
            CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0)
        );
        // OPTIONAL CUSTOMISATION COMPLETED.
        
        return chart;
        
    }
    
    private JFreeChart createChartQ(CategoryDataset dataset) {
        
        //Create the chart...
            JFreeChart chart = ChartFactory.createBarChart(
            "Statistical by quantity",         // chart title
            "Products",               // domain axis label
            "Quantity sold",                  // range axis label
            dataset,                  // data
            PlotOrientation.VERTICAL, // orientation
            true,                     // include legend
            true,                     // tooltips?
            false                     // URLs?
        );          

        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...

        //Set the background color for the chart...
        chart.setBackgroundPaint(Color.white);

        //Get a reference to the plot for further customisation...
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setDomainGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.white);

        //Set the range axis to display integers only...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        //Disable bar outlines...
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setDrawBarOutline(false);
        
        //Set up gradient paints for series...
        GradientPaint gp0 = new GradientPaint(
            0.0f, 0.0f, Color.blue, 
            0.0f, 0.0f, new Color(0, 0, 64)
        );
        GradientPaint gp1 = new GradientPaint(
            0.0f, 0.0f, Color.green, 
            0.0f, 0.0f, new Color(0, 64, 0)
        );
        
        renderer.setSeriesPaint(0, gp0);
        renderer.setSeriesPaint(1, gp1);

        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(
            CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0)
        );
        // OPTIONAL CUSTOMISATION COMPLETED.
        
        return chart;
        
    }
    
    
    public static JFreeChart getStatistical(int i) {

        Statistical stat = new Statistical(i);
        return chart;
    }
    
}
