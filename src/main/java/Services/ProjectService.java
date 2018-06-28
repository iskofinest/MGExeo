package Services;

import Entities.Project;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProjectService {

    public static boolean saveProject(Project project) {
        try{
            Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            System.out.print(session.save(project) + " ");
            tx.commit();
            session.close();
        } catch(Exception e) {
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, e.toString(), "ERROR OCCURED", 0);
            return false;
        }
        return true;
    }
    
    public static Project findProjectById(int projectId) {
        Project project;
        Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
        project = (Project) session.get(Project.class, projectId);
        session.close();
        return project;
    }
    
}
