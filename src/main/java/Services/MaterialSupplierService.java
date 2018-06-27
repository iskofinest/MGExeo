/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.JoinedTables.MaterialSupplier;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ilovebromanceBRO
 */
public class MaterialSupplierService {
    
    public static boolean saveMaterialSupplier(MaterialSupplier materialSupplier) {
        try{
            Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.save(materialSupplier);
            tx.commit();
            session.close();
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, e.toString(), "ERROR OCCURED", 0);
            return false;
        }
        return true;
    }
    
}
