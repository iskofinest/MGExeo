
package Services;

import Entities.Transactions;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TransactionService {
    
    public static boolean saveTransaction(Transactions transaction) {
        try{
            Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            System.out.print(session.save(transaction) + " ");
            tx.commit();
            session.close();
        } catch(Exception e) {
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, e.toString(), "ERROR OCCURED", 0);
            return false;
        }
        return true;
    }
    
    public static Transactions findTransactionById(int transactionId) {
        Transactions transaction;
        Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
        transaction = (Transactions) session.get(Transactions.class, transactionId);
        session.close();
        return transaction;
    }

    public static boolean updateTransaction(Transactions transactions) {
        boolean saved = false;
        try{
            Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.update(transactions);
            tx.commit();
            session.close();
            saved = true;
            
        } catch(Exception ex) {
            saved = false;
            System.out.println(ex.toString());
        }
        return saved;
    }
    
}
