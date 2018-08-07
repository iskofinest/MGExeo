
package Services;

import Entities.JoinedTables.ToolSupplier;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author user
 */
public class ToolSupplierService {

    public static boolean saveToolSupplier(ToolSupplier toolSupplier) {
        try{
            Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.save(toolSupplier);
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

    public static List<ToolSupplier> findBySupplierCode(String supplierCode) {
        String hql = "Select ts from ToolSupplier ts left join  ts.toolSupplierId.tool t left join ts.toolSupplierId.supplier s where s.code='" + supplierCode + "'";
        Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery(hql);
        List<ToolSupplier> toolSuppliers = query.list();
        session.close();
        return toolSuppliers;
    }

    public static ToolSupplier findbySupplierIdAndItemCode(int supplierId, String itemCode) {
        String hql = "SELECT ts FROM Tool t "
                + "LEFT JOIN t.toolSuppliers ts LEFT JOIN ts.toolSupplierId.supplier s "
                + "WHERE s.id=:supplier_id and t.code=:toolCode";
        Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery(hql);
        query.setInteger("supplier_id", supplierId);
        query.setString("toolCode", itemCode);
        List<ToolSupplier> toolSupplier = query.list();
        ToolSupplier ts = (ToolSupplier) toolSupplier.get(0);
        return ts;
    }
    
    
    
}
