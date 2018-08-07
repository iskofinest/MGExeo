
package Services;

import Entities.JoinedTables.MaterialDelivery;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MaterialDeliveryService {

    public static boolean saveMaterialDelivery(MaterialDelivery materialDelivery) {
        try{
            Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            System.out.print(session.save(materialDelivery) + " Transaction In saved inside method");
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
