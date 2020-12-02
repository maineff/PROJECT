/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Dbutils;
import Controller.OrderDBQuery;
import Controller.ProductDBQuery;
import Model.Order;
import Model.Product;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author maine
 */
public class Achat extends javax.swing.JFrame {

    //Fields
    private final ProductDBQuery productdb=new ProductDBQuery();
    private  ArrayList<Product> produit = new  ArrayList<Product>(); 
    private final ProductPage parentPage;
    private int here;
    private Order currentOrder;
    

    //Constructor
    public Achat(ProductPage p) {
        initComponents();
        parentPage=p;
    }
     
    
    //Méthode permettant d'afficher la page Achat sans créer une nouvelle JFrame à chaque fois
    //et qui affiche les informations du produit selectionné par le customer
    public void setAchat(int i, Order co) {
         
        this.currentOrder=co;
        this.here=i;
        
        try {
       
            parentPage.setVisible(false);//On désaffiche la page parent, ie la Productpage
            
            //On établit la connection
            Connection conn= Dbutils.getDbConnection();
            produit=productdb.getProducts();
            
            //On affiche les informations relatives au produit choisi par le customer
            nameLabel.setText(produit.get(i).getProductName());
            priceLabel.setText(Double.toString(produit.get(i).getProductPrice())+"$");
            quantityLabel.setText(Integer.toString(produit.get(i).getProductStock())+"/100");

        }catch (SQLException ex) {
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

        jPanel1 = new javax.swing.JPanel();
        achatLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        skipButton = new javax.swing.JButton();
        quantityLabel = new javax.swing.JLabel();
        bucketButton = new javax.swing.JButton();
        quantity1Label = new javax.swing.JLabel();
        quantityTextfield = new javax.swing.JTextField();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(850, 600));

        achatLabel.setFont(new java.awt.Font("Impact", 0, 48)); // NOI18N
        achatLabel.setText("ACHAT");

        nameLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        nameLabel.setText("product_name");

        priceLabel.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        priceLabel.setText("price");

        skipButton.setText("SKIP");
        skipButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skipButtonActionPerformed(evt);
            }
        });

        quantityLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        quantityLabel.setText("quantity");

        bucketButton.setText("add to bucket");
        bucketButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bucketButtonActionPerformed(evt);
            }
        });

        quantity1Label.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        quantity1Label.setText("QUANTITY");

        backButton.setText("BACK");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(backButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(skipButton))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(quantityLabel)
                                .addGap(312, 312, 312)
                                .addComponent(priceLabel))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(nameLabel)
                                        .addGap(152, 152, 152))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(quantity1Label)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addComponent(quantityTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bucketButton))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(351, 351, 351)
                        .addComponent(achatLabel)))
                .addGap(0, 202, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(skipButton)
                            .addComponent(backButton))
                        .addGap(157, 157, 157)
                        .addComponent(nameLabel)
                        .addGap(18, 18, 18)
                        .addComponent(quantityLabel)
                        .addGap(79, 79, 79)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(quantityTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(quantity1Label)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(achatLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(priceLabel)
                        .addGap(41, 41, 41)
                        .addComponent(bucketButton)))
                .addContainerGap(235, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void skipButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skipButtonActionPerformed
       System.exit(0);//Closing of the system
    }//GEN-LAST:event_skipButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        this.dispose();
        parentPage.setVisible(true);//On rend la Productpage visible
    }//GEN-LAST:event_backButtonActionPerformed

    //Méthode permettant d'effacer l'ancienne saisie de l'utilisateur
    public void clearQuantity()
    {
        quantityTextfield.setText("");
    }
    
    private void bucketButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bucketButtonActionPerformed
        
        //We manage product stock
        int quantityInitial=produit.get(here).getProductStock();
        int quantityBuy=Integer.parseInt(quantityTextfield.getText());

        int quantityFinal=quantityInitial-quantityBuy;
        produit.get(here).setProductStock(quantityFinal);
        productdb.updateProduct(produit.get(here));

        //We actualize the current order
        int quanIni=currentOrder.getQuantity();
        double priceIni=currentOrder.getTotalPrice();

        currentOrder.setDiscount(10);
        currentOrder.setQuantity(quanIni+quantityBuy);
        currentOrder.setTotalPrice(priceIni+produit.get(here).getProductPrice()*quantityBuy);
        System.out.println(currentOrder.getDiscount()+" "+currentOrder.getQuantity()+" "+currentOrder.getTotalPrice());

        parentPage.addToBucket(produit.get(here));
        
        //Back to Product page
        //setVisible(false);
        parentPage.setVisible(true);//On rend la Productpage visible
    }//GEN-LAST:event_bucketButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Achat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Achat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Achat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Achat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

       //  Create and display the form
        java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
              //new Achat().setVisible(true);
         }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel achatLabel;
    private javax.swing.JButton backButton;
    private javax.swing.JButton bucketButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JLabel quantity1Label;
    private javax.swing.JLabel quantityLabel;
    private javax.swing.JTextField quantityTextfield;
    private javax.swing.JButton skipButton;
    // End of variables declaration//GEN-END:variables
}
