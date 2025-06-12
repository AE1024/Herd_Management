
package Pages;

import Dao.ReminderDao;
import Entity.Reminder;
import Entity.User;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Panel4 extends javax.swing.JPanel {

    //Reminder panel
    private User user;
    public Panel4(User user) {
        initComponents();
        this.user = user;
            if (user == null) {
        throw new IllegalArgumentException("User cannot be null");
        }
            
        buildReminderTable(); 
    }
    
    public JTable buildReminderTable() {
        ReminderDao reminderdao = new ReminderDao(this.user);
        reminderdao.checkReminderforDifferentDates();
        List<Reminder> reminders = reminderdao.getAllReminderRecords();
        
        DefaultTableModel model = (DefaultTableModel) reminderTable.getModel();
        
        model.setRowCount(0);
        
        Object[] Datas;
        for(Reminder reminder : reminders) {
            Datas = new Object[] {
                reminder.getReminder_id(),
                reminder.getMaintenance_id(),
                reminder.getAnimalEarTagNumber(),
                reminder.getPhoneNumber(),
                reminder.isSent(),
                reminder.getReminder_date()
        
            };
            model.addRow(Datas);
        } 
        return reminderTable;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        refreshButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        reminderTable = new javax.swing.JTable();

        setBackground(new java.awt.Color(250, 250, 250));

        refreshButton.setBackground(new java.awt.Color(255, 255, 255));
        refreshButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        refreshButton.setForeground(new java.awt.Color(0, 153, 51));
        refreshButton.setText("Yenile");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        reminderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Hatırlatıcı No:", "Bakım No:", "Küpe No:", "Telefon No:", "Gonderildi mi?:", "Hatırlatıcı Tarih:"
            }
        ));
        jScrollPane1.setViewportView(reminderTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(refreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(436, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(refreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(154, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        buildReminderTable();
                 
    }//GEN-LAST:event_refreshButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton refreshButton;
    private javax.swing.JTable reminderTable;
    // End of variables declaration//GEN-END:variables
}
