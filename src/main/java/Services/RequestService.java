
package Services;

import Entities.MaterialRequest;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class RequestService {
    
    public static boolean saveRequest(MaterialRequest materialRequest) {
        try{
            Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            System.out.print(session.save(materialRequest) + " ");
            tx.commit();
            session.close();
        } catch(Exception e) {
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, e.toString(), "ERROR OCCURED", 0);
            return false;
        }
        return true;
    }
    
    public static MaterialRequest findMaterialRequestById(int materialRequestId) {
        MaterialRequest materialRequest;
        Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
        materialRequest = (MaterialRequest) session.get(MaterialRequest.class, materialRequestId);
        session.close();
        return materialRequest;
    }
    
}
