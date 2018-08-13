
package com.mycompany.mgexeo;

import Entities.Department;
import Entities.JoinedTables.BorrowTool;
import Entities.JoinedTables.MaterialDelivery;
import Entities.JoinedTables.MaterialSupplier;
import Entities.JoinedTables.ToolSupplier;
import Entities.Material;
import Entities.MaterialRequest;
import Entities.Project;
import Entities.Supplier;
import Entities.Tool;
import Entities.TransactionIn;
import Entities.TransactionOut;
import Entities.User;
import Services.DepartmentService;
import Services.MaterialDeliveryService;
import Services.MaterialService;
import Services.MaterialSupplierService;
import Services.ProjectService;
import Services.RequestService;
import Services.SupplierService;
import Services.ToolService;
import Services.ToolSupplierService;
import Services.TransactionInService;
import Services.TransactionService;
import Services.UserService;
import Utilities.HibernateUtil;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import org.hibernate.Session;

public class Tests {
    
    static Material material;
    
    public static void TestItemEntities() {
        Supplier supplier = new Supplier();
        supplier.setCode("1");
        supplier.setName("sample");
        supplier.setAddress("sample");
        supplier.setTelephone("sample");
        supplier.setEmail("sample");
        supplier.setContactPerson("sample");
        supplier.setTinNo("sample");
        supplier.setFaxNo("sample");
        System.out.println("SUPPLIER SAVED: " + SupplierService.saveSupplier(supplier));
        
        material = new Material();
        material.setCode("123");
        material.setDescription("material description");
        material.setUnit("pcs");
        System.out.println("MATERIAL SAVED: " + MaterialService.saveMaterial(material));
        
        Tool tool = new Tool("tool code", "tool description", "tool unit", "tool brand", "tool size", "tool color");
        System.out.println("TOOL SAVED: " + ToolService.saveTool(tool));
        
        User user = new User("admin", 
        "admin",
        "admin",
        "admin",
        "admin",
        "admin",
        "admin");
        System.out.println("USER SAVED: " + UserService.saveUser(user));
        System.out.println("FINISHED");

        Supplier supplier1 = SupplierService.findMaterialById(1);
        Material material1 = MaterialService.findMaterialById(1);
        Tool tool1 = ToolService.findToolById(1);
        
        MaterialSupplier materialSupplier = new MaterialSupplier();
        materialSupplier.setMaterial(material1);
        materialSupplier.setSupplier(supplier1);
        materialSupplier.setPrice(BigDecimal.valueOf(Double.parseDouble("500")));
        System.out.println("MATERIAL SUPPLIER SAVED: " + MaterialSupplierService.saveMaterialSupplier(materialSupplier));
        
        ToolSupplier toolSupplier = new ToolSupplier();
        toolSupplier.setTool(tool1);
        toolSupplier.setSupplier(supplier1);
        toolSupplier.setPrice(BigDecimal.valueOf(Double.parseDouble("3000")));
        System.out.println("TOOL SUPPLIER SAVED: " + ToolService.saveToolSupplier(toolSupplier));
        
        System.out.println(supplier1.toString());
        System.out.println(material1.toString());
        System.out.println(materialSupplier.toString());
        
    }
    
    public static void testUser() {
        User user = new User("admin", 
        "admin",
        "admin",
        "admin",
        "admin",
        "admin",
        "admin");
        System.out.println("USER SAVED: " + UserService.saveUser(user));
        System.out.println("FINISHED");
    }
    
    static Project project;
    static TransactionOut transaction;
    
    public static void testProject() {
        project = new Project();
        project.setProjectCode("project code");
        project.setProjectName("project name");
        project.setDateStarted(new Date());
        project.setDateFinished(new Date());
        project.setDateCreated(new Date());
        project.setSpentAmount(BigDecimal.valueOf(Double.parseDouble("12345")));
        project.setTotalBudget(BigDecimal.valueOf(Double.parseDouble("2468")));
        System.out.println("PROJECT SAVED: " + ProjectService.saveProject(project));
    }
    
//    public static void testTransaction() {
//        transaction = new TransactionOut("transaction code", "IN", new Date(), new Date(), BigDecimal.valueOf(Double.parseDouble("369")));
//        transaction.setProject(project);
//        System.out.println("TRANSACTION SAVED: " + TransactionService.saveTransaction(transaction));
//    }
//    
//    public static void testRequest() {
//        material = new Material();
//        material.setCode("123");
//        material.setDescription("material description");
//        material.setUnit("pcs");
//        System.out.println("MATERIAL SAVED: " + MaterialService.saveMaterial(material));
//        
//        MaterialRequest materialRequest = new MaterialRequest();
//        materialRequest.setQuantity(10);
//        materialRequest.setTotalAmount(BigDecimal.valueOf(Double.parseDouble("13579")));
//        materialRequest.setTransaction(transaction);
//        materialRequest.setMaterial(material);
//        System.out.println("MATERIAL REQUEST SAVED: " + RequestService.saveRequest(materialRequest));
//        
//    }
    
//    public static void testBorrowTool() {
//        Tool tool = new Tool("tool code", "tool description", "tool unit", "tool brand", "tool size", "tool color");
//        System.out.println("TOOL SAVED: " + ToolService.saveTool(tool));
//        
//        BorrowTool borrowTool = new BorrowTool();
//        borrowTool.setQuantity(5);
//        borrowTool.setTool(tool);
//        borrowTool.setTotalAmount(BigDecimal.valueOf(1235));
//        borrowTool.setBorrowDate(new Date());
//        Calendar c = Calendar.getInstance();
//        c.setTime(new Date()); // Now use today date.
//        c.add(Calendar.DATE, 5);
//        borrowTool.setReturnDate(c.getTime());
//        borrowTool.setTransaction(transaction);
//        System.out.println("BORROW TOOL SAVED: " + ToolService.saveBorrowTool(borrowTool));
//        
//    }
//    
//    public static void testUserTransaction() {
//        TransactionOut transactions = TransactionService.findTransactionById(1);
//        User user = UserService.findUserById(1);
//        transactions.setRequisitioner(user);
//        if(TransactionService.updateTransaction(transactions)) System.out.println("Transaction - User updated");
//    }
    
