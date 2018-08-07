
package Services;

import Entities.JoinedTables.MaterialSupplier;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MaterialSupplierService {
    
    public static boolean saveMaterialSupplier(MaterialSupplier materialSupplier) {
        try{
            Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.save(materialSupplier);
            tx.commit();
            session.close();
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, e.toString(), "ERROR OCCURED", 0);
            return false;
        }
        return true;
    }

    public static List<MaterialSupplier> findBySupplierCode(String supplierCode) {
        String hql = "Select ms from MaterialSupplier ms left join  ms.materialSupplierId.material m left join ms.materialSupplierId.supplier s where s.code=" + supplierCode;
        Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery(hql);
        List<MaterialSupplier> materialSupplier = query.list();
        session.close();
        return materialSupplier;
    }

    public static MaterialSupplier findBySupplierIdAndItemCode(int supplierId, String itemCode) {
        String hql = "SELECT ms FROM Material m "
                + "LEFT JOIN m.materialSuppliers ms LEFT JOIN ms.materialSupplierId.supplier s "
                + "WHERE s.id=:supplier_id and m.code=:materialCode";
        Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery(hql);
        query.setInteger("supplier_id", supplierId);
        query.setString("materialCode", itemCode);
        List<MaterialSupplier> materialSupplier = query.list();
        MaterialSupplier ms = (MaterialSupplier) materialSupplier.get(0);
        return ms;
    }
    
}
