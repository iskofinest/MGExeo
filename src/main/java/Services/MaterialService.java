
package Services;

import Entities.Material;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MaterialService {
    
    private final static Logger logger = Logger.getLogger(MaterialService.class.getName());
    
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

    public static String[][] getAllMaterials() {
        String hql = "FROM Material";
        Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery(hql);
        query.setCacheable(true);
        List<Material> materials = query.list();      // no ClassCastException here
        session.close();
        String[][] data = new String[materials.size()][13];
        for(int i=0; i<materials.size(); i++) {
            try{
                Material material = materials.get(i);
                data[i][0] = material.getCode();
                data[i][1] = material.getDescription();
                data[i][2] = String.valueOf(material.getId());
            }catch(ArrayIndexOutOfBoundsException ex){
                logger.log(Level.SEVERE, ex.toString());
            }
        }
        return data;
    }
    
    public static List<Material> findAll() {
        String hql = "FROM Material";
        Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery(hql);
        query.setCacheable(true);
        List<Material> materials = query.list();      // no ClassCastException here
        session.close();
        return materials;
    }

//    public static List<Material> findMaterialBySupplierCode(String supplierCode) {
//        String hql = "Select m from Material m join m.materialSuppliers ms join ms.materialSupplierId.supplier s where s.code=" + supplierCode;
////        String hql = "Select m from Material m left join m.materialSuppliers ms left join ms.s where s.code=" + supplierCode;
//        Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
//        Query query = session.createQuery(hql);
//        List<Material> materials = query.list();
//        session.close();
//        return materials;
//    }
    
}