    public static void testUserDepartment() {
        String code = "001";
        String name = "IT Department";
        Department department = new Department(code, name);
        User user = UserService.findUserById(1);
        user.setDepartment(department);
        if(UserService.updateUser(user)) System.out.println("Department - User updated");
    }
    
    public static void testProjectDepartment() {
        Project project = ProjectService.findProjectById(1);
        Department department = DepartmentService.findDepartmentById(1);
        project.setDepartment(department);
        if(ProjectService.updateProject(project)) System.out.println("Project - Department updated");
    }
    
    public static void testMaterialToolSupplier() {
        List<Supplier> suppliers = SupplierService.findAll();
        List<Material> materials = MaterialService.findAll();
        List<Tool> tools = ToolService.findAll();
        
        Random random = new Random(500);
        
        suppliers.forEach(supplier -> {
//            materials.forEach(material -> {
//                MaterialSupplier materialSupplier = new MaterialSupplier();
//                materialSupplier.setMaterial(material);
//                materialSupplier.setSupplier(supplier);
//                materialSupplier.setCurrency("PHP");
//                materialSupplier.setPrice(BigDecimal.valueOf(Double.parseDouble(String.valueOf(random.nextInt(10001)))));
//                if(MaterialSupplierService.saveMaterialSupplier(materialSupplier)) 
//                    System.out.println("MATERIAL SUCCESSFULLY SAVED :D");
//                else System.err.println("MATERIAL NOT SUCCESSFULLY SAVED :D");
//            });

            tools.forEach(tool -> {
                ToolSupplier toolSupplier = new ToolSupplier();
                toolSupplier.setTool(tool);
                toolSupplier.setSupplier(supplier);
                toolSupplier.setCurrency("PHP");
                toolSupplier.setPrice(BigDecimal.valueOf(Double.parseDouble(String.valueOf(random.nextInt(11001)))));
                if(ToolSupplierService.saveToolSupplier(toolSupplier))
                    System.out.println("TOOL SUPPLIER SUCCESSFULLY SAVED");
                else System.err.println("TOOL SUPPLIER NOT SUCCESSFULLY SAVED");
            });
        });
        System.out.println("DONE DONE DONE . . . . .");
    }
    
    public static void test() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.close();
    }
    
    public static void testMaterialDelivery() {
        Supplier supplier = new Supplier("0001", 
                "BL Construction Supply", 
                "1466 Doroteo Jose St, Santa Cruz, Manila", 
                "827-62-62", 
                "person1@email.com",
                "person 1",
                "0123456789",
                "09994218650"
        );
        
        Department department = new Department("001", "IT Department");
        
        TransactionIn  transactionIn = new TransactionIn();
        transactionIn.setTransactionCode("001");
        transactionIn.setTransactionInDate(new Date());
        transactionIn.setDeliveryReceiptNo("0730201801");
        transactionIn.setPurchaseOrderNo("0725201801");
//        transactionIn.setVat(BigDecimal.valueOf(Double.parseDouble("55.85")));
//        transactionIn.setNetAmount(new Date());
//        transactionIn.setTotalAmount(new Date());
        transactionIn.setRemarks("This is only a sample remarks");
        transactionIn.setTransactionInDate(new Date());
        
        Material material = new Material("001", "VALVE", "pcs");
        MaterialSupplier materialSupplier = new MaterialSupplier();
        materialSupplier.setMaterial(material);
        materialSupplier.setSupplier(supplier);
        materialSupplier.setPrice(BigDecimal.valueOf(Double.parseDouble("1508.95")));
        
        MaterialDelivery materialDelivery = new MaterialDelivery();
        materialDelivery.setMaterialSupplier(materialSupplier);
        materialDelivery.setTransactionIn(transactionIn);
        transactionIn.setSupplier(supplier);
        
        
        if(SupplierService.saveSupplier(supplier)) {
            System.out.println("Supplier saved");
        } else {
            System.out.println("Supplier not saved");
        }
        
        if(MaterialService.saveMaterial(material)) {
            System.out.println("Material Saved");
        } else {
            System.out.println("Material not saved");
        }
        
        if(DepartmentService.saveDepartment(department)) {
            System.out.println("Department saved");
        } else {
            System.out.println("Department not saved");
        }
        
        if(TransactionInService.saveTransactionIn(transactionIn)) {
            System.out.println("Transaction In Saved");
        } else {
            System.out.println("Transaction In Not Saved");
        }
        
        if(MaterialSupplierService.saveMaterialSupplier(materialSupplier)) {
            System.out.println("Material Supplier In Saved");
        } else {
            System.out.println("Material Supplier Not Saved");
        }
        
        if(MaterialDeliveryService.saveMaterialDelivery(materialDelivery)) {
            System.out.println("Material Delivery Saved");
        } else {
            System.out.println("Material Delivery not saved");
        }
        
    }
    
}
