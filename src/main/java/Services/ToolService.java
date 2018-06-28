
package Services;

import Entities.JoinedTables.ToolSupplier;
import Entities.Tool;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ToolService {
    
    public static boolean saveTool(Tool tool) {
        try{
            Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            System.out.print(session.save(tool) + " ");
            tx.commit();
            session.close();
        } catch(Exception e) {
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, e.toString(), "ERROR OCCURED", 0);
            return false;
        }
        return true;
    }
    
    public static Tool findToolById(int toolId) {
        Tool material;
        Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
        material = (Tool) session.get(Tool.class, toolId);
        session.close();
        return material;
    }
    
    public static boolean saveToolSupplier(ToolSupplier toolSupplier) {
        try{
            Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            System.out.print(session.save(toolSupplier) + " ");
            tx.commit();
            session.close();
        } catch(Exception e) {
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, e.toString(), "ERROR OCCURED", 0);
            return false;
        }
        return true;
    }
    
}
