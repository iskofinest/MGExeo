
package Services;

import Entities.Supplier;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SupplierService {
    
    public static boolean saveSupplier(Supplier supplier) {
        try{
            Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.save(supplier);
            tx.commit();
            session.close();
        } catch(Exception e) {
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, e.toString(), "ERROR OCCURED", 0);
            return false;
        }
        return true;
    }
    
    public static Supplier findMaterialById(int supplierId) {
        Supplier supplier;
        Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
        supplier = (Supplier) session.get(Supplier.class, supplierId);
        session.close();
        return supplier;
    }
    
}
