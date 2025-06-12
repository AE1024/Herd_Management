/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Pages;

import Core.Database;
import Dao.AnimalDao;
import Dao.Health_RecordDao;
import Entity.Health_Record;
import Entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class Panel3 extends javax.swing.JPanel {

    //Health records panel
    private User user;
    public Panel3(User user) {
        initComponents();
        this.user = user;
            if (user == null) {
        throw new IllegalArgumentException("User cannot be null");
        }

        table();
        combobox();
            
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        health_records_Table = new javax.swing.JTable();
        saveButton = new javax.swing.JToggleButton();
        removeButton = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        healthText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        diagnosisText = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        comboBox = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(250, 250, 250));

        health_records_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "SaglıkID:", "Küpe No:", "Sağlık Durumu:", "Teşhis:"
            }
        ));
        jScrollPane1.setViewportView(health_records_Table);

        saveButton.setBackground(new java.awt.Color(250, 250, 250));
        saveButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        saveButton.setForeground(new java.awt.Color(0, 153, 102));
        saveButton.setText("Kaydet");
        saveButton.setMaximumSize(new java.awt.Dimension(70, 25));
        saveButton.setMinimumSize(new java.awt.Dimension(70, 25));
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        removeButton.setBackground(new java.awt.Color(250, 250, 250));
        removeButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        removeButton.setForeground(new java.awt.Color(0, 153, 102));
        removeButton.setText("Kaldır");
        removeButton.setMaximumSize(new java.awt.Dimension(70, 25));
        removeButton.setMinimumSize(new java.awt.Dimension(70, 25));
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("KüpeNO:");

        jLabel2.setText("Sağlık Durumu:");

        jLabel3.setText("Teşhis:");

        comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(254, 254, 254)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(healthText, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(16, 277, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(254, 254, 254)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(diagnosisText, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(233, 233, 233)
                        .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(healthText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(diagnosisText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void combobox() {
        AnimalDao animalDao = new AnimalDao(this.user);
        List<String> earTags = animalDao.getAllUserEarTags();
        comboBox.removeAllItems();
        
     for (String earTag : earTags) {
        comboBox.addItem(earTag);
        }
    }
    
        public JTable table() {
        
        Health_RecordDao health_RecordDao=new Health_RecordDao();
        List<Health_Record> healthTable = health_RecordDao.findAllHealth_Record();
        
        DefaultTableModel model = (DefaultTableModel) health_records_Table.getModel();
        //clear table
        model.setRowCount(0);
        
        //building
        Object[] Datas;
        for(Health_Record health : healthTable) {
                Datas = new Object[] {
                health.getId(),
                health.getEarTagNumber(),
                health.isHealthCondition(),
                health.getDiagnosis()

            };
            
           model.addRow(Datas);
        } 
        
        return health_records_Table;
        
    }

       public void Remove(){

        Health_RecordDao health_RecordDao = new Health_RecordDao();
        int selectedRow = health_records_Table.getSelectedRow(); // Seçilen satırın indeksi
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Lütfen bir satır seçin!");
            return;
        }
        // Tablodan değerleri Object olarak alıyoruz
     DefaultTableModel model = (DefaultTableModel) health_records_Table.getModel();
        if (selectedRow != -1) {
    int health_id = (int) model.getValueAt(selectedRow, 0);
    boolean success = health_RecordDao.deleteHealth(health_id);
    
    if(success) {
        model.removeRow(selectedRow);
        JOptionPane.showMessageDialog(this, "Saglık kaydı başarıyla silindi.");
             }        
        }
    }
    
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        Health_RecordDao health_RecordDao=new Health_RecordDao();
        String eartag=(String) comboBox.getSelectedItem();
        String tmp = healthText.getText().trim();
        boolean box1Bool = Boolean.parseBoolean(tmp);
        try {
            boolean insert_check = health_RecordDao.checkForHealthRecord(eartag); 
            if(insert_check == false){
                JOptionPane.showMessageDialog(null, "Hayvana ait zaten kayıt var.");
                return;
            }
            health_RecordDao.addHealth_Record(eartag,box1Bool,diagnosisText.getText());
            table();
        } catch (SQLException ex) {
            Logger.getLogger(Panel3.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_saveButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        Remove();
        table();

    }//GEN-LAST:event_removeButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboBox;
    private javax.swing.JTextField diagnosisText;
    private javax.swing.JTextField healthText;
    private javax.swing.JTable health_records_Table;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton removeButton;
    private javax.swing.JToggleButton saveButton;
    // End of variables declaration//GEN-END:variables
}
