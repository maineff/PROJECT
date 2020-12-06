/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Dbutils;
import Controller.OrderDBQuery;
import Controller.ProductDBQuery;
import Model.Employee;
import Model.Order;
import Model.Product;
import Model.Statistical;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


/**
 *
 * @author maine
 */
public class EmployeePage extends javax.swing.JFrame {

    private final ProductDBQuery productdb=new ProductDBQuery();
    private  ArrayList<Product> produit = new  ArrayList<Product>(); 
    private ArrayList<JLabel> productNameLabels=new ArrayList<>();
    private ArrayList<JLabel> productPriceLabels=new ArrayList<>();
    private ArrayList<JLabel> productQuantityLabels=new ArrayList<>();
    private ArrayList<JLabel> productDiscountLabels=new ArrayList<>();
    private ArrayList<JLabel> productLotLabels=new ArrayList<>();
    
    private final OrderDBQuery orderdb=new OrderDBQuery();
    private  ArrayList<Order> commande = new  ArrayList<Order>();
    private ArrayList<JLabel> orderIdLabel1=new ArrayList<>();
    private ArrayList<JLabel> orderPriceLabel=new ArrayList<>();
    private ArrayList<JLabel> orderQuantityLabel=new ArrayList<>();
    private ArrayList<JLabel> orderDiscountLabel=new ArrayList<>();
    private ArrayList<JLabel> orderDateLabel=new ArrayList<>(); 
    private ArrayList<JLabel> orderUserLabel=new ArrayList<>();
    private ArrayList<JButton> selectorder= new ArrayList<>();
    Details detailPage;    
    String employeeAction="";
    Employee currentEmployee;
    JTable detailsTable;

 
    
