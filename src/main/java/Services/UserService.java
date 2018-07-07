package Services;

import Entities.User;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class UserService {
    
    public static boolean saveUser(User user) {
        try{
            Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.save(user);
            tx.commit();
            session.close();
        } catch(Exception e) {
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, e.toString(), "ERROR OCCURED", 0);
            return false;
        }
        return true;
    }

    public static User getUserLogin(String authority, String userId, String password) {
        User user = null;
        Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq(User.AUTHORITY, authority));
        criteria.add(Restrictions.eq(User.EMPLOYEE_ID, userId));
        criteria.add(Restrictions.eq(User.PASSWORD, password));
        List list = criteria.list();
        if(list.size() > 0) user = (User) (list.get(0));
        return user;
    }
    
}
