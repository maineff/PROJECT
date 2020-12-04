/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.CustomerDBQuery;
import Controller.Dbutils;
import Controller.EmployeeDBQuery;

import Model.Customer;
import Model.Employee;
import Model.Order;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**    
 *
 * @author maine
 */
public class HomePage extends javax.swing.JFrame {

    /**
     * Creates new form HomePage
     */
    CustomerDBQuery customerdb= new CustomerDBQuery();
    EmployeeDBQuery employeedb= new EmployeeDBQuery();
    
    public HomePage() {
        initComponents();
//        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
//        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
//        setSize(400, 400);
        
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        
//utile pour plus tard je pense(ml)
//        int i=0;
//        selleur1Label.setText((String) employeedb.getEmployeeName().get(i));
//        i ++;
//        selleur2Label.setText((String) employeedb.getEmployeeName().get(i));
        customerLogin.setVisible(false);
        employeeLogin.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        Acceuil = new javax.swing.JPanel();
        you_areLabel = new javax.swing.JLabel();
        customerButton = new javax.swing.JButton();
        sellerButton = new javax.swing.JButton();
        welcomeLabel = new javax.swing.JLabel();
        skipButton = new javax.swing.JButton();
        customerLogin = new javax.swing.JPanel();
        menuButton = new javax.swing.JButton();
        usernameLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        usernameTextfield = new javax.swing.JTextField();
        okcustButton = new javax.swing.JButton();
        subscribeButon = new javax.swing.JButton();
        skipButton1 = new javax.swing.JButton();
        wrongLabel = new javax.swing.JLabel();
        imageLabel = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        employeeLogin = new javax.swing.JPanel();
        menu1Button = new javax.swing.JButton();
        skipButton2 = new javax.swing.JButton();
        idLabel1 = new javax.swing.JLabel();
        idTextfield1 = new javax.swing.JTextField();
        passwordLabel1 = new javax.swing.JLabel();
        subscribeButton = new javax.swing.JButton();
        okempButton1 = new javax.swing.JButton();
        wrongLabel1 = new javax.swing.JLabel();
        logoLabel = new javax.swing.JLabel();
        jPasswordField2 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLayeredPane1.setPreferredSize(new java.awt.Dimension(850, 600));
        jLayeredPane1.setRequestFocusEnabled(false);

        Acceuil.setPreferredSize(new java.awt.Dimension(850, 600));

        you_areLabel.setText("You are :");

        customerButton.setText("Customer");
        customerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerButtonActionPerformed(evt);
            }
        });

        sellerButton.setText("Seller");
        sellerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sellerButtonActionPerformed(evt);
            }
        });

        welcomeLabel.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        welcomeLabel.setText("WECOME TO OUR STORE");

        skipButton.setText("SKIP");
        skipButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skipButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AcceuilLayout = new javax.swing.GroupLayout(Acceuil);
        Acceuil.setLayout(AcceuilLayout);
        AcceuilLayout.setHorizontalGroup(
            AcceuilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AcceuilLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(skipButton))
            .addGroup(AcceuilLayout.createSequentialGroup()
                .addGap(189, 189, 189)
                .addComponent(customerButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 237, Short.MAX_VALUE)
                .addComponent(sellerButton)
                .addGap(241, 241, 241))
            .addGroup(AcceuilLayout.createSequentialGroup()
                .addGroup(AcceuilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AcceuilLayout.createSequentialGroup()
                        .addGap(301, 301, 301)
                        .addComponent(welcomeLabel))
                    .addGroup(AcceuilLayout.createSequentialGroup()
                        .addGap(374, 374, 374)
                        .addComponent(you_areLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        AcceuilLayout.setVerticalGroup(
            AcceuilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AcceuilLayout.createSequentialGroup()
                .addComponent(skipButton)
                .addGap(89, 89, 89)
                .addComponent(welcomeLabel)
                .addGap(104, 104, 104)
                .addComponent(you_areLabel)
                .addGap(60, 60, 60)
                .addGroup(AcceuilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customerButton)
                    .addComponent(sellerButton))
                .addContainerGap(241, Short.MAX_VALUE))
        );

        customerLogin.setBackground(new java.awt.Color(204, 153, 255));
        customerLogin.setPreferredSize(new java.awt.Dimension(850, 600));
        customerLogin.setRequestFocusEnabled(false);

        menuButton.setText("Menu");
        menuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuButtonActionPerformed(evt);
            }
        });

        usernameLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        usernameLabel.setForeground(new java.awt.Color(255, 255, 255));
        usernameLabel.setText("Username");

        passwordLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(255, 255, 255));
        passwordLabel.setText("Password");

        usernameTextfield.setBackground(new java.awt.Color(204, 153, 255));
        usernameTextfield.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 5, 0, new java.awt.Color(255, 255, 255)));
        usernameTextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameTextfieldActionPerformed(evt);
            }
        });

        okcustButton.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        okcustButton.setText("OK");
        okcustButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okcustButtonActionPerformed(evt);
            }
        });

        subscribeButon.setBackground(new java.awt.Color(255, 255, 255));
        subscribeButon.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        subscribeButon.setForeground(new java.awt.Color(204, 153, 255));
        subscribeButon.setText("You don't have an account? Sign in");
        subscribeButon.setBorder(null);
        subscribeButon.setBorderPainted(false);
        subscribeButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subscribeButonActionPerformed(evt);
            }
        });

        skipButton1.setText("SKIP");
        skipButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skipButton1ActionPerformed(evt);
            }
        });

        wrongLabel.setForeground(new java.awt.Color(255, 0, 0));

        jPasswordField1.setBackground(new java.awt.Color(204, 153, 255));
        jPasswordField1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 5, 0, new java.awt.Color(255, 255, 255)));

        javax.swing.GroupLayout customerLoginLayout = new javax.swing.GroupLayout(customerLogin);
        customerLogin.setLayout(customerLoginLayout);
        customerLoginLayout.setHorizontalGroup(
            customerLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customerLoginLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(skipButton1))
            .addGroup(customerLoginLayout.createSequentialGroup()
                .addGroup(customerLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menuButton)
                    .addGroup(customerLoginLayout.createSequentialGroup()
                        .addGap(385, 385, 385)
                        .addComponent(okcustButton))
                    .addGroup(customerLoginLayout.createSequentialGroup()
                        .addGap(289, 289, 289)
                        .addComponent(subscribeButon, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customerLoginLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                .addGroup(customerLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                    .addGroup(customerLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(passwordLabel)
                        .addComponent(usernameTextfield, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                        .addComponent(usernameLabel)
                        .addComponent(wrongLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(323, 323, 323))
        );
        customerLoginLayout.setVerticalGroup(
            customerLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customerLoginLayout.createSequentialGroup()
                .addComponent(skipButton1)
                .addGap(56, 56, 56)
                .addComponent(imageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(customerLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(customerLoginLayout.createSequentialGroup()
                        .addGap(403, 403, 403)
                        .addComponent(menuButton))
                    .addGroup(customerLoginLayout.createSequentialGroup()
                        .addComponent(usernameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(usernameTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(passwordLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(wrongLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(okcustButton)
                        .addGap(32, 32, 32)
                        .addComponent(subscribeButon)))
                .addGap(27, 27, 27))
        );

        employeeLogin.setBackground(new java.awt.Color(0, 153, 153));
        employeeLogin.setPreferredSize(new java.awt.Dimension(850, 600));

        menu1Button.setText("Menu");
        menu1Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu1ButtonActionPerformed(evt);
            }
        });

        skipButton2.setText("SKIP");
        skipButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skipButton2ActionPerformed(evt);
            }
        });

        idLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        idLabel1.setForeground(new java.awt.Color(255, 255, 255));
        idLabel1.setText("Username");

        idTextfield1.setBackground(new java.awt.Color(0, 153, 153));
        idTextfield1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 5, 0, new java.awt.Color(255, 255, 255)));
        idTextfield1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idTextfield1ActionPerformed(evt);
            }
        });

        passwordLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        passwordLabel1.setForeground(new java.awt.Color(255, 255, 255));
        passwordLabel1.setText("Password");

        subscribeButton.setBackground(new java.awt.Color(255, 255, 255));
        subscribeButton.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        subscribeButton.setForeground(new java.awt.Color(0, 153, 153));
        subscribeButton.setText("You don't have an account? Sign in");
        subscribeButton.setBorder(null);
        subscribeButton.setBorderPainted(false);
        subscribeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subscribeButtonActionPerformed(evt);
            }
        });

        okempButton1.setText("OK");
        okempButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okempButton1ActionPerformed(evt);
            }
        });

        wrongLabel1.setBackground(new java.awt.Color(0, 153, 153));
        wrongLabel1.setForeground(new java.awt.Color(255, 0, 0));

        jPasswordField2.setBackground(new java.awt.Color(0, 153, 153));
        jPasswordField2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 5, 0, new java.awt.Color(255, 255, 255)));
        jPasswordField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout employeeLoginLayout = new javax.swing.GroupLayout(employeeLogin);
        employeeLogin.setLayout(employeeLoginLayout);
        employeeLoginLayout.setHorizontalGroup(
            employeeLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(employeeLoginLayout.createSequentialGroup()
                .addGroup(employeeLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(employeeLoginLayout.createSequentialGroup()
                        .addGap(276, 276, 276)
                        .addComponent(subscribeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(employeeLoginLayout.createSequentialGroup()
                        .addGap(357, 357, 357)
                        .addComponent(logoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(employeeLoginLayout.createSequentialGroup()
                .addGroup(employeeLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(employeeLoginLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(menu1Button))
                    .addGroup(employeeLoginLayout.createSequentialGroup()
                        .addGap(371, 371, 371)
                        .addComponent(okempButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, employeeLoginLayout.createSequentialGroup()
                .addGap(89, 291, Short.MAX_VALUE)
                .addGroup(employeeLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, employeeLoginLayout.createSequentialGroup()
                        .addComponent(skipButton2)
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, employeeLoginLayout.createSequentialGroup()
                        .addGroup(employeeLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(idTextfield1, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                            .addComponent(passwordLabel1)
                            .addComponent(idLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(wrongLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPasswordField2))
                        .addGap(348, 348, 348))))
        );
        employeeLoginLayout.setVerticalGroup(
            employeeLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(employeeLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(skipButton2)
                .addGap(45, 45, 45)
                .addComponent(logoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(idLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idTextfield1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(passwordLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(wrongLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(okempButton1)
                .addGap(35, 35, 35)
                .addComponent(subscribeButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(menu1Button)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Acceuil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(customerLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(employeeLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Acceuil, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(customerLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(employeeLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE))
        );
        jLayeredPane1.setLayer(Acceuil, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(customerLogin, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(employeeLogin, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void customerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerButtonActionPerformed
        Acceuil.setVisible(false);
        customerLogin.setVisible(true);
        employeeLogin.setVisible(false);
        
    }//GEN-LAST:event_customerButtonActionPerformed

    private void sellerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sellerButtonActionPerformed
        Acceuil.setVisible(false);
        customerLogin.setVisible(false);
        employeeLogin.setVisible(true);
        
    }//GEN-LAST:event_sellerButtonActionPerformed

    private void menu1ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu1ButtonActionPerformed
         Acceuil.setVisible(true);
         customerLogin.setVisible(false);
         employeeLogin.setVisible(false);
    }//GEN-LAST:event_menu1ButtonActionPerformed

    private void idTextfield1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idTextfield1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idTextfield1ActionPerformed

    private void skipButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skipButtonActionPerformed
       System.exit(0);
    }//GEN-LAST:event_skipButtonActionPerformed

    private void skipButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skipButton2ActionPerformed
       System.exit(0);
    }//GEN-LAST:event_skipButton2ActionPerformed

    private void okempButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okempButton1ActionPerformed
         String rq = "SELECT * FROM employee WHERE username='"+idTextfield1.getText()+"'and password='"+jPasswordField2.getText()+"'";
        try 
        {
            ResultSet rst = Dbutils.executeQuery(rq);
            if(rst.next())
            { 
                //On ferme la fenêtre HomePage
                setVisible(false); 
                
                //On créé un employée à l'aide des informations de la base de donnée sur l'employee en question
                Employee empConnected=new Employee();
                empConnected.setEmployeeId(rst.getInt("employeeId"));
                empConnected.setEmployeeName(rst.getString("name"));
                empConnected.setEmployeeLastname(rst.getString("lastname"));
                empConnected.setEmployeeUsername(rst.getString("username"));
                empConnected.setEmployeePassword(rst.getString("password"));
                
               new EmployeePage(empConnected).setVisible(true);
               
            }
            else
            {
                wrongLabel1.setText("wrong id or password");
                wrongLabel1.setForeground(new Color(255,0,0));
            }
                
        } 
        catch (SQLException ex) 
        {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_okempButton1ActionPerformed

    private void subscribeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subscribeButtonActionPerformed
        setVisible(false);
        new SubscribeE().setVisible(true); 
    }//GEN-LAST:event_subscribeButtonActionPerformed

    private void skipButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skipButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_skipButton1ActionPerformed

    private void subscribeButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subscribeButonActionPerformed
        setVisible(false);
        new SubscribeC().setVisible(true);

    }//GEN-LAST:event_subscribeButonActionPerformed

    private void okcustButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okcustButtonActionPerformed

        //Requête permettant d'identifier le client
        String rq = "SELECT * FROM customer WHERE username='"+usernameTextfield.getText()+"'and password='"+jPasswordField1.getText()+"'";
        
        try
        {
            //On exécute la requête
            ResultSet rst = Dbutils.executeQuery(rq);
            if(rst.next())
            {
                //On ferme la fenêtre HomePage
                setVisible(false);
                
                //On crée une commande actuelle
                Order currentOrder=new Order();
                
                //On créé un customer à l'aide des informations de la base de donnée sur le customer en question
                Customer custConnected=new Customer();
                custConnected.setCustomerId(rst.getInt("customerId"));
                custConnected.setCustomerName(rst.getString("name"));
                custConnected.setCustomerLastname(rst.getString("lastname"));
                custConnected.setCustomerAddress(rst.getString("address"));
                custConnected.setCustomerCity(rst.getString("city"));
                custConnected.setCustomerUsername(rst.getString("username"));
                custConnected.setCustomerPassword(rst.getString("password"));
                
                new ProductPage(custConnected,currentOrder).setVisible(true); //On ouvre une nouvelle fenêtre en passant les informations du customer connecté
            }
            else
            {
                wrongLabel.setText("Wrong username or password");
                wrongLabel.setForeground(new Color(255,0,0));
            }
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_okcustButtonActionPerformed

    private void usernameTextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameTextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameTextfieldActionPerformed

    private void menuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuButtonActionPerformed
        Acceuil.setVisible(true);
        customerLogin.setVisible(false);
        employeeLogin.setVisible(false);
    }//GEN-LAST:event_menuButtonActionPerformed

    private void jPasswordField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField2ActionPerformed

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
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Acceuil;
    private javax.swing.JButton customerButton;
    private javax.swing.JPanel customerLogin;
    private javax.swing.JPanel employeeLogin;
    private javax.swing.JLabel idLabel1;
    private javax.swing.JTextField idTextfield1;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JButton menu1Button;
    private javax.swing.JButton menuButton;
    private javax.swing.JButton okcustButton;
    private javax.swing.JButton okempButton1;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel passwordLabel1;
    private javax.swing.JButton sellerButton;
    private javax.swing.JButton skipButton;
    private javax.swing.JButton skipButton1;
    private javax.swing.JButton skipButton2;
    private javax.swing.JButton subscribeButon;
    private javax.swing.JButton subscribeButton;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JTextField usernameTextfield;
    private javax.swing.JLabel welcomeLabel;
    private javax.swing.JLabel wrongLabel;
    private javax.swing.JLabel wrongLabel1;
    private javax.swing.JLabel you_areLabel;
    // End of variables declaration//GEN-END:variables





}