    public EmployeePage(Employee emp) {
       
        try{
        initComponents();
        detailPage=new Details(this);
        currentEmployee=emp;
        welcome_employeeLabel.setText("Welcome "+currentEmployee.getEmployeeName());
        jPanel1.add(jPanel2);
        jPanel1.add(jScrollPane);
        
        jLabel1.setVisible(false);
        jLabel2.setVisible(false);
        jLabel3.setVisible(false);
        jLabel4.setVisible(false);
        jLabel5.setVisible(false);
        productTextfield.setVisible(false);
        priceTextfield.setVisible(false);
        quantityTextfield.setVisible(false);
        discountTextfield.setVisible(false);
        lotTextfield.setVisible(false);
        okButtonLabel.setVisible(false);
        jPanel1.add(jScrollPane);
        jPanel1.add(jPanel2);

        
        //We establish the connexion
        
        Connection conn= Dbutils.getDbConnection();
        
        produit=productdb.getProducts();
        commande=orderdb.getOrder();
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.HALF_UP);
        //Display of the products
        int j=20;
        for(int i=0;i<produit.size();i++)
        {
           
            productNameLabels.add(new JLabel(produit.get(i).getProductName()));
            productPriceLabels.add(new JLabel(df.format(produit.get(i).getProductPrice())+"$"));
            productQuantityLabels.add(new JLabel(Integer.toString(produit.get(i).getProductStock())));
            productDiscountLabels.add(new JLabel(Integer.toString(produit.get(i).getProductDiscount())));
            productLotLabels.add(new JLabel(Integer.toString(produit.get(i).getProductQuantityDiscount())));

            jPanel3.add(productNameLabels.get(i));
            jPanel3.add(productPriceLabels.get(i));
            jPanel3.add(productQuantityLabels.get(i));
            jPanel3.add(productDiscountLabels.get(i));
            jPanel3.add(productLotLabels.get(i));

            productNameLabels.get(i).setBounds(50, j, 200, 20);
            productPriceLabels.get(i).setBounds(260, j, 200, 20);
            productQuantityLabels.get(i).setBounds(400, j, 200, 20);
            productDiscountLabels.get(i).setBounds(590, j, 200, 20);
            productLotLabels.get(i).setBounds(760, j, 200, 20);


            productNameLabels.get(i).setVisible(true);
            productPriceLabels.get(i).setVisible(true);
            productQuantityLabels.get(i).setVisible(true);
            productDiscountLabels.get(i).setVisible(true);
            productLotLabels.get(i).setVisible(true);
            j+=30;
        }
        
        
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        int k=20;
        for(int i=0;i<commande.size();i++)
        {
           final int number=i;
           orderIdLabel1.add(new JLabel(Integer.toString(commande.get(i).getOrderId())));
           orderQuantityLabel.add(new JLabel(Integer.toString(commande.get(i).getQuantity())));
           orderDiscountLabel.add(new JLabel(Integer.toString(commande.get(i).getDiscount())));
           orderPriceLabel.add(new JLabel(Double.toString(commande.get(i).getTotalPrice())));
           orderDateLabel.add(new JLabel(commande.get(i).getOrderDate()));           
           orderUserLabel.add(new JLabel(commande.get(i).getUsername()));
           selectorder.add(new JButton());
           
           jPanel5.add(orderIdLabel1.get(i));
           jPanel5.add(orderQuantityLabel.get(i));
           jPanel5.add(orderDiscountLabel.get(i));
           jPanel5.add(orderPriceLabel.get(i));
           jPanel5.add(orderDateLabel.get(i));
           jPanel5.add(orderUserLabel.get(i));
           jPanel5.add(selectorder.get(i));
           
           selectorder.get(i).setBounds(50, k, 20, 20);
           orderIdLabel1.get(i).setBounds(100, k, 200, 20);
           orderDiscountLabel.get(i).setBounds(210, k, 200, 20);
           orderQuantityLabel.get(i).setBounds(350, k, 200, 20);
           orderPriceLabel.get(i).setBounds(480, k, 200, 20);
           orderDateLabel.get(i).setBounds(600, k, 200, 20);
           orderUserLabel.get(i).setBounds(730, k, 200, 20);
           selectorder.get(i).setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/loopIcon.png")));
           
           selectorder.get(i).setVisible(true);
           orderIdLabel1.get(i).setVisible(true);
           orderQuantityLabel.get(i).setVisible(true);
           orderDiscountLabel.get(i).setVisible(true);
           orderPriceLabel.get(i).setVisible(true);
           orderDateLabel.get(i).setVisible(true);
           orderUserLabel.get(i).setVisible(true);
           selectorder.get(i).addActionListener(new ActionListener() {

               @Override
               public void actionPerformed(ActionEvent ae)
               {
                   dispose();
                   detailPage.setVisible(true);
                   detailPage.setOrderId(commande.get(number).getOrderId());
               }
           });

           k+=30;
        } 
        
        //On affiche les stat en fonction du prix par défault
        JFreeChart chart=Statistical.getStatistical(1);
        ChartPanel chartPanel=new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(400, 300));
        jPanelStat.removeAll();
        jPanelStat.add(chartPanel);
        jPanelStat.validate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        PRODUCTSPANEL = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        productsLabel = new javax.swing.JLabel();
        pricesLabel = new javax.swing.JLabel();
        quantitiesLabel = new javax.swing.JLabel();
        discountsLabel = new javax.swing.JLabel();
        lotsLabel = new javax.swing.JLabel();
        jScrollPane = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        productTextfield = new javax.swing.JTextField();
        priceTextfield = new javax.swing.JTextField();
        quantityTextfield = new javax.swing.JTextField();
        lotTextfield = new javax.swing.JTextField();
        discountTextfield = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pbnameLabel = new javax.swing.JLabel();
        invalaibleLabel = new javax.swing.JLabel();
        updateButtonLabel = new javax.swing.JLabel();
        addButtonLabel = new javax.swing.JLabel();
        deleteButtonLabel = new javax.swing.JLabel();
        okButtonLabel = new javax.swing.JLabel();
        ORDERPANEL = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();
        orderIdLabel = new javax.swing.JLabel();
        discountLabel = new javax.swing.JLabel();
        quantityLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        ownerLabel = new javax.swing.JLabel();
        totalpriceLabel1 = new javax.swing.JLabel();
        STATPANEL = new javax.swing.JPanel();
        statPriceButton = new javax.swing.JButton();
        statQuantityButton = new javax.swing.JButton();
        jPanelStat = new javax.swing.JPanel();
        welcome_employeeLabel = new javax.swing.JLabel();
        exitLabel2 = new javax.swing.JLabel();
        homeLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel6.setBackground(new java.awt.Color(216, 237, 237));

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        productsLabel.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        productsLabel.setForeground(new java.awt.Color(255, 255, 255));
        productsLabel.setText("Products");

