/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Core.Helper;
import javax.swing.JFrame;
import javax.swing.JTextField;
import Dao.UserDao;
import Dashboard.Dashboard;
import Entity.User;
/*
 * @author elmaz
 */
public class Login extends javax.swing.JFrame {
 
    /*
     * Creates new form Login
     */
    public Login() {
        initComponents();
        
        this.setTitle("Sürü Yönetim Uygulamması");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        //Helper.setLoginIcon(this);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        loginButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        name_text = new javax.swing.JLabel();
        phone_text = new javax.swing.JLabel();
        phoneTextField = new javax.swing.JTextField();
        pass_text = new javax.swing.JLabel();
        sifreTextField = new javax.swing.JPasswordField();
        registerButton = new javax.swing.JButton();
        check_for_regLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(4, 399));

        loginButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        loginButton.setForeground(new java.awt.Color(0, 153, 51));
        loginButton.setText("Giriş");
        loginButton.setActionCommand("button_giris");
        loginButton.setFocusPainted(false);
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginAction(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 153, 51));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("    Sürü Yönetim Sistemi");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        nameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextFieldActionPerformed(evt);
            }
        });

        name_text.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        name_text.setForeground(new java.awt.Color(0, 0, 0));
        name_text.setText("İsim");

        phone_text.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        phone_text.setForeground(new java.awt.Color(0, 0, 0));
        phone_text.setText("Tel No");

        pass_text.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pass_text.setForeground(new java.awt.Color(0, 0, 0));
        pass_text.setText("Şifre");

        registerButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        registerButton.setForeground(new java.awt.Color(0, 153, 51));
        registerButton.setText("Kayıt Ol");
        registerButton.setActionCommand("button_giris");
        registerButton.setFocusPainted(false);
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registirationAction(evt);
            }
        });

        check_for_regLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        check_for_regLabel.setForeground(new java.awt.Color(0, 153, 153));
        check_for_regLabel.setText("Hesabınız yok mu ? ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(name_text, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phone_text, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pass_text, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sifreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(114, 114, 114))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(loginButton)
                .addGap(71, 71, 71)
                .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(96, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(check_for_regLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(name_text)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(phone_text)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pass_text)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sifreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(check_for_regLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginButton)
                    .addComponent(registerButton))
                .addGap(116, 116, 116))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginAction
        // TODO add your handling code here:
        JTextField[] fields = {this.nameTextField,this.phoneTextField};
        if(Helper.isFieldsEmpty(fields)) {
            Helper.showMsg("empty");
        }
        else if(Helper.isFieldEmpty(sifreTextField)){
            Helper.showMsg("error");
        }
        else {
            Helper.isPhoneValidate(phoneTextField);
            UserDao userdao = new UserDao();
            String isim = nameTextField.getText();
            String tel = phoneTextField.getText();
            String sifre = new String(sifreTextField.getPassword());
            
            User user = userdao.findbyLogin(isim, tel, sifre);
            if(user == null) {
                Helper.showMsg("Hesap bulunamadı.Kayıt işlemi yapın.");
                
            }else {
             this.dispose(); 
             Dashboard dashboard = new Dashboard(user);
             dashboard.setVisible(true);
            }
        }
    
    }//GEN-LAST:event_loginAction

    private void nameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextFieldActionPerformed

    private void registirationAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registirationAction
           
        this.dispose();
        Registiration registiration = new Registiration(); 
        
    }//GEN-LAST:event_registirationAction
  
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                 new Login().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel check_for_regLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton loginButton;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JLabel name_text;
    private javax.swing.JLabel pass_text;
    private javax.swing.JTextField phoneTextField;
    private javax.swing.JLabel phone_text;
    private javax.swing.JButton registerButton;
    private javax.swing.JPasswordField sifreTextField;
    // End of variables declaration//GEN-END:variables
}
