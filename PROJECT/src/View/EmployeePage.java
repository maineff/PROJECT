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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;

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
    Details detailpage=new Details(this);    
    String employeeAction="";
    Employee currentEmployee;

    
    public EmployeePage(Employee emp) {
       
        try{
        initComponents();
        
        currentEmployee=emp;
        welcome_employeeLabel.setText("WELCOME "+currentEmployee.getEmployeeName());
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
        okButton.setVisible(false);

        
        //We establish the connexion
        
        Connection conn= Dbutils.getDbConnection();
        
        produit=productdb.getProducts();
        commande=orderdb.getOrder();
        
        //Display of the products
            int j=20;
            for(int i=0;i<produit.size();i++)
            {
                
                productNameLabels.add(new JLabel(produit.get(i).getProductName()));
                productPriceLabels.add(new JLabel(Double.toString(produit.get(i).getProductPrice())+"$"));
                productQuantityLabels.add(new JLabel(Integer.toString(produit.get(i).getProductStock())+"    /100"));
                productDiscountLabels.add(new JLabel(Integer.toString(produit.get(i).getProductDiscount())));
                productLotLabels.add(new JLabel(Integer.toString(produit.get(i).getProductQuantityDiscount())));
                
                jPanel3.add(productNameLabels.get(i));
                jPanel3.add(productPriceLabels.get(i));
                jPanel3.add(productQuantityLabels.get(i));
                jPanel3.add(productDiscountLabels.get(i));
                jPanel3.add(productLotLabels.get(i));
                
                productNameLabels.get(i).setBounds(50, j, 200, 20);
                productPriceLabels.get(i).setBounds(260, j, 200, 20);
                productQuantityLabels.get(i).setBounds(380, j, 200, 20);
                productDiscountLabels.get(i).setBounds(580, j, 200, 20);
                productLotLabels.get(i).setBounds(750, j, 200, 20);
                
                
                productNameLabels.get(i).setVisible(true);
                productPriceLabels.get(i).setVisible(true);
                productQuantityLabels.get(i).setVisible(true);
                productDiscountLabels.get(i).setVisible(true);
                productLotLabels.get(i).setVisible(true);
                
               
                
                j+=30;
            }
        
        
        }catch(Exception ex){
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
           
           selectorder.get(i).setVisible(true);
           orderIdLabel1.get(i).setVisible(true);
           orderQuantityLabel.get(i).setVisible(true);
           orderDiscountLabel.get(i).setVisible(true);
           orderPriceLabel.get(i).setVisible(true);
           orderDateLabel.get(i).setVisible(true);
           orderUserLabel.get(i).setVisible(true);
           
           selectorder.get(i).addActionListener(new ActionListener() {

               @Override
               public void actionPerformed(ActionEvent ae) {
                   dispose();
                   detailpage.setVisible(true);
               }
           });

           
           
          
           
           
            k+=30;
        }
        
        
       
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        productTextfield = new javax.swing.JTextField();
        priceTextfield = new javax.swing.JTextField();
        quantityTextfield = new javax.swing.JTextField();
        lotTextfield = new javax.swing.JTextField();
        discountTextfield = new javax.swing.JTextField();
        updateButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pbnameLabel = new javax.swing.JLabel();
        ORDERPANEL = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        orderIdLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();
        discountLabel = new javax.swing.JLabel();
        quantityLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        ownerLabel = new javax.swing.JLabel();
        totalpriceLabel1 = new javax.swing.JLabel();
        STATPANEL = new javax.swing.JPanel();
        skipButton = new javax.swing.JButton();
        menuButton = new javax.swing.JButton();
        welcome_employeeLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        productsLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        productsLabel.setText("Products");

        pricesLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        pricesLabel.setText("Prices");

        quantitiesLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        quantitiesLabel.setText("Quantities");

        discountsLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        discountsLabel.setText("Discounts");

        lotsLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lotsLabel.setText("Lots");

        jScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 848, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 503, Short.MAX_VALUE)
        );

        jScrollPane.setViewportView(jPanel3);

        addButton.setText("add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        priceTextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceTextfieldActionPerformed(evt);
            }
        });

        lotTextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lotTextfieldActionPerformed(evt);
            }
        });

        updateButton.setText("update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        okButton.setText("ok");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Name :");

        jLabel2.setText("Price :");

        jLabel3.setText("Quantity :");

        jLabel4.setText("Disocunt :");

        jLabel5.setText("Lots :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(39, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(productTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(addButton)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(priceTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(quantityTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addGap(5, 5, 5)
                        .addComponent(discountTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lotTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(okButton)
                        .addGap(0, 25, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(updateButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 182, Short.MAX_VALUE)
                        .addComponent(deleteButton)
                        .addGap(162, 162, 162))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pbnameLabel)
                .addContainerGap(603, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateButton)
                    .addComponent(deleteButton)
                    .addComponent(addButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(priceTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantityTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(discountTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lotTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(okButton)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pbnameLabel))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(productsLabel)
                .addGap(130, 130, 130)
                .addComponent(pricesLabel)
                .addGap(68, 68, 68)
                .addComponent(quantitiesLabel)
                .addGap(67, 67, 67)
                .addComponent(discountsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lotsLabel)
                .addGap(87, 87, 87))
            .addComponent(jScrollPane)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(110, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addGap(0, 329, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout PRODUCTSPANELLayout = new javax.swing.GroupLayout(PRODUCTSPANEL);
        PRODUCTSPANEL.setLayout(PRODUCTSPANELLayout);
        PRODUCTSPANELLayout.setHorizontalGroup(
            PRODUCTSPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PRODUCTSPANELLayout.setVerticalGroup(
            PRODUCTSPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("PRODUCTS", PRODUCTSPANEL);

        orderIdLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        orderIdLabel.setText("OrderId");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 848, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 627, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel5);

        discountLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        discountLabel.setText("Discount");

        quantityLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        quantityLabel.setText("Quantity");

        dateLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        dateLabel.setText("Date");

        ownerLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        ownerLabel.setText("Owner");

        totalpriceLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        totalpriceLabel1.setText("Total price");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout ORDERPANELLayout = new javax.swing.GroupLayout(ORDERPANEL);
        ORDERPANEL.setLayout(ORDERPANELLayout);
        ORDERPANELLayout.setHorizontalGroup(
            ORDERPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ORDERPANELLayout.setVerticalGroup(
            ORDERPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ORDERPANELLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("ORDER", ORDERPANEL);

        javax.swing.GroupLayout STATPANELLayout = new javax.swing.GroupLayout(STATPANEL);
        STATPANEL.setLayout(STATPANELLayout);
        STATPANELLayout.setHorizontalGroup(
            STATPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 852, Short.MAX_VALUE)
        );
        STATPANELLayout.setVerticalGroup(
            STATPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 439, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("STAT", STATPANEL);

        skipButton.setText("SKIP");
        skipButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skipButtonActionPerformed(evt);
            }
        });

        menuButton.setText("Menu");
        menuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuButtonActionPerformed(evt);
            }
        });

        welcome_employeeLabel.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(skipButton))
            .addGroup(layout.createSequentialGroup()
                .addGap(226, 226, 226)
                .addComponent(welcome_employeeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(menuButton)
                    .addGap(0, 786, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(skipButton)
                .addGap(7, 7, 7)
                .addComponent(welcome_employeeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 609, Short.MAX_VALUE)
                    .addComponent(menuButton)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void skipButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skipButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_skipButtonActionPerformed

    private void menuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuButtonActionPerformed
        dispose();
        new HomePage().setVisible(true);
    }//GEN-LAST:event_menuButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
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
        okButton.setVisible(true);
        
        employeeAction="add";
        
        
        
    }//GEN-LAST:event_addButtonActionPerformed

    private void priceTextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceTextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceTextfieldActionPerformed

    private void lotTextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lotTextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lotTextfieldActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
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
        okButton.setVisible(true);
        
        employeeAction="update";
        
    }//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        
        jLabel1.setVisible(true);
        
        productTextfield.setVisible(true);
        
        okButton.setVisible(true);
        
        employeeAction="delete";
        
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        if(employeeAction=="add")
        {
        Product prod=new Product();
        
        prod.setProductName(productTextfield.getText());
        prod.setProductPrice(Double.parseDouble(priceTextfield.getText()));
        prod.setProductStock(Integer.parseInt(quantityTextfield.getText()));
        prod.setProductDiscount(Integer.parseInt(discountTextfield.getText()));
        prod.setProductQuantityDiscount(Integer.parseInt(lotTextfield.getText()));
        
        productdb.addProduct(prod);
        
        productTextfield.setText(null);
        priceTextfield.setText(null);
        quantityTextfield.setText(null);
        discountTextfield.setText(null);
        lotTextfield.setText(null);
        setVisible(false);
        new EmployeePage(currentEmployee).setVisible(true);
            
        }
        else if(employeeAction=="update")
        {
             for(int i=0; i<produit.size();i++)
       {
           if(productTextfield.getText().equals(produit.get(i).getProductName()))
           {
               produit.get(i).setProductPrice(Double.parseDouble(priceTextfield.getText()));
               produit.get(i).setProductStock(Integer.parseInt(quantityTextfield.getText()));
               produit.get(i).setProductDiscount(Integer.parseInt(discountTextfield.getText()));
               produit.get(i).setProductQuantityDiscount(Integer.parseInt(lotTextfield.getText()));
               productdb.updateProduct(produit.get(i));
               
               System.out.println("modif");
           }
       }
        
        productTextfield.setText(null);
        priceTextfield.setText(null);
        quantityTextfield.setText(null);
        discountTextfield.setText(null);
        lotTextfield.setText(null);
        
        setVisible(false);
        new EmployeePage(currentEmployee).setVisible(true);
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

        productTextfield.setText(null);
        priceTextfield.setText(null);
        quantityTextfield.setText(null);
        discountTextfield.setText(null);
        lotTextfield.setText(null);
        
        setVisible(false);
        new EmployeePage(currentEmployee).setVisible(true);
        }
    }//GEN-LAST:event_okButtonActionPerformed

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
    private javax.swing.JButton addButton;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel discountLabel;
    private javax.swing.JTextField discountTextfield;
    private javax.swing.JLabel discountsLabel;
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
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField lotTextfield;
    private javax.swing.JLabel lotsLabel;
    private javax.swing.JButton menuButton;
    private javax.swing.JButton okButton;
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
    private javax.swing.JButton skipButton;
    private javax.swing.JLabel totalpriceLabel1;
    private javax.swing.JButton updateButton;
    private javax.swing.JLabel welcome_employeeLabel;
    // End of variables declaration//GEN-END:variables
}
