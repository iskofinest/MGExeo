package Services;

import ConstantHandlers.ConstantHandler;
import Entities.Project;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Query;
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

    public static boolean updateProject(Project project) {
        boolean updated = false;
        try{
            Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.update(project);
            tx.commit();
            session.close();
            updated = true;
            
        } catch(Exception ex) {
            updated = false;
            System.out.println(ex.toString());
        }
        return updated;
    }

    public static List<Project> findAll() {
        String hql = "Select p from Project p join p.department d where d.id=" + ConstantHandler.user.getDepartment().getId();
//        String hql =  "Select p from Product p join p.suppliers s where s.id=" + id;
        System.out.println("QUERY: " + hql);
        Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
        List list = session.createQuery(hql).list();
        session.close();
        return list; 
    }

    public static List<Project> getProjectsByDepartmentId(int departmentId) {
        String hql = "Select p from Project p left join p.department d where d.id=" + departmentId;
        Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery(hql);
        List<Project> projects = query.list();
        session.close();
        return projects;
    }
    
}
