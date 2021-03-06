
package Panels;

import Entities.JoinedTables.MaterialSupplier;
import Entities.Material;
import Entities.Supplier;
import Services.MaterialService;
import Services.MaterialSupplierService;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class CreateMaterialSupplierPanel extends javax.swing.JPanel {

    Supplier supplier;
    List<Material> materials;
    MaterialSupplier materialSupplier;
    String[] currencies = {"PHP", "USD", "EUR", "JPY", "GBP", "KRW", "SGD", "GBP", "CHF", "CAD", "AUD", "NZD", "ZAR"};
    
    /**
     * Creates new form CreateMaterialSupplierPanel
     */
    public CreateMaterialSupplierPanel() {
        initComponents();
    }

    public CreateMaterialSupplierPanel(Supplier supplier) {
        initComponents();
        this.supplier = supplier;
        initializeData();
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
        jLabel6 = new javax.swing.JLabel();
        cbxMaterialCode = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cbxDescription = new javax.swing.JComboBox<>();
        lblSupplierName = new javax.swing.JLabel();
        txtUnit = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnSubmit = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtCurrency = new javax.swing.JComboBox<>();

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Price:  ");
        jLabel6.setPreferredSize(new java.awt.Dimension(131, 22));

        cbxMaterialCode.setEditable(true);
        cbxMaterialCode.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cbxMaterialCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMaterialCodeActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Description:  ");
        jLabel3.setPreferredSize(new java.awt.Dimension(131, 22));

        txtPrice.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPriceKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("MaterialCode:  ");

        cbxDescription.setEditable(true);
        cbxDescription.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cbxDescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxDescriptionActionPerformed(evt);
            }
        });

        lblSupplierName.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        txtUnit.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Supplier Name:  ");
        jLabel1.setPreferredSize(new java.awt.Dimension(131, 22));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Unit:  ");
        jLabel5.setPreferredSize(new java.awt.Dimension(131, 22));

        btnSubmit.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnSubmit.setText("SUBMIT");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Currency:  ");
        jLabel7.setPreferredSize(new java.awt.Dimension(131, 22));

        txtCurrency.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSubmit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSupplierName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPrice))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUnit))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxMaterialCode, 0, 391, Short.MAX_VALUE)
                            .addComponent(cbxDescription, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCurrency, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSupplierName))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbxMaterialCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCurrency, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSubmit)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbxMaterialCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMaterialCodeActionPerformed
        if(cbxMaterialCode.getSelectedIndex() > -1) {
            Material material = materials.get(cbxMaterialCode.getSelectedIndex());
            cbxDescription.setSelectedItem(material.getDescription());
            txtUnit.setText(material.getUnit());
        }
        txtUnit.setEnabled(cbxMaterialCode.getSelectedIndex() == -1);
    }//GEN-LAST:event_cbxMaterialCodeActionPerformed

    private void cbxDescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxDescriptionActionPerformed
        if(cbxDescription.getSelectedIndex() > -1) {
            Material material = materials.get(cbxDescription.getSelectedIndex());
            cbxMaterialCode.setSelectedItem(material.getCode());
            txtUnit.setText(material.getUnit());
        }
        txtUnit.setEnabled(cbxDescription.getSelectedIndex() == -1);
    }//GEN-LAST:event_cbxDescriptionActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:
        boolean confirmToSave = false;
        Material material = new Material();
        int confirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to add this item to the supplier?", "CONFIRM MATERIAL SUPPLIED", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(confirmation == 0) {
            if(cbxDescription.getSelectedIndex() == -1 || cbxMaterialCode.getSelectedIndex() == -1) {
                boolean confirmToSaveMaterial = false;
                if(MaterialService.isExisting("code", cbxMaterialCode.getSelectedItem().toString())) {
                    JOptionPane.showMessageDialog(null, "Material Code is already existing, please reformat the data", "EXISTING UNIQUE MATERIAL IDENTIFIER", JOptionPane.ERROR_MESSAGE);
                } else {
                    int saveAnyway = 0;
                    if(MaterialService.isExisting("description", cbxDescription.getSelectedItem().toString())) {
                        saveAnyway = JOptionPane.showConfirmDialog(null, "Material Description is already existing, DO YOU WISH TO SAVE IT ANYWAY?", "CONFIRM SAVE EXISTING DATA", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                    } 
                    if(saveAnyway == 0) {
                        confirmToSaveMaterial = true;
                    }
                }
                if(confirmToSaveMaterial) {
                    material.setCode(cbxMaterialCode.getSelectedItem().toString());
                    material.setDescription(cbxDescription.getSelectedItem().toString());
                    material.setUnit(txtUnit.getText().trim());
                    if(MaterialService.saveMaterial(material)) {
                        confirmToSave = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to save material, please contact technical support.", "SAVING FAILED", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                material = materials.get(cbxDescription.getSelectedIndex());
                confirmToSave = true;
            }
            if(confirmToSave) {
                materialSupplier = new MaterialSupplier();
                materialSupplier.setSupplier(supplier);
                materialSupplier.setMaterial(material);
                materialSupplier.setCurrency(txtCurrency.getSelectedItem().toString());
                materialSupplier.setPrice(BigDecimal.valueOf(Double.parseDouble(txtPrice.getText())));
                if(MaterialSupplierService.saveMaterialSupplier(materialSupplier)) {
                    JOptionPane.showMessageDialog(null, "MATERIAL SUPPLIER SUCCESSFULLY SAVED!!");
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to save Material Supplier, Please Contact Technical Support", "TRANSACTION FAILED", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void txtPriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPriceKeyTyped
        if (!Character.isDigit(evt.getKeyChar()) && !(evt.getKeyChar() == '.')){
            evt.consume();
        } 
    }//GEN-LAST:event_txtPriceKeyTyped

    private void initializeData() {
        lblSupplierName.setText(supplier.getName());
        AutoCompleteDecorator.decorate(cbxDescription);
        AutoCompleteDecorator.decorate(cbxMaterialCode);
        materials = MaterialService.findByNotInSupplier(supplier);
        DefaultComboBoxModel materialsCodeModel = new DefaultComboBoxModel();
        DefaultComboBoxModel descriptionModel = new DefaultComboBoxModel();
        materials.forEach(material -> {
            materialsCodeModel.addElement(material.getCode());
            descriptionModel.addElement(material.getDescription());
        });
        SwingUtilities.invokeLater(() -> {
            cbxMaterialCode.setModel(materialsCodeModel);
            cbxDescription.setModel(descriptionModel);
            txtCurrency.setModel(new DefaultComboBoxModel(currencies));
        });
    }

    public MaterialSupplier getMaterialSupplier() {
        return materialSupplier;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSubmit;
    private javax.swing.JComboBox<String> cbxDescription;
    private javax.swing.JComboBox<String> cbxMaterialCode;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblSupplierName;
    private javax.swing.JComboBox<String> txtCurrency;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtUnit;
    // End of variables declaration//GEN-END:variables

}
