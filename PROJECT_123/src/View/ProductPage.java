/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Dbutils;
import Controller.OrderDBQuery;
import Controller.OrderDetailsDBQuery;
import Controller.ProductDBQuery;
import Model.Customer;
import Model.Order;
import Model.OrderDetails;
import Model.Product;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
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
    private ArrayList<JButton> deleteButtons=new ArrayList<>();
    private ArrayList<JLabel> productLabel=new ArrayList<>();
    private static Customer currentCustomer=null;
    private Achat achatPage;
    private Order currentOrder;
    private OrderDBQuery orderdb= new OrderDBQuery();
    double psr=0;
    double save=0;
    
    //Constructor
    public ProductPage(Customer cust, Order co) {
        
        this.currentOrder=co;//Attribut de l'order actuelle
         
         try {
            
            initComponents();
            //We establish the connexion
            Connection conn= Dbutils.getDbConnection();
            
            //Field initialization
            currentCustomer=cust;
            welcome_customerLabel.setText("Welcome "+currentCustomer.getCustomerName());
            produit=productdb.getProducts();
            achatPage= new Achat(this);
            jPanel1.add(jScrollPane1);
            
            //Display of the products
            displayProducts();
            
          
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
          
    }
    
    
    public void displayProducts()
    {
        int j=30;
            for(int i=0;i<produit.size();i++)
            {
                String str=(produit.get(i).getProductName().replace(" ", "")+".jpg");
                ImageIcon img;
                System.out.println(str);
                try{
                    img=new ImageIcon(str);
                    
                }catch(Exception e)
                {
                    img=new ImageIcon("notfound.jpg"); 
                    System.out.println("salut");
                }
                final int number=i;
                productLabel.add(new JLabel(produit.get(i).getProductName()));
                productButtons.add(new JButton());
                productButtons.get(i).setIcon(img);
                
                jPanel2.add(productButtons.get(i));
                jPanel2.add(productLabel.get(i));
                productButtons.get(i).setBounds(30, j, 100, 100);
                productLabel.get(i).setBounds(200, j+50, 200, 20);
                productButtons.get(i).setVisible(true);
                productLabel.get(i).setVisible(true);
               
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
                j+=150;
            }
    }

     public void addToBucket(Product p)
     {
          bucket.add(p);
          System.out.println(bucket.size());
     }
     
     public void addQuantity (int i)
     {
         quantity.add(i);
         System.out.println(quantity.size());
     }
     
     public void addDeleteButton()
     {
         deleteButtons.add(new JButton("Delete"));
         jPanel1.add(deleteButtons.get(deleteButtons.size()-1));
         if (deleteButtons.size()==1){
             deleteButtons.get(deleteButtons.size()-1).setBounds(760, 225, 80, 15);
         }
         else{
             int j = deleteButtons.get(deleteButtons.size()-2).getY();
             deleteButtons.get(deleteButtons.size()-1).setBounds(760, j+17, 80, 15);
         }
            deleteButtons.get(deleteButtons.size()-1).setVisible(true);
            
            deleteButtons.get(deleteButtons.size()-1).addActionListener(new ActionListener(){
                
                @Override
                public void actionPerformed(ActionEvent ae) {
                    Object o = ae.getSource();
                    int here=0;
                    for (int i=0; i<deleteButtons.size();i++){
                        if (deleteButtons.get(i)==o){
                            here=i;
                        }
                    }
                    System.out.println(bucket.get(here).getProductName());
                    
                    //We manage product stock
                    int quantityInitial=bucket.get(here).getProductStock();
                    int quantityBuy=quantity.get(here);
                    int quantityFinal=quantityInitial+quantityBuy;
                    bucket.get(here).setProductStock(quantityFinal);
                    productdb.updateProduct(bucket.get(here));
                    
                    //We actualize the current order
                    int quanIni=currentOrder.getQuantity();
                    double priceIni=currentOrder.getTotalPrice();
                    int n = quantityBuy;
                    double tp;
                    double p = bucket.get(here).getProductPrice();
                        
                    if(bucket.get(here).getProductQuantityDiscount()>0 && bucket.get(here).getProductDiscount()>0)
                    {
                        tp=(n/bucket.get(here).getProductQuantityDiscount())*bucket.get(here).getProductDiscount()
                            +(n%bucket.get(here).getProductQuantityDiscount())*bucket.get(here).getProductPrice();
                    }
                    else
                    {
                        tp=p*n;
                    }
                        
                    currentOrder.setQuantity(quanIni-quantityBuy);
                    currentOrder.setTotalPrice(priceIni-tp);
                    
                    //calcul du prix sans reduc
                    psr-=bucket.get(here).getProductPrice()*quantityBuy;
                    
                    //On supprime des ArrayList ce que l'on vient d'enlever
                    bucket.remove(here);
                    quantity.remove(here);
                    jPanel1.remove(deleteButtons.get(here));
                    deleteButtons.remove(here);
                    for(int l=here;l<deleteButtons.size();l++){
                        deleteButtons.get(l).setBounds(750, deleteButtons.get(l).getY()-17, 80, 15);
                    }
                    
                    //On affiche le panier en appelant la méthode updateTable
                    updateTable();
   
                    //On met à jour le statut du panier
                    updateStatutBucket();
      
                    //On met à jour le prix total
                    updateTotalPrice();
                       
                    //On rend la page visible
                    setVisible(true);
                }
            });
     }
     
    //Méthode mettant à jour la table en fonction des achats du customer
     public void updateTable() {
        
        String[][] rowData = new String[bucket.size()][3];
        String[] colNames = {"Item", "Quantity", "Price"};
         double tp =0;
        for (int i=0; i<bucket.size();i++)
        {
            int n = quantity.get(i);
            double p = bucket.get(i).getProductPrice();
            // psr+=p*n;
             
            if(bucket.get(i).getProductQuantityDiscount()>0 && bucket.get(i).getProductDiscount()>0)
            {
                tp=(n/bucket.get(i).getProductQuantityDiscount())*bucket.get(i).getProductDiscount()
                        +(n%bucket.get(i).getProductQuantityDiscount())*bucket.get(i).getProductPrice();
            }
            else
            {
                tp=p*n;
            }
            
            String price = String.valueOf(tp) + " $";
            String quant = "x"+String.valueOf(n);
            
            
            rowData[i][0]=bucket.get(i).getProductName();
            rowData[i][1]=quant;            //Conversion du int en String
            rowData[i][2]=price;
        }
        
            // System.out.println("prix sans reduc="+psr);
		
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();

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
                "Item", "Quantity", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableBucket);
        if (jTableBucket.getColumnModel().getColumnCount() > 0) {
            jTableBucket.getColumnModel().getColumn(0).setPreferredWidth(3);
            jTableBucket.getColumnModel().getColumn(1).setPreferredWidth(1);
            jTableBucket.getColumnModel().getColumn(2).setPreferredWidth(1);
        }

        jLabelBucket.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabelBucket.setText("Your bucket :");

        jLabelStatutBucket.setText("Empty for the moment");

        jLabelTotalPrice.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(skipButton))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(224, 224, 224)
                .addComponent(welcome_customerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menuButton)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(755, 755, 755)
                        .addComponent(BuyButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(367, 367, 367)
                        .addComponent(jLabelTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(economieLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelBucket)
                                .addGap(40, 40, 40)
                                .addComponent(jLabelStatutBucket)))
                        .addGap(42, 42, 42))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112))))
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
                .addGap(37, 37, 37)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(jLabelTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(economieLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BuyButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(menuButton))
        );

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel2.setPreferredSize(new java.awt.Dimension(504, 5000));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 504, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3000, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 846, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 340, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(117, 117, 117)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(38, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuButtonActionPerformed
      dispose();
      new HomePage().setVisible(true); //Back to Page 1
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
        
         //calculs economies
        save=psr-currentOrder.getTotalPrice();
        economieLabel1.setText("you save £"+save);
        
        OrderDetails panier;
        OrderDetailsDBQuery od =new OrderDetailsDBQuery();
        
        //boucle for pour le détails de chaque article du panier
        for(int i=0;i<bucket.size();i++)
        {
            panier=new OrderDetails();
            //chaque produit de la meme commande a le meme id
            panier.setOrderId(currentOrder.getOrderId());
            panier.setProductId(bucket.get(i).getProductId());
            panier.setQuantity(quantity.get(i));
            if(bucket.get(i).getProductQuantityDiscount()>0 && bucket.get(i).getProductDiscount()>0)
            {  
                //calcul prix sans reduc
                double p=bucket.get(i).getProductPrice()*quantity.get(i);
                //calcul prix avec reduc
                double n=(quantity.get(i)/bucket.get(i).getProductQuantityDiscount())
                        *(bucket.get(i).getProductDiscount())
                        +(quantity.get(i)%bucket.get(i).getProductQuantityDiscount())
                        *bucket.get(i).getProductPrice();
                //calcul de la reduction
                double d=p-n;
                
                panier.setPrice(n);
                panier.setDiscount(d);
            }
            else
            {
                panier.setPrice(bucket.get(i).getProductPrice()*quantity.get(i));
                panier.setDiscount(0);
            }
            
            od.submitBucket(panier);
        }  
        
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
                Customer currentCustomer = new Customer();
                
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
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
    
    public double getPsr()
    {
        return psr;
    }

     public void setPsr(double psr)
    {
        this.psr=psr;
    }
}
