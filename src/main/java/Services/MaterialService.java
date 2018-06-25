
package Services;

import Entities.Item.Material;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MaterialService {
    
    public static boolean saveMaterial(Material material) {
        try{
            Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            System.out.print(session.save(material) + " ");
            tx.commit();
            session.close();
        } catch(Exception e) {
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, e.toString(), "ERROR OCCURED", 0);
            return false;
        }
        return true;
    }
    
    public static Material findMaterialById(int materialId) {
        Material material;
        Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
        material = (Material) session.get(Material.class, materialId);
        session.close();
        return material;
    }
    
}
