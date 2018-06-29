
package com.mycompany.mgexeo;

import Forms.Login;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MGExeo {
    public static void main(String[] args) {
//        Tests.TestItemEntities();
//        Tests.testProject();
//        Tests.testTransaction();
//        Tests.testRequest();
//        Tests.testBorrowTool();
//        Tests.testUser();

        Login login = new Login();
        login.setLocation(378, 179);
        login.setVisible(true);

//        final JFrame f = new JFrame();
//        JButton open = new JButton("open");
//        open.addActionListener(new ActionListener()
//        {
//            public void actionPerformed(ActionEvent e)
//            {
//                openDialog(f);
//            }
//        });
//        JPanel north = new JPanel();
//        north.add(open);
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        f.getContentPane().add(north, "North");
//        f.setSize(200,100);
//        f.setLocation(200,200);
//        f.setVisible(true);
//    }
//  
//    private static void openDialog(Frame f)
//    {
//        final JDialog dialog = new JDialog(f, "a test", true);
//        final JButton button = new JButton("custom button");
//        button.addActionListener(new ActionListener()
//        {
//            public void actionPerformed(ActionEvent e)
//            {
//                System.out.println(button.getActionCommand());
//                dialog.dispose();
//            }
//        });
//        JPanel panel = new JPanel();
//        panel.add(button);
//        JButton[] buttons = { button };
//        JOptionPane optionPane = new JOptionPane(panel,
//                                                 JOptionPane.YES_NO_OPTION,
//                                                 JOptionPane.PLAIN_MESSAGE,
//                                                 null, buttons, button);
//        dialog.getContentPane().add(optionPane);
//        dialog.setSize(300,300);
//        dialog.setLocationRelativeTo(f);
//        dialog.setVisible(true);
    }
    
}
