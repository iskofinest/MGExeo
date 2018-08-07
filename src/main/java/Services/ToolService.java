
package Services;

import Entities.JoinedTables.BorrowTool;
import Entities.JoinedTables.ToolSupplier;
import Entities.Tool;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ToolService {
    
    private final static Logger logger = Logger.getLogger(ToolService.class.getName());
    
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
        Tool tool;
        Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
        tool = (Tool) session.get(Tool.class, toolId);
        session.close();
        return tool;
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
    
    public static boolean saveBorrowTool(BorrowTool borrowTool) {
        try{
            Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            System.out.print(session.save(borrowTool) + " ");
            tx.commit();
            session.close();
        } catch(Exception e) {
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, e.toString(), "ERROR OCCURED", 0);
            return false;
        }
        return true;
    }

    public static List<Tool> findAll() {
        String hql = "FROM Tool";
        Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery(hql);
        query.setCacheable(true);
        List<Tool> tools = query.list();      // no ClassCastException here
        session.close();
        return tools;
    }

    public static String[][] getAlltools() {
        String hql = "FROM Tool";
        Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery(hql);
        query.setCacheable(true);
        List<Tool> materials = query.list();      // no ClassCastException here
        session.close();
        String[][] data = new String[materials.size()][13];
        for(int i=0; i<materials.size(); i++) {
            try{
                Tool material = materials.get(i);
                data[i][0] = material.getCode();
                data[i][1] = material.getDescription();
                data[i][2] = String.valueOf(material.getId());
            }catch(ArrayIndexOutOfBoundsException ex){
                logger.log(Level.SEVERE, ex.toString());
            }
        }
        return data;
    }
    
//    public static String[][] getAlltools() {
//        String hql = "FROM Tool";
//        Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
//        Query query = session.createQuery(hql);
//        query.setCacheable(true);
//        List<Tool> tools = query.list();      // no ClassCastException here
//        session.close();
//        String[][] data = new String[tools.size()][13];
//        for(int i=0; i<tools.size(); i++) {
//            try{
//                Tool tool = tools.get(i);
//                data[i][0] = tool.getCode();
//                data[i][1] = tool.getDescription();
//                data[i][2] = String.valueOf(tool.getId());
//            }catch(ArrayIndexOutOfBoundsException ex){
//                logger.log(Level.SEVERE, ex.toString());
//            }
//        }
//        return data;
//    }
    
}
