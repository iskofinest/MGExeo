package Utilities;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
    
    private static SessionFactory SESSION_FACTORY;
    
//    static {
//        
//        
//        try {
////            JSONObject jsonConfigFile = JSONService.getJSONFile();
////            Properties properties = new Properties();
////            properties.setProperty("hibernate.connection.url", String.valueOf(jsonConfigFile.get("hibernate.connection.url")));
////            properties.setProperty("hibernate.connection.username", String.valueOf(jsonConfigFile.get("hibernate.connection.username")));
////            properties.setProperty("hibernate.connection.password", String.valueOf(jsonConfigFile.get("hibernate.connection.password")));
//            
//            Configuration configuration = new Configuration().configure(); // configuration // settings // from // hibernate.cfg.xml
////            configuration.setProperties(properties);
//            StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
//            serviceRegistryBuilder.applySettings(configuration.getProperties());
//            ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
//            SESSION_FACTORY = configuration.buildSessionFactory(serviceRegistry);
//        } catch (Throwable ex) {
//            // Log the exception. 
//            System.err.println("Initial SessionFactory creation failed." + ex);
//            javax.swing.JOptionPane.showMessageDialog(null, ex.toString(), "ERROR", 0);
////            JSONService.setJSONFile();
//            throw new ExceptionInInitializerError(ex);
//        }
//    }
    
    public static SessionFactory getSessionFactory() {
        try {
//            JSONObject jsonConfigFile = JSONService.getJSONFile();
//            Properties properties = new Properties();
//            properties.setProperty("hibernate.connection.url", String.valueOf(jsonConfigFile.get("hibernate.connection.url")));
//            properties.setProperty("hibernate.connection.username", String.valueOf(jsonConfigFile.get("hibernate.connection.username")));
//            properties.setProperty("hibernate.connection.password", String.valueOf(jsonConfigFile.get("hibernate.connection.password")));
            
            Configuration configuration = new Configuration().configure(); // configuration // settings // from // hibernate.cfg.xml
//            configuration.setProperties(properties);
            StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
            serviceRegistryBuilder.applySettings(configuration.getProperties());
            ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
            SESSION_FACTORY = configuration.buildSessionFactory(serviceRegistry);
            return SESSION_FACTORY;
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            javax.swing.JOptionPane.showMessageDialog(null, ex.toString(), "ERROR", 0);
//            JSONService.setJSONFile();
            throw new ExceptionInInitializerError(ex);
        }
//        return SESSION_FACTORY;
    }
    
}