        pricesLabel.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        pricesLabel.setForeground(new java.awt.Color(255, 255, 255));
        pricesLabel.setText("Prices");

        quantitiesLabel.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        quantitiesLabel.setForeground(new java.awt.Color(255, 255, 255));
        quantitiesLabel.setText("Number of products");

        discountsLabel.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        discountsLabel.setForeground(new java.awt.Color(255, 255, 255));
        discountsLabel.setText("Discounts");

        lotsLabel.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lotsLabel.setForeground(new java.awt.Color(255, 255, 255));
        lotsLabel.setText("Lots");

        jScrollPane.setBorder(null);
        jScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 875, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 503, Short.MAX_VALUE)
        );

        jScrollPane.setViewportView(jPanel3);

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        productTextfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                productTextfieldKeyPressed(evt);
            }
        });

        priceTextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceTextfieldActionPerformed(evt);
            }
        });
        priceTextfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                priceTextfieldKeyPressed(evt);
            }
        });

        quantityTextfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                quantityTextfieldKeyPressed(evt);
            }
        });

        lotTextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lotTextfieldActionPerformed(evt);
            }
        });
        lotTextfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lotTextfieldKeyPressed(evt);
            }
        });

        discountTextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discountTextfieldActionPerformed(evt);
            }
        });
        discountTextfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                discountTextfieldKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Name ");

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Price");

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Quantity ");

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Discount ");

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Lots");

        updateButtonLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/updateIcon.png"))); // NOI18N
        updateButtonLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateButtonLabelMouseClicked(evt);
            }
        });

        addButtonLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/addIcon.png"))); // NOI18N
        addButtonLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addButtonLabelMouseClicked(evt);
            }
        });

        deleteButtonLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/deleteIcon2.png"))); // NOI18N
        deleteButtonLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteButtonLabelMouseClicked(evt);
            }
        });

        okButtonLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/okkIcon.png"))); // NOI18N
        okButtonLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                okButtonLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .addComponent(pbnameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(241, 241, 241)
                .addComponent(invalaibleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(166, 166, 166))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(productTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(priceTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(updateButtonLabel)
                        .addGap(90, 90, 90)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(12, 12, 12)
                        .addComponent(quantityTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(addButtonLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(discountTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lotTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(deleteButtonLabel)
                        .addGap(34, 34, 34)))
                .addGap(25, 25, 25)
                .addComponent(okButtonLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(updateButtonLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(deleteButtonLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 6, Short.MAX_VALUE)
                                .addComponent(addButtonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(productTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(priceTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(quantityTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(lotTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(discountTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(okButtonLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(invalaibleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pbnameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(productsLabel)
                .addGap(123, 123, 123)
                .addComponent(pricesLabel)
                .addGap(45, 45, 45)
                .addComponent(quantitiesLabel)
                .addGap(61, 61, 61)
                .addComponent(discountsLabel)
                .addGap(102, 102, 102)
                .addComponent(lotsLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productsLabel)
                    .addComponent(pricesLabel)
                    .addComponent(quantitiesLabel)
                    .addComponent(discountsLabel)
                    .addComponent(lotsLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PRODUCTSPANELLayout = new javax.swing.GroupLayout(PRODUCTSPANEL);
        PRODUCTSPANEL.setLayout(PRODUCTSPANELLayout);
        PRODUCTSPANELLayout.setHorizontalGroup(
            PRODUCTSPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PRODUCTSPANELLayout.setVerticalGroup(
            PRODUCTSPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jTabbedPane1.addTab("PRODUCTS", PRODUCTSPANEL);

        jPanel4.setBackground(new java.awt.Color(0, 153, 153));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 873, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 627, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel5);

        orderIdLabel.setBackground(new java.awt.Color(255, 255, 255));
        orderIdLabel.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        orderIdLabel.setForeground(new java.awt.Color(255, 255, 255));
        orderIdLabel.setText("OrderId");

        discountLabel.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        discountLabel.setForeground(new java.awt.Color(255, 255, 255));
        discountLabel.setText("Discount");

        quantityLabel.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        quantityLabel.setForeground(new java.awt.Color(255, 255, 255));
        quantityLabel.setText("Quantity");

        dateLabel.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        dateLabel.setForeground(new java.awt.Color(255, 255, 255));
        dateLabel.setText("Date");

        ownerLabel.setBackground(new java.awt.Color(255, 255, 255));
        ownerLabel.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        ownerLabel.setForeground(new java.awt.Color(255, 255, 255));
        ownerLabel.setText("Owner");

        totalpriceLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        totalpriceLabel1.setForeground(new java.awt.Color(255, 255, 255));
        totalpriceLabel1.setText("Total price");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 901, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(orderIdLabel)
                .addGap(56, 56, 56)
                .addComponent(discountLabel)
                .addGap(62, 62, 62)
                .addComponent(quantityLabel)
                .addGap(63, 63, 63)
                .addComponent(totalpriceLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dateLabel)
                .addGap(60, 60, 60)
                .addComponent(ownerLabel)
                .addGap(82, 82, 82))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(orderIdLabel)
                    .addComponent(discountLabel)
                    .addComponent(quantityLabel)
                    .addComponent(dateLabel)
                    .addComponent(ownerLabel)
                    .addComponent(totalpriceLabel1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout ORDERPANELLayout = new javax.swing.GroupLayout(ORDERPANEL);
        ORDERPANEL.setLayout(ORDERPANELLayout);
        ORDERPANELLayout.setHorizontalGroup(
            ORDERPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ORDERPANELLayout.setVerticalGroup(
            ORDERPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("ORDER", ORDERPANEL);

        STATPANEL.setBackground(new java.awt.Color(0, 153, 153));

        statPriceButton.setText("Statistics according to price");
        statPriceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statPriceButtonActionPerformed(evt);
            }
        });

        statQuantityButton.setText("Statistics according to quantity");
        statQuantityButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statQuantityButtonActionPerformed(evt);
            }
        });

        jPanelStat.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout STATPANELLayout = new javax.swing.GroupLayout(STATPANEL);
        STATPANEL.setLayout(STATPANELLayout);
        STATPANELLayout.setHorizontalGroup(
            STATPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, STATPANELLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(statPriceButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 282, Short.MAX_VALUE)
                .addComponent(statQuantityButton)
                .addGap(66, 66, 66))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, STATPANELLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelStat, javax.swing.GroupLayout.PREFERRED_SIZE, 845, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        STATPANELLayout.setVerticalGroup(
            STATPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(STATPANELLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(STATPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statPriceButton)
                    .addComponent(statQuantityButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 385, Short.MAX_VALUE)
                .addComponent(jPanelStat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        jTabbedPane1.addTab("STAT", STATPANEL);

        welcome_employeeLabel.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        welcome_employeeLabel.setForeground(new java.awt.Color(0, 102, 102));

        exitLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/exiticon.png"))); // NOI18N
        exitLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitLabel2MouseClicked(evt);
            }
        });

        homeLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/homeIcon.png"))); // NOI18N
        homeLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 307, Short.MAX_VALUE)
                .addComponent(welcome_employeeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(212, 212, 212)
                .addComponent(exitLabel2)
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(homeLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 906, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(welcome_employeeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exitLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 497, Short.MAX_VALUE)
                .addComponent(homeLabel1)
                .addContainerGap())
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                    .addContainerGap(82, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(67, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 906, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 638, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void priceTextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceTextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceTextfieldActionPerformed

    private void lotTextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lotTextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lotTextfieldActionPerformed

    private void productTextfieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_productTextfieldKeyPressed
        
         pbnameLabel.setText("");
        char car= evt.getKeyChar();
        if((car<'a' || car>'z' ) && (car<'A' || car>'Z' )
            && (car!=(char)KeyEvent.VK_BACK_SPACE)&& (car!=(char)KeyEvent.VK_SPACE))
        {
            pbnameLabel.setText("please enter a corect name");
            pbnameLabel.setForeground(Color.red);
        }  
        else 
            pbnameLabel.setText("");
    }//GEN-LAST:event_productTextfieldKeyPressed

    private void priceTextfieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_priceTextfieldKeyPressed
        enterANumber(evt, priceTextfield);
    }//GEN-LAST:event_priceTextfieldKeyPressed

    private void quantityTextfieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityTextfieldKeyPressed
        enterANumber(evt, quantityTextfield);
    }//GEN-LAST:event_quantityTextfieldKeyPressed

    private void discountTextfieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_discountTextfieldKeyPressed
        enterANumber(evt, discountTextfield);
    }//GEN-LAST:event_discountTextfieldKeyPressed

    private void lotTextfieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lotTextfieldKeyPressed
        enterANumber(evt, lotTextfield);
    }//GEN-LAST:event_lotTextfieldKeyPressed

    private void statPriceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statPriceButtonActionPerformed
        int i=1;
        JFreeChart chart=Statistical.getStatistical(i);
        ChartPanel chartPanel=new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(400, 270));
        jPanelStat.removeAll();
        jPanelStat.add(chartPanel);
        jPanelStat.validate();
        
    }//GEN-LAST:event_statPriceButtonActionPerformed

    private void statQuantityButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statQuantityButtonActionPerformed
        int i=2;
        JFreeChart chart=Statistical.getStatistical(i);
        ChartPanel chartPanel=new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(400, 270));
        jPanelStat.removeAll();
        jPanelStat.add(chartPanel);
        jPanelStat.validate();
    }//GEN-LAST:event_statQuantityButtonActionPerformed

    private void exitLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitLabel2MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitLabel2MouseClicked

    private void homeLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeLabel1MouseClicked
        // TODO add your handling code here:
        setVisible(false);
        new HomePage().setVisible(true);
    }//GEN-LAST:event_homeLabel1MouseClicked

    private void addButtonLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addButtonLabelMouseClicked
        jLabel1.setVisible(true);
        jLabel2.setVisible(true);
        jLabel3.setVisible(true);
        jLabel4.setVisible(true);
        jLabel5.setVisible(true);
        productTextfield.setVisible(true);
        priceTextfield.setVisible(true);
        quantityTextfield.setVisible(true);
        discountTextfield.setVisible(true);
        lotTextfield.setVisible(true);
        okButtonLabel.setVisible(true);
        
        employeeAction="add";
        
    }//GEN-LAST:event_addButtonLabelMouseClicked

    private void updateButtonLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateButtonLabelMouseClicked
        jLabel1.setVisible(true);
        jLabel2.setVisible(true);
        jLabel3.setVisible(true);
        jLabel4.setVisible(true);
        jLabel5.setVisible(true);
        productTextfield.setVisible(true);
        priceTextfield.setVisible(true);
        quantityTextfield.setVisible(true);
        discountTextfield.setVisible(true);
        lotTextfield.setVisible(true);
        okButtonLabel.setVisible(true);
        
        employeeAction="update";
        
    }//GEN-LAST:event_updateButtonLabelMouseClicked

    private void deleteButtonLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButtonLabelMouseClicked
         jLabel1.setVisible(true);
        jLabel2.setVisible(false);
        jLabel3.setVisible(false);
        jLabel4.setVisible(false);
        jLabel5.setVisible(false);
        
        productTextfield.setVisible(true);
        priceTextfield.setVisible(false);
        quantityTextfield.setVisible(false);
        discountTextfield.setVisible(false);
        lotTextfield.setVisible(false);
        
        
        okButtonLabel.setVisible(true);
        
        employeeAction="delete";
    }//GEN-LAST:event_deleteButtonLabelMouseClicked

    private void okButtonLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_okButtonLabelMouseClicked
        boolean ok=true;
        if(employeeAction=="add")
        {

        
        try {
            
                 String rq="SELECT COUNT(*) FROM product WHERE name = '"+productTextfield.getText()+"'";
                 ResultSet rst= Dbutils.executeQuery(rq);
                 rst.next();
                 int count=rst.getInt(1);
                 System.out.println(count);
                 
                 if(count==0)
                 {
                    Product prod=new Product();
        
                    prod.setProductName(productTextfield.getText());
                    prod.setProductPrice(Double.parseDouble(priceTextfield.getText()));
                    prod.setProductStock(Integer.parseInt(quantityTextfield.getText()));
                    prod.setProductDiscount(Integer.parseInt(discountTextfield.getText()));
                    prod.setProductQuantityDiscount(Integer.parseInt(lotTextfield.getText()));
        
                    productdb.addProduct(prod);

                 }
                 else
                 {
                     JOptionPane.showMessageDialog(null,"your product already exists");
                 }
             }
             catch (SQLException ex)
             {
                 System.out.println(ex.getMessage());
             }
        
        }
        else if(employeeAction=="update")
        {
             for(int i=0; i<produit.size();i++)
            {
                if(productTextfield.getText().equals(produit.get(i).getProductName()))
                {
                    //si le textfields est vide garde son ancienne valeur
                    if (priceTextfield.getText().isEmpty()||priceTextfield.getText().length()==0)  
                        produit.get(i).setProductPrice(produit.get(i).getProductPrice());
                    else
                         produit.get(i).setProductPrice(Double.parseDouble(priceTextfield.getText()));
                    
                    
                    if(quantityTextfield.getText().isEmpty()||quantityTextfield.getText().length()==0)
                        produit.get(i).setProductStock(produit.get(i).getProductStock());
                    else
                        produit.get(i).setProductStock(Integer.parseInt(quantityTextfield.getText()));
                    
                    
                    if(discountTextfield.getText().isEmpty()||discountTextfield.getText().length()==0)
                        produit.get(i).setProductDiscount(produit.get(i).getProductDiscount());
                    else
                        produit.get(i).setProductDiscount(Integer.parseInt(discountTextfield.getText()));
                    
                    
                    if(lotTextfield.getText().isEmpty()||lotTextfield.getText().length()==0)
                        produit.get(i).setProductQuantityDiscount(produit.get(i).getProductQuantityDiscount());
                    else
                        produit.get(i).setProductQuantityDiscount(Integer.parseInt(lotTextfield.getText()));
                    
                    
               productdb.updateProduct(produit.get(i));
               
               System.out.println("modif");
                }
            }
        }
        
        else if(employeeAction=="delete")
        {
            for(int i=0; i<produit.size();i++)
            {
                if(productTextfield.getText().equals(produit.get(i).getProductName()))
                 {
                    productdb.deleteProduct(produit.get(i));
                    System.out.println("supp");
                 }
            }

        }
        
        
        productTextfield.setText(null);
        priceTextfield.setText(null);
        quantityTextfield.setText(null);
        discountTextfield.setText(null);
        lotTextfield.setText(null);
        
        setVisible(false);
        new EmployeePage(currentEmployee).setVisible(true);
    }//GEN-LAST:event_okButtonLabelMouseClicked

    private void discountTextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discountTextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_discountTextfieldActionPerformed

    //blinder les textfields
    public void enterANumber(java.awt.event.KeyEvent evt, JTextField txtId)
    {
         invalaibleLabel.setText("");
         char car= evt.getKeyChar();
        if((car<'0' || car>'9' ) && txtId.getText().contains(".")
            && (car!=(char)KeyEvent.VK_BACK_SPACE))
        {
             invalaibleLabel.setText("");
        } else if
        ((car<'0' ||car>'9')&&(car!='.')
            &&(car!=(char)KeyEvent.VK_BACK_SPACE)){
           
             invalaibleLabel.setText("please enter a number");
             invalaibleLabel.setForeground(Color.red);
        }
    }
    /**
     * @param args the command line arguments
     */
   /* public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
    /*    try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EmployeePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
       /* java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeePage(currentEmployee).setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ORDERPANEL;
    private javax.swing.JPanel PRODUCTSPANEL;
    private javax.swing.JPanel STATPANEL;
    private javax.swing.JLabel addButtonLabel;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JLabel deleteButtonLabel;
    private javax.swing.JLabel discountLabel;
    private javax.swing.JTextField discountTextfield;
    private javax.swing.JLabel discountsLabel;
    private javax.swing.JLabel exitLabel2;
    private javax.swing.JLabel homeLabel1;
    private javax.swing.JLabel invalaibleLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanelStat;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField lotTextfield;
    private javax.swing.JLabel lotsLabel;
    private javax.swing.JLabel okButtonLabel;
    private javax.swing.JLabel orderIdLabel;
    private javax.swing.JLabel ownerLabel;
    private javax.swing.JLabel pbnameLabel;
    private javax.swing.JTextField priceTextfield;
    private javax.swing.JLabel pricesLabel;
    private javax.swing.JTextField productTextfield;
    private javax.swing.JLabel productsLabel;
    private javax.swing.JLabel quantitiesLabel;
    private javax.swing.JLabel quantityLabel;
    private javax.swing.JTextField quantityTextfield;
    private javax.swing.JButton statPriceButton;
    private javax.swing.JButton statQuantityButton;
    private javax.swing.JLabel totalpriceLabel1;
    private javax.swing.JLabel updateButtonLabel;
    private javax.swing.JLabel welcome_employeeLabel;
    // End of variables declaration//GEN-END:variables
}
