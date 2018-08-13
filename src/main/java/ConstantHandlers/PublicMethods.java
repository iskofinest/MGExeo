
package ConstantHandlers;

import Entities.JoinedTables.MaterialSupplier;
import Entities.JoinedTables.ToolSupplier;
import Entities.Project;
import Entities.Supplier;
import Panels.CreateMaterialSupplierPanel;
import Panels.CreateProjectPanel;
import Panels.CreateToolSupplier;
import java.awt.Frame;
import javax.swing.JDialog;
import javax.swing.JPanel;

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
    
    public static MaterialSupplier addMaterialSupplier(Frame frame, Supplier supplier) {
        MaterialSupplier materialSupplier = null;
        CreateMaterialSupplierPanel createMaterialSupplierPanel = new CreateMaterialSupplierPanel(supplier);
        final JDialog dialog = new JDialog(frame, "Add Material for Supplier", true);
        dialog.getContentPane().add(createMaterialSupplierPanel);
        dialog.setSize(475, 300);
        dialog.setLocationRelativeTo(frame);
        dialog.setVisible(true);
        materialSupplier = createMaterialSupplierPanel.getMaterialSupplier();
        return materialSupplier;
    }

    public static ToolSupplier addToolSupplier(Frame frame, Supplier supplier) {
        ToolSupplier toolSupplier = null;
        CreateToolSupplier createToolSupplier = new CreateToolSupplier(supplier);
        final JDialog dialog = new JDialog(frame, "Add Tool for Supplier", true);
        dialog.getContentPane().add(createToolSupplier);
        dialog.setSize(475, 300);
        dialog.setLocationRelativeTo(frame);
        dialog.setVisible(true);
        toolSupplier = createToolSupplier.getToolSupplier();
        return toolSupplier;
    }
    
    private void openDialog(Frame f, JPanel panel, String title) {
        final JDialog dialog = new JDialog(f, title, true);
        dialog.getContentPane().add(panel);
        dialog.setSize(panel.getWidth() + 20, panel.getHeight() + 20);
        dialog.setLocationRelativeTo(f);
        dialog.setVisible(true);
    }
}
