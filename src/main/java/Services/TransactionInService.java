
package Services;

import Entities.TransactionIn;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TransactionInService {

    public static boolean saveTransactionIn(TransactionIn transactionIn) {
        try{
            Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            System.out.print(session.save(transactionIn) + " Transaction In saved inside method");
            tx.commit();
            session.close();
        } catch(Exception e) {
            System.err.println(e.toString());
            JOptionPane.showMessageDialog(null, e.toString(), "ERROR OCCURED", 0);
            return false;
        }
        return true;
    }

    public static void updateTransactionIn(TransactionIn transactionIn) {
        try{
            Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.update(transactionIn);
            tx.commit();
            session.close();
        } catch(Exception e) {
            System.err.println(e.toString());
            JOptionPane.showMessageDialog(null, e.toString(), "ERROR OCCURED", 0);
        }
    }
    
}
