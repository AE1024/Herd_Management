/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Pages;

import Core.Database;
import Dao.AnimalDao;
import Dao.MaintenanceDao;
import Dao.ReminderDao;
import Entity.Maintenance;
import Entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
 
public class Panel2 extends javax.swing.JPanel {

    //Maintenance panel
    private User user;
    public Panel2(User user) {
        initComponents();
        this.user = user;
            if (user == null) {
        throw new IllegalArgumentException("User cannot be null");
    }
        loadAllearTags();
        builtMaintenanceTable();
    }
    private Connection connection;
    
    //get all ear tag numbers
    public void loadAllearTags(){
        AnimalDao animalDao = new AnimalDao(this.user);
        List<String> earTags = animalDao.getEarTagsByUserId();
        earTagComboBox.removeAllItems();
        
     for (String earTag : earTags) {
        earTagComboBox.addItem(earTag);
        }
    }
    
    //creating table
    public JTable builtMaintenanceTable() {
        MaintenanceDao maintenanceDao = new MaintenanceDao(this.user);
        List<Maintenance> maintenancesTable = maintenanceDao.getAllMaintenanceRecords();
        
        DefaultTableModel model = (DefaultTableModel) maintenanceTable.getModel();
        //clear table
        model.setRowCount(0);
        
        //building
        Object[] Datas;
        for(Maintenance maintenance : maintenancesTable) {
                Datas = new Object[] {
                maintenance.getMaintenanceId(),
                maintenance.getEarTagNumber(),
                maintenance.getVaccinationCheckDate(),
                maintenance.getNailCheckDate(),
                maintenance.getVeterinarianCheckDate(),
                maintenance.getBirthControlDate(),
                maintenance.getMatingCheckDate()
            };
            
           model.addRow(Datas);
        } 
        return maintenanceTable;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bakimScroll = new javax.swing.JScrollPane();
        maintenanceTable = new javax.swing.JTable();
        saveButton = new javax.swing.JToggleButton();
        removeButton = new javax.swing.JToggleButton();
        jLabel6 = new javax.swing.JLabel();
        vaccineText = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        nailText = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        birthText = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        matText = new javax.swing.JTextField();
        vetText = new javax.swing.JTextField();
        earTagComboBox = new javax.swing.JComboBox<>();
        refreshButton = new javax.swing.JButton();
        changeButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(250, 250, 250));

        maintenanceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Bakım No:", "Küpe No:", "Aşı Kontrol Tarihi:", "Tırnak Kontrol Tarihi:", "Veteriner Kontrol Tarihi:", "Doğum Kontrol Tarihi:", "Çifleşme Tarihi:"
            }
        ));
        maintenanceTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                maintenanceTableMouseClicked(evt);
            }
        });
        bakimScroll.setViewportView(maintenanceTable);

        saveButton.setBackground(new java.awt.Color(250, 250, 250));
        saveButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        saveButton.setForeground(new java.awt.Color(0, 153, 51));
        saveButton.setText("Kaydet");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        removeButton.setBackground(new java.awt.Color(250, 250, 250));
        removeButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        removeButton.setForeground(new java.awt.Color(0, 153, 51));
        removeButton.setText("Kaldır");
        removeButton.setOpaque(true);
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        jLabel6.setText("Aşı Kontrol Tarihi:");

        jLabel7.setText("Tırnak Kontrol Tarihi:");

        jLabel8.setText("Doğum Kontrol Tarihi:");

        jLabel9.setText(" Çiftleşme Tarihi:");

        jLabel10.setText("Veteriner Kontrol Tarihi:");

        earTagComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        earTagComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item  4" }));

        refreshButton.setBackground(new java.awt.Color(255, 255, 255));
        refreshButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        refreshButton.setForeground(new java.awt.Color(0, 153, 51));
        refreshButton.setText("Temizle");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        changeButton.setBackground(new java.awt.Color(255, 255, 255));
        changeButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        changeButton.setForeground(new java.awt.Color(0, 153, 51));
        changeButton.setText("Değistir");
        changeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeButton(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nailText, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(vaccineText, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(matText, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(vetText, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(birthText, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(earTagComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(refreshButton)))
                    .addComponent(bakimScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 808, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(changeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bakimScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel6)
                            .addComponent(vaccineText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(nailText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(vetText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(earTagComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(birthText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(matText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(refreshButton)
                    .addComponent(removeButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(changeButton)
                .addContainerGap(71, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    //remove data from table
    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
    int row = maintenanceTable.getSelectedRow();

    if (row == -1) {
        JOptionPane.showMessageDialog(this, "Lütfen silmek istediğiniz satırı seçiniz.");
        return;
    }

    DefaultTableModel model = (DefaultTableModel) maintenanceTable.getModel();

    int maintenanceId = (int) model.getValueAt(row, 0);
    MaintenanceDao maintenanceDao = new MaintenanceDao(this.user);
    boolean success = maintenanceDao.deleteMaintenance(maintenanceId);
    
    if(success) {
        model.removeRow(row);
        JOptionPane.showMessageDialog(this, "Bakım kaydı başarıyla silindi.");
    }

    }//GEN-LAST:event_removeButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
       //get texts from user
       String asiKOntrol = this.vaccineText.getText();
       String tirnakKontrol = this.nailText.getText();
       String vetKontrol = this.vetText.getText();
       String dogumKontrol = this.birthText.getText();
       String ciftKontrol = this.matText.getText();
       
       
       SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        
        try {
            //default null values
        java.sql.Date sqlDate1 = null;
        java.sql.Date sqlDate2 = null;
        java.sql.Date sqlDate3 = null;
        java.sql.Date sqlDate4 = null;
        java.sql.Date sqlDate5 = null;
         
        //checking if it is filled and get date
        if (!asiKOntrol.isEmpty()) {
            java.util.Date utilDate1 = formatter.parse(asiKOntrol);
            sqlDate1 = new java.sql.Date(utilDate1.getTime());
        }
        
        if (!tirnakKontrol.isEmpty()) {
            java.util.Date utilDate2 = formatter.parse(tirnakKontrol);
            sqlDate2 = new java.sql.Date(utilDate2.getTime());
        }
        
        if (!vetKontrol.isEmpty()) {
            java.util.Date utilDate3 = formatter.parse(vetKontrol);
            sqlDate3 = new java.sql.Date(utilDate3.getTime());
        }
        
        if (!dogumKontrol.isEmpty()) {
            java.util.Date utilDate4 = formatter.parse(dogumKontrol);
            sqlDate4 = new java.sql.Date(utilDate4.getTime());
        }
        
        if (!ciftKontrol.isEmpty()) {
            java.util.Date utilDate5 = formatter.parse(ciftKontrol);
            sqlDate5 = new java.sql.Date(utilDate5.getTime());
        }
        //calling with user
        MaintenanceDao maintenanceDao = new MaintenanceDao(this.user);
        Maintenance maintenance = new Maintenance();
        
        String selectedAnimal = (String) earTagComboBox.getSelectedItem(); 
        
        //checking
        if (maintenanceDao.maintenanceCheck(selectedAnimal)) {
        JOptionPane.showMessageDialog(this, "Bu hayvan için zaten bir bakım kaydı bulunuyor.");
            return;
        }
        

        maintenance = maintenanceDao.addMaintenanceDate(selectedAnimal, sqlDate1, sqlDate2, sqlDate3, sqlDate4, sqlDate5);
        if(maintenance != null) {
                
               builtMaintenanceTable();
           }
            
        } catch (ParseException ex) {
            Logger.getLogger(Panel2.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(earTagComboBox, ex);
        }

    }//GEN-LAST:event_saveButtonActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        vaccineText.setText("");
        matText.setText("");
        birthText.setText("");
        nailText.setText("");
        vetText.setText("");
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void changeButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeButton
        
               //get texts from user
       String asiKOntrol = this.vaccineText.getText();
       String tirnakKontrol = this.nailText.getText();
       String vetKontrol = this.vetText.getText();
       String dogumKontrol = this.birthText.getText();
       String ciftKontrol = this.matText.getText();
       
       
       SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
       
        int selectedRow = maintenanceTable.getSelectedRow();
        if(selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Satır seçiniz.");
            return;
        }
        int maintenanceId = (int) maintenanceTable.getModel().getValueAt(selectedRow, 0);
        String earTagNumber = (String) maintenanceTable.getModel().getValueAt(selectedRow, 1);
        try {


            //default null values
        java.sql.Date sqlDate1 = null;
        java.sql.Date sqlDate2 = null;
        java.sql.Date sqlDate3 = null;
        java.sql.Date sqlDate4 = null;
        java.sql.Date sqlDate5 = null;
         
        //checking if it is filled and get date
        if (!asiKOntrol.isEmpty()) {
            java.util.Date utilDate1 = formatter.parse(asiKOntrol);
            sqlDate1 = new java.sql.Date(utilDate1.getTime());
        }
        
        if (!tirnakKontrol.isEmpty()) {
            java.util.Date utilDate2 = formatter.parse(tirnakKontrol);
            sqlDate2 = new java.sql.Date(utilDate2.getTime());
        }
        
        if (!vetKontrol.isEmpty()) {
            java.util.Date utilDate3 = formatter.parse(vetKontrol);
            sqlDate3 = new java.sql.Date(utilDate3.getTime());
        }
        
        if (!dogumKontrol.isEmpty()) {
            java.util.Date utilDate4 = formatter.parse(dogumKontrol);
            sqlDate4 = new java.sql.Date(utilDate4.getTime());
        }
        
        if (!ciftKontrol.isEmpty()) {
            java.util.Date utilDate5 = formatter.parse(ciftKontrol);
            sqlDate5 = new java.sql.Date(utilDate5.getTime());
        }
        //calling with user
        MaintenanceDao maintenanceDao = new MaintenanceDao(this.user);
            boolean result = maintenanceDao.updateMaintenanceDate(maintenanceId, earTagNumber,sqlDate1, sqlDate2, sqlDate3, sqlDate4, sqlDate5);
            
            if(result == true) {  
                //updated maintenance record
                Maintenance maintenance = maintenanceDao.getMaintenanceById(maintenanceId);
                
               ReminderDao reminderDao = new ReminderDao(this.user);
               
               if(sqlDate1 != null) {
                   reminderDao.updateReminder(maintenance, sqlDate1, maintenanceId);
               }

                if(sqlDate2 != null) {
                   reminderDao.updateReminder(maintenance, sqlDate2, maintenanceId);
               }
                 if(sqlDate3 != null) {
                   reminderDao.updateReminder(maintenance, sqlDate3, maintenanceId);
               }
                                             
                if(sqlDate4 != null) {
                   reminderDao.updateReminder(maintenance, sqlDate4, maintenanceId);
               }
                               
                if(sqlDate5 != null) {
                   reminderDao.updateReminder(maintenance, sqlDate5, maintenanceId);
               }
                
                builtMaintenanceTable();
           }
            
        } catch (ParseException ex) {
            Logger.getLogger(Panel2.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(earTagComboBox, ex);
        }  
        
    }//GEN-LAST:event_changeButton

    private void maintenanceTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maintenanceTableMouseClicked
          connection = Database.getDatabase();
        try {
            int selectedRow = maintenanceTable.getSelectedRow();
            int table_value1 = (int) maintenanceTable.getModel().getValueAt(selectedRow, 0);
            
            String sql =  "Select * from Maintenance where maintenance_id = ?";
            PreparedStatement pstm = connection.prepareStatement(sql);
            
            pstm.setInt(1, table_value1);
            ResultSet rs = pstm.executeQuery();            
            if(rs.next()) {  
                if(rs.getDate("vaccinationCheckDate") != null) {
                    vaccineText.setText(rs.getDate("vaccinationCheckDate").toString());                
                }else vaccineText.setText("");
                if(rs.getDate("nailCheckDate") != null){
                    nailText.setText(rs.getDate("nailCheckDate").toString());
                }else nailText.setText("");
                if(rs.getDate("veterinarianCheckDate") != null){
                   vetText.setText(rs.getDate("veterinarianCheckDate").toString()); 
                }else vetText.setText("");
                if(rs.getDate("birthControlDate") != null){
                    birthText.setText(rs.getDate("birthControlDate").toString());
                }else birthText.setText("");
                if(rs.getDate("matingCheckDate") != null){
                    matText.setText(rs.getDate("matingCheckDate").toString());                    
                }else matText.setText("");       
                
                earTagComboBox.setSelectedItem(rs.getString("earTagNumber"));
                
                
            }
            
        } catch (SQLException ex){
            Logger.getLogger(Panel2.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Veritabanı hatası: " + ex.getMessage());
        }
        
        
    }//GEN-LAST:event_maintenanceTableMouseClicked

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane bakimScroll;
    private javax.swing.JTextField birthText;
    private javax.swing.JButton changeButton;
    private javax.swing.JComboBox<String> earTagComboBox;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTable maintenanceTable;
    private javax.swing.JTextField matText;
    private javax.swing.JTextField nailText;
    private javax.swing.JButton refreshButton;
    private javax.swing.JToggleButton removeButton;
    private javax.swing.JToggleButton saveButton;
    private javax.swing.JTextField vaccineText;
    private javax.swing.JTextField vetText;
    // End of variables declaration//GEN-END:variables
}
