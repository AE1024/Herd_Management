package Pages;
import Dao.AnimalDao;
import Entity.Animal;
import Entity.User;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
 
public class Panel1 extends javax.swing.JPanel {

    //animal panel
    private User user;
    public Panel1(User user) {
        initComponents();
        this.user = user;
            if (user == null) {
        throw new IllegalArgumentException("User cannot be null");
        }
         
        builtAnimalTable();
           
    }
    
    public JTable builtAnimalTable(){
        AnimalDao animalDao = new AnimalDao(this.user);
        List<Animal> animalsTable = animalDao.findAllAnimalsByUserId();
        
        DefaultTableModel model = (DefaultTableModel) animalTable.getModel();
        model.setRowCount(0); // Clear existing data
    
    // Populate table
    for (Animal animal : animalsTable) {
        model.addRow(new Object[]{
            animal.getEarTagNumber(),
            animal.getUser_id(),
            animal.getParentEarTagNumber(),
            animal.getType(),
            animal.getBreed(),
            animal.getBirthDate(),
            animal.getGender(),
            animal.getWeight(),
            animal.getHasOffspring() ? "Var" : "Yok"
        });
    }
    return animalTable;
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        animalTable = new javax.swing.JTable();
        saveButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        earTagText = new javax.swing.JTextField();
        genderText = new javax.swing.JTextField();
        parentText = new javax.swing.JTextField();
        birthDateText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        typeText = new javax.swing.JTextField();
        breedText = new javax.swing.JTextField();
        weightText = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        hasOffspringText = new javax.swing.JTextField();

        setBackground(new java.awt.Color(250, 250, 250));
        setPreferredSize(new java.awt.Dimension(950, 460));

        animalTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Küpe No:", "Kullanıcı ID", "Ebevyn Küpe No:", "Hayvan Tipi:", "Hayvan Irkı:", "Doğum Tarihi:", "Cinsiyet:", "Ağırlık:", "Yavru/Var-Yok"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(animalTable);
        if (animalTable.getColumnModel().getColumnCount() > 0) {
            animalTable.getColumnModel().getColumn(0).setResizable(false);
            animalTable.getColumnModel().getColumn(2).setResizable(false);
            animalTable.getColumnModel().getColumn(3).setResizable(false);
            animalTable.getColumnModel().getColumn(4).setResizable(false);
            animalTable.getColumnModel().getColumn(5).setResizable(false);
            animalTable.getColumnModel().getColumn(6).setResizable(false);
        }

        saveButton.setBackground(new java.awt.Color(250, 250, 250));
        saveButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        saveButton.setForeground(new java.awt.Color(0, 153, 51));
        saveButton.setText("Kaydet");
        saveButton.setOpaque(true);
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

        jLabel1.setText("KüpeNo:");

        jLabel2.setText("Cinsiyet:");

        jLabel3.setText("Ebevyn Küpe No:");

        jLabel7.setText("Ağırlık");

        jLabel10.setText("Doğum Tarihi:");

        jLabel11.setText("Hayvan Tipi:");

        jLabel12.setText("Hayvan Irkı:");

        jLabel5.setText("Yavruları var mı?");

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
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(birthDateText, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(saveButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(genderText, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(106, 106, 106))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(removeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(6, 6, 6))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(parentText, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(earTagText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(breedText, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(typeText, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(weightText, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hasOffspringText, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 836, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(earTagText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(typeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(weightText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(parentText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(breedText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hasOffspringText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(birthDateText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel2)
                    .addComponent(genderText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(removeButton))
                .addContainerGap(84, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            AnimalDao animaldao = new AnimalDao(this.user);
            
            String ear = earTagText.getText();
            int userid;
            String parent = parentText.getText();
            String type = typeText.getText();
            String breed = breedText.getText();
            String birthdate = null;
            java.sql.Date sqlDate  = null;
            
            String gender = genderText.getText();
            float weightValue = 0;
            boolean hasOffspringValue = false;

             userid = this.user.getId();            
            if(!ear.isEmpty()) {
                ear = this.earTagText.getText();
            }
            if(parent.isEmpty()) {
            parent = null; 
            }
            if(!type.isEmpty()){
                type = this.typeText.getText();
            }
            if(!breed.isEmpty()){
                breed = this.breedText.getText();
            }
            if(birthDateText.getText() != null){
                birthdate = this.birthDateText.getText();
                java.util.Date utilDate = formatter.parse(birthdate);
                sqlDate = new java.sql.Date(utilDate.getTime()); 
            }
            
            if(!gender.isEmpty()) {
                gender = this.genderText.getText();
            }
            if(weightText.getText() != null) {
                weightValue = Float.parseFloat(weightText.getText());
            } 
            if(hasOffspringText.getText() != null){
                if(hasOffspringText.getText().equals("1"))
                hasOffspringValue = true;
                else if(hasOffspringText.getText().equals("0"))
                hasOffspringValue = false;
            }

            Animal animal = new Animal();
            animal = animaldao.addAnimal(ear, userid, parent, type, breed, sqlDate, gender, weightValue, hasOffspringValue);
    
            if(animal != null) {
                builtAnimalTable();
            }
            
            
            
        } catch (ParseException ex) {
            Logger.getLogger(Panel1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }//GEN-LAST:event_saveButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
    int row = animalTable.getSelectedRow();

    if (row == -1) {
        JOptionPane.showMessageDialog(this, "Lütfen silmek istediğiniz satırı seçiniz.");
        return;
    }

    DefaultTableModel model = (DefaultTableModel) animalTable.getModel();
    String earTagNo = (String) model.getValueAt(row, 0);
    AnimalDao animalDao = new AnimalDao(this.user);
    boolean success = animalDao.deleteAnimal(earTagNo);
       if(success) {
        model.removeRow(row);
        JOptionPane.showMessageDialog(this, "Bakım kaydı başarıyla silindi.");
    }
       builtAnimalTable();

    }//GEN-LAST:event_removeButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable animalTable;
    private javax.swing.JTextField birthDateText;
    private javax.swing.JTextField breedText;
    private javax.swing.JTextField earTagText;
    private javax.swing.JTextField genderText;
    private javax.swing.JTextField hasOffspringText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField parentText;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField typeText;
    private javax.swing.JTextField weightText;
    // End of variables declaration//GEN-END:variables
}
