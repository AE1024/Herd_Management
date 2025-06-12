/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Dashboard;

import Entity.User;
import Pages.*;
import View.Login;
import javax.swing.JFrame;

public class Dashboard extends javax.swing.JFrame {
    private User user;   
    private Panel1 a;
    private Panel2 b;
    private Panel3 c;
    private Panel4 d;
    
    public Dashboard(User user) {
        initComponents();
        this.user = user;
           if (user == null) {
                throw new IllegalArgumentException("User cannot be null");
            }
        this.setLocationRelativeTo(null);
        
        a = new Panel1(this.user);
        b = new Panel2(this.user);
        c = new Panel3(this.user);
        d = new Panel4(this.user);
        
        main.add(a);
        main.add(b);
        main.add(c);
        main.add(d); 
        a.setVisible(false);
        b.setVisible(false);
        c.setVisible(false);
        d.setVisible(false); 
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Sürü Yönetim Sistemi");
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        HayvanKayit = new javax.swing.JButton();
        bakimKayit = new javax.swing.JButton();
        SaglikKayit = new javax.swing.JButton();
        hatirlatici = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cikis = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        main = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 500));

        jPanel1.setBackground(new java.awt.Color(0, 153, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(175, 465));

        HayvanKayit.setBackground(new java.awt.Color(250, 250, 250));
        HayvanKayit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        HayvanKayit.setForeground(new java.awt.Color(0, 153, 51));
        HayvanKayit.setText("Hayvan Kayıt");
        HayvanKayit.setOpaque(true);
        HayvanKayit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HayvanKayitActionPerformed(evt);
            }
        });

        bakimKayit.setBackground(new java.awt.Color(250, 250, 250));
        bakimKayit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bakimKayit.setForeground(new java.awt.Color(0, 153, 51));
        bakimKayit.setText("Bakım Kayıt");
        bakimKayit.setOpaque(true);
        bakimKayit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bakimKayitActionPerformed(evt);
            }
        });

        SaglikKayit.setBackground(new java.awt.Color(250, 250, 250));
        SaglikKayit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SaglikKayit.setForeground(new java.awt.Color(0, 153, 0));
        SaglikKayit.setText("Sağlık Kayıt");
        SaglikKayit.setOpaque(true);
        SaglikKayit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaglikKayitActionPerformed(evt);
            }
        });

        hatirlatici.setBackground(new java.awt.Color(250, 250, 250));
        hatirlatici.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        hatirlatici.setForeground(new java.awt.Color(0, 153, 51));
        hatirlatici.setText("Hatırlatıcı");
        hatirlatici.setOpaque(true);
        hatirlatici.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hatirlaticiActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Hoşgeldiniz");

        cikis.setBackground(new java.awt.Color(255, 255, 255));
        cikis.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cikis.setForeground(new java.awt.Color(0, 153, 51));
        cikis.setText("Çıkış");
        cikis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cikisActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\elmaz\\Downloads\\goat (1).png")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(HayvanKayit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SaglikKayit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bakimKayit, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                    .addComponent(hatirlatici, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1)))
                            .addComponent(cikis))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(HayvanKayit)
                .addGap(18, 18, 18)
                .addComponent(bakimKayit)
                .addGap(18, 18, 18)
                .addComponent(SaglikKayit)
                .addGap(18, 18, 18)
                .addComponent(hatirlatici)
                .addGap(64, 64, 64)
                .addComponent(cikis, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_START);

        main.setPreferredSize(new java.awt.Dimension(1000, 500));
        main.setLayout(new java.awt.CardLayout());
        getContentPane().add(main, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void HayvanKayitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HayvanKayitActionPerformed
        a.setVisible(true);
        b.setVisible(false);
        c.setVisible(false);
        d.setVisible(false);
    }//GEN-LAST:event_HayvanKayitActionPerformed

    private void bakimKayitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bakimKayitActionPerformed
        a.setVisible(false);
        b.setVisible(true);
        c.setVisible(false);
        d.setVisible(false);
    }//GEN-LAST:event_bakimKayitActionPerformed

    private void SaglikKayitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaglikKayitActionPerformed
        a.setVisible(false);
        b.setVisible(false);
        c.setVisible(true);
        d.setVisible(false);
    }//GEN-LAST:event_SaglikKayitActionPerformed

    private void hatirlaticiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hatirlaticiActionPerformed
        a.setVisible(false);
        b.setVisible(false);
        c.setVisible(false);
        d.setVisible(true);
    }//GEN-LAST:event_hatirlaticiActionPerformed

    private void cikisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cikisActionPerformed
        this.dispose();
        Login login = new Login();
        login.setVisible(true);
    }//GEN-LAST:event_cikisActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton HayvanKayit;
    private javax.swing.JButton SaglikKayit;
    private javax.swing.JButton bakimKayit;
    private javax.swing.JButton cikis;
    private javax.swing.JButton hatirlatici;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLayeredPane main;
    // End of variables declaration//GEN-END:variables
}
