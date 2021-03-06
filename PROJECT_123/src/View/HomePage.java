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
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.sql.ResultSet;
import java.sql.SQLException;


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
        customerLogin.setVisible(false);
        employeeLogin.setVisible(false);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        Acceuil = new javax.swing.JPanel();
        welcomeLabel = new javax.swing.JLabel();
        custButtonLabel = new javax.swing.JLabel();
        empButtonLabel = new javax.swing.JLabel();
        exitLabel = new javax.swing.JLabel();
        customerLogin = new javax.swing.JPanel();
        usernameLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        usernameTextfield = new javax.swing.JTextField();
        subscribecustButon = new javax.swing.JButton();
        wrongLabel = new javax.swing.JLabel();
        imageLabel = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        exitLabel1 = new javax.swing.JLabel();
        LoginIconLabel = new javax.swing.JLabel();
        homeLabel = new javax.swing.JLabel();
        okcustButtonLabel = new javax.swing.JLabel();
        employeeLogin = new javax.swing.JPanel();
        idTextfield1 = new javax.swing.JTextField();
        subscribeempButton = new javax.swing.JButton();
        wrongLabel1 = new javax.swing.JLabel();
        logoLabel = new javax.swing.JLabel();
        jPasswordField2 = new javax.swing.JPasswordField();
        homeLabel1 = new javax.swing.JLabel();
        exitLabel2 = new javax.swing.JLabel();
        LoginIconLabel1 = new javax.swing.JLabel();
        usernameLabel1 = new javax.swing.JLabel();
        passwordLabel2 = new javax.swing.JLabel();
        okempButtonLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLayeredPane1.setPreferredSize(new java.awt.Dimension(850, 600));
        jLayeredPane1.setRequestFocusEnabled(false);

        Acceuil.setPreferredSize(new java.awt.Dimension(850, 600));
        Acceuil = new javax.swing.JPanel() {
            protected void paintComponent(Graphics g) {
                if (g instanceof Graphics2D) {
                    final int R = 200;
                    final int G = 0;
                    final int B = 100;
                    //new GradientPaint(0.0f, 0.0f, new Color(R, G, B, 0),
                        Paint p =
                        new GradientPaint(0, 0,Color.PINK, 100,getHeight(), Color.WHITE);
                        //getWidth(), getHeight(), new Color(R, G, B, 255), true);
                    Graphics2D g2d = (Graphics2D)g;
                    //  g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                    // g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    g2d.setPaint(p);
                    g2d.fillRect(0, 0, getWidth(), getHeight());
                } else {
                    super.paintComponent(g);
                }
            }
        };

        welcomeLabel.setFont(new java.awt.Font("Impact", 0, 48)); // NOI18N
        welcomeLabel.setForeground(new java.awt.Color(171, 66, 79));
        welcomeLabel.setText("WECOME TO OUR STORE");

        custButtonLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/custbutton.png"))); // NOI18N
        custButtonLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                custButtonLabelMouseClicked(evt);
            }
        });

        empButtonLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/empbutton.png"))); // NOI18N
        empButtonLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                empButtonLabelMouseClicked(evt);
            }
        });

        exitLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/exiticon.png"))); // NOI18N
        exitLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout AcceuilLayout = new javax.swing.GroupLayout(Acceuil);
        Acceuil.setLayout(AcceuilLayout);
        AcceuilLayout.setHorizontalGroup(
            AcceuilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AcceuilLayout.createSequentialGroup()
                .addGap(310, 310, 310)
                .addGroup(AcceuilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(empButtonLabel)
                    .addComponent(custButtonLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(AcceuilLayout.createSequentialGroup()
                .addGap(186, 186, 186)
                .addComponent(welcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                .addComponent(exitLabel)
                .addGap(24, 24, 24))
        );
        AcceuilLayout.setVerticalGroup(
            AcceuilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AcceuilLayout.createSequentialGroup()
                .addGroup(AcceuilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AcceuilLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(welcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AcceuilLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(exitLabel)))
                .addGap(100, 100, 100)
                .addComponent(custButtonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(empButtonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        customerLogin.setBackground(new java.awt.Color(204, 204, 255));
        customerLogin.setPreferredSize(new java.awt.Dimension(850, 600));
        customerLogin.setRequestFocusEnabled(false);

        usernameLabel.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        usernameLabel.setForeground(new java.awt.Color(255, 255, 255));
        usernameLabel.setText("Username");

        passwordLabel.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(255, 255, 255));
        passwordLabel.setText("Password");

        usernameTextfield.setBackground(new java.awt.Color(204, 204, 255));
        usernameTextfield.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 255, 255)));
        usernameTextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameTextfieldActionPerformed(evt);
            }
        });

        subscribecustButon.setBackground(new java.awt.Color(255, 255, 255));
        subscribecustButon.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        subscribecustButon.setForeground(new java.awt.Color(204, 204, 255));
        subscribecustButon.setText("You don't have an account? Sign in");
        subscribecustButon.setBorder(null);
        subscribecustButon.setBorderPainted(false);
        subscribecustButon.setOpaque(true);
        subscribecustButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subscribecustButonActionPerformed(evt);
            }
        });

        wrongLabel.setForeground(new java.awt.Color(255, 0, 0));

        jPasswordField1.setBackground(new java.awt.Color(204, 204, 255));
        jPasswordField1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 255, 255)));

        exitLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/exiticon.png"))); // NOI18N
        exitLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitLabel1MouseClicked(evt);
            }
        });

        LoginIconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/loginIcon.png"))); // NOI18N

        homeLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/homeIcon.png"))); // NOI18N
        homeLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeLabelMouseClicked(evt);
            }
        });

        okcustButtonLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/okIcon.png"))); // NOI18N
        okcustButtonLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                okcustButtonLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout customerLoginLayout = new javax.swing.GroupLayout(customerLogin);
        customerLogin.setLayout(customerLoginLayout);
        customerLoginLayout.setHorizontalGroup(
            customerLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerLoginLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(customerLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(customerLoginLayout.createSequentialGroup()
                        .addComponent(homeLabel)
                        .addContainerGap())
                    .addGroup(customerLoginLayout.createSequentialGroup()
                        .addGroup(customerLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(LoginIconLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(customerLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(customerLoginLayout.createSequentialGroup()
                                .addGap(142, 142, 142)
                                .addGroup(customerLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(usernameTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(usernameLabel)
                                    .addComponent(passwordLabel)
                                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(wrongLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customerLoginLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(exitLabel1)
                                .addGap(25, 25, 25))))))
            .addGroup(customerLoginLayout.createSequentialGroup()
                .addGroup(customerLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(customerLoginLayout.createSequentialGroup()
                        .addGap(364, 364, 364)
                        .addComponent(okcustButtonLabel))
                    .addGroup(customerLoginLayout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addComponent(subscribecustButon, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 286, Short.MAX_VALUE))
        );
        customerLoginLayout.setVerticalGroup(
            customerLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customerLoginLayout.createSequentialGroup()
                .addGroup(customerLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(customerLoginLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(imageLabel))
                    .addGroup(customerLoginLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(exitLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(customerLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LoginIconLabel)
                    .addComponent(usernameLabel))
                .addGap(27, 27, 27)
                .addComponent(usernameTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(passwordLabel)
                .addGap(18, 18, 18)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(wrongLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(okcustButtonLabel)
                .addGap(44, 44, 44)
                .addGroup(customerLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(subscribecustButon)
                    .addComponent(homeLabel))
                .addGap(126, 126, 126))
        );

        employeeLogin.setBackground(new java.awt.Color(0, 153, 153));
        employeeLogin.setPreferredSize(new java.awt.Dimension(850, 600));

        idTextfield1.setBackground(new java.awt.Color(0, 153, 153));
        idTextfield1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 255, 255)));
        idTextfield1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idTextfield1ActionPerformed(evt);
            }
        });

        subscribeempButton.setBackground(new java.awt.Color(255, 255, 255));
        subscribeempButton.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        subscribeempButton.setForeground(new java.awt.Color(0, 153, 153));
        subscribeempButton.setText("You don't have an account? Sign in");
        subscribeempButton.setBorder(null);
        subscribeempButton.setBorderPainted(false);
        subscribeempButton.setOpaque(true);
        subscribeempButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subscribeempButtonActionPerformed(evt);
            }
        });

        wrongLabel1.setBackground(new java.awt.Color(0, 153, 153));
        wrongLabel1.setForeground(new java.awt.Color(255, 0, 0));

        jPasswordField2.setBackground(new java.awt.Color(0, 153, 153));
        jPasswordField2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 255, 255)));
        jPasswordField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField2ActionPerformed(evt);
            }
        });

        homeLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/homeIcon.png"))); // NOI18N
        homeLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeLabel1MouseClicked(evt);
            }
        });

        exitLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/exiticon.png"))); // NOI18N
        exitLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitLabel2MouseClicked(evt);
            }
        });

        LoginIconLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/loginIcon.png"))); // NOI18N

        usernameLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        usernameLabel1.setForeground(new java.awt.Color(255, 255, 255));
        usernameLabel1.setText("Username");

        passwordLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        passwordLabel2.setForeground(new java.awt.Color(255, 255, 255));
        passwordLabel2.setText("Password");

        okempButtonLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/okIcon2.png"))); // NOI18N
        okempButtonLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                okempButtonLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout employeeLoginLayout = new javax.swing.GroupLayout(employeeLogin);
        employeeLogin.setLayout(employeeLoginLayout);
        employeeLoginLayout.setHorizontalGroup(
            employeeLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, employeeLoginLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exitLabel2)
                .addGap(40, 40, 40))
            .addGroup(employeeLoginLayout.createSequentialGroup()
                .addGroup(employeeLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(employeeLoginLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(employeeLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LoginIconLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(homeLabel1))
                        .addGap(144, 144, 144)
                        .addGroup(employeeLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usernameLabel1)
                            .addComponent(idTextfield1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordLabel2)
                            .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(228, 228, 228)
                        .addComponent(logoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(employeeLoginLayout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addComponent(subscribeempButton, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(employeeLoginLayout.createSequentialGroup()
                        .addGap(368, 368, 368)
                        .addGroup(employeeLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(wrongLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(okempButtonLabel))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        employeeLoginLayout.setVerticalGroup(
            employeeLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(employeeLoginLayout.createSequentialGroup()
                .addGroup(employeeLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(employeeLoginLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(LoginIconLabel1))
                    .addGroup(employeeLoginLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(exitLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(logoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(334, 334, 334)
                .addComponent(homeLabel1)
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, employeeLoginLayout.createSequentialGroup()
                .addComponent(usernameLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idTextfield1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(passwordLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(wrongLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(okempButtonLabel)
                .addGap(18, 18, 18)
                .addComponent(subscribeempButton)
                .addGap(94, 94, 94))
        );

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Acceuil, javax.swing.GroupLayout.DEFAULT_SIZE, 870, Short.MAX_VALUE)
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(customerLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 870, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(employeeLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 870, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Acceuil, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(customerLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(employeeLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE))
        );
        jLayeredPane1.setLayer(Acceuil, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(customerLogin, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(employeeLogin, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 870, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idTextfield1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idTextfield1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idTextfield1ActionPerformed

    private void subscribeempButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subscribeempButtonActionPerformed
        setVisible(false);
        new SubscribeE().setVisible(true); 
    }//GEN-LAST:event_subscribeempButtonActionPerformed

    private void subscribecustButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subscribecustButonActionPerformed
        setVisible(false);
        new SubscribeC().setVisible(true);

    }//GEN-LAST:event_subscribecustButonActionPerformed

    private void usernameTextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameTextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameTextfieldActionPerformed

    private void jPasswordField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField2ActionPerformed

    private void empButtonLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_empButtonLabelMouseClicked
        // TODO add your handling code here:
        Acceuil.setVisible(false);
        customerLogin.setVisible(false);
        employeeLogin.setVisible(true);
    }//GEN-LAST:event_empButtonLabelMouseClicked

    private void custButtonLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_custButtonLabelMouseClicked
        // TODO add your handling code here:
        Acceuil.setVisible(false);
        customerLogin.setVisible(true);
        employeeLogin.setVisible(false);

    }//GEN-LAST:event_custButtonLabelMouseClicked

    private void exitLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitLabelMouseClicked
        // TODO add your handling code here:
         System.exit(0);
    }//GEN-LAST:event_exitLabelMouseClicked

    private void exitLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitLabel1MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitLabel1MouseClicked

    private void homeLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeLabelMouseClicked
        // TODO add your handling code here:
         Acceuil.setVisible(true);
        customerLogin.setVisible(false);
        employeeLogin.setVisible(false);
    }//GEN-LAST:event_homeLabelMouseClicked

    private void okcustButtonLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_okcustButtonLabelMouseClicked
        // TODO add your handling code here:
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
                custConnected.setCustomerEmail(rst.getString("email"));
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
    }//GEN-LAST:event_okcustButtonLabelMouseClicked

    private void homeLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeLabel1MouseClicked
        // TODO add your handling code here:
        Acceuil.setVisible(true);
        customerLogin.setVisible(false);
        employeeLogin.setVisible(false);
    }//GEN-LAST:event_homeLabel1MouseClicked

    private void exitLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitLabel2MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitLabel2MouseClicked

    private void okempButtonLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_okempButtonLabelMouseClicked
        // TODO add your handling code here:
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
    }//GEN-LAST:event_okempButtonLabelMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Acceuil;
    private javax.swing.JLabel LoginIconLabel;
    private javax.swing.JLabel LoginIconLabel1;
    private javax.swing.JLabel custButtonLabel;
    private javax.swing.JPanel customerLogin;
    private javax.swing.JLabel empButtonLabel;
    private javax.swing.JPanel employeeLogin;
    private javax.swing.JLabel exitLabel;
    private javax.swing.JLabel exitLabel1;
    private javax.swing.JLabel exitLabel2;
    private javax.swing.JLabel homeLabel;
    private javax.swing.JLabel homeLabel1;
    private javax.swing.JTextField idTextfield1;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JLabel okcustButtonLabel;
    private javax.swing.JLabel okempButtonLabel;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel passwordLabel2;
    private javax.swing.JButton subscribecustButon;
    private javax.swing.JButton subscribeempButton;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JLabel usernameLabel1;
    private javax.swing.JTextField usernameTextfield;
    private javax.swing.JLabel welcomeLabel;
    private javax.swing.JLabel wrongLabel;
    private javax.swing.JLabel wrongLabel1;
    // End of variables declaration//GEN-END:variables
}

