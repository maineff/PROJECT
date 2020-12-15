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
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
       
         try 
         {
            initComponents();
            //We establish the connexion
            Connection conn= Dbutils.getDbConnection();
            
            //Field initialization
            currentCustomer=cust;
            welcome_customerLabel.setText("Welcome "+currentCustomer.getCustomerName());
            produit=productdb.getProducts();
            achatPage= new Achat(this);
            jPanel1.add(jScrollPane1);
            finalLabel.setVisible(false);
            economieLabel1.setVisible(false);
            //Display of the products
            displayProducts();
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
          
    }
    
    //on affiche les produits
    public void displayProducts()
    {
        int j=30;
        for(int i=0;i<produit.size();i++)
        {
            //nom de l'image
            String str=(produit.get(i).getProductName().replace(" ", "")+".jpg");
            ImageIcon img;
            img=new ImageIcon(str);

            //on afiiche autant de boutons que de produits
            final int number=i;
            productLabel.add(new JLabel(produit.get(i).getProductName()));
            productButtons.add(new JButton());
            productButtons.get(i).setIcon(img);

            jPanel2.add(productButtons.get(i));
            jPanel2.add(productLabel.get(i));
            productButtons.get(i).setBounds(30, j, 100, 100);
            productLabel.get(i).setBounds(180, j+50, 200, 20);

            productButtons.get(i).setVisible(true);
            productLabel.get(i).setVisible(true);
            
            productButtons.get(i).addActionListener(new ActionListener() {
             @Override
                public void actionPerformed(ActionEvent ae)
                {
                    dispose();
                    achatPage.clearQuantity();
                    achatPage.setAchat(number, currentOrder);
                    achatPage.setVisible(true);//We display the purchase window if we click on a JButton  
                }
            });
            j+=150;
        }
    }

    //on ajoute au panier
     public void addToBucket(Product p)
     {
          bucket.add(p);
     }
     
     //on ajoute les quantites saisies dans un arraylist d'entier
     public void addQuantity (int i)
     {
         quantity.add(i);
     }
     
     //ajout des boutons supprimer
     public void addDeleteButton()
     {
         String str=("deleteIcon.png");
         ImageIcon img;
         img=new ImageIcon(str);
         
         deleteButtons.add(new JButton());
         deleteButtons.get(deleteButtons.size()-1).setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/deleteIcon.png")));
         
         jPanel1.add(deleteButtons.get(deleteButtons.size()-1));
         if (deleteButtons.size()==1)
         {
            deleteButtons.get(deleteButtons.size()-1).setBounds(755, 225, 18, 18);
         }
         else
         {
            int j = deleteButtons.get(deleteButtons.size()-2).getY();
            deleteButtons.get(deleteButtons.size()-1).setBounds(755, j+17, 18, 18);
         }
         deleteButtons.get(deleteButtons.size()-1).setVisible(true);
            
    deleteButtons.get(deleteButtons.size()-1).addActionListener(new ActionListener()
    {

        @Override
        public void actionPerformed(ActionEvent ae) 
        {
            Object o = ae.getSource();
            int here=0;
            for (int i=0; i<deleteButtons.size();i++){
                if (deleteButtons.get(i)==o){
                    here=i;
                }
            }
           
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
            jPanel1.revalidate();
            jPanel1.repaint();
            deleteButtons.remove(here);
            for(int l=here;l<deleteButtons.size();l++){
                deleteButtons.get(l).setBounds(755, deleteButtons.get(l).getY()-17, 18, 18);
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
         double tp=0;
        for (int i=0; i<bucket.size();i++)
        {
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
            DecimalFormat df = new DecimalFormat("#.##");
            df.setRoundingMode(RoundingMode.HALF_UP);
            String price = String.valueOf(df.format(tp)) + "$";
            String quant = "x"+String.valueOf(n);
            
            
            rowData[i][0]=bucket.get(i).getProductName();
            rowData[i][1]=quant;//Conversion du int en String
            rowData[i][2]=price;
        }
        
	DefaultTableModel dtm = new DefaultTableModel(rowData, colNames);
	jTableBucket.setModel(dtm);
    }
     
     //maj du prix total
     public void updateTotalPrice()
     {
         if (bucket.isEmpty())
         {
             jLabelTotalPrice.setText("");
         }
         else
         {
             DecimalFormat df = new DecimalFormat("#.##");
             df.setRoundingMode(RoundingMode.HALF_UP);
             jLabelTotalPrice.setText("Total Price : " + df.format(currentOrder.getTotalPrice()) + " $");
         }
     }
     
     //Méthode mettant à jour le label affichant le statut du panier
     public void updateStatutBucket()
     {
         if (bucket.isEmpty()){
             jLabelStatutBucket.setText("Empty for the moment");
         }
         else if (bucket.size()==1)
         {
             jLabelStatutBucket.setText(bucket.size()+" item for the moment");
         }
         else
         {
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
        welcome_customerLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableBucket = new javax.swing.JTable();
        jLabelBucket = new javax.swing.JLabel();
        jLabelStatutBucket = new javax.swing.JLabel();
        jLabelTotalPrice = new javax.swing.JLabel();
        economieLabel1 = new javax.swing.JLabel();
        exitLabel2 = new javax.swing.JLabel();
        homeLabel1 = new javax.swing.JLabel();
        buyButtonLabel = new javax.swing.JLabel();
        DecoIconjLabel = new javax.swing.JLabel();
        finalLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(850, 600));

        welcome_customerLabel.setFont(new java.awt.Font("Impact", 0, 48)); // NOI18N
        welcome_customerLabel.setForeground(new java.awt.Color(255, 255, 255));

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

        jLabelBucket.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabelBucket.setForeground(new java.awt.Color(255, 255, 255));
        jLabelBucket.setText("Your bucket");

        jLabelStatutBucket.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabelStatutBucket.setForeground(new java.awt.Color(255, 255, 255));
        jLabelStatutBucket.setText("Empty for the moment");

        jLabelTotalPrice.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabelTotalPrice.setForeground(new java.awt.Color(255, 255, 255));

        economieLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        economieLabel1.setForeground(new java.awt.Color(255, 255, 255));

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

        buyButtonLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/buyIcon.png"))); // NOI18N
        buyButtonLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buyButtonLabelMouseClicked(evt);
            }
        });

        DecoIconjLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/buyDecoIcon.png"))); // NOI18N

        finalLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/button_7.png"))); // NOI18N
        finalLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                finalLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(224, 224, 224)
                .addComponent(welcome_customerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                .addComponent(exitLabel2)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelBucket)
                            .addComponent(jLabelStatutBucket))
                        .addGap(26, 26, 26)
                        .addComponent(buyButtonLabel)
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(121, 121, 121))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(homeLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(economieLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(finalLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DecoIconjLabel)
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(welcome_customerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(exitLabel2)))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelBucket)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelStatutBucket))
                    .addComponent(buyButtonLabel))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(economieLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(DecoIconjLabel))
                .addGap(18, 18, 18)
                .addComponent(finalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(34, 34, 34)
                .addComponent(homeLabel1)
                .addContainerGap())
        );

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(504, 5000));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 504, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5000, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 846, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 477, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 643, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(117, 117, 117)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(109, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitLabel2MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitLabel2MouseClicked

    private void homeLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeLabel1MouseClicked
        // TODO add your handling code here:
        setVisible(false);
        new HomePage().setVisible(true);
    }//GEN-LAST:event_homeLabel1MouseClicked

    private void buyButtonLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buyButtonLabelMouseClicked
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.HALF_UP);
        
        //Lorsque la commande est passée on remplit les champs manquants de l'order
        currentOrder.setCustomerName(currentCustomer);
        currentOrder.setProduct(produit);
        currentOrder.setUsername(currentCustomer.getCustomerUsername());
        
        //Lorsque la commande est passée on met à jour la liste de commande du customer
        currentCustomer.getCommandes().add(currentOrder);
        currentOrder.getProduct().add(bucket);
        
         //calculs economies
        save=psr-currentOrder.getTotalPrice();
        currentOrder.setDiscount(save);
        economieLabel1.setText("you save $"+df.format(save));
        //If we click on the "BUY" JButton, the current order registers in the database
        orderdb.submitOrder(currentOrder); 
        if(currentOrder.getTotalPrice()>0)
        {
            finalLabel.setVisible(true);
        }
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
    }//GEN-LAST:event_buyButtonLabelMouseClicked

    private void finalLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_finalLabelMouseClicked
        // TODO add your handling code here:
        dispose();
        new Final().setVisible(true);
    }//GEN-LAST:event_finalLabelMouseClicked

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DecoIconjLabel;
    private javax.swing.JLabel buyButtonLabel;
    private javax.swing.JLabel economieLabel1;
    private javax.swing.JLabel exitLabel2;
    private javax.swing.JLabel finalLabel;
    private javax.swing.JLabel homeLabel1;
    private javax.swing.JLabel jLabelBucket;
    private javax.swing.JLabel jLabelStatutBucket;
    private javax.swing.JLabel jLabelTotalPrice;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableBucket;
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
