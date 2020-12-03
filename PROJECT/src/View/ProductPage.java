/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Dbutils;
import Controller.OrderDBQuery;
import Controller.ProductDBQuery;
import Model.Customer;
import Model.Order;
import Model.Product;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author maine
 */
public class ProductPage extends javax.swing.JFrame {

    //Fields
    private ProductDBQuery productdb=new ProductDBQuery();
    private ArrayList<Product> produit = new  ArrayList<Product>(); 
    private ArrayList<Product> bucket = new  ArrayList<Product>(); 
    private ArrayList<Integer> quantity = new ArrayList<Integer>();
    private ArrayList<JButton> productButtons=new ArrayList<>();
    private static Customer currentCustomer=null;
    private Achat achatPage;
    private Order currentOrder;
    private OrderDBQuery orderdb= new OrderDBQuery();
    double psr=0;
    
    //Constructor
    public ProductPage(Customer cust, Order co) {
        
        this.currentOrder=co;//Attribut de l'order actuelle
         
         try {
            
            initComponents();
            //setExtendedState(JFrame.MAXIMIZED_BOTH);
            
            //We establish the connexion
            Connection conn= Dbutils.getDbConnection();
            
            //Field initialization
            currentCustomer=cust;
            welcome_customerLabel.setText("Welcome "+currentCustomer.getCustomerName());
            produit=productdb.getProducts();
            achatPage= new Achat(this);
            
            //Display of the products
            int j=100;
            for(int i=0;i<produit.size();i++)
            {
                final int number=i;
                productButtons.add(new JButton(produit.get(i).getProductName()));
                jPanel1.add(productButtons.get(i));
                productButtons.get(i).setBounds(100, j, 200, 20);
                productButtons.get(i).setVisible(true);
               
                productButtons.get(i).addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent ae) {
                         
                        dispose();
                        
                        achatPage.clearQuantity();
                        achatPage.setAchat(number, currentOrder);
                        achatPage.setVisible(true);//We display the purchase window if we click on a JButton
                        System.out.println(bucket.size());
                    }
                });
                j+=50;
            }
          
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

     public void addToBucket(Product p)
     {
          bucket.add(p);
          System.out.println(bucket.size());
     }
     
     public void addQuantity (int i){
         quantity.add(i);
         System.out.println(quantity.size());
     }
     
    //Méthode mettant à jour la table en fonction des achats du customer
     public void updateTable() {
        
        String[][] rowData = new String[bucket.size()][3];
        String[] colNames = {"Quantity", "Item", "Price"};
         double tp =0;
        for (int i=0; i<bucket.size();i++){
            
             int n = quantity.get(i);
             double p = bucket.get(i).getProductPrice();
            if(bucket.get(i).getProductQuantityDiscount()>0 && bucket.get(i).getProductDiscount()>0)
            {
                tp=(n/bucket.get(i).getProductQuantityDiscount())*bucket.get(i).getProductDiscount()
                        +(n%bucket.get(i).getProductQuantityDiscount())*bucket.get(i).getProductPrice();
            }
            else
            {
                tp=p*n;
            }
             psr+=p*n;
             System.out.println("prix sans reduc="+psr);
            String price = String.valueOf(tp) + " $";
            
            rowData[i][0]=String.valueOf(n);            //Conversion du int en String
            rowData[i][1]=bucket.get(i).getProductName();
            rowData[i][2]=price;
        }
		
        DefaultTableModel dtm = new DefaultTableModel(rowData, colNames);
	jTableBucket.setModel(dtm);
    }
     
     public void updateTotalPrice(){
         if (bucket.isEmpty()){
             jLabelTotalPrice.setText("");
         }
         else{
             jLabelTotalPrice.setText("Total Price : " + currentOrder.getTotalPrice() + " $");
         }
     }
     
     //Méthode mettant à jour le label affichant le statut du panier
     public void updateStatutBucket(){
         if (bucket.isEmpty()){
             jLabelStatutBucket.setText("Empty for the moment");
         }
         else if (bucket.size()==1){
             jLabelStatutBucket.setText(bucket.size()+" item for the moment");
         }
         else{
             jLabelStatutBucket.setText(bucket.size()+" items for the moment");
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
        skipButton = new javax.swing.JButton();
        welcome_customerLabel = new javax.swing.JLabel();
        menuButton = new javax.swing.JButton();
        BuyButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableBucket = new javax.swing.JTable();
        jLabelBucket = new javax.swing.JLabel();
        jLabelStatutBucket = new javax.swing.JLabel();
        jLabelTotalPrice = new javax.swing.JLabel();
        economieLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(850, 600));

        skipButton.setText("SKIP");
        skipButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skipButtonActionPerformed(evt);
            }
        });

        welcome_customerLabel.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N

        menuButton.setText("Menu");
        menuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuButtonActionPerformed(evt);
            }
        });

        BuyButton.setText("BUY");
        BuyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuyButtonActionPerformed(evt);
            }
        });

        jTableBucket.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Quantity", "Item", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableBucket);
        if (jTableBucket.getColumnModel().getColumnCount() > 0) {
            jTableBucket.getColumnModel().getColumn(0).setPreferredWidth(1);
            jTableBucket.getColumnModel().getColumn(2).setPreferredWidth(1);
        }

        jLabelBucket.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabelBucket.setText("Your bucket :");

        jLabelStatutBucket.setText("Empty for the moment");

        jLabelTotalPrice.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        economieLabel1.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(skipButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelBucket)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelStatutBucket)))
                        .addGap(30, 30, 30))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menuButton)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(755, 755, 755)
                        .addComponent(BuyButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(224, 224, 224)
                .addComponent(welcome_customerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(191, 191, 191))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(economieLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(122, 122, 122))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(skipButton)
                .addGap(9, 9, 9)
                .addComponent(welcome_customerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelBucket)
                    .addComponent(jLabelStatutBucket))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(jLabelTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(economieLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BuyButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(menuButton))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 833, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuButtonActionPerformed
      dispose();
      new Page1().setVisible(true); //Back to Page 1
    }//GEN-LAST:event_menuButtonActionPerformed

    private void skipButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skipButtonActionPerformed
        System.exit(0); //Closing of the system
    }//GEN-LAST:event_skipButtonActionPerformed

    private void BuyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuyButtonActionPerformed
       
        currentOrder.setUsername(currentCustomer.getCustomerUsername());
        orderdb.submitOrder(currentOrder); //If we click on the "BUY" JButton, the current order registers in the database
        
        //Lorsque la commande est passée on remplit les champs manquants de l'order
        currentOrder.setCustomerName(currentCustomer);
        currentOrder.setProduct(produit);
        
        //Lorsque la commande est passée on met à jour la liste de commande du customer
        currentCustomer.getCommandes().add(currentOrder);
        currentOrder.getProduct().add(bucket);
        
        double save=psr-currentOrder.getTotalPrice();
        economieLabel1.setText("you save £"+save);
    }//GEN-LAST:event_BuyButtonActionPerformed

    
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
            java.util.logging.Logger.getLogger(ProductPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                Order currentOrder = new Order();
                
                new ProductPage(currentCustomer, currentOrder).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BuyButton;
    private javax.swing.JLabel economieLabel1;
    private javax.swing.JLabel jLabelBucket;
    private javax.swing.JLabel jLabelStatutBucket;
    private javax.swing.JLabel jLabelTotalPrice;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableBucket;
    private javax.swing.JButton menuButton;
    private javax.swing.JButton skipButton;
    private javax.swing.JLabel welcome_customerLabel;
    // End of variables declaration//GEN-END:variables


   /*-----------------------Getter-----------------------*/
    
    public ArrayList<Product> getBucket()
    {
        return bucket;
    }
    
    public ArrayList<Integer> getQuantity()
    {
        return quantity;
    }
    
    public Achat getAchatPage()
    {
        return achatPage;
    }

}
