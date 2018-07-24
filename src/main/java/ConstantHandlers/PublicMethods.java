/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConstantHandlers;

import Entities.Project;
import Panels.CreateProjectPanel;
import java.awt.Frame;
import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 *
 * @author user
 */
public class PublicMethods {
    
    public static Project addProject(Frame frame) {
        Project project = new Project();
        CreateProjectPanel createProjectPanel = new CreateProjectPanel();
        final JDialog dialog = new JDialog(frame, "Create Project", true);
        dialog.getContentPane().add(createProjectPanel);
        dialog.setSize(475, 300);
        dialog.setLocationRelativeTo(frame);
        dialog.setVisible(true);
        project = createProjectPanel.getProject();
        return project;
    }
    
    private void openDialog(Frame f, JPanel panel, String title)
    {
        final JDialog dialog = new JDialog(f, title, true);
        dialog.getContentPane().add(panel);
        dialog.setSize(panel.getWidth() + 20, panel.getHeight() + 20);
        dialog.setLocationRelativeTo(f);
        dialog.setVisible(true);
    }
}
