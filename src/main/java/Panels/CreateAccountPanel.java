
package Panels;

import ConstantHandlers.ConstantHandler;
import Entities.Department;
import Entities.User;
import Services.DepartmentService;
import Services.UserService;
import java.awt.Color;
import java.awt.Frame;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.text.JTextComponent;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class CreateAccountPanel extends javax.swing.JPanel {
    
    // dialog messages for save user confirmation
    
    JTextComponent[] fields;
    JLabel[] labels;
    Color color;
    List<Department> departments;
    String[] departmentNames;
    Frame frame;
    
    public CreateAccountPanel(Frame frame) {
        initComponents();
        this.frame = frame;
        departments = DepartmentService.findAll();
        departmentNames = new String[departments.size()];
        for(int i=0; i<departments.size(); i++) departmentNames[i] = departments.get(i).getName();
        cbxDepartment.setModel(new DefaultComboBoxModel(departmentNames));
        AutoCompleteDecorator.decorate(cbxDepartment);
        color = lblUsername.getForeground();
        fields  = new JTextComponent[]{txtConfirmPassword, txtEmployeeId, txtFirstName, txtLastName, txtMiddleName, txtPassword, txtUsername};
        labels = new JLabel[]{lblConfirmPassword, lblEmployeeId, lblFirstName, lblLastName, lblMiddleName, lblPassword, lblUsername};
        int i =0;
        for(JTextComponent component : fields) {

            final int index = i;
            labels[i].setForeground(Color.RED);
            component.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            if(component.getText().isEmpty()) {
                                labels[index].setForeground(Color.RED);
                            } else {
                                labels[index].setForeground(color);
                            }
                        }
                    });
                }
            });
            i++;
        }
    }
    
    private void clearAllFields() {
        cbxAuthority.setSelectedIndex(1);
        txtEmployeeId.setText("");
        txtMiddleName.setText("");
        txtFirstName.setText("");
        txtLastName.setText("");
        txtUsername.setText("");
        txtPassword.setText("");
        txtConfirmPassword.setText("");
        for(JLabel label : labels) label.setForeground(Color.RED);
    }
    
    private void createAccount() {
        int confirmation = JOptionPane.showConfirmDialog(null, ConstantHandler.CONFIRM_SAVE_MESSAGE, ConstantHandler.CONFIRM_SAVE_TITLE, JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(confirmation == 0) {
            String authority = cbxAuthority.getSelectedItem().toString().trim();
            String employeeId = txtEmployeeId.getText().trim();
            String password = String.valueOf(txtPassword.getPassword());
            String firstName = txtFirstName.getText().trim();
            String middleName = txtMiddleName.getText().trim();
            String lastName = txtLastName.getText().trim();
            String username = txtUsername.getText().trim();
            Department department = departments.get(cbxDepartment.getSelectedIndex());
            User user = new User(employeeId, username, password, firstName, middleName, lastName, authority);
            user.setDepartment(department);
            boolean saved = UserService.saveUser(user);
            
            if(saved) {
                // if successfully saved
                JOptionPane.showMessageDialog(null, ConstantHandler.SUCCESSFUL_SAVE_MESSAGE, ConstantHandler.SUCCESSFUL_SAVE_TITLE, JOptionPane.INFORMATION_MESSAGE);
                clearAllFields();
            } else {
                // if not successfully saved
                JOptionPane.showMessageDialog(null, ConstantHandler.UNSUCCESSFUL_SAVE_MESSAGE, ConstantHandler.UNSUCCESSFUL_SAVE_TITLE, JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private boolean confirmedToCreate() {
        // if some field is empty
        for(JTextComponent field : fields) {
            if(field.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please complete " + field.getToolTipText(), "UNABLE TO CREATE NEW USER", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        // if password not matched to confirm password
        if(!String.valueOf(txtPassword.getPassword()).equals(String.valueOf(txtConfirmPassword.getPassword()))) {
            JOptionPane.showMessageDialog(null, "Password not matched", "UNABLE TO CREATE NEW USER", JOptionPane.ERROR_MESSAGE);
                return false;
        }
        if(UserService.isUserIdExists(txtEmployeeId.getText().trim())) {
            JOptionPane.showMessageDialog(null, "User Exists", "UNABLE TO CREATE NEW USER", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    private void openDialog(CreateDepartment panel)
    {
//        final JDialog dialog = new JDialog("CREATE ACCOUNT", true);
//        final JButton button = new JButton("custom button");
//        button.setSize(33, 19);
//        button.addActionListener(new ActionListener()
//        {
//            @Override
//            public void actionPerformed(ActionEvent e)
//            {
//                System.out.println(button.getActionCommand());
//                System.out.println(dialog.getSize());
//                dialog.dispose();
//            }
//        });
//        JButton[] buttons = { button };
//
//        dialog.getContentPane().add(panel);
//        dialog.setSize(1000, 320);
//        dialog.setLocationRelativeTo(this);
//        dialog.setVisible(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lblFirstName = new javax.swing.JLabel();
        lblMiddleName = new javax.swing.JLabel();
        lblLastName = new javax.swing.JLabel();
        lblEmployeeId = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        txtMiddleName = new javax.swing.JTextField();
        txtFirstName = new javax.swing.JTextField();
        txtEmployeeId = new javax.swing.JTextField();
        lblLastName1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnAddDepartment = new javax.swing.JButton();
        cbxDepartment = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        lblUsername = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        lblConfirmPassword = new javax.swing.JLabel();
        txtConfirmPassword = new javax.swing.JPasswordField();
        lblContactNumber = new javax.swing.JLabel();
        cbxAuthority = new javax.swing.JComboBox<>();
        btnCreateAccount = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(1000, 300));
        setPreferredSize(new java.awt.Dimension(960, 300));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setMaximumSize(new java.awt.Dimension(970, 290));
        jPanel1.setPreferredSize(new java.awt.Dimension(962, 265));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel5.setMaximumSize(new java.awt.Dimension(32767, 248));
        jPanel5.setPreferredSize(new java.awt.Dimension(444, 248));

        lblFirstName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblFirstName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFirstName.setText("FIRST NAME*");

        lblMiddleName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblMiddleName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMiddleName.setText("MIDDLE NAME*");

        lblLastName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblLastName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblLastName.setText("LAST NAME*");

        lblEmployeeId.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblEmployeeId.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblEmployeeId.setText("EMPLOYEE ID*");

        txtLastName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtLastName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtLastName.setToolTipText("Last Name Field");
        txtLastName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtMiddleName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtMiddleName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMiddleName.setToolTipText("Middle Name Field");
        txtMiddleName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtFirstName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtFirstName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFirstName.setToolTipText("First Name Field");
        txtFirstName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtEmployeeId.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtEmployeeId.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEmployeeId.setToolTipText("Employee ID field");
        txtEmployeeId.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblLastName1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblLastName1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblLastName1.setText("DEPARTMENT*");

        btnAddDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDepartmentActionPerformed(evt);
            }
        });

        cbxDepartment.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbxDepartment.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(cbxDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbxDepartment, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(btnAddDepartment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLastName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblEmployeeId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblMiddleName, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
                    .addComponent(lblLastName1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtEmployeeId, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                            .addComponent(txtFirstName)
                            .addComponent(txtMiddleName))
                        .addComponent(txtLastName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmployeeId, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmployeeId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMiddleName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMiddleName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLastName1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setMaximumSize(new java.awt.Dimension(32767, 248));

        lblUsername.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblUsername.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUsername.setText("USERNAME*");

        txtUsername.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtUsername.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsername.setToolTipText("Username Field");
        txtUsername.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtUsername.setName("USERNAME"); // NOI18N

        lblPassword.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblPassword.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPassword.setText("PASSWORD*");

        txtPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPassword.setToolTipText("Password Field");
        txtPassword.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblConfirmPassword.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblConfirmPassword.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblConfirmPassword.setText("CONFIRM PASSWORD*");

        txtConfirmPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtConfirmPassword.setToolTipText("Confirm Password Field");
        txtConfirmPassword.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblContactNumber.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblContactNumber.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblContactNumber.setText("AUTHORITY*");

        cbxAuthority.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbxAuthority.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "REQUISITIONER", "MMD", "WAREHOUSE ADMIN" }));
        cbxAuthority.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnCreateAccount.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnCreateAccount.setForeground(new java.awt.Color(0, 102, 102));
        btnCreateAccount.setText("CREATE ACCOUNT");
        btnCreateAccount.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnCreateAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateAccountActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCreateAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblConfirmPassword)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblContactNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxAuthority, 0, 291, Short.MAX_VALUE)
                            .addComponent(txtPassword)
                            .addComponent(txtConfirmPassword)
                            .addComponent(txtUsername))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblContactNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxAuthority, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblConfirmPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(btnCreateAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jLabel3)
                .addGap(233, 233, 233))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 960, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateAccountActionPerformed
        if(confirmedToCreate()) {
            createAccount();
        }

    }//GEN-LAST:event_btnCreateAccountActionPerformed

    private void btnAddDepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDepartmentActionPerformed
        // TODO add your handling code here:
        openDialog(new CreateDepartment());
    }//GEN-LAST:event_btnAddDepartmentActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddDepartment;
    private javax.swing.JButton btnCreateAccount;
    private javax.swing.JComboBox<String> cbxAuthority;
    private javax.swing.JComboBox<String> cbxDepartment;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lblConfirmPassword;
    private javax.swing.JLabel lblContactNumber;
    private javax.swing.JLabel lblEmployeeId;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblLastName1;
    private javax.swing.JLabel lblMiddleName;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPasswordField txtConfirmPassword;
    private javax.swing.JTextField txtEmployeeId;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtMiddleName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
