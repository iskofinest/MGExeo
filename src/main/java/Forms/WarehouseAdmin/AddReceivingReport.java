
package Forms.WarehouseAdmin;

import Entities.Department;
import Entities.JoinedTables.MaterialSupplier;
import Entities.JoinedTables.ToolSupplier;
import Entities.Material;
import Entities.Project;
import java.util.List;
import java.util.Date;
import Entities.Supplier;
import Entities.Tool;
import Services.DepartmentService;
import Services.MaterialSupplierService;
import Services.ProjectService;
import Services.SupplierService;
import Services.ToolSupplierService;
import java.math.BigDecimal;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class AddReceivingReport extends javax.swing.JFrame {
    
    private List<Supplier> suppliers; 
    private List<Department> departments; 
    private List<MaterialSupplier> materialSuppliers = null;
    private List<ToolSupplier> toolSuppliers = null;
    private boolean supplierNameChoosing = false;
    private boolean supplierCodeChoosing = false;
    Vector<Vector> data = new Vector<>();
    Vector<String> columns = new Vector<>();
    String[] titles = new String[] {"Category", "Item Code", "Description", "Qty", "Unit", "Unit Cost", "Total Cost"};

    public AddReceivingReport() {
        initComponents();
        
        
        for(String column: titles) {
            columns.addElement(column);
        }
//        for(int i=0; i<10; i++) {
//            Vector<String> row = new Vector<String>();
//            for(int j=0; j<7; j++) { 
//                row.addElement("Row " + (i+1) + " - column " + (j+1));
//            }
//            data.add(row);
//        }
//        DefaultTableModel model = new DefaultTableModel(data, columns);
//        tblDeliveryItems.setModel(model);

        initializeData();
    }
    
    //<editor-fold defaultstate="collapsed" desc=" Custom Code ">
    
    //METHOD TO BE CALL FOR INITIALIZING DATA IN CONSTRUCTOR
    private void initializeData() {
        suppliers = SupplierService.findAll();
        AutoCompleteDecorator.decorate(cbxSupplierId);
        AutoCompleteDecorator.decorate(cbxSupplierName);
        AutoCompleteDecorator.decorate(cbxProjectName);
        AutoCompleteDecorator.decorate(cbxDepartmentName);
        AutoCompleteDecorator.decorate(cbxItemCode);
        AutoCompleteDecorator.decorate(cbxDescription);
        
        //Supplier ID and Supplier Name Combo Box
        DefaultComboBoxModel supplierIdModel = new DefaultComboBoxModel();
        DefaultComboBoxModel supplierNameModel = new DefaultComboBoxModel();
        suppliers.forEach(supplier -> {
            supplierIdModel.addElement(supplier.getCode());
            supplierNameModel.addElement(supplier.getName());
        });
        
        //Department Name and Project Name Combo Box
        departments = DepartmentService.findAllDepartmentWithProjects();
        DefaultComboBoxModel departmentNameModel = new DefaultComboBoxModel();
        DefaultComboBoxModel projectNameModel = new DefaultComboBoxModel();
        departments.forEach(department -> {
            departmentNameModel.addElement(department.getName());
            List<Project> departmentProjects = ProjectService.getProjectsByDepartmentId(department.getId());
            departmentProjects.forEach(project -> projectNameModel.addElement(project.getProjectName()));
        });
        SwingUtilities.invokeLater(() -> {
            cbxSupplierId.setModel(supplierIdModel);
            cbxSupplierName.setModel(supplierNameModel);
            cbxDepartmentName.setModel(departmentNameModel);
            cbxProjectName.setModel(projectNameModel);
            jdcDate.setDate(new Date());
            setItemDropDown();
        });
//        System.out.println("UNIT: " + materialSuppliers.get(0).getMaterial().getUnit());
//        System.out.println("PRICE: " + String.valueOf(materialSuppliers.get(0).getPrice()));
        SwingUtilities.invokeLater(() -> {
            setUnitAndPrice(materialSuppliers.get(0).getMaterial().getUnit(), String.valueOf(materialSuppliers.get(0).getPrice()));
        });
    }
    
    // METHOD FOR INITIALIZING DATA ON DROPDOWN FROM ITEM FIELDS
    private void setItemDropDown() {
        String supplierCode = cbxSupplierId.getSelectedItem().toString();
        if(cbxCategory.getSelectedItem().toString().equals("Material")) {
            lblCode.setText("Material Codes");
            toolSuppliers = null;
            DefaultComboBoxModel materialsCodeModel = new DefaultComboBoxModel();
            DefaultComboBoxModel materialDescriptionModel = new DefaultComboBoxModel();
            materialSuppliers = MaterialSupplierService.findBySupplierCode(supplierCode);
            materialSuppliers.forEach(materialSupplier ->{ 
                materialsCodeModel.addElement(materialSupplier.getMaterial().getCode());
                materialDescriptionModel.addElement(materialSupplier.getMaterial().getDescription());
            });
            cbxItemCode.setModel(materialsCodeModel);
            cbxDescription.setModel(materialDescriptionModel);
        } else {
            lblCode.setText("Tool Codes");
            materialSuppliers = null;
            DefaultComboBoxModel toolCodeModel = new DefaultComboBoxModel();
            DefaultComboBoxModel toolDescriptionModel = new DefaultComboBoxModel();
            toolSuppliers = ToolSupplierService.findBySupplierCode(supplierCode);
            toolSuppliers.forEach(toolSupplier ->{ 
                toolCodeModel.addElement(toolSupplier.getTool().getCode());
                toolDescriptionModel.addElement(toolSupplier.getTool().getDescription());
            });
            cbxItemCode.setModel(toolCodeModel);
            cbxDescription.setModel(toolDescriptionModel);
        }
        System.out.println("private void setItemDropDown() {");
    }
    
    // METHOD FOR INITIALIZING DATA ON OTHER FIELDS FROM ITEM FIELDS
    private void setUnitAndPrice(String unit, String price) {
        System.out.println("setUnitAndPrice(String unit, String price) {");
        txtUnit.setText(unit);
        txtUnitCost.setText(price);
        System.out.println("setUnitAndPrice(String unit, String price) {");
    }
    
    //</editor-fold>
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        cbxProjectName = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDeliveryReceiptNo = new javax.swing.JTextField();
        cbxDepartmentName = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbxSupplierId = new javax.swing.JComboBox<>();
        cbxSupplierName = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtPurchaseOrderNo = new javax.swing.JTextField();
        txtTransactionCode = new javax.swing.JTextField();
        jdcDate = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtReceivedBy = new javax.swing.JTextField();
        txtCheckedBy = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtVerifiedBy = new javax.swing.JTextField();
        txtApprovedBy = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        cbxCategory = new javax.swing.JComboBox<>();
        lblCode = new javax.swing.JLabel();
        cbxItemCode = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        cbxDescription = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtUnitCost = new javax.swing.JTextField();
        txtTotalCost = new javax.swing.JTextField();
        btnAddItemToTable = new javax.swing.JButton();
        txtUnit = new javax.swing.JTextField();
        btnAddItemToDatabase = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDeliveryItems = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ADD RECEIVING REPORT");
        setBackground(new java.awt.Color(102, 153, 255));
        setBounds(new java.awt.Rectangle(0, 0, 1938, 1048));
        setExtendedState(6);
        setMaximumSize(new java.awt.Dimension(1938, 1048));
        setMinimumSize(new java.awt.Dimension(1938, 1048));
        setPreferredSize(new java.awt.Dimension(1938, 1048));
        setSize(new java.awt.Dimension(1938, 1048));

        mainPanel.setBackground(new java.awt.Color(102, 153, 255));
        mainPanel.setMaximumSize(new java.awt.Dimension(1914, 1024));
        mainPanel.setMinimumSize(new java.awt.Dimension(1914, 1024));
        mainPanel.setPreferredSize(new java.awt.Dimension(1914, 1024));

        jPanel4.setBackground(new java.awt.Color(102, 153, 255));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Department Name:  ");
        jLabel7.setMaximumSize(new java.awt.Dimension(175, 22));
        jLabel7.setMinimumSize(new java.awt.Dimension(175, 22));
        jLabel7.setPreferredSize(new java.awt.Dimension(175, 22));

        cbxProjectName.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cbxProjectName.setMaximumSize(new java.awt.Dimension(38, 28));
        cbxProjectName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxProjectNameActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Delivery Receipt No.:  ");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Supplier Name:  ");
        jLabel4.setMaximumSize(new java.awt.Dimension(175, 22));
        jLabel4.setMinimumSize(new java.awt.Dimension(175, 22));
        jLabel4.setPreferredSize(new java.awt.Dimension(175, 22));

        txtDeliveryReceiptNo.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtDeliveryReceiptNo.setMaximumSize(new java.awt.Dimension(38, 28));

        cbxDepartmentName.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cbxDepartmentName.setMaximumSize(new java.awt.Dimension(38, 28));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Project Name:  ");
        jLabel6.setMaximumSize(new java.awt.Dimension(175, 22));
        jLabel6.setMinimumSize(new java.awt.Dimension(175, 22));
        jLabel6.setPreferredSize(new java.awt.Dimension(175, 22));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Supplier ID:  ");
        jLabel5.setMaximumSize(new java.awt.Dimension(175, 22));
        jLabel5.setMinimumSize(new java.awt.Dimension(175, 22));
        jLabel5.setPreferredSize(new java.awt.Dimension(175, 22));

        cbxSupplierId.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cbxSupplierId.setMaximumSize(new java.awt.Dimension(38, 28));
        cbxSupplierId.setPreferredSize(new java.awt.Dimension(31, 28));
        cbxSupplierId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSupplierIdActionPerformed(evt);
            }
        });

        cbxSupplierName.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cbxSupplierName.setMaximumSize(new java.awt.Dimension(38, 28));
        cbxSupplierName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSupplierNameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDeliveryReceiptNo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxSupplierName, 0, 359, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbxDepartmentName, 0, 359, Short.MAX_VALUE)
                            .addComponent(cbxProjectName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxSupplierId, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(0, 0, 0))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtDeliveryReceiptNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxSupplierName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxSupplierId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxProjectName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxDepartmentName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        jPanel5.setBackground(new java.awt.Color(102, 153, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(483, 193));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Transaction Code:  ");
        jLabel1.setPreferredSize(new java.awt.Dimension(164, 22));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Purchase Order No.:  ");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Date:  ");
        jLabel2.setPreferredSize(new java.awt.Dimension(164, 22));

        txtPurchaseOrderNo.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtTransactionCode.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jdcDate.setDateFormatString("MMMM-dd-yyyy");
        jdcDate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTransactionCode, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jdcDate, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                            .addComponent(txtPurchaseOrderNo))))
                .addGap(0, 0, 0))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTransactionCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPurchaseOrderNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdcDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setText("Received By:");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel11.setText("Checked By:");

        txtReceivedBy.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtCheckedBy.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel12.setText("Approved By:");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel13.setText("Verified By:");

        txtVerifiedBy.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtApprovedBy.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jPanel6.setBackground(new java.awt.Color(102, 153, 255));

        jPanel3.setBackground(new java.awt.Color(102, 153, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Category:  ");
        jLabel14.setMaximumSize(new java.awt.Dimension(127, 22));
        jLabel14.setMinimumSize(new java.awt.Dimension(127, 22));
        jLabel14.setName(""); // NOI18N
        jLabel14.setPreferredSize(new java.awt.Dimension(127, 22));

        cbxCategory.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cbxCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Material", "Tool" }));
        cbxCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCategoryActionPerformed(evt);
            }
        });

        lblCode.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblCode.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCode.setText("Material Code:  ");

        cbxItemCode.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cbxItemCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxItemCodeActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Description:  ");
        jLabel16.setMaximumSize(new java.awt.Dimension(127, 22));
        jLabel16.setMinimumSize(new java.awt.Dimension(127, 22));
        jLabel16.setName(""); // NOI18N
        jLabel16.setPreferredSize(new java.awt.Dimension(127, 22));

        cbxDescription.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cbxDescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxDescriptionActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Quantity:  ");
        jLabel17.setMaximumSize(new java.awt.Dimension(127, 22));
        jLabel17.setMinimumSize(new java.awt.Dimension(127, 22));
        jLabel17.setName(""); // NOI18N
        jLabel17.setPreferredSize(new java.awt.Dimension(127, 22));

        txtQuantity.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtQuantity.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtQuantityCaretUpdate(evt);
            }
        });
        txtQuantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtQuantityKeyTyped(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("Unit:  ");
        jLabel18.setMaximumSize(new java.awt.Dimension(127, 22));
        jLabel18.setMinimumSize(new java.awt.Dimension(127, 22));
        jLabel18.setName(""); // NOI18N
        jLabel18.setPreferredSize(new java.awt.Dimension(127, 22));

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Unit Cost:  ");
        jLabel19.setMaximumSize(new java.awt.Dimension(127, 22));
        jLabel19.setMinimumSize(new java.awt.Dimension(127, 22));
        jLabel19.setName(""); // NOI18N
        jLabel19.setPreferredSize(new java.awt.Dimension(127, 22));

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("Total Cost:  ");
        jLabel20.setMaximumSize(new java.awt.Dimension(127, 22));
        jLabel20.setMinimumSize(new java.awt.Dimension(127, 22));
        jLabel20.setName(""); // NOI18N
        jLabel20.setPreferredSize(new java.awt.Dimension(127, 22));

        txtUnitCost.setEditable(false);
        txtUnitCost.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtTotalCost.setEditable(false);
        txtTotalCost.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        btnAddItemToTable.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnAddItemToTable.setLabel("Add to Table");
        btnAddItemToTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddItemToTableActionPerformed(evt);
            }
        });

        txtUnit.setEditable(false);
        txtUnit.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        btnAddItemToDatabase.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnAddItemToDatabase.setText("Add Item to Database");
        btnAddItemToDatabase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddItemToDatabaseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddItemToTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblCode, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtUnitCost, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtQuantity, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxDescription, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTotalCost)
                            .addComponent(txtUnit, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxCategory, 0, 388, Short.MAX_VALUE)
                            .addComponent(cbxItemCode, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(btnAddItemToDatabase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAddItemToDatabase)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCode, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxItemCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUnitCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAddItemToTable)
                .addContainerGap(298, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));

        tblDeliveryItems.setBackground(new java.awt.Color(240, 240, 240));
        tblDeliveryItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Category", "Item Code", "Description", "Quantity", "Unit", "Unit Cost", "Total Cost"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblDeliveryItems);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1292, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel7.setMaximumSize(new java.awt.Dimension(536, 82));
        jPanel7.setMinimumSize(new java.awt.Dimension(536, 82));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("PUT THE LOGO HERE");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton1.setText("jButton1");
        jButton1.setMaximumSize(new java.awt.Dimension(199, 25));
        jButton1.setMinimumSize(new java.awt.Dimension(199, 25));
        jButton1.setPreferredSize(new java.awt.Dimension(199, 25));

        jButton3.setText("jButton1");
        jButton3.setMaximumSize(new java.awt.Dimension(199, 25));
        jButton3.setMinimumSize(new java.awt.Dimension(199, 25));
        jButton3.setPreferredSize(new java.awt.Dimension(199, 25));

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtReceivedBy, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(txtCheckedBy, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtApprovedBy, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtVerifiedBy, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtApprovedBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtReceivedBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtCheckedBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtVerifiedBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1890, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 974, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // <editor-fold defaultstate="collapsed" desc="Object Responsive Methods">       
    private void cbxSupplierIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSupplierIdActionPerformed
//        SwingUtilities.invokeLater(() -> {
            cbxSupplierName.setSelectedIndex(cbxSupplierId.getSelectedIndex());
//        });
    }//GEN-LAST:event_cbxSupplierIdActionPerformed

    private void cbxSupplierNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSupplierNameActionPerformed
        cbxSupplierId.setSelectedIndex(cbxSupplierName.getSelectedIndex());
        setItemDropDown();
        System.out.println("cbxSupplierNameActionPerformed");
    }//GEN-LAST:event_cbxSupplierNameActionPerformed

    private void cbxProjectNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxProjectNameActionPerformed
        String departmentName = DepartmentService.findDepartmentByProjectName(cbxProjectName.getSelectedItem().toString());
        cbxDepartmentName.setSelectedItem(departmentName);
        setItemDropDown();
        System.out.println("cbxProjectNameActionPerformed");
    }//GEN-LAST:event_cbxProjectNameActionPerformed

    private void cbxItemCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxItemCodeActionPerformed
        int index = cbxItemCode.getSelectedIndex();
        if(cbxCategory.getSelectedItem().toString().equals("Material")) {
            MaterialSupplier ms = materialSuppliers.get(index);
            Material material = ms.getMaterial();
            cbxDescription.setSelectedIndex(index);
            setUnitAndPrice(material.getUnit(),ms.getPrice() + "");
        } else {
            ToolSupplier ts = toolSuppliers.get(index);
            Tool tool = ts.getTool();
            cbxDescription.setSelectedIndex(index);
            setUnitAndPrice(tool.getUnit(),ts.getPrice() + "");
            System.out.println("cbxItemCodeActionPerformed");
        }
    }//GEN-LAST:event_cbxItemCodeActionPerformed

    private void cbxDescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxDescriptionActionPerformed
        int index = cbxDescription.getSelectedIndex();
        if(cbxCategory.getSelectedItem().toString().equals("Material")) {
            MaterialSupplier ms = materialSuppliers.get(index);
            Material material = ms.getMaterial();
            cbxItemCode.setSelectedIndex(index);
            setUnitAndPrice(material.getUnit(),"" + ms.getPrice());
        } else {
            ToolSupplier ts = toolSuppliers.get(index);
            Tool tool = ts.getTool();
            cbxItemCode.setSelectedIndex(index);
            setUnitAndPrice(tool.getUnit(),"" + ts.getPrice());
        }
        System.out.println("cbxDescriptionActionPerformed");
    }//GEN-LAST:event_cbxDescriptionActionPerformed

    private void cbxCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCategoryActionPerformed
        // TODO add your handling code here:
        setItemDropDown();
    }//GEN-LAST:event_cbxCategoryActionPerformed

    private void btnAddItemToTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddItemToTableActionPerformed
        SwingUtilities.invokeLater(() -> {
            if(!txtQuantity.getText().isEmpty() && !txtTotalCost.getText().isEmpty()) {
                Vector<String> row = new Vector<>();
                row.add(cbxCategory.getSelectedItem().toString()); // category
                row.add(cbxItemCode.getSelectedItem().toString()); // item code
                row.add(cbxDescription.getSelectedItem().toString()); // item description
                row.add(txtQuantity.getText()); // item quantity
                row.add(txtUnit.getText()); // item unit
                row.add(txtUnitCost.getText()); // item unit cost
                row.add(txtTotalCost.getText()); // item total cost
                data.add(row);
                DefaultTableModel tableModel = new DefaultTableModel(data, columns);
                tblDeliveryItems.setModel(tableModel);
            } else {
                JOptionPane.showMessageDialog(null, "Please complete the details", "INCOMPLETE DETAILS", 0);
            }
        });
    }//GEN-LAST:event_btnAddItemToTableActionPerformed

    private void btnAddItemToDatabaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddItemToDatabaseActionPerformed
        int index = cbxItemCode.getSelectedIndex();
        if(cbxCategory.getSelectedItem().toString().equals("Material")) {
            MaterialSupplier materialSupplier = materialSuppliers.get(index);
            Material material = materialSupplier.getMaterial();
        } else {
            
        }
    }//GEN-LAST:event_btnAddItemToDatabaseActionPerformed

    private void txtQuantityCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtQuantityCaretUpdate
        SwingUtilities.invokeLater(() -> {
            if(txtQuantity.getText().isEmpty()) {
                txtTotalCost.setText("0.00");
            } else {
                BigDecimal quantity = BigDecimal.valueOf(Double.parseDouble(txtQuantity.getText()));
                BigDecimal unitCost = BigDecimal.valueOf(Double.parseDouble(txtUnitCost.getText()));
                txtTotalCost.setText(String.valueOf(quantity.multiply(unitCost)));
            }
        });
    }//GEN-LAST:event_txtQuantityCaretUpdate

    private void txtQuantityKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantityKeyTyped
        // TODO add your handling code here:
        if (!Character.isDigit(evt.getKeyChar())){
            evt.consume();
        } 
    }//GEN-LAST:event_txtQuantityKeyTyped

    //</editor-fold>
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
            java.util.logging.Logger.getLogger(AddReceivingReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddReceivingReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddReceivingReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddReceivingReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddReceivingReport().setVisible(true);
            }
        });
    }
    
    //<editor-fold defaultstate="collapsed" desc=" Variable Declarations ">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddItemToDatabase;
    private javax.swing.JButton btnAddItemToTable;
    private javax.swing.JComboBox<String> cbxCategory;
    private javax.swing.JComboBox<String> cbxDepartmentName;
    private javax.swing.JComboBox<String> cbxDescription;
    private javax.swing.JComboBox<String> cbxItemCode;
    private javax.swing.JComboBox<String> cbxProjectName;
    private javax.swing.JComboBox<String> cbxSupplierId;
    private javax.swing.JComboBox<String> cbxSupplierName;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdcDate;
    private javax.swing.JLabel lblCode;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTable tblDeliveryItems;
    private javax.swing.JTextField txtApprovedBy;
    private javax.swing.JTextField txtCheckedBy;
    private javax.swing.JTextField txtDeliveryReceiptNo;
    private javax.swing.JTextField txtPurchaseOrderNo;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtReceivedBy;
    private javax.swing.JTextField txtTotalCost;
    private javax.swing.JTextField txtTransactionCode;
    private javax.swing.JTextField txtUnit;
    private javax.swing.JTextField txtUnitCost;
    private javax.swing.JTextField txtVerifiedBy;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>
}