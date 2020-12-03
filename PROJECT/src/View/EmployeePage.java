/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Dbutils;
import Controller.ProductDBQuery;
import Model.Product;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
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
    
    public EmployeePage() {
       
        try{
        initComponents();
        jPanel1.add(jPanel2);
        jPanel1.add(jScrollPane);
        
        //We establish the connexion
        
        Connection conn= Dbutils.getDbConnection();
        
        produit=productdb.getProducts();
        
        //Display of the products
            int j=50;
            for(int i=0;i<produit.size();i++)
            {
                final int number=i;
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
        ORDERPANEL = new javax.swing.JPanel();
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(updateButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteButton))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(productTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(priceTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addComponent(quantityTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(discountTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107)
                .addComponent(lotTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 19, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(discountTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(priceTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantityTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lotTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(productTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(deleteButton)
                    .addComponent(updateButton)))
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
            .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 845, Short.MAX_VALUE)
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

        javax.swing.GroupLayout ORDERPANELLayout = new javax.swing.GroupLayout(ORDERPANEL);
        ORDERPANEL.setLayout(ORDERPANELLayout);
        ORDERPANELLayout.setHorizontalGroup(
            ORDERPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 845, Short.MAX_VALUE)
        );
        ORDERPANELLayout.setVerticalGroup(
            ORDERPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 439, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("ORDER", ORDERPANEL);

        javax.swing.GroupLayout STATPANELLayout = new javax.swing.GroupLayout(STATPANEL);
        STATPANEL.setLayout(STATPANELLayout);
        STATPANELLayout.setHorizontalGroup(
            STATPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 845, Short.MAX_VALUE)
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
        welcome_employeeLabel.setText("WELCOME EMPLOYEE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(skipButton))
            .addGroup(layout.createSequentialGroup()
                .addGap(269, 269, 269)
                .addComponent(welcome_employeeLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(menuButton)
                    .addGap(0, 779, Short.MAX_VALUE)))
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
        new Page1().setVisible(true);
    }//GEN-LAST:event_menuButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
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
        new EmployeePage().setVisible(true);
        
    }//GEN-LAST:event_addButtonActionPerformed

    private void priceTextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceTextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceTextfieldActionPerformed

    private void lotTextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lotTextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lotTextfieldActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
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
        new EmployeePage().setVisible(true);    
    }//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        
       for(int i=0; i<produit.size();i++)
       {
           if(productTextfield.getText().equals(produit.get(i).getProductName()))
           {
               productdb.deleteProduct(produit.get(i));
               System.out.println("supp");
           }
       }
        
        
//        nv.deleteProduct(prod);
        
        productTextfield.setText(null);
        priceTextfield.setText(null);
        quantityTextfield.setText(null);
        discountTextfield.setText(null);
        lotTextfield.setText(null);
        
        setVisible(false);
        new EmployeePage().setVisible(true);
    }//GEN-LAST:event_deleteButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ORDERPANEL;
    private javax.swing.JPanel PRODUCTSPANEL;
    private javax.swing.JPanel STATPANEL;
    private javax.swing.JButton addButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField discountTextfield;
    private javax.swing.JLabel discountsLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField lotTextfield;
    private javax.swing.JLabel lotsLabel;
    private javax.swing.JButton menuButton;
    private javax.swing.JTextField priceTextfield;
    private javax.swing.JLabel pricesLabel;
    private javax.swing.JTextField productTextfield;
    private javax.swing.JLabel productsLabel;
    private javax.swing.JLabel quantitiesLabel;
    private javax.swing.JTextField quantityTextfield;
    private javax.swing.JButton skipButton;
    private javax.swing.JButton updateButton;
    private javax.swing.JLabel welcome_employeeLabel;
    // End of variables declaration//GEN-END:variables
}
