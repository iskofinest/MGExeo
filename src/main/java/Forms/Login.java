package Forms;

import Forms.WarehouseAdmin.Warehouse_Account;
import Forms.Requisitioner.Requisitioner_Account;
import ConstantHandlers.ConstantHandler;
import Entities.User;
import Panels.CreateAccountPanel;
import Services.UserService;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Login extends javax.swing.JFrame {
    
    // <editor-fold defaultstate="fold" desc="CLASS VARIABLES">   
    
    // </editor-fold> 
    
    public Login() {
        initComponents();
        initializeApplication();
    }

    // <editor-fold defaultstate="fold" desc="CUSTOM METHODS">     
    private void initializeApplication() {
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    login();
                }
            }
        });
        txtUserId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    login();
                }
            }
        });
    }
    
    private boolean clearToLogin() {
        // if incomplete form
        if(txtUserId.getText().length()<1 || txtPassword.getPassword().length < 1) {
            JOptionPane.showMessageDialog(null, ConstantHandler.INCOMPLETE_FORM_MESSAGE, ConstantHandler.INVALIDITY_TITLE, JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        if(txtUserId.getText().length()<6 || txtPassword.getPassword().length < 6) {
            JOptionPane.showMessageDialog(null, ConstantHandler.LESS_THAN_6_CHAR_MESSAGE, ConstantHandler.INVALIDITY_TITLE, JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        if(txtUserId.getText().length()>20 || txtPassword.getPassword().length > 20) {
            JOptionPane.showMessageDialog(null, ConstantHandler.MAX_CHAR_MESSAGE, ConstantHandler.INVALIDITY_TITLE, JOptionPane.WARNING_MESSAGE);
            return false;
        }

        for(char userIdChar : txtUserId.getText().toCharArray()) {
            boolean contains = false;
            for(char constantChar : ConstantHandler.UNAME_ALLOWED_CHARS.toCharArray()) {
                if(constantChar == userIdChar) {
                    contains = true;
                    break;
                }
            }
            if(!contains) {
                JOptionPane.showMessageDialog(null, ConstantHandler.SPECIAL_CHAR_MESSAGE, ConstantHandler.INVALIDITY_TITLE, JOptionPane.WARNING_MESSAGE);
                return false;
            }
        }
        
        for(char userIdChar : txtPassword.getPassword()) {
            boolean contains = false;
            for(char constantChar : ConstantHandler.UNAME_ALLOWED_CHARS.toCharArray()) {
                if(constantChar == userIdChar) {
                    contains = true;
                    break;
                }
            }
            if(!contains) {
                JOptionPane.showMessageDialog(null, ConstantHandler.SPECIAL_CHAR_MESSAGE, ConstantHandler.INVALIDITY_TITLE, JOptionPane.WARNING_MESSAGE);
                return false;
            }
        }
        
        return true;
    }
    
    private void login() {
        if(clearToLogin()) {
            SwingUtilities.invokeLater(() -> {
                String authority = String.valueOf(cbxAuthority.getSelectedItem().toString());
                String userId = txtUserId.getText().trim();
                String password = String.valueOf(txtPassword.getPassword()).trim();
                User user = UserService.getUserLogin(authority, userId, password);
                if(user != null) {
                    ConstantHandler.user = user;
                    ConstantHandler.WELCOME_MESSAGE += user.getFirstName() + " " + user.getLastName();
                    JOptionPane.showMessageDialog(null, ConstantHandler.WELCOME_MESSAGE, ConstantHandler.WELCOME_TITLE, JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    switch(user.getAuthority().toUpperCase()) {

                        case "REQUISITIONER":
                            new Requisitioner_Account().setVisible(true);
                            break;

                        case "MMD":
                            new MMD_Account().setVisible(true);
                            break;

                        case "WAREHOUSE ADMIN":
                            new Warehouse_Account().setVisible(true);
                            break;

                    }
                } else {
                    JOptionPane.showMessageDialog(null, ConstantHandler.INVALIDITY_MESSAGE, ConstantHandler.INVALIDITY_TITLE, JOptionPane.ERROR_MESSAGE);
                }
            });
        }
    }
    
    private void openDialog(Frame f, CreateAccountPanel panel)
    {
        final JDialog dialog = new JDialog(f, "CREATE ACCOUNT", true);
        final JButton button = new JButton("custom button");
        button.setSize(33, 19);
        button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.out.println(button.getActionCommand());
                System.out.println(dialog.getSize());
                dialog.dispose();
            }
        });
        JButton[] buttons = { button };

        dialog.getContentPane().add(panel);
        dialog.setSize(1000, 315);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }
    
    // </editor-fold> 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cbxAuthority = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUserId = new javax.swing.JTextField();
        lblCreateAccount = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(51, 153, 255));
        setLocation(new java.awt.Point(393, 247));

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 0)));

        jLabel5.setFont(new java.awt.Font("Vani", 1, 18)); // NOI18N
        jLabel5.setText("Log-In Account ...");

        btnLogin.setBackground(new java.awt.Color(102, 153, 255));
        btnLogin.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnLogin.setText("LOG-IN");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(255, 0, 51));
        btnCancel.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnCancel.setText("CANCEL");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Log-in As :");

        cbxAuthority.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbxAuthority.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "REQUISITIONER", "MMD", "WAREHOUSE ADMIN" }));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("User ID :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Password :");

        txtUserId.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblCreateAccount.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        lblCreateAccount.setText("Create Account");
        lblCreateAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCreateAccountMouseClicked(evt);
            }
        });

        txtPassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnLogin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancel)
                        .addGap(88, 88, 88))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbxAuthority, javax.swing.GroupLayout.Alignment.LEADING, 0, 192, Short.MAX_VALUE)
                            .addComponent(txtUserId, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPassword))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblCreateAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(222, 222, 222))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxAuthority, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUserId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                            .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(lblCreateAccount)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    // <editor-fold defaultstate="fold" desc="GUI RESPONSIVE METHODS"> 
    private void lblCreateAccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCreateAccountMouseClicked
        // TODO add your handling code here:
        SwingUtilities.invokeLater(() -> {
            CreateAccountPanel createAccountPanel = new CreateAccountPanel(this);
            openDialog(this, createAccountPanel);
        });
    
    }//GEN-LAST:event_lblCreateAccountMouseClicked

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        login();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        int confirmation = JOptionPane.showConfirmDialog(null, ConstantHandler.CONFIRM_EXIT_MESSAGE, ConstantHandler.CONFIRM_EXIT_TITLE, JOptionPane.OK_CANCEL_OPTION);
        if(confirmation == 0) {
            SwingUtilities.invokeLater(() -> {
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                dispose();
            });
        }
    }//GEN-LAST:event_btnCancelActionPerformed
    
    // </editor-fold> 
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnLogin;
    private javax.swing.JComboBox<String> cbxAuthority;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCreateAccount;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUserId;
    // End of variables declaration//GEN-END:variables
}
