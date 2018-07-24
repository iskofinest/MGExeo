/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Department;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author user
 */
public class DepartmentService {

    public static Department findDepartmentById(int departmentId) {
        Department department;
        Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
        department = (Department) session.get(Department.class, departmentId);
        session.close();
        return department;    
    }
    
    public static List<Department> findAll() {
        Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
        List list = session.createQuery("from Department order by name").list();
        session.close();
        return list; 
    }

    public static List<Department> findAllDepartmentWithProjects() {
        String hql = "from Department";
        Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery(hql);
        List<Department> departments = query.list();
        session.close();
        return departments;
    }

    public static String findDepartmentByProjectName(String projectName) {
        String hql = "Select d.name from Department d left join d.projects p where p.projectName='" + projectName + "'";
        Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery(hql);
        String departmentName = (String) query.list().get(0);
        session.close();
        return departmentName;
    }
    
}
