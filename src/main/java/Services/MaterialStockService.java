
package Services;

import Entities.JoinedTables.MaterialStock;
import java.math.BigDecimal;
import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MaterialStockService {

    public static void addStock(String itemCode, int quantity, BigDecimal totalCost) {
        if(isExisting("code", itemCode)) {
            addQuantity(itemCode, quantity, totalCost);
        } else {
            saveMaterialStock(itemCode, quantity, totalCost);
        }
    }

    public static boolean isExisting(String column, String value) {
        boolean existing = false;
        String hql = "SELECT COUNT(m.code) FROM MaterialStock ms "
                + "LEFT JOIN ms.material m WHERE m." + column + "=:value";
        Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery(hql);
        query.setString("value", value);
        existing = Integer.parseInt(query.list().get(0).toString()) > 0;
        System.out.println("COUNT: " + query.list().get(0));
        return existing;
    }

    private static void addQuantity(String itemCode, int quantity, BigDecimal totalCost) {
        MaterialStock materialStock = findByItemCode(itemCode);
        materialStock.setQuantity(materialStock.getQuantity() + quantity);
        materialStock.setTotalAmount(materialStock.getTotalAmount().add(totalCost));
        Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(materialStock);
        tx.commit();
        session.close();
    }
    
    public static MaterialStock findByItemCode(String itemCode) {
        String hql = "SELECT ms FROM MaterialStock ms "
                + "LEFT JOIN ms.material m WHERE m.code=:itemCode";
        Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery(hql);
        query.setString("itemCode", itemCode);
        MaterialStock materialStock = (MaterialStock)query.list().get(0);
        return materialStock;
    }
    
    public static void saveMaterialStock(String itemCode, int quantity, BigDecimal totalCost) {
        MaterialStock materialStock = new MaterialStock();
        materialStock.setMaterial(MaterialService.findByItemCode(itemCode));
        materialStock.setQuantity(quantity);
        materialStock.setTotalAmount(totalCost);
        try{
            Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            System.out.print(session.save(materialStock) + " ");
            tx.commit();
            session.close();
        } catch(Exception e) {
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, e.toString(), "MATERIAL STOCK NOT SAVED!!", 0);
        }
    }
    
}
