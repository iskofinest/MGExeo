
package Services;

import Entities.Supplier;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Query;
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

    public static List<Supplier> findAll() {
        String hql = "FROM Supplier";
        Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery(hql);
        query.setCacheable(true);
        List<Supplier> suppliers = query.list();      // no ClassCastException here
        session.close();
        return suppliers;
    }
    
}
